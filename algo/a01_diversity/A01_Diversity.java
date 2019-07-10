package algorithm.a01.diversity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class A01_Diversity {
	
	 /*
	  * 1. ī���� �迭 ���
	  * 
	  * table = new int[10] // �迭 �ε����� ����ؼ� �Ȱ��� �ε����� ī���� �Ѵ�
	  * 
	  * table[(num.charAt(i) - '0')]++;
	  * 
	  * [0] = 1
	  * [1] = 0
	  * [2] = 3 ... �̷�������
	  * 
	  * 2. HashSet ����ؼ� �ߺ��ȵǰ� �߰� -> ���� ������ ���
	  * 
	  */

	public static void main(String[] args) throws FileNotFoundException {
		
		int T;
		
		System.setIn(new FileInputStream("data/diversity_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();

		for(int i=0; i<T; i++) {

			String str = scanner.next();
			
			HashSet<Character> set = new HashSet<Character>();
			
			for (int k=0; k<str.length(); k++) {
				set.add(str.charAt(k));
			}
			
			System.out.println("#"+(i+1) + " " + set.size());
			
		}
		
		scanner.close();
	}

}
