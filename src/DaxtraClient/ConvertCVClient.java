package DaxtraClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.apache.axis.encoding.Base64;

import CVXtractorService.CVXtractor_PortTypeProxy;


public class ConvertCVClient {

	public static void main(String[] args) throws RemoteException {
		CVXtractor_PortTypeProxy cvXtractor_PortTypeProxy = new CVXtractor_PortTypeProxy();

		String contentresult = cvXtractor_PortTypeProxy.convertCV(getContent().getBytes(), "InsightGlobalCVXDEMO");
		System.out.println("Contentresult Response \n"+contentresult);
		
		
		System.out.println("------------------------------------------------------------------------------------ \n");
		
		String fileResult = cvXtractor_PortTypeProxy.convertCV(getCV().getBytes(), "InsightGlobalCVXDEMO");
		System.out.println("FileResult Response"+fileResult);
		
	}
	
	
	private static String getContent(){
		return "Sample Content";
	}
	
    public static String getCV(){
    	File resume = new File("/home/smi-user/Krishnan_Resume.doc");
        String encodedBase64 = null;
        try {
        	
			FileInputStream inputStream = new FileInputStream(resume);
            byte[] bytes = new byte[(int)resume.length()];
            inputStream.read(bytes);
            encodedBase64 = new String(Base64.encode(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedBase64;
    }

	
	
}
