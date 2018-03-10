package phonedir;

/**
 * Title: Phonedir
 * Author: Oseriemen Ivbaze
 * Date: 3/9/18
 * 
 * Purpose: This program processes contact information and saves them into a phone directory
 * 
 * Solution: Given contact info, this program will add it to the storage. Once in there it can be manipulated
 * according to the user
 * 
 * Data Structures: Linked Lists, Array, Classes
 * 
 * User Guide: When program starts user will be given a set of instructions and commands. When the user types in 
 * 			a certain command the program will execute. The different commands that can be executed are as follows. 
 * 			- a: used to show display all current contact records to user
 * 			- f: used to change the first name of the current selected record
 * 			- l: used to change the last name of the current selected record
 * 			- n: used to create a new record from the user provided values after execution
 * 			- p: used to change the phone number of the current selected record
 * 			- s: used to select a record based on a first and last name query
 * 			- q: used to quit the program
 */

import java.util.LinkedList;
import java.util.Scanner;
//Purpose: runs the program and accepts user input for processing
public class program {

	public static void main(String[] args) {
		
		PhoneDir phoneDir = new PhoneDir();
		//Creates new default menu message
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
			//accepts user input command
			userSelection = getInput(menuMessage);
			//executes respective phoneDir methods according to command given by user
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
				phoneDir.showRecords();
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
			//logs out if user gives a command other than requested
			else {
				System.out.println("Invalid Input, please try again");
			}
			
		}
	}
	//Used for keeping the scanner open and accepting user input
	public static String getInput(String message) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(message);
		String option = scan.nextLine();
			
		return option;
	}
}
