package com.sabari.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.binary.Base64;

@SuppressWarnings("restriction")
public class DaxtraSOAPClientSAAJ {

	 public static final String url = "http://cvxdemo.daxtra.com/cvvalid/CVXtractorService.wsdl";
	 
	 public static final String encodeString = "";
	public static void main(String args[]) throws Exception {
        testFirstMessage();
        //testLegalMessageAccess();
    }

	private static void testFirstMessage() throws SOAPException, Exception {
		// Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
       
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

        // print SOAP Response
        System.out.print("Response SOAP Message:");
        createSoapResponse(soapResponse);
        
        soapConnection.close();
	}

	private static SOAPMessage createSOAPRequest() throws Exception {
        SOAPMessage soapMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        soapMessage.getSOAPPart().getEnvelope().setPrefix("x");
        soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
        soapMessage.getSOAPHeader().setPrefix("x");
        soapMessage.getSOAPBody().setPrefix("x");
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String serverURI = "CVXtractorService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("cvx", serverURI);

      /*
       * Constructed SOAP Request Message:
       *   <x:Envelope xmlns:x="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cvx="CVXtractorService">
        <x:Header/>
        <x:Body>
            <cvx:ConvertCV>
                <cvx:document_url>[base64Binary?]</cvx:document_url>
                <cvx:account>?</cvx:account>
            </cvx:ConvertCV>
        </x:Body>
    	</x:Envelope>*/
        
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("ConvertCV", "cvx");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("document_url", "cvx");
        soapBodyElem1.addTextNode(prepareBase64());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("account", "cvx");
        soapBodyElem2.addTextNode("InsightGlobalCVXDEMO");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "#ConvertCV");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
    
    
    public static String prepareBase64(){
    	File originalFile = new File("/home/smi-user/Desktop/CFW_team/DaXtra/ConvertCV/Request.pdf");
        String encodedBase64 = null;
        try {
            @SuppressWarnings("resource")
			FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
            byte[] bytes = new byte[(int)originalFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedBase64;
    }
    
	private static void createSoapResponse(SOAPMessage soapResponse) throws Exception  {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.println("\n----------SOAP Response-----------");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	 }

    
	public static void  testLegalMessageAccess() throws Exception
    {
       MessageFactory msgFactory = MessageFactory.newInstance();
       SOAPConnection con = SOAPConnectionFactory.newInstance().createConnection();

       String reqEnv = 
          "<x:Envelope xmlns:x='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cvx='CVXtractorService'>" + 
          " <x:Header/>" + 
          " <x:Body>" + 
          "  <cvx:ConvertCV>" + 
          "   <cvx:document_url>"+prepareBase64()+"</cvx:document_url>" + 
          "		<cvx:account>InsightGlobalCVXDEMO</cvx:account>"+
          "  </cvx:ConvertCV>" + 
          " </x:Body>" + 
          "</x:Envelope>";
       SOAPMessage reqMsg = msgFactory.createMessage(null, new ByteArrayInputStream(reqEnv.getBytes()));

       URL epURL = new URL(url);
       SOAPMessage resMsg = con.call(reqMsg, epURL);

       // print SOAP Response
       System.out.print("Response SOAP Message:");
       createSoapResponse(resMsg);
       
       con.close();
       
       }
     
}