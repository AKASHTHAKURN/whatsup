package algorithm.a09.mazerecursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A09_Maze2_Recursion_sol {

	static boolean isVisited[][];
	static int maze[][];
	static int dx[]={-1,1,0,0};  //x 规氢汲沥 规过
	static int dy[]={0,0,-1,1};  //y 规氢汲沥 规过
	static boolean answer;
	
	static int ROW, COL;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		int T;
		
		System.setIn(new FileInputStream("data/maze_input.txt"));
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int testcase = 1; testcase <=T; testcase++)
		{
			answer = false;
			ROW = scanner.nextInt();
			COL = scanner.nextInt();
			
			maze = new int[ROW][COL];
			isVisited=new boolean[ROW][COL];
			
			for(int i=0; i< ROW; i++)
			{
				for(int j=0; j<COL; j++)
				{
					maze[i][j] = scanner.nextInt();
					isVisited[i][j] = false;
				}			
			}
				
			findpath(0,0);
			
			System.out.print("#"+testcase + " ");
			if(answer) System.out.println("Yes");
			else System.out.println("No");
		}
		scanner.close();
	}
	
	public static void findpath(int x,int y)
	{
		if(x==COL-1 && y==ROW-1)
		{
			answer=true;
			return;
		}
		for(int i=0;i<4;i++)
		{
			int nextX=x+dx[i];				
			int nextY=y+dy[i];
			
			if(nextX<0||nextY<0||nextX>7||nextY>7) continue;
			if(isVisited[nextX][nextY]) continue;
			if(maze[nextX][nextY]==1) continue;
				
			isVisited[nextX][nextY]=true;
			
			findpath(nextX,nextY);
		}
	}


}
