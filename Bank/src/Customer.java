import java.util.Random;
import java.util.concurrent.TimeUnit;
//Purpose: To act as a customer and request assistance time
public class Customer {
	long arrivalTime = 0;
	long processTime = 0;
	Random r = new Random();
	//Pre: time in long format
	//Constructor for Customer that randomizes a requested time
	public Customer(long x) {
		arrivalTime = x;
		processTime = (long)(TimeUnit.SECONDS.toNanos(r.nextInt((5 - 2) + 1) + 2));
	}
	//returns the time customer arrived in line queue
	public long arrival() {
		return arrivalTime;
	}
	//returns the time customer requested for assistance
	public long timeRequested() {
		return processTime;
	}
}
