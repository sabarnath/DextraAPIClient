package DaxtraClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.apache.axis.encoding.Base64;

import CVXtractorService.CVXtractor_PortTypeProxy;


public class PDFToWordClient {

	public static void main(String[] args) throws RemoteException {
		CVXtractor_PortTypeProxy cvXtractor_PortTypeProxy = new CVXtractor_PortTypeProxy();
		
		byte[] fileResult = cvXtractor_PortTypeProxy.PDF2Word(getPDF(), "InsightGlobalCVXDEMO");
		String string = new String(fileResult);
		System.out.println("FileResult Response"+Base64.decode(string));
		
	}
	
/*    public static String getCV(){

        String encodedBase64 = null;
        try {
	       	 URL address = new URL("https://fds.duke.edu/db/Nicholas/esp/faculty/spimm/files/cv.pdf");
	       	InputStream in = address.openStream();
	       	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	       	StringBuilder result = new StringBuilder();
	       	String line;
	       	while((line = reader.readLine()) != null) {
	       	    result.append(line);
	       	}
	       	System.out.println(result.toString());
	       encodedBase64 = new String(Base64.encode(result.toString().getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedBase64;
    }*/

    public static byte[] getPDF(){
    	File resume = new File("/home/smi-user/HttpRegressionFailures1.pdf");
        String encodedBase64 = null;
        byte[] bytes = null;

        try {
        	
			FileInputStream inputStream = new FileInputStream(resume);
             bytes = new byte[(int)resume.length()];
            inputStream.read(bytes);
            encodedBase64 = new String();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return bytes;
    }

	
}
