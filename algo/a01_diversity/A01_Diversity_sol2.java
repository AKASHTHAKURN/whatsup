package algorithm.a01.diversity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class A01_Diversity_sol2 {
	
	 

	public static void main(String[] args) throws FileNotFoundException {
		
		int T;
		
		System.setIn(new FileInputStream("data/diversity_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		String num;
		T = scanner.nextInt();
		
		int testCase_idx = 0 ;
		while(scanner.hasNextInt()){
			testCase_idx++ ;
			
			num = scanner.next();
			HashSet<Character> hs = new HashSet<Character>() ;
			
			for(int i = 0 ; i < num.length() ; i++){
				char c = num.charAt(i) ;
				hs.add(c) ;
			}
			
			System.out.println("#"+ testCase_idx + " " + hs.size());
		}
		
		scanner.close();
		
	}

}
