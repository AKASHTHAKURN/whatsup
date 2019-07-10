package algorithm.a08.mazestack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class A08_Maze1_Stack_sol {
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		int T;
		int COL;
		int ROW;
		
		System.setIn(new FileInputStream("data/maze_input.txt"));		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int k = 0 ; k < T ; k++) {
			COL = sc.nextInt();
			ROW = sc.nextInt();
			
			int[][] maze = new int[COL + 1][ROW + 1];
			boolean[][] isVisited = new boolean[COL + 1][ROW + 1];
			boolean answer = false;
			
			//초기화
			for(int i = 0 ; i < COL ; i++){
				for(int j = 0 ; j < ROW ; j++){
					maze[i][j] = sc.nextInt();
					isVisited[i][j] = false;
				}
			}
			
			Stack<Node> st = new Stack<>();
			st.push(new Node(0, 0));
			
			while(true){
				boolean wayExisted = false;
				Node peek;
				
				if(!st.isEmpty()) {
					peek = st.peek();
				} else {
					answer = false;
					break;
				}
				
				int X = peek.getX();
				int Y = peek.getY();
				
				if(X == COL - 1 && Y == ROW - 1) {
					answer = true;
					break;
				}
								
				for(int ways = 0 ; ways <= 3 ; ways++){
					int nowX = X;
					int nowY = Y;
					
					switch(ways){
					case 0:  //상
						nowY--;
						break;					
					case 1:  //하
						nowY++;
						break;
					case 2:  //좌
						nowX--;
						break;
					case 3:  //우
						nowX++;
						break;
					}
					if(nowX < 0 || nowY < 0 || nowX > COL || nowY > ROW) continue;
					
					if(maze[nowX][nowY] != 1 && !isVisited[nowX][nowY]){
						wayExisted = true;
						isVisited[nowX][nowY] = true;
						st.push(new Node(nowX, nowY));
						break;
					}
				}
				if(!wayExisted){
					st.pop();
				}
			}	
			
			//미로 경로 출력
			/*for(int i = 0 ; i < st.size() ; i++) {
				Node n = st.get(i);
				System.out.print("[" +n.getX() + "," + n.getY() + "]");
			}
			System.out.println();*/
			
			if(answer){
				System.out.println("#" + (k+1) +  " Yes");
			} else {
				System.out.println("#" + (k+1) +  " No");
			}
		}
		sc.close();

	}
	
	public static class Node{
		private int x;
		private int y;
		
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}		
	}
	
}
