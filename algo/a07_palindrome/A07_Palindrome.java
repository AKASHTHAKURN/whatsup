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
		//String in = "GHDAAABBAAAHAABAA"; // 9�� �̻��ϰ� ���� -> 8
		
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
