package algorithm.a04.tilesetting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A04_Tilesetting_sol {

	    public static void main(String[] args) throws FileNotFoundException {
	    	
	    	int T;

	    	System.setIn(new FileInputStream("data/tilesetting_input.txt"));		
			Scanner scanner = new Scanner(System.in);
			
			T = scanner.nextInt();
			
			for(int testcase = 1; testcase <=T; testcase++)
			{
			
		        long n = scanner.nextLong();
		        long m = scanner.nextLong();
	
		        long gcd = gcd1(n, m);
		        System.out.print("#"+testcase+" "+gcd+"m -");
		        System.out.println(n / gcd * m / gcd);
	       }			
			scanner.close();
	    }
	    
	    static long gcd1(long a, long b) {

	        long k = 0;
	        while (a % b != 0) {
	            k = a % b;
	            a = b;
	            b = k;
	        }
	        return b;
	    }	   
	    
	    static long gcd2(long a, long b) {
	        for (long k = a % b; k != 0; a = b, b = k, k = a % b) {
	        }
	        return b;
	    }
	}