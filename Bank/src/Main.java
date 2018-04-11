import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/*
 * Title: Bank
 * Author: Oseriemen Ivbaze
 * Date: 4/10/18
 * 
 * Purpose: To simulate the processes of a bank life cycle
 * 
 * Solution: This program will run a bank simulation once it has been started. It was also prompt the user
 * for an option to repeat or quit once simulation has run
 * 
 * Data Structures: Queues, ArrayLists, Classes
 * 
 * User Guide: User only has to run the program and there will be 5 generated tellers. Once the simulation begins
 * customers will randomly be generated every 3 or 5 seconds and will be added to the line queue. Tellers will take from 
 * the queue to process customers. Once a teller has taken a customer its status will change to unavailable. If a teller
 * is unavailable the next available teller will be chosen to process the next customer from the line queue. This will go on
 * for a total of 2 minutes. Once the time is over the statistics of the simulation will be printed
 * out to the console. 
 * This includes:
 * 	- Total customers each teller assisted
 * 	- How long in seconds each teller was occupied in total
 * 	- Average wait time per second for each customer
 * 	- How many customers still waiting in line
 * 
 * Once this information is provided, user will have the option to quit or restart the simulation.
 * 	 
 * */


public class Main {

	public static void main(String[] args) throws InterruptedException {

		int numberOfTellers = 5;
		int numberOfSeconds = 120;
		double totalWait = 0.0;
		int numberOfCustomers = 0;
		String input = "";
		//New line and teller collection created
		Queue<Customer> line = new ArrayDeque<Customer>();
		ArrayList<Teller> tellers = new ArrayList<Teller>(numberOfTellers);
		
		//Tellers are added to teller collection
		for(int i = 0; i < 5; i++) {
			Teller teller = new Teller();
			tellers.add(teller);
		}
		//program loop begins
		while(!input.equals("q")) {
			for(int i = 0; i < 5; i++) {
				//add 5 customers to the line
				Customer customer = new Customer(System.nanoTime());
				line.offer(customer);
			}
			//loop bank simulation for 2 minutes
			for(int time = 1; time <= numberOfSeconds; time++) {
				//randomize when customers enter the line
				if(time % 3 == 0 || time % 5 == 0) {
					//add new customers to the line with current system time
					Customer newCustomer = new Customer(System.nanoTime());
					line.offer(newCustomer);
					System.out.println("A customer has walked in...");
				}
				//check all of the tellers for availability
				for(int i = 0; i < numberOfTellers; i++) {
					if(tellers.get(i).isFree() && !(line.isEmpty())) {
						//add customer at the front of the line to first available teller
						Customer frontCustomer = line.poll();
						tellers.get(i).addCustomer(frontCustomer);
						System.out.println("Teller " + i + " is now assisting next customer in line...");
						numberOfCustomers++;
						totalWait += (System.nanoTime() - frontCustomer.arrival());
					}
				}
				//wait for one second before looping again
				TimeUnit.SECONDS.sleep(1);
			}
			//output out teller info to console
			for(int i = 0; i < 5; i++) {
				System.out.println("Teller " + i + " has assisted " + tellers.get(i).totalCustomers + " customers");
				System.out.println(" and was occupied for " + tellers.get(i).getTime() + " seconds.\n");
			}
			//output global info to console
			System.out.println("Average wait time per customer is " + ((totalWait/1000000000)/numberOfCustomers) + " seconds.\n");
			System.out.println(line.size() + " customers have not been helped.");
			//prompt user for option to quit or restart simulation
			input = getInput("would you like to quit or restart bank? (Enter q to quit, y to restart)");
			//if quit end program
			if(input.equals("q")) {
				return;
			}
		}
		
		
	}
	//Pre: accepts a string
	//Post: outputs accepted string to console and returns user input
	public static String getInput(String message) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println(message);
			String option = scan.nextLine();
				
			return option;
		}

}
