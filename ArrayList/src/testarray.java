import java.util.Random;
import java.util.Scanner;

public class testarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter an initial size for your new ArrayList: ");
		
		int size = input.nextInt();
		ArrayList list = new ArrayList();
		ArrayList customList = new ArrayList(size);
		
		Random rand = new Random();
		
		for(int i = 0; i < 15; i++) {
			list.add(i, new Integer(rand.nextInt(26)));
			customList.add(i, new Integer(rand.nextInt(26)));
		}

		System.out.println("Here I used the add method with a parameter to initialize \n" + list.toString());
		System.out.println(customList.toString());
		
		list.add(new Integer(5));
		customList.add(new Integer(6));
		
		System.out.println("Here I'm using the add method with no parameters \n" + list.toString());
		System.out.println(customList.toString());
		
		System.out.println("get Method: " + list.get(2));
		
		System.out.println("isEmpty: " + list.isEmpty());
		
		System.out.println("isIn Method: " + list.isIn(new Integer(4)));
		
		System.out.println("find Method: " + list.find(new Integer(16)));
		
		System.out.println("size Method: " + list.size() + " and " + customList.size());
		
		System.out.println("Removing number 7 if present");
		
		list.remove(new Integer(7));
		customList.remove(new Integer(7));
		
		System.out.println(list.toString());
		System.out.println(customList.toString());
		
		
		
		
		
		
		
		
	}

}
