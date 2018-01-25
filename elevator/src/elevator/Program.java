package elevator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Integer> up = new ArrayList<Integer>();
		ArrayList<Integer> down = new ArrayList<Integer>();
		
		String option = "yes";
		
		
		Elevator elevator = new Elevator(up, down);
		
		while(option.equals("yes")) {
			
			
			fillRequest(up,9);
			fillRequest(down,5);
			elevator = new Elevator(up,down);
			
			option = getInput("Would you like to run elevator? yes or no");
			
			if(option.equals("no")) {
				System.out.println("Thanks for riding!");
				System.exit(0);
			}
			
			elevator.startElevator();	
		}		
		
		
	}
	
	
	public static void fillRequest(ArrayList<Integer> obj, int size) {
		
		Random rand = new Random();
		
		while(obj.size() <= size) {
			int x = rand.nextInt(12)+1;
			
			if(!obj.contains(x)) {
				obj.add(x);
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
	
	
	
