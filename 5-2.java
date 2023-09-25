import java.io.*;
import java.util.Scanner;
import java.util.Stack;

class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	// 1 * 2 ( 3 + 4 ) / 5 $
    // 1 2 3 4 + * 5 /
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		// Stack<String> result_stack = new Stack<String>();

		String str = scan.next();

        // switch(token) {
        //     case ")" : {
        //         while(!stack.empty() && !stack.peek().equals("("))
        //             str.append(stack.pop()).append(" ");
        //         stack.pop();
        //         break;
        //     }
        //     case "(" :
        //     case "+" :
        //     case "-" :
        //     case "*" :
        //     case "/" :
        //     case "^" : {
        //         while(!stack.empty() && PIS.get(stack.peek()) >= PIE.get(token))
        //             str.append(stack.pop()).append(" ");
        //         stack.push(token);
        //         break; 
        //     }
        //     case " " :
        //         break;
        //     default :
        //         str.append(token).append(" ");
        //         break;
        //     }
        // }

		while (!str.equals("$")) {
			if (str.equals("+")) {
                
            } else if (str.equals("-")) {

            } else if (str.equals("*")) {

            } else if (str.equals("/")) {
 
            } else {
                stack.push(str);
			}
			str = scan.next();
		}

        // while (!str.equals("$")) {
        //     switch(str) {
        //         case ")" : {
        //             while(!stack.empty() && !stack.peek().equals("("))
        //                 str.append(stack.pop()).append(" ");
        //             stack.pop();
        //             break;
        //         }
        //         case "(" :
        //         case "+" :
        //         case "-" :
        //         case "*" :
        //         case "/" :
        //         case "^" : {
        //             while(!stack.empty() && PIS.get(stack.peek()) >= PIE.get(str))
        //                 str.append(stack.pop()).append(" ");
        //             stack.push(str);
        //             break; 
        //         }
        //         case " " :
        //             break;
        //         default :
        //             str.append(str).append(" ");
        //             break;
        //         }
        //     }
        //     str = scan.next();
		// }

		while (!stack.isEmpty()) {
			result_stack.push(stack.pop());
		}
		while (!result_stack.isEmpty()) {
			System.out.print(result_stack.pop());
		}
	}
}

// import java.io.*;
// import java.util.Scanner;
// import java.util.Stack;
// import java.util.StringTokenizer;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;


// class Main {
	
// 	// 필요한 필드나 메소드가 있으면 작성하시오.
// 	public String postfix(String exp) {
// 		StringTokenizer tokenizer = new StringTokenizer(exp, "[({})]+-*/ ", true);
// 		Stack<String> stack = new ListStack<String>();
// 		StringBuffer str = new StringBuffer();
		
// 		while(tokenizer.hasMoreElements()) {
// 			String token = tokenizer.nextToken();
// 			switch(token) {
// 				case ")" : {
// 					while(!stack.empty() && !stack.peek().equals("("))
// 						str.append(stack.pop()).append(" ");
// 					stack.pop();
// 					break;
// 				}
// 				case "(" :
// 				case "+" :
// 				case "-" :
// 				case "*" :
// 				case "/" :
// 				case "^" : {
// 					while(!stack.empty() && PIS.get(stack.peek()) >= PIE.get(token))
// 						str.append(stack.pop()).append(" ");
// 					stack.push(token);
// 					break; 
// 				}
// 			case " " :
// 				break;
// 			default :
// 				str.append(token).append(" ");
// 				break;
// 			}
// 		}
// 	}
// 	while(!stack.empty())
// 		str.append(stack.pop()).append(" ");
// 	return str.toString();
// 	}
	
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
// 		String str = r.readLine();
		
// 		Calculator calc = new Calculator();
// 		String exp = calc.postfix(str);
// 		System.out.println(exp);
		
// 		double result = calc.evalPostfix(exp);
// 		System.out.println(result);
// 	}

// }

// 우림 정답
// import java.util.*;

// class Main {

//     public static int priority(String str) {
//         if(str.equals("*") || str.equals("/"))
//             return 2;
//         else if(str.equals("+") || str.equals("-"))
//             return 1;
//         else 
//             return -1;
//     }
//     public static void main(String[] args) throws Exception {
//         Scanner scan = new Scanner(System.in);
//         Stack s = new Stack<Object>();
//         String result = "";

//         String str = scan.next();
//         while(!str.equals("$")) {

//             if(str.equals("(")) {
//                 while(!str.equals(")")) {
//                     if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
//                         s.push(str);
//                     } else if(str.equals("(")) {
            
//                     } else {
//                         result += str + " ";
//                     }
//                     str = scan.next();
//                 }
//                 result += s.pop() + " ";
//             }else if (str.equals(")")) {

//             } else if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
//                 if(!s.isEmpty()) {
//                     if(priority(str) > priority((String) s.peek())) {
//                         s.push(str);
//                     } else {
//                         result += s.pop() + " ";
//                         s.push(str);
//                         }
//                     } else {
//                         s.push(str);
//                     }
//             } else {
//                 result += str + " ";
//             }

//             str = scan.next();
//         }

//         while(!s.isEmpty()) {
//             result += s.pop() + " ";
//         }

//         System.out.println(result);
//     }
// }