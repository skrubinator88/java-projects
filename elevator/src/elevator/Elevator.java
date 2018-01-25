package elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
	
	
	public void move(ArrayList<Integer> el, String d) throws InterruptedException {
		
		int floorStop = 0;
		
		if(d.equals("up")) {
			Collections.sort(el);
		}else if(d.equals("down")) {
			Collections.sort(el, Collections.reverseOrder());
		}
		
		while((el.size() > 1 && d == "up") || (floor > 1 && d == "down")) {
			
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
					Thread.sleep(3000);
					System.out.println("\nStarting at floor " + floor);
					el.remove(0);
					
				}else if(floor == 1) {
					System.out.println("\nStarting at floor " + floor);
				}
				
				if(direction.equals("up")) {
					floor++;
					System.out.println("Going " + direction + " : now at floor " + floor);
					Thread.sleep(2000);
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

