package phonedir;

import java.util.LinkedList;
//Purpose: Acts as a phone directory and utilizes the customer class for adding and retrieving data
public class PhoneDir {
	
	LinkedList<Customer> phonedir = new LinkedList<Customer>();
	Customer currentRecord = new Customer();
	
	public PhoneDir() {
		currentRecord = currentRecord;
	}

	public PhoneDir(Customer record) {
		phonedir.add(record);
		currentRecord = record;
	}

	public void showRecords() {
		//Checks to see if directory is empty
		if(!phonedir.isEmpty()) {
			//Prints out menu header
			System.out.println("First Name\t Last Name\t Phone Number\n"
					+ "----------\t ----------\t ----------");
			//Loops through directory and outputs all info for each respective Customer
			for(int i = 0; i < phonedir.size(); i++) {
				System.out.println(phonedir.get(i).firstName + "\t    \t" + phonedir.get(i).lastName + "\t \t" + phonedir.get(i).phoneNumber + "\n");
			}
		}
		//Logs out if directory is empty
		else {
			System.out.println("No records currently available");
		}
	}
	//Pre: Accepts a first name String value, a last name String value, and a phone number as a String
	public void addCustomer(String firstName, String lastName, String phoneNumber) {
		String phone = "";
		//Changes phone number format
		for(int i = 0; i< phoneNumber.length(); i++) {
			//checks to see if current character is not a number and advances loop if so
			if(phoneNumber.charAt(i) < 48 || (phoneNumber.charAt(i) > 57)) {
				continue;
			}
			//adds dashes to appropriate locations
			else {
				if(phone.length() == 3 || phone.length() == 7) {
					phone += "-";
				}
			//adds phone number digits to correctly formatted String	
			phone += phoneNumber.charAt(i);
			}
		}
		//Creates a new Customer object with all accepted variables and newly formatted phone number
		Customer customer = new Customer(firstName, lastName, phone);
		//Checks to see if directory is empty
		if(!phonedir.isEmpty()) {
			//checks respective variables for duplicates and places in correct order if some are found
			if(customer.checkLastName(phonedir, customer)[0] == "") {
				if(customer.checkFirstName(phonedir, customer)[0] == "") {
					phonedir.add((Integer.parseInt(customer.checkPhoneNumber(phonedir, customer)[1])), customer);
					if(customer.checkPhoneNumber(phonedir, customer)[0] == "") {
						//logs out if a duplicate customer is found and does not add to directory
						System.out.println("Customer already exists");
					}
				}
				else
					phonedir.add((Integer.parseInt(customer.checkFirstName(phonedir, customer)[1])), customer);
			}
			else
				phonedir.add((Integer.parseInt(customer.checkLastName(phonedir, customer)[1])), customer);
		}
		//adds Customer to directory
		else {
			phonedir.add(customer);
		}
		//sets current record new newly added Customer
		currentRecord = customer;
	}
	
	public void deleteRecord() {
		//checks to see if currentRecord contains a Customer object
		if(currentRecord != null) {
			//removes currentRecord from directory and resets currentRecord
			phonedir.remove(currentRecord);
			currentRecord = null;
		}
		//Logs out if currentRecord does not exist
		else {
			System.out.println("No record has been selected");
		}
	}
	//Pre: Accepts first and last name String values
	public void selectRecord(String first, String last) {
		//Checks to see if directory is empty
		if(!phonedir.isEmpty()) {
			//creates a temporary Customer and sets first and last name variables to Customer
			Customer tempCust = new Customer();
			tempCust.firstName = first;
			tempCust.lastName = last;
			//Searches directory for record using temporary Customer object and logs out an error if not found
			if(currentRecord.checkLastName(phonedir, tempCust)[0] == "") {
				if(currentRecord.checkFirstName(phonedir, tempCust)[0] == "") {
					int index = Integer.parseInt(currentRecord.checkPhoneNumber(phonedir, tempCust)[1]);
					//sets current record to found Customer and logs out success message
					currentRecord = phonedir.get(index);
					System.out.println("Current Record is " + phonedir.get(index).firstName + "\t " + phonedir.get(index).lastName + "\t " + phonedir.get(index).phoneNumber);
				}
				else
					System.out.println("No Matching record found\n");
			}
			else
				System.out.println("No Matching record found\n");
		}
		//logs out if directory is empty
		else {
			System.out.println("No records currently available\n");
		}
	}
}
