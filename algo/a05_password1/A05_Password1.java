package algorithm.a05.password1;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/*
 * 
 * replace
 * 
 * A. StringBuilder�� �ۼ�
 * B. String ���� �ۼ��� ���� ===============================>>>>>> �� ������ �� ��
 * 
 * 1. charAt ���� ��Ʈ�� Ž��
 * 2. ������ replace�� ����
 * 
 * 
 */


/* =================
 * ������ ���
 * 
 * 1. ������ �ڷᱸ�� ����
 * 2. Ư���� �˰��� ��� �ϳ�
 * 3. 
 * 
 * ���ð� ť�� Ǯ�� ������
 * 
 * 
  ===============*/

class A05_Password1 {
	
	public static void main(String args[]) throws Exception	{

		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner scanner = new Scanner(System.in);

		// �̷��� �ް� nextLine���� ������ ���ڴ��� ������ �д´�
		// ���ڸ� ��� ���� ��� �ƴϸ� ������� ����
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