
import java.io.IOException;




public class TextBuddy {

 private static boolean exit = false;
 private static String input = "";
 private static String command;
 private static String information;
 public static  Cache cache;
 public static FileToWrite fileToWrite;
 private static String output = "";
 public static void main(String args[]) throws IOException{
		
		fileToWrite = new FileToWrite(args[0]);
		fileToWrite.createFile();
		cache = new Cache();
		takeInput();
	
	
	}
	
	private static void takeInput() throws IOException{
		
		UserInterface ui = new UserInterface();
		while (!exit) {
			
			input = ui.getInput();
			Parser parser = new Parser(input);
			CommandObject commandObject = parser.getCommandObject();
			command = commandObject.returnCommand();
			information = commandObject.returnInformation();
			output = doInstruction();
			ui.printOutput(output);
		}
		System.exit(1);
	
		
	}
	
	private static String doInstruction() throws IOException {

		switch (command) {

		case "add":
			return addInformation();
		
		case "clear":
			return clearFile();
		
		case "delete":
			return deleteLineFromFile();
		
		case "display":
			return displayFile();
		
		case "sort":
			return sortTheFile();
			
		case "exit":	
			exit = true;
			return "Thank you for using our program!";
			
		default:
			return "";
			

		}

	}
	private static String sortTheFile(){
		
		cache.sort();
		
		
	}
	
	private static String addInformation() throws IOException{
		
		if(information.length() != 0){
			
			cache.addToCache(information);
			return fileToWrite.writeToFile(information);
		
		}else{
			
			return "No information given";
		}
		
	}
	
	private static String clearFile() throws IOException{
		
		cache.clearCache();
		return fileToWrite.clearTheFile();
		
	}
	
	private static String deleteLineFromFile() throws IOException{
		
		if(cache.checkValidLine(information)){
			
			String deleteLine = cache.deleteLine(information);
			return FileToWrite.delete(deleteLine,cache);
			
		}else{
			
			return "No such line please try again"; 
		}
	}

	private static String displayFile(){
		
		return fileToWrite.display();
		
	}

	

}
