package phonedir;

import java.util.LinkedList;

public class Customer {
	String lastName = "";
	String firstName = "";
	String phoneNumber = "";
	
	public Customer(String first, String last, String phone) {
		firstName = first;
		lastName = last;
		phoneNumber = phone;
	}
	
	public void changePhone(LinkedList<Customer> e, String phone, Customer target) {
		Customer newTarget = new Customer(target.firstName, target.lastName, phone);
		
		String newPosition = checkPhoneNumber(e, newTarget)[0];
		int newIndex = Integer.parseInt(checkPhoneNumber(e, newTarget)[1]);
		
		if(newPosition == "before") {
			e.add(newIndex, newTarget);
			e.remove(target);
		}
//		else if(newPosition == "after") {
//			e.add(newIndex+1, newTarget);
//			e.remove(target);
//		}
		else {
			System.out.println("Duplicate customer");
		}
		
	}
	
	public void changeFirstName(LinkedList<Customer> e, String first, Customer target) {
		Customer newTarget = new Customer(first, target.lastName, target.phoneNumber);
		
		String position = checkFirstName(e, newTarget)[0];
		int index = Integer.parseInt(checkFirstName(e, newTarget)[1]);
		
		if(position == "before") {
			e.add(index, newTarget);
			e.remove(target);
		}
//		else if(position == "after") {
//			e.add(index+1, newTarget);
//			e.remove(target);
//		}
		else if(position == "") {
			changePhone(e,newTarget.phoneNumber, target);
		}
	}
	
	public void changeLastName(LinkedList<Customer> e, String last, Customer target) {
		Customer newTarget = new Customer(last, target.lastName, target.phoneNumber);
		
		String position = checkLastName(e, newTarget)[0];
		int index = Integer.parseInt(checkLastName(e, newTarget)[1]);
		
		if(position == "before") {
			e.add(index, newTarget);
			e.remove(target);
		}
//		else if(position == "after") {
//			e.add(index+1, newTarget);
//			e.remove(target);
//		}
		else if(position == "") {
			changePhone(e, newTarget.phoneNumber, target);
		}
	}
	
	
	
	public String getAttrib(String attrib) {
		if(attrib.equalsIgnoreCase("first")) {
			return firstName;
		}
		else if(attrib.equalsIgnoreCase("last")) {
			return lastName;
		}
		else if(attrib.equalsIgnoreCase("phone")) {
			return phoneNumber;
		}
		
		return "Not a valid argument";
	}
	
	private String checkDuplicate(Customer cust, Customer target) {
		
		String answer = "";
		if(cust.lastName.equalsIgnoreCase(target.lastName)) {
			answer = "lastName duplicate";
			if(cust.firstName.equalsIgnoreCase(target.firstName)) {
				answer = "firstName duplicate";
				if (cust.phoneNumber.equalsIgnoreCase(target.phoneNumber)) {
					answer = "duplicate";
					
				}
			}
		}
		
		return answer;
	}
	
	public String[] checkLastName(LinkedList<Customer> e , Customer target) {
		
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			Customer currentCust = e.get(i);
			
			if(checkDuplicate(currentCust, target) != "lastName duplicate" || checkDuplicate(currentCust, target) != "firstName duplicate" || checkDuplicate(currentCust, target) != "duplicate") {
				//check to see order of lastName
				if(currentCust.lastName.compareToIgnoreCase(target.lastName) > 0) {
					tokens[0] = "before";
					tokens[1] = i+"";
				}
//				else if(currentCust.lastName.compareToIgnoreCase(target.lastName) < 0) {
//					tokens[0] = "after";
//					tokens[1] = i+"";
//				}
				else {
					continue;
				}
				
			}
			else {
				System.out.println(checkDuplicate(currentCust, target));
				break;
			}
				
		}
		
		return tokens;
	}
	
	public String[] checkFirstName(LinkedList<Customer> e, Customer target) {
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			Customer currentCust = e.get(i);
			
			if(checkDuplicate(currentCust, target) != "firstName duplicate" || checkDuplicate(currentCust, target) != "duplicate") {
				//check to see order of lastName
				if(currentCust.firstName.compareToIgnoreCase(target.firstName) > 0) {
					tokens[0] = "before";
					tokens[1] = i+"";
				}
				else if(currentCust.firstName.compareToIgnoreCase(target.firstName) < 0) {
					tokens[0] = "after";
					tokens[1] = i+"";
				}
				else {
					continue;
				}
				
			}
			else {
				System.out.println(checkDuplicate(currentCust, target));
				break;
			}
		}
		
		return tokens;
	}
	
	public String[] checkPhoneNumber(LinkedList<Customer> e, Customer target) {
		String[] tokens = new String[2];
		for(int i = 0; i < e.size(); i++) {
			Customer currentCust = e.get(i);
			
			if(checkDuplicate(currentCust, target) != "firstName duplicate" || checkDuplicate(currentCust, target) != "duplicate") {
				//check to see order of lastName
				if(currentCust.phoneNumber.compareToIgnoreCase(target.phoneNumber) > 0) {
					tokens[0] = "before";
					tokens[1] = i+"";
				}
				else if(currentCust.phoneNumber.compareToIgnoreCase(target.phoneNumber) < 0) {
					tokens[0] = "after";
					tokens[1] = i+"";
				}
				else {
					continue;
				}
				
			}
			else {
				System.out.println(checkDuplicate(currentCust, target));
				break;
			}
		}
		
		return tokens;
	}
}
