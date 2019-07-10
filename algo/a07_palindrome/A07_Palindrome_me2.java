package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 문제있음 -> 넘어가지 않는 범위를 지정해야 함
 * 
 * 해법은 while charAt 사용 -> char 배열로 변환하지 않고 문자열에서 비교가 가능하다
 * 
 * 2차원형태로에서 가로,세로, 대각선까지 확장 할 수 있다
 * 
 */


//
// 한글자씩 앞으로 가면서 앞뒤로 같은지 검사해서 카운트 증가시킨다.
// str.charAt(index) 사용 한글자씩 검사
//

public class A07_Palindrome_me2 {

	public static void main(String args[]) throws Exception	{
		
/*
		ABBA
		9
		ABCDEDCBF
		50
		AABABBBBAABBCACBBAACCBCAACACACAAACBCACBAACACCABCCA
		100
		ABABBBBACCCACCAAABAAABACACAAABBCABBBBBABBBBCCBACBCBCCACCABCCBBCCBCBAAABAAAAABCAAABABBAACBBBBCBCBABAB
		100
		ABBACABACACBCCCABBABAACBBBBAAACBABAAAACCAACBBCBACBACBACACACABCAAAACAACCCBBBBBBBACBAACAAAABACACCABCAB

		#1 4
		#2 7
		#3 11
		#4 9
		#5 13
*/		
		
		String str = "AABABBBBAABBCACBBAACCBCAACACACAAACBCACBAACACCABCCA";
		
		int max1 = 0; 
		int max2 = 0;
		
		
		int size = str.length();
		
		for (int i=0; i<str.length(); i++) {
			
				int count = 0;
				
				for (int k=1; k<size; k++){

					if (i-k <= 0 || i+k >= size)
						break;
					
					if ( str.charAt(i-k) == str.charAt(i+k) )
						count++;
					else 
						break;
				}

				if (count > max1) {
					max1 = count * 2+1;
					System.out.println(i + ":" + count);
				}

		}

		System.out.println("max1 = " + max1);
		
		for (int i=0; i<size; i++) {
			
			int count = 0;
			
			for (int k=0; k<size; k++){

				if (i-k <= 0 || i+k+1 >= size)
					break;

				if ( str.charAt(i-k) == str.charAt(i-k+1) )
					count++;
				else
					break;
			}

			if (count > max2) {
				max2 = count*2;
				System.out.println(i + ":" + count);
			}

		}

		System.out.println("max2 = " + max2);
		
		System.out.println("max => " + Math.max(max1, max2));
		
	}
}
