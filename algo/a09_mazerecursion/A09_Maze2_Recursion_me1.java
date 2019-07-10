package algorithm.a09.mazerecursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/*
 * 재귀함수를 이용하여 풀이완료
 */
public class A09_Maze2_Recursion_me1 {
	
	static int col, row;
	static boolean answer = false;
	static int[][] maze;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException 
	{
		
		System.setIn(new FileInputStream("data/maze_input.txt"));
		Scanner sc = new Scanner(System.in);		

		int testcase = sc.nextInt();
		
		for(int t=0; t<testcase; t++) 
		{
			col = sc.nextInt();
			row = sc.nextInt();
			
			maze = new int[col][row];
			visited = new int[col][row];
			
			//System.out.println("=======================");
			for(int i=0; i<col; i++) {

				for(int k=0; k<row; k++) {
					
					visited[i][k] = 0; // 초기화

					maze[i][k] = sc.nextInt();
					
					//System.out.print(maze[i][k] + "  ");
				}
				//System.out.println();
			}
			//System.out.println("=======================");
	
			answer = false;
			visited[0][0] = 1;
			findpath(0, 0);
			
			System.out.println("#" + (t+1) + " answr = " + answer);
			
		}	
	}

	static void findpath(int x, int y) {
		
		//System.out.println("x="+x + " y=" + y);
		
		if (x==col-1 && y==row-1) {
			answer = true;
			return;
		}
		
		for(int i=0; i<4; i++) {

			int px = x + dx[i];
			int py = y + dy[i];

			// 갈곳이 없는 경우 continue 되어서 findpath를 실행하지 않음
			if (px<0 || px>=col || py<0 || py>=row) continue;
			if (maze[px][py] == 1) continue;
			if (visited[px][py] == 1) continue;

			visited[px][py] = 1;
			
			findpath(px, py);
		}
	}
}



