package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 *  x1, x2 를 상하로 늘려가면서 같은지 비교하면서 카운트 증가
 *  x1, x2 자체값을 변경시키므로 while 사용
 *  while (x1 >= 0 && x2 < len)
 */

public class A07_Palindrome_me1 {

	public static void main(String args[]) throws Exception	{
		
		/*
			ABBA
			ABCDEDCBF
			AABABBBBAABBCACBBAACCBCAACACACAAACBCACBAACACCABCCA
			ABABBBBACCCACCAAABAAABACACAAABBCABBBBBABBBBCCBACBCBCCACCABCCBBCCBCBAAABAAAAABCAAABABBAACBBBBCBCBABAB
			ABBACABACACBCCCABBABAACBBBBAAACBABAAAACCAACBBCBACBACBACACACABCAAAACAACCCBBBBBBBACBAACAAAABACACCABCAB
			#1 4
			#2 7
			#3 11
			#4 9
			#5 13
		 */		
		
		String str = "ABABBBBACCCACCAAABAAABACACAAABBCABBBBBABBBBCCBACBCBCCACCABCCBBCCBCBAAABAAAAABCAAABABBAACBBBBCBCBABAB";
		
		int len = str.length();
		int x1, x2;
		int cnt, max, max2;
		
		max = 0;
		
		// 홀수 대칭
		for(int i=0; i<len; i++) {
			cnt = 0;
			x1 = i-1;
			x2 = i+1;
			
			while(x1>=0 && x2<len) {
				if(str.charAt(x1) == str.charAt(x2)) {
					cnt++;
					x1--;
					x2++;
				} else {
					break;
				}
			}
			if (cnt > max)
				max = cnt;
		}	
		if(max>0)
			max = max*2 +1;
		System.out.println(max);
		
		// 짝수 대칭
		max2 = 0;
		for(int i=0; i<len; i++) {
			cnt = 0;
			x1 = i;
			x2 = i+1;
			
			while(x1>=0 && x2<len) {
				if(str.charAt(x1) == str.charAt(x2)) {
					cnt++;
					x1--;
					x2++;
				} else {
					break;
				}
			}

			if (cnt > max2)
				max2 = cnt;

		}	
		max2 = max2*2;
		System.out.println(max2);
		
	}
}
