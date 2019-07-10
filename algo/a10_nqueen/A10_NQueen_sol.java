package algorithm.a10.nqueen;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class A10_NQueen_sol {

	static int SIZE;;

	static int []x; 
	static int cnt;


	static void print ()
	{
	  int i,j;
	  System.out.println(cnt + "번째 경우");
	  if(SIZE == 4)
      System.out.println("+--------+");
	  if(SIZE == 8)
      System.out.println("+----------------+");
	  for (i=0; i<SIZE; i++) {
		  System.out.print("|");
	    for (j=0; j<SIZE; j++)
	      if (j==x[i]) System.out.print("<>");
	      else System.out.print("  ");
	    System.out.println("|");
	  }
	  if(SIZE == 4)
		  System.out.println("+--------+");
	  if(SIZE == 8)
		  System.out.println("+----------------+");
	}


	static boolean is_free (int ix, int iy)
	{
	  int i;
	  for (i=0; i<iy; i++)
		  if ((x[i]==ix) || (Math.abs(x[i]-ix)==Math.abs(i-iy))) return false;
	  return true;
	}


	static void try_queen (int n)
	{
	  int i;
	  if (n==SIZE) { 	
		  cnt++;
		  print();	
	  }
	  else {
	    for (i=0; i<SIZE; i++) {
	      if (is_free(i,n)) {
	        x[n]=i;
	        try_queen (n+1);
	      }
	    }
	  }
	}

	public static void main (String []args) throws FileNotFoundException
	{
		int T;
		System.setIn(new FileInputStream("data/nqueen_input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++)
		{
			cnt = 0;
	        SIZE = sc.nextInt();	
	        x = new int[SIZE];
			try_queen(0);
			System.out.println("#"+testcase + " " + cnt);
		}
		
		sc.close();
		
	  
	  
	}

	

}
