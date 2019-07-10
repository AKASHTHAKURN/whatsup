package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.util.Scanner;

public class A07_Palindrome_test {

	public static void main(String args[]) throws Exception	{

		System.setIn(new FileInputStream("data/palindrome_input.txt"));
		Scanner sc = new Scanner(System.in);		

		String ss = "ABABBBBACCCACCAAABAAABACACAAABBCABBBBBABBBBCCBACBCBCCACCABCCBBCCBCBAAABAAAAABCAAABABBAACBBBBCBCBABAB";
		
		
		int T = sc.nextInt();
		
		for(int j=0; j<T; j++) {
		
			int n = sc.nextInt();
			String str = sc.next();

			str = "ABABBBBACCCACCAAABAAABACACAAABBCABBBBBABBBBCCBACBCBCCACCABCCBBCCBCBAAABAAAAABCAAABABBAACBBBBCBCBABAB";
			
			
			int count=0;
			int max = 0;
			
			// È¦¼ö
			for(int i=0; i<str.length(); i++) {
			
				for(int t=0; t<str.length(); t++) {
					if( i-t >= 0 && i+t+1<str.length() && str.charAt(i-t) == str.charAt(i+t+1)) {
						count++;
						System.out.println(i + " " + t + "  cnt = " +count);

					} else {
						int val = count*2;
						if(val > max) 
							max = val;
						count = 0;
					}
				}			
			}
			System.out.println(max);
	
			for(int i=0; i<str.length(); i++) {
				
				for(int t=1; t<str.length(); t++) {
					
					if( i-t>=0 && i+t<str.length() 
							&& str.charAt(i-t) == str.charAt(i+t)) {
						
						count++;
						
					} else {
						int val = count*2 + 1;
						if(val > max) 
							max = val;
						count = 0;
						
						break;
					}
				}			
			}
	
			System.out.println(max);
			System.out.println();
			
		}
	}
}
/*
#1 4
#2 7
#3 11
#4 9
#5 13

 */

