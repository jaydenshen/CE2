import java.util.Scanner;


public class UserInterface {

	String input;
	Scanner sc;
	public UserInterface(){
		
		this.sc = new Scanner(System.in);
		
		
	}
	
	public String getInput(){
		
		return sc.nextLine();
		
	}
	
	public void printOutput(String output){
		
		System.out.println(output);
	}
}
