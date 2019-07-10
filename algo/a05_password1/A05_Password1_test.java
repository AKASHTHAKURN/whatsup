package algorithm.a05.password1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class A05_Password1_test {

	// stack �̿��� ���
	public static void main(String args[]) throws Exception	{

		//solution_1();
		solution_2();		// use sb
	}
		
	public static void solution_1() throws FileNotFoundException {
		
		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int k=1; k<=T; k++) {
			String str = sc.next();
			Stack<Character> st = new Stack<>();
			
			for(int i=0; i<str.length(); i++) {
				
				if(!st.isEmpty() && str.charAt(i) == st.peek()) {
					st.pop();
				} else {
					st.push(str.charAt(i));
				}
			}
	
			/*
			 * ���ؿ��� ó������ ������� ���� ���� ��
			 * st.size(), st.get(index) ����ؾ� �Ѵ�
			 */
			System.out.print("#"+ k+" ");
			for(int i=0; i<st.size(); i++) {
				System.out.print(st.get(i));
			}
			System.out.println();
		}
	}	
	
	/*
	 * SB ��� -> ���� ����� ���
	 */
	public static void solution_2() throws FileNotFoundException {

		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int j=0; j<T; j++) {
			String s = sc.next();
	
			StringBuilder sb = new StringBuilder(s);
			boolean find = true;
			while(find) {
				find = false;
				for(int i=0; i<sb.length()-1; i++) {
					
					if(sb.charAt(i) == sb.charAt(i+1)) {
						sb.replace(i, i+2, "");
						find = true;
						break;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}	
	
	/*
	 * �߱����� --> ���� ���� Ǯ�� ����
	 */
	public static void solution_3() throws FileNotFoundException {

		System.setIn(new FileInputStream("data/password1_input.txt"));		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			
			String str = sc.next();

			//StringBuilder sb = new StringBuilder(str);
			
			boolean same = false;
			String dest = "";
			
			while(true) {
				same = false;

				if(dest != "")
					str = dest;
				dest = "";
				
				for(int k=0; k<str.length(); k++) {
					
					String a = str.substring(k, k+1);
					String b = "";
					if(k+1 < str.length())
						b = str.substring(k+1, k+2);
					
					if(a.equals(b)) {
						k++;
						same = true;
					} else {
						dest += str.substring(k, k+1);
					}
				}
				//System.out.println(dest);
				
				if(same == false) break;
			}
			
			System.out.println("#" + (i+1) + " " + dest);
		}
		
	}

	
}