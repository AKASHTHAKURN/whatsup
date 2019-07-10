package algorithm.a02.guesswhat;

import java.util.Scanner;
import java.io.FileInputStream;

public class A02_GuessWhat_sol
{
		public static void main(String args[]) throws Exception	{
			int test_case; 
			int i; 
			int num; 
			int max;
			int idx;
			int[] data; 
			int TC, cnt;

			System.setIn(new FileInputStream("data/guesswhat_input.txt"));
			Scanner sc = new Scanner(System.in);
			TC = sc.nextInt();
			for (test_case = 1; test_case<=TC; test_case++)
			{
				
				
				data = new int[101];
				max = 0; // maximum count
				idx = 0; // maximum count idx
				
				cnt = sc.nextInt();
				
				for (i = 0; i < cnt; i++)
				{
					num = sc.nextInt();
					data[num]++;
				}

				
				for (i = 0; i < 101; i++)
				{
					if (data[i] >= max)
					{
						idx = i;
						max = data[i];
					}
				}

				System.out.println("#"+test_case+' '+idx);
			}
			sc.close();
		}
	}