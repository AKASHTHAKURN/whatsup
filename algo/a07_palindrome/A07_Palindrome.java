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

public class A07_Palindrome {

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
		
		String in = "ABBACABACACBCCCABBABAACBBBBAAACBABAAAACCAACBBCBACBACBACACACABCAAAACAACCCBBBBBBBACBAACAAAABACACCABCAB";
		//String in = "GHDAAABBAAAHAABAA"; // 9로 이상하게 나옴 -> 8
		
		char[] arr = in.toCharArray();
		
		int max = 0;
		
		for (int i=0; i<arr.length; i++) {
			
				int count = 0;
				
				for (int k=1; k<arr.length; k++){

					try {
						if ( arr[i-k] == arr[i+k]) {
							count++;
							//System.out.println(i+" "+k+" " + ":" + count);
						}
						else {
							if (count > max) {
								max = count * 2+1;
								System.out.println(i + "=" + count);
							}
							break;
						}
						
						
					} catch (Exception e) {
						if (count > max) {
							max = count*2 + 1;
							System.out.println(i + "->" + count);
						}
					}
				}
		}

		System.out.println("max = " + max);
		
		for (int i=0; i<arr.length; i++) {
			
			int count = 0;
			
			for (int k=0; k<arr.length; k++){

				try {

					if ( arr[i-k] == arr[i+k+1]) {
						count++;
						//System.out.println(i + ":" + count);
					}
					else {
						if (count > max) {
							max = count * 2;
							System.out.println(i + ":" + count);
						}
						break;
					}
					
				} catch (Exception e) {
					if (count > max) {
						max = count*2;
						System.out.println(i + "->" + count);
					}
				}
			}
		}

		System.out.println("max = " + max);
		
	}
}
