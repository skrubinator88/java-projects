import java.util.concurrent.TimeUnit;

//Purpose: To act as a bank teller and receive and process customers
public class Teller {
	
	boolean free = true;
	Customer currentCust;
	long busyTime = 0;
	int totalCustomers;
	long occupiedTime = 0;
	
	public Teller() {
		free = true;
	}
	//Pre: Accepts Customer with time already set
	public void addCustomer(Customer x) {
		//assigns accepted customer to this customer
		currentCust = x;
		occupiedTime += TimeUnit.NANOSECONDS.toSeconds(x.timeRequested());
		//adds customers requested time to Teller time
		setBusyTime(x.timeRequested());
		totalCustomers++;
	}
	//Post: returns a boolean telling whether Teller is available to accept customers
	public boolean isFree() {
		//returns true if Customer requested time has expired
		if(System.nanoTime() - busyTime > 0)
			return true;
		if(free)
			return true;
		return free;
	}
	//Pre: accepts time in long format
	//Post: adjusts Teller time to Customer requested time and sets availability to false
	private void setBusyTime(long x) {
		busyTime = x + System.nanoTime();
		free = false;
	}
	
	public long getTime() {
		//retrieves total time Teller spent with customers
		return occupiedTime;
	}
}
