package algorithm.a05.password1;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * replace
 * 
 * A. StringBuilder로 작성
 * B. String 으로 작성해 볼것 ===============================>>>>>> 꼭 연습해 볼 것
 * 
 * 1. charAt 으로 스트링 탐색
 * 2. 같은면 replace로 삭제
 * 
 * 
 */


/* =================
 * 스택을 써라
 * 
 * 1. 적용할 자료구조 결정
 * 2. 특별한 알고리즘 써야 하나
 * 3. 
 * 
 * 스택과 큐로 풀수 있을까
 * 
 * 
  ===============*/

class A05_Password1 {
	
	public static void main(String args[]) throws Exception	{

		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner scanner = new Scanner(System.in);

		// 이렇게 받고 nextLine으로 받으면 숫자다음 빈줄을 읽는다
		// 숫자를 계속 받을 경우 아니면 사용하지 말것
		//int T = scanner.next());
		
		int T = Integer.parseInt(scanner.nextLine());

		
		for (int t=0; t<T; t++) {
			
			String str = scanner.nextLine();
			StringBuilder sb = new StringBuilder(str);
		
			//System.out.println(str);
			
			//String str = "abceecffighhqtt";
			//StringBuilder sb = new StringBuilder("abceecffighhqtt");
			
			boolean find = false;
			while(find == false) {
			
				find = true;
	
//				for(int i=0; i<str.length()-1;i++) {
				for(int i=0; i<sb.length()-1; i++) {
					
//					if (str.charAt(i) == str.charAt(i+1)) {
					if (sb.toString().charAt(i) == sb.toString().charAt(i+1)) {
						
						sb.replace(i, i+2, ""); // i <= n < i+2 
						//str = sb.toString();
		
						//System.out.println(str);
						find = false;
						break;
					}
					
				}
			}
			System.out.println("#" + (t+1) + " " + sb.toString());
		}
		
	}
	
	
}