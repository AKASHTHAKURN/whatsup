package algorithm.a01.diversity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class A01_Diversity_test {
	
	 

	public static void main(String[] args) throws FileNotFoundException {
		
		int T;
		
		System.setIn(new FileInputStream("data/diversity_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
				
		////////////////////////여기부터 구현 (1) ---------------->
		
		for(int k=0; k<T; k++) {
			HashSet<Character> hs = new HashSet<>();
			
			String s = scanner.next();

			for(int i=0; i<s.length(); i++) {
				hs.add(s.charAt(i));
			}
			
			System.out.println("#" + (k+1) + " " + hs.size());
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)

		scanner.close();
	}
}
