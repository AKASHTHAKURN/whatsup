package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 *  x1, x2 �� ���Ϸ� �÷����鼭 ������ ���ϸ鼭 ī��Ʈ ����
 *  x1, x2 ��ü���� �����Ű�Ƿ� while ���
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
		
		// Ȧ�� ��Ī
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
		
		// ¦�� ��Ī
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
