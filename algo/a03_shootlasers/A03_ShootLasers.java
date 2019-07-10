package algorithm.a03.shootlasers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 인덱스를 뒤에서 부터 접근하는 방법
 * 
 * 나보다 큰값을 찾는다
 */
public class A03_ShootLasers {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("data/shootlasers_input2.txt"));		
		Scanner scanner = new Scanner(System.in);

		
		int T = scanner.nextInt();

		int table[] = new int[T];
		int result[] = new int[T];
		
		for(int i=0; i<T; i++) {
			
			table[i] = scanner.nextInt();
			
			//System.out.println(table[i]);
		}
		
		for(int i=T-1; i>0; i--) {
			
			for(int k=i; k>0; k--) {
			
				if (table[i] < table[k-1]) {
					
					result[i] = k;
					
					break;
				}
			}
		}	
	
		for(Integer n : result)
			System.out.print(n + " ");
	}

}
