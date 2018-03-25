package calc;

public class Calculator {
	
	String expression = "";
	CalculatorEngine calcEng = new CalculatorEngine();
	int variable = 0;
	
	public Calculator(String exp, int v) {
		expression = exp;
		variable = v;
	} 
	
	public void eval() {
		int x = 0;
		while(x < expression.length()) {
			char exp = expression.charAt(x);
			if(exp == 'x') {
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
	}
}
