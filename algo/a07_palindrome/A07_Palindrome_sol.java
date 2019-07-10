package algorithm.a07.palindrome;

import java.io.FileInputStream;
import java.util.Scanner;

public class A07_Palindrome_sol {

	public static void main(String args[]) throws Exception	{
		
		System.setIn(new FileInputStream("data/palindrome_input.txt"));
		Scanner sc = new Scanner(System.in);		
		
		String str;
		
		int test_case;
		int i, x, x1, x2;
		int max;
		int T, len, length;
		T = sc.nextInt();
		
		for (test_case = 1; test_case <= T; ++test_case){
			len = sc.nextInt();
			str = sc.next();
			max = 0;
						
			for ( i = 0; i < len; i++){
				x = i;  //체크하고자 하는 문자 위치 값
				
				//짝수 개수의 palindrome 찾기
				length = 0;
				x1 = x;
				x2 = x + 1;				
				while (x1 >= 0 && x2 < len){
					if (str.charAt(x1) == str.charAt(x2)){
						x1--;
						x2++;
						length += 2;
					}else
						break;
				}
				if (length > max)
					max = length;
				
				
				//홀수 개수의 palindrome 찾기	
				length = 1;
				x1 = x - 1;
				x2 = x + 1;								
				
				while (x1 >= 0 && x2 < len){
					if (str.charAt(x1) == str.charAt(x2)){
						x1--;
						x2++;
						length += 2;
					}
					else
						break;
				}
				if (length > max) {
					max = length;
				}
				
			}
			System.out.printf("#%d %d\n", test_case,max);		
		}

		sc.close();
	}
}
