package calc;

import java.util.Stack;

public class CalculatorEngine {
	Stack<Integer> calcStack = new Stack<Integer>();
	
	//Pre: Accepts an integer value and adds to calc stack 
	public void pushOperand(int operand) {
		calcStack.push(operand);
		
	}
	
	int currentMemory() {
		return calcStack.peek();
	}
	
	//Pre: accepts a character operator
	//Post: performs operation and pushes result to calcStack
	public void doOperator(char operator) {
		int right = calcStack.pop();
		int left = calcStack.pop();
		int result;
		
		if(operator == '+') {
			result = left + right;
			calcStack.push(result);
			
		}else if(operator == '-'){
			result = left - right;
			calcStack.push(result);
			
		}else if(operator == '/') {
			result = left / right;
			calcStack.push(result);
			
		}else if(operator == '*') {
			result = left * right;
			calcStack.push(result);
			
		}else if(operator == '%') {
			result = left % right;
			calcStack.push(result);
		}
	}
	
}
