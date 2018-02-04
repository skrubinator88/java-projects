package elevator;

/**
 * Title: Elevator
 * Author: Oseriemen Ivbaze
 * Date: 2/3/18
 * 
 * Purpose: This program simulates the process of an elevator running
 * 
 * Solution: Given a set of elevator requests, this program will go to all respective
 * floor requests and eventually start back at floor 1
 * 
 * Data Structures: Classes, ArrayLists
 * 
 * User Guide: Once program has been started a random set of elevator requests will be 
 * processed and the simulator will stop at all of the floors generated. The elevator
 * will stop for 3 seconds at each of the stops requested, and move on to the next stop.
 * Once the elevator has visited each stop it will eventually end up back at floor 1 and 
 * will give you the option to run the simulator again.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Purpose: Initializes the entire program
public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Integer> up = new ArrayList<Integer>();
		ArrayList<Integer> down = new ArrayList<Integer>();
		
		String option = "yes";
		
		
		Elevator elevator = null;
		
		while(option.equals("yes")) {
			
			
			fillRequest(up,9, "up");
			fillRequest(down,5, "down");
			elevator = new Elevator(up,down);
			
			option = getInput("Would you like to run elevator? yes or no");
			
			if(option.equals("no")) {
				System.out.println("Thanks for riding!");
				System.exit(0);
			}
			
			elevator.startElevator();	
		}		
		
		
	}
	
	
	public static void fillRequest(ArrayList<Integer> obj, int size, String direction) {
		
		Random rand = new Random();
		
		while(obj.size() <= size) {
			int x = rand.nextInt(12)+1;
			
			if(!obj.contains(x) && !(x == 1 && direction.equalsIgnoreCase("up"))) {
				obj.add(x);
			}
	
		}
		
	}
	
	@SuppressWarnings("resource")
	public static String getInput(String message) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(message);
		String option = scan.nextLine();
			
		return option;
	}
	
	
}
	
	
	
