package algorithm.a03.shootlasers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A03_ShootLasers2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//System.setIn(new FileInputStream("data/shootlasers_input.txt"));		
		System.setIn(new FileInputStream("data/shootlasers_input2.txt"));		
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		System.out.println(T);
		
		int [] arr = new int[T];
		int [] ans = new int[T];
		
		for(int i=0; i<T; i++) {
			arr[i] = scanner.nextInt();
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for(int i=T-1; i>0; i--) {
			
			for(int k=1; k<i; k++) {
				
				//System.out.println(i +"," + (i-k));
				
				if( arr[i] < arr[i-k]) {
					ans[i] = i-k + 1;
					break;	
				}
			}
		}	

		for(int i=0; i<T; i++)
			System.out.print(ans[i] + " ");
		
		
		
		
	}	
}
