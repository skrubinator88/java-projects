package calc;
//Purpose: The control center of the calculator, and is used for the computational tasks after recieving user input
public class calc {
	
	String expression = "";
	CalculatorEngine calcEng = new CalculatorEngine();
	int variable = 0;
	
	public calc(String exp, int v) {
		expression = exp;
		variable += v;
	} 
	
	public void eval() {
		int x = 0;
		//loops through expression and performs respective operations
		while(x < expression.length()) {
			char exp = expression.charAt(x);
			
			if(exp == 'x' || exp == 'X') {
				calcEng.pushOperand(variable);
			}else if(Character.isDigit(exp)) {
				int y = exp - '0';
				calcEng.pushOperand(y);
			}else if(exp == '+') {
				calcEng.doOperator(exp);
			}else if(exp == '-') {
				calcEng.doOperator(exp);
			}else if(exp == '/') {
				calcEng.doOperator(exp);
			}else if(exp == '*') {
				calcEng.doOperator(exp);
			}else if(exp == '%') {
				calcEng.doOperator(exp);
			}else if(exp == 'p') {
				System.out.println(calcEng.currentMemory());
			}else if(x == expression.length() - 1) {
				break;
			}
			x++;
		}
		//prints out answer to expression
		System.out.println("Answer to expression: " + calcEng.currentMemory());
	}
}
