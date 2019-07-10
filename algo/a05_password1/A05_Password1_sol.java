//Stack 객체를 이용한 코드

package algorithm.a05.password1;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class A05_Password1_sol {
	
	public static void main(String args[]) throws Exception	{
		
		Stack<Character> stack;
		int T;
		
		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		for(int testcase = 1; testcase <= T; testcase++)
		{
//			abceecffighhqtt
			stack  = new Stack<Character>();
			String data = scanner.next();		
					
			for(int i=0; i<data.length(); i++) {
				if(!stack.isEmpty() && data.charAt(i) == stack.peek()) {
					stack.pop();					
				} else
					stack.push(data.charAt(i));
			}
			
			
			System.out.print("#"+testcase+" ");
			for(int i=0; i<stack.size(); i++) {
				System.out.print(stack.get(i));
			}
			System.out.println();
		
		}
		scanner.close();
	}
	
	
}