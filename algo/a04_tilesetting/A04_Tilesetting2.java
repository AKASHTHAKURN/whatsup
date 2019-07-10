package algorithm.a04.tilesetting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A04_Tilesetting2 {

    public static void main(String[] args) throws FileNotFoundException {
    	
        
        System.setIn(new FileInputStream("data/tilesetting_input.txt"));	
        Scanner sc = new Scanner(System.in);
        
		int T = sc.nextInt();

		for(int i=0; i<T; i++) {

			int T1 = sc.nextInt();
			int T2 = sc.nextInt();

			int g = gcd(T1, T2);
			
			System.out.println("#" + (i+1) + " " +  g + "m" + " " + (T1*T2)/(g * g));

		}
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
          int temp = a % b;
          a = b;
          b = temp;
        }
        return Math.abs(a);
    }
}	
/*
#1 6m -20
#2 24m -1
#3 4m -42
#4 2m -210
#5 10m -42
#6 5m -42
#7 2m -114
#8 1m -341
#9 2m -276
#10 1m -527
*/

