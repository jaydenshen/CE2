import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileToWrite {
	
	private static File file;
	private Cache cache;
	private static FileWriter fw;
	private String MESSAGE_TEXT_ADDED = "add  %1$s to \"%2$s\"\n";
	private String MESSAGE_CLEAR_FILE = "all content deleted from %1$s \n";
	private String MESSAGE_FILE_NOT_HERE = "file not file";
	private static String MESSAGE_DELETE_LINE = "deleted from %1$s: \"%2$s\"";
	private static   String fileName;
	public FileToWrite(String fileName){
		
		file = new File(fileName);
		this.fileName = fileName;
	}
	
	public void createFile() throws IOException{
		
		if(file.exists()){
			
			readExistingFile();
		}else{
			
			file.createNewFile();
		}
	}
	
	private void readExistingFile() throws FileNotFoundException{
		
		BufferedReader bw  = new BufferedReader(new FileReader(file));
	}
	
	public String writeToFile(String information) throws IOException{
		

		fw = new FileWriter(file,true);
		fw.write(information + "\r\n");
		fw.close();
		fw.close(); 
		return String.format(MESSAGE_TEXT_ADDED,information,fileName );
	}
	
	public String clearTheFile() throws IOException{
		
		fw = new FileWriter(file);
		fw.write("");
		fw.close();
		return String.format(MESSAGE_CLEAR_FILE,fileName);
	
	}
	

	public static String delete(String deleteLine, Cache cache) throws IOException {
		
		fw = new FileWriter(file);
		ArrayList<String> currentCache = Cache.getCache();
		
		for (String temp : currentCache) {
			fw.write(temp+"\r\n");
		}
		fw.close();
		return String.format(MESSAGE_DELETE_LINE,fileName,deleteLine);
	}
	
	public String display(){
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    String displayMes = "";
		    int lineIndex = 1;
		    while ((line = br.readLine()) != null) {
		       
		    	displayMes = displayMes + Integer.toString(lineIndex)+". " + line + "\n";
		    	lineIndex = lineIndex+1;
		    }
		    return displayMes;
		
		}catch(IOException e){
			
			return MESSAGE_FILE_NOT_HERE;
		}
	}
	
	public File returnFile(){
		
		return file;
	}

}
