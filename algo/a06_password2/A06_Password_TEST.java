package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * - Deque(ArrayDeque) 사용
 * - 배열을 쉬프트 하는 방법
 */

public class A06_Password_TEST {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		int T;
		System.setIn(new FileInputStream("data/password2_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();

		for(int testcase=1;testcase<=T;testcase++){

			String str[] = new String[8];
			for(int i=0; i<8; i++) {
				str[i] = sc.next();
				//System.out.print(str[i] + " ");		
			}
			
			Deque<Integer> qu = new ArrayDeque<Integer>();
	
			for(int i=0; i<str.length; i++) {
				qu.add(Integer.parseInt(str[i]));
			}
			//System.out.println(qu);
			
			//for(Integer n : qu)
			//	System.out.print(n + " ");
			//System.out.println();
			
			boolean loop = true;
			while(loop) {
				for(int i=1; i<6; i++) {
					
					int val = qu.poll() - i;
					
					if(val <= 0) {
						qu.add(0);
						loop =false;
						break;
					}
					
					qu.add(val);
				}
			}
			
			for(Integer n : qu)
				System.out.print(n + " ");
			System.out.println();
			
			
				
				
			}	
	}
}
