package algorithm.a03.shootlasers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A03_ShootLasers_sol1 {

	static int tower[]; 
	static int target[]; 
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/shootlasers_input.txt"));		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		tower = new int[N+1];
		target = new int[N+1];
		
		for(int i=1; i<= N; i++)
		{
			tower[i] = scanner.nextInt();			
		}		
		
		for(int j=tower.length-1; j>=1; j--)
		{
			for(int t = j-1; t >= 1; t--)
			{
				if(tower[j] < tower[t])
				{
					target[j] = t;	
					break;
				}
			}
			
		}
		
		for(int i=1; i<=N; i++)
			System.out.print(target[i] + " ");

		System.out.println();
		
		scanner.close();
	}
	

}
