
public class CommandObject {

	String information;
	String command;
	public CommandObject(String command,String information){

		this.information = information;
		this.command = command;

	}	

	public String returnCommand(){
		
		
		return command;
		
	}
	
	public String returnInformation(){
		
		return information;
	}
}
