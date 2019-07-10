package algorithm.a11.knapsack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A11_Knapsack_sol {

	static int W, n, i, j;
	static int []w = new int[102];
	static int []v = new int[102];
	
	static int max(int a, int b) { return a>b ? a : b; }
	
	static int f(int i, int r)		// f(물건 번호 i,남은 무게 r)
	{
		if (i == n + 1)
			return 0;
		else if (r<w[i])
			return f(i + 1, r);
		else
			return max( f(i + 1, r),  f(i + 1, r-w[i]) + v[i]  );
	}
	
	public static void main(String []args) throws FileNotFoundException
	{
		int T;
		
		System.setIn(new FileInputStream("data/knapsack_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++)			
		{
		
			n = sc.nextInt();
			W = sc.nextInt();
			
			for (i = 1; i <= n; i++)
			{
				w[i] = sc.nextInt();
				v[i] = sc.nextInt();
			}		
						
			System.out.println("#"+testcase + " " + f(1, W));		
		}
		
	}

}
