package calc;

import java.util.Scanner;
import java.util.Stack;
/*
 * Title: Calc
 * Author: Oseriemen Ivbaze
 * Date: 3/26/18
 * 
 * Purpose: used to solve mathematical functions
 * 
 * Solution: This program will correctly compute arithmetic functions and output an answer to the user 
 * 
 * Data Structures: Stacks, Classes
 * 
 * User Guide: 
 * User will be prompted to enter a mathematical expression with an unknown variable of x.
 * Once that is done User will again be prompted to provide a value to x. Once that value has
 * been received, the program will compute and output an answer to the expression substituted
 * with the user provided value for x.
 * 
 * 	
 * */

//Purpose: To start program, and serve as a frontend for user commands
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userInput = "";
		String postFixString;
		
	
		while(userInput != "q") {
			//gets infix expression from user
			postFixString = getInput("Enter a mathematical expression with an unknown variable of x: ");
			postFixString = infixToPostfix(postFixString);
			
			//gets variable value from user
			String variable = getInput("Enter value of x: ");
			
			//computes expression with calculator
			calc calc = new calc(postFixString, Integer.parseInt(variable));
			calc.eval();
			
			//prompts user for option to quit program
			userInput = getInput("Quit or continue? (Enter q to quit) ");
			//quits program
			if(userInput.equalsIgnoreCase("q")) {
				System.out.println("Thanks for using my calculator!");
				System.exit(0);
			}
		}
	}
	
	//Pre: accepts a string message
	//Post: Outputs accepted user input as a String
	public static String getInput(String message) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(message);
		String option = scan.nextLine();
			
		return option;
	}
	//Pre: accepts an operator character
	//Post: returns order precedence of operator as an integer
	public static int opOrder(char operator)
    {
        switch (operator)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

	//Pre:accepts an infix string expression
	//Post: returns infix expression as a postfix string
	public static String infixToPostfix(String exp)
    {
        String result = new String("");
       
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
             
             // If scanned character is an operand add to result
            if (Character.isLetterOrDigit(c))
                result += c;
              
            // If scanned character is a '(' push to stack
            else if (c == '(')
                stack.push(c);
             
            //  If scanned character is an ')' pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                 
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression                
                else
                    stack.pop();
            }
         // an operator is encountered
            else 
            {
                while (!stack.isEmpty() && opOrder(c) <= opOrder(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
      
        }
      
        // pop all operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();
      
        return result;
    }
}
