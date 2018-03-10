package phonedir;

import java.util.LinkedList;

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
		if(!phonedir.isEmpty()) {
			System.out.println("First Name\t Last Name\t Phone Number\n"
					+ "----------\t ----------\t ----------");
			for(int i = 0; i < phonedir.size(); i++) {
				System.out.println(phonedir.get(i).firstName + "\t    \t" + phonedir.get(i).lastName + "\t \t" + phonedir.get(i).phoneNumber );
			}
		}
		else {
			System.out.println("No records currently available");
		}
	}
	
	public void addCustomer(String firstName, String lastName, String phoneNumber) {
		String phone = "";
		for(int i = 0; i< phoneNumber.length(); i++) {
			if(phoneNumber.charAt(i) < 48 || (phoneNumber.charAt(i) > 57)) {
				continue;
			}
			else {
				if(phone.length() == 3 || phone.length() == 7) {
					phone += "-";
				}
				phone += phoneNumber.charAt(i);
			}
		}
		Customer customer = new Customer(firstName, lastName, phone);
		
		if(!phonedir.isEmpty()) {
			if(customer.checkLastName(phonedir, customer)[0] == "") {
				if(customer.checkFirstName(phonedir, customer)[0] == "") {
					phonedir.add((Integer.parseInt(customer.checkPhoneNumber(phonedir, customer)[1])), customer);
					if(customer.checkPhoneNumber(phonedir, customer)[0] == "") {
						System.out.println("Customer already exists");
					}
				}
				else
					phonedir.add((Integer.parseInt(customer.checkFirstName(phonedir, customer)[1])), customer);
			}
			else
				phonedir.add((Integer.parseInt(customer.checkLastName(phonedir, customer)[1])), customer);
		}	
		else {
			phonedir.add(customer);
		}
		currentRecord = customer;
	}
	
	public void deleteRecord() {
		
		if(currentRecord != null) {
			phonedir.remove(currentRecord);
			currentRecord = null;
		}
		else {
			System.out.println("No record has been selected");
		}
	}
	
	public void selectRecord(String first, String last) {
		
		if(!phonedir.isEmpty()) {
			Customer tempCust = new Customer();
			tempCust.firstName = first;
			tempCust.lastName = last;
			if(currentRecord.checkLastName(phonedir, tempCust)[0] == "") {
				if(currentRecord.checkFirstName(phonedir, tempCust)[0] == "") {
					int index = Integer.parseInt(currentRecord.checkPhoneNumber(phonedir, tempCust)[1]);
					currentRecord = phonedir.get(index);
					System.out.println("Current Record is " + phonedir.get(index).firstName + "\t " + phonedir.get(index).lastName + "\t " + phonedir.get(index).phoneNumber);
				}
				else
					System.out.println("No Matching record found\n");
			}
			else
				System.out.println("No Matching record found\n");
		}
		else {
			System.out.println("No records currently available\n");
		}
	}
}
