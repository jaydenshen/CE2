
public class Parser {
	
	String input;
	String command;
	String information;
	String[] arr;
	public Parser(String input){
		
		this.input = new String();
		this.command = new String();
		this.arr = new String[0];
		this.input = input;
		
	}
	
	public CommandObject getCommandObject(){
		
		getCommand();
		getInformation();
		CommandObject commandObject = new CommandObject(command,information);
		return commandObject;
	}
	
	public void getInformation() {
		
		information = "";
		for (int i = 1; i < arr.length; i++) {

			information = information + arr[i] + " ";
			
		}
	}
	
	public void getCommand() {

		if (input.length() == 0) {
			return;
		} else {

			input.trim();
			arr = input.split(" ");
			command = arr[0].toLowerCase();
			
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
