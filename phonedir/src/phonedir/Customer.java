package phonedir;

import java.util.LinkedList;
//Purpose: Fundamental ADT used for the storing and arranging of user input
public class Customer {
	String lastName = "";
	String firstName = "";
	String phoneNumber = "";
	
	public Customer() {
		lastName = "";
		firstName = "";
		phoneNumber = "";
	}
	public Customer(String first, String last, String phone) {
		firstName = first;
		lastName = last;
		phoneNumber = phone;
	}
	//Pre: accepts a Customer Linked List, phone number String, and a Customer object
	public void changePhone(LinkedList<Customer> e, String phone, Customer target) {
		//Creates an edited Customer object with the new phone number
		Customer newTarget = new Customer(target.firstName, target.lastName, phone);
		//assigns the position variable to a string after checking
		String newPosition = checkPhoneNumber(e, newTarget)[0];
		//assigns the index of the new location of the edited Customer
		int newIndex = Integer.parseInt(checkPhoneNumber(e, newTarget)[1]);
		
		if(newPosition == "success") {
			//removes the original Customer object
			e.remove(target);
			//adds in the edited Customer and into the right index
			e.add(newIndex, newTarget);
		}
		else {
			//Logs out if edited customer object already exists within list
			System.out.println("Duplicate customer");
		}
		
	}
	
	public void changeFirstName(LinkedList<Customer> e, String first, Customer target) {
		//checks to see if list is empty
		if(!e.isEmpty()) {
			//Creates an edited Customer object with the new first name
			Customer newTarget = new Customer(first, target.lastName, target.phoneNumber);
			//assigns the position variable to a string after checking
			String position = checkFirstName(e, newTarget)[0];
			//assigns the index of the new location of the edited Customer
			int index = Integer.parseInt(checkFirstName(e, newTarget)[1]);
			//checks to see if First name already exists in list
			if(position == "success") {
				//removes the original Customer object
				e.remove(target);
				//adds in the edited Customer and into the right index
				e.add(index, newTarget);
			}
			//goes on to insert based on phone number sort 
			else{
				changePhone(e,newTarget.phoneNumber, target);
			}
		}
		//logs out if list is empty
		else {
			System.out.println("No records currently available");
		}
	}
	
	public void changeLastName(LinkedList<Customer> e, String last, Customer target) {
		//Creates an edited Customer object with the new last name
		Customer newTarget = new Customer(target.firstName, last, target.phoneNumber);
		//assigns the position variable to a string after checking
		String position = checkLastName(e, newTarget)[0];
		//assigns the index of the new location of the edited Customer
		int index = Integer.parseInt(checkLastName(e, newTarget)[1]);
		//checks to see if last name already exists in list
		if(position == "success") {
			//removes the original Customer object
			e.remove(target);
			//adds in the edited Customer and into the right index
			e.add(index, newTarget);
		}
		else{
			//goes on to insert based on phone number sort 
			changeFirstName(e, newTarget.firstName, target);
		}
	}
	//Pre: Accepts 2 non-null Customer Objects
	private String checkDuplicate(Customer cust, Customer target) {
		
		String answer = "";
		//Checks each respective variable for duplicates and passes the type to answer variable
		if(cust.lastName.equalsIgnoreCase(target.lastName)) {
			answer = "lastName duplicate";
			if(cust.firstName.equalsIgnoreCase(target.firstName)) {
				answer = "firstName duplicate";
				if (cust.phoneNumber.equalsIgnoreCase(target.phoneNumber)) {
					answer = "duplicate";
					
				}
			}
		}
		//Post: Returns the type of duplicate if found in String format
		return answer;
	}
	//Pre: Accepts a list and a non-null Customer Object
	public String[] checkLastName(LinkedList<Customer> e , Customer target) {
		//declares a String array for storing output variables
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			//sets temporary Customer Variable to current iteration of loop
			Customer currentCust = e.get(i);
			//checks to see if none of the variables already exist in list
			if(checkDuplicate(currentCust, target) != "lastName duplicate" && checkDuplicate(currentCust, target) != "firstName duplicate" && checkDuplicate(currentCust, target) != "duplicate") {
				//checks to see where Customer needs to be placed in list based on last name
				if(currentCust.lastName.compareToIgnoreCase(target.lastName) > 0) {
					//outputs indication of success and new index location into output tokens
					tokens[0] = "success";
					tokens[1] = i+"";
				}
				else {
					continue;
				}
			}
			else {
				//assigns an empty output and the index location of duplicate if found to output variables
				tokens[0] = "";
				tokens[1] = i+"";
				break;
			}	
		}
		//Post: returns output variables
		return tokens;
	}
	//Pre: Accepts a list and a non-null Customer Object
	public String[] checkFirstName(LinkedList<Customer> e, Customer target) {
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			//sets temporary Customer Variable to current iteration of loop
			Customer currentCust = e.get(i);
			//checks to see if none of the variables already exist in list
			if(checkDuplicate(currentCust, target) != "firstName duplicate" && checkDuplicate(currentCust, target) != "duplicate") {
				//checks to see where Customer needs to be placed in list based on first name
				if(currentCust.firstName.compareToIgnoreCase(target.firstName) > 0) {
					//outputs indication of success and new index location into output tokens
					tokens[0] = "success";
					tokens[1] = i+"";
				}
				else {
					continue;
				}
				
			}
			else {
				//assigns an empty output and the index location of duplicate if found to output variables
				tokens[0] = "";
				tokens[1] = i+"";
				break;
			}
		}
		//Post: returns output variables
		return tokens;
	}
	//Pre: Accepts a list and a non-null Customer Object
	public String[] checkPhoneNumber(LinkedList<Customer> e, Customer target) {
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			//sets temporary Customer Variable to current iteration of loop
			Customer currentCust = e.get(i);
			//checks to see if none of the variables already exist in list
			if(checkDuplicate(currentCust, target) != "duplicate") {
				//checks to see where Customer needs to be placed in list based on phone number
				if(currentCust.phoneNumber.compareToIgnoreCase(target.phoneNumber) > 0) {
					//outputs indication of success and new index location into output tokens
					tokens[0] = "success";
					tokens[1] = i+"";
				}
				else {
					continue;
				}
				
			}
			else {
				//assigns an empty output and the index location of duplicate if found to output variables
				tokens[0] = "";
				tokens[1] = i+"";
				break;
			}
		}
		//Post: returns output variables
		return tokens;
	}
}
