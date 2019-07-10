package algorithm.a01.diversity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class A01_Diversity {
	
	 /*
	  * 1. 카운팅 배열 방식
	  * 
	  * table = new int[10] // 배열 인덱스를 사용해서 똑같은 인덱스에 카운팅 한다
	  * 
	  * table[(num.charAt(i) - '0')]++;
	  * 
	  * [0] = 1
	  * [1] = 0
	  * [2] = 3 ... 이런식으로
	  * 
	  * 2. HashSet 사용해서 중복안되게 추가 -> 내가 구현한 방법
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
