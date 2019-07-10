package algorithm.a02.guesswhat;

import java.util.Scanner;
import java.io.FileInputStream;

/*
 * 카운팅 배열 사용
 */
public class A02_GuessWhat
{
	public static void main(String args[]) throws Exception	{

		System.setIn(new FileInputStream("data/guesswhat_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		int table[] = new int[101];	// 0 ~ 100 이니까 101 잡아야 한다
		
		int T = scanner.nextInt();

		for(int i=0; i<T; i++) {
		
			int T1 = scanner.nextInt();
			
			for (int k=0; k<T1; k++) {
				int num = scanner.nextInt();
				table[num]++;
			}

			int max = 0;
			int index = 0;
			for (int k=0; k<101; k++) {

				if(table[k] > max ) {
					max = table[k];
					index = k;
				}
			}	
			
			System.out.println("#" + (i+1) + " " + index);
		}
	}
}