package elevator;

import java.util.ArrayList;
import java.util.Collections;

//Purpose: Elevator object for commands and independent action
public class Elevator {
	
	ArrayList<Integer> upRequest = new ArrayList<Integer>();
	ArrayList<Integer> downRequest = new ArrayList<Integer>();
	
	int floor = 1;
	String direction = "up";
	public boolean run = true;
	
	public Elevator(ArrayList<Integer> up, ArrayList<Integer> down) {
		upRequest = up;
		downRequest = down;
	}
	
	public void pause(int time) throws InterruptedException {
		
		System.out.println("Please exit the Elevator if this is your floor");
		for(int i = 1; i <= time; i++) {
			
			Thread.sleep(1000);
			System.out.print(i + ",");
		
		}
		Thread.sleep(1000);
	}
	
	public void move(ArrayList<Integer> el, String d) throws InterruptedException {
		
		int floorStop = 0;
		
		if(d.equals("up")) {
			Collections.sort(el);
		}else if(d.equals("down")) {
			Collections.sort(el, Collections.reverseOrder());
		}
		
		while((el.size() > 0 && d == "up") || (floor > 1 && d == "down" && el.size() > 0)) {
			
				floorStop = el.get(0);
				
				if(el.size()>1) {
					if(el.get(1) > floor) {
						direction = "up";
					}else if(el.get(1) < floor) {
						direction = "down";
					}
				}
				else {
					if(floorStop > floor) {
						direction = "down";
					}
				}
				
				
				if(floorStop == floor) {
					System.out.println("Stopping at floor " + floor + " for 3 seconds");
					pause(3);
					System.out.println("\nStarting at floor " + floor);
					el.remove(0);
					
				}else if(floor == 1) {
					System.out.println("\nStarting at floor " + floor);
				}
				
				if(direction.equals("up")) {
					if(el.size() == 0) {
						break;
					}
					else{
						floor++;
						System.out.println("Going " + direction + " : now at floor " + floor);
						Thread.sleep(2000);
					}
				}else if(direction.equals("down")){
					floor--;
					System.out.println("Going " + direction + " : now at floor " + floor);
					Thread.sleep(2000);
				}	
				
		}
	}
		
			
	
	public void startElevator() throws InterruptedException {
			
				move(upRequest, "up");
				move(downRequest, "down");	
			}
				
			
	}

