package phonedir;

import java.util.LinkedList;
import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		
		PhoneDir phoneDir = new PhoneDir();
		
		String menuMessage = "a Show all records\n"
				+ "d Delete the current record\n"
				+ "f Change the first name in the current record\n"
				+ "l Change the last name in the current record\n"
				+ "n Add a new record\n"
				+ "p Change the phone number in the current record\n"
				+ "q Quit\n"
				+ "s Select from the record list to become the current record";
		
		String userSelection = "";
		
		while(userSelection != "q") {
			
			userSelection = getInput(menuMessage);
			
			if(userSelection.equals("a")) {
				phoneDir.showRecords();
			}else if(userSelection.equals("d")) {
				phoneDir.deleteRecord();
			}else if(userSelection.equals("f")) {
				String firstName = getInput("First Name: ");
				phoneDir.currentRecord.changeFirstName(phoneDir.phonedir, firstName, phoneDir.currentRecord);
			}else if(userSelection.equals("l")) {
				String lastName = getInput("Last Name: ");
				phoneDir.currentRecord.changeLastName(phoneDir.phonedir, lastName, phoneDir.currentRecord);
			}else if(userSelection.equals("n")) {
				String first = getInput("First Name: ");
				String last = getInput("Last Name: ");
				String phone = getInput("Phone Number: ");
				
				phoneDir.addCustomer(first, last, phone);
			}else if(userSelection.equals("p")) {
				String phone = getInput("phone: ");
				phoneDir.currentRecord.changeLastName(phoneDir.phonedir, phone, phoneDir.currentRecord);
			}else if(userSelection.equals("s")) {
				phoneDir.showRecords();
				String first = getInput("\nFirst Name: ");
				String last = getInput("Last Name: ");
				
				phoneDir.selectRecord(first, last);
			}
			else if(userSelection.equals("q")) {
				System.out.println("Thanks for using my phone directory! ");
				break;
			}
			else {
				System.out.println("Invalid Input, please try again");
			}
			
		}
	}
	
	public static String getInput(String message) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(message);
		String option = scan.nextLine();
			
		return option;
	}
}
