package calc;

import java.util.Scanner;
import java.util.Stack;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userInput = "";
		String postFixString;
		
		
		while(userInput != "q") {
			
			postFixString = getInput("Enter a mathematical expression with an unknown variable of x: ");
			postFixString = infixToPost(postFixString);
			
			String variable = getInput("Enter value of x: ");
			
			Calculator calc = new Calculator(postFixString, Integer.parseInt(variable));
			calc.eval();
			
			userInput = getInput("Quit or continue? (Enter q to quit) ");
			if(userInput == "q") {
				System.out.println("Thanks for using my calculator");
				System.exit(0);
			}
		}
	}
	
	public static String getInput(String message) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(message);
		String option = scan.nextLine();
			
		return option;
	}

	public static int opOrder(char op) {
		if( op == '*' || op == '/') {
			return 1;
		}
		if(op == '+' || op == '-') {
			return 2;
		}
		if(op == '%')
			return 3;
		return 0;
	}
	
	public static int processOp(char op, Stack<Character> opStack, String result) {
		
		while(!opStack.empty() && (opOrder(op) <= opOrder(opStack.peek()))) {
			if(opStack.peek() == op) {
				System.out.println("Input mismatch: Operator repeated!");
			}else {
				result += opStack.pop();
				opStack.push(op);
				return 1;
			}
			
		}
		return 0;
	}
	
	public static String infixToPost(String infix) {
		Stack<Character> opStack = new Stack<Character>();
		String result = "";
		int i = 0;
		
		while(i < infix.length()) {
			char current = infix.charAt(i);
			if(Character.isDigit(current)) {
				result += current;
				i++;
				if(i < infix.length()-1) {
					while(Character.isDigit(current)) {
						System.out.println(result);
						result += current;
						i++;
					}
				}
			}else {
				if(infix.charAt(i++) == '(') {
					opStack.push('(');
					i++;
				}else if(infix.charAt(i++) == ')') {
					while(opStack.peek() != '(') {
						result += opStack.pop();
					}
					opStack.pop();
					i++;
				}else if(current == '+') {
					if(processOp(current, opStack, result) == 0) {
						result = "";
						return result;
					};
					i++;
				}else if(current == '-') {
					if(processOp(current, opStack, result) == 0) {
						result = "";
						return result;
					};
					i++;
				}else if(current == '/') {
					if(processOp(current, opStack, result) == 0) {
						result = "";
						return result;
					};
					i++;
				}else if(current == '*') {
					if(processOp(current, opStack, result) == 0) {
						result = "";
						return result;
					};
					i++;
				}else if(current == '%') {
					if(processOp(current, opStack, result) == 0) {
						result = "";
						return result;
					};
					i++;
				}	
			}
		}
		
		return result;
	} 
}
