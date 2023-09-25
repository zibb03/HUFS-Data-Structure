import java.io.*;
import java.util.Scanner;
import java.util.Stack;

class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack<Double> stack = new Stack<Double>();
		double a1, a2;
		
		// 아래 코드를 완성하시오.
		String str = scan.next();
		while (!str.equals("$")) {
			if (str.equals("+")) {
				a2 = stack.pop();
				a1 = stack.pop();
				stack.push(a1 + a2);
			} else if (str.equals("-")) {
				a2 = stack.pop();
				a1 = stack.pop();
				stack.push(a1 - a2);
			} else if (str.equals("*")) {
				a2 = stack.pop();
				a1 = stack.pop();
				stack.push(a1 * a2);
			} else if (str.equals("/")) {
				a2 = stack.pop();
				a1 = stack.pop();
				stack.push(a1 / a2);
			} else {
				double operand = Double.parseDouble(str);	
				stack.push(operand);
			}
			
			str = scan.next();
		}
		
		System.out.println(stack.pop());
	}
}