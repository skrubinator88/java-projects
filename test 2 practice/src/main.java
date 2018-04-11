import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ray = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a phrase: ");
		String word = scan.nextLine();
		System.out.println(check(word));

	}
	
	public static Boolean check(String L){
        if(L.equals("")){
            return true;
        }
//        else if(L.equals("B")){
//            return true;
//        }
        else if(L.equals("A")){
            return false;
        }
        else if(L.charAt(0) == 'A' && L.charAt(L.length()-1) == 'B'){
            System.out.println("pass");
            
            return check(L.substring(1, L.length()-1));
        }
        else if(L.charAt(0) == 'B' && L.charAt(L.length()-1) == 'B' && L.length() <= 2 && L.length() > 1){
            return true;
        }
        return false;
    }

}
