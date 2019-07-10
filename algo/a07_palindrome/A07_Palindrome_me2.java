package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * �������� -> �Ѿ�� �ʴ� ������ �����ؾ� ��
 * 
 * �ع��� while charAt ��� -> char �迭�� ��ȯ���� �ʰ� ���ڿ����� �񱳰� �����ϴ�
 * 
 * 2�������·ο��� ����,����, �밢������ Ȯ�� �� �� �ִ�
 * 
 */


//
// �ѱ��ھ� ������ ���鼭 �յڷ� ������ �˻��ؼ� ī��Ʈ ������Ų��.
// str.charAt(index) ��� �ѱ��ھ� �˻�
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
