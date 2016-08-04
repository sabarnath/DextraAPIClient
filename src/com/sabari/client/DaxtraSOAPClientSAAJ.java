package com.sabari.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.soap.*;

import org.apache.commons.codec.binary.Base64;

public class DaxtraSOAPClientSAAJ {

    @SuppressWarnings("restriction")
	public static void main(String args[]) throws Exception {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://cvxdemo.daxtra.com/cvvalid/CVXtractorService.wsdl";
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

        // print SOAP Response
        System.out.print("Response SOAP Message:");
        soapResponse.writeTo(System.out);

        soapConnection.close();
    }

    @SuppressWarnings("restriction")
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

       /* MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "ConvertCV");*/

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

}