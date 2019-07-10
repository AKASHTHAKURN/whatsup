package algorithm.a02.guesswhat;

import java.util.Scanner;
import java.io.FileInputStream;

public class A02_GuessWhat_test
{
	public static void main(String args[]) throws Exception	{

		System.setIn(new FileInputStream("data/guesswhat_input.txt"));		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
	
		int score[] = new int[101];
		
		for(int i=0; i<T; i++) {

			int N = sc.nextInt();
			for(int k=0; k<N; k++) {
				int val = sc.nextInt();
				score[val] += 1;
			}

			int max = 0;
			int index = -1;
			for(int k=0; k<101; k++) {
			
				if(score[k] > max) {
					max = score[k];
					index = k;
				}
			}
			
			System.out.println("#" + (i+1) + " " + index );
		}		
	}
}