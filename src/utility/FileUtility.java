package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
	
	
	public static void writeInFile(String str) throws IOException{
		String filePath=(System.getProperty("user.dir")+ "//TestResult.html").trim();
		System.out.println("Print the file path "+filePath);
		File file = new File(filePath);
	    BufferedWriter writer = null;
		try {
			
			 if (!file.exists()) file.createNewFile();
	
			writer = new BufferedWriter(new FileWriter(file, true));
			
			
			    writer.append(str);
			    writer.newLine();
			     
			    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteFile() throws IOException{
		String filePath=(System.getProperty("user.dir")+ "//TestResult.html").trim();
		File file = new File(filePath);
	    
		if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
	}

}
