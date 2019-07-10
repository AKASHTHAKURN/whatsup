package algorithm.a01.diversity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A01_Diversity_sol {
	
	static String num;
	static int table[]; 

	public static void main(String[] args) throws FileNotFoundException {
		int i, k, cnt;
		int T;
		
		System.setIn(new FileInputStream("data/diversity_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
				
		for(int testcase = 1; testcase <=T; testcase++)
		{
			 
			table = new int[10];
			 
			 num = scanner.next();
			 for (i = 0; i < num.length(); i++)
			 {
				     table[(num.charAt(i) - '0')]++;					
			 }
			 
			
			 cnt = 0;
			 for (k = 0; k < 10; k++)
			 {
				if (table[k] != 0)
				{
					cnt = cnt + 1;
					table[k] = 0;
				}

			  }
			 
			 System.out.print("#"+testcase+" ");
			 System.out.println(cnt);
			
			
		}
		
		scanner.close();

		
	}

}
