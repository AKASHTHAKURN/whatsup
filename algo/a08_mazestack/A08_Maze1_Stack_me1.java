package algorithm.a08.mazestack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class A08_Maze1_Stack_me1 {
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException 
	{
		System.setIn(new FileInputStream("data/maze_input2.txt"));
		Scanner sc = new Scanner(System.in);		

		int testcase = sc.nextInt();
		
		for(int t=0; t<testcase; t++) 
		{
		
			int col = sc.nextInt();
			int row = sc.nextInt();
			
			int[][] maze = new int[col][row];
			
			for(int i=0; i<col; i++) {
				for(int k=0; k<row; k++) {
					maze[i][k] = sc.nextInt();
					System.out.print(maze[i][k] + " ");
				}
				System.out.println();
			}
			System.out.println("=======================");
	
			Stack<Point> stk = new Stack<Point>(); 
				
			Point cur = new Point(0, 0);	
			maze[cur.x][cur.y] = 1;
	
			Point temp;
			
			int count = 0;
			
			while(true) {

				temp = findPath(maze, cur);
				
				if(temp.x == -1 && temp.y == -1) {

					if (stk.isEmpty() == false) {
						cur = stk.pop();
						//maze[cur.x][cur.y] = 0;
						System.out.println("pop " + "=> " + cur.x + "," + cur.y);
					} 
					else {
						System.out.println("No escape way");
						break;
					}
				}
				else {
					stk.push(cur);
					cur = temp;
					maze[cur.x][cur.y] = 1;
				}
				
				System.out.println(cur.x + "," + cur.y);
				count++;
				//Thread.sleep(30);

				if(cur.x == maze.length-1 && cur.y == maze.length-1) {
					System.out.println("find count = " + count);
					printPath(stk, col);
					break;
				}
			}
		}//for loop
	}

	static Point findPath(int[][] arr, Point p) {
		
		int x = p.x;
		int y = p.y;
		int xx, yy;
		int len = arr.length;
		
		Point pp = new Point(0,0);;

		xx = x; yy = y-1;
		if (xx>=0 && xx<len && yy>=0 && yy<len && arr[xx][yy] == 0) {
			pp.setXY(xx, yy);
			return pp;
		}

		xx = x; yy = y+1;
		if (xx>=0 && xx<len && yy>=0 && yy<len && arr[xx][yy] == 0) {
			pp.setXY(xx, yy);
			return pp;
		}

		xx = x-1; yy = y;
		if (xx>=0 && xx<len && yy>=0 && yy<len && arr[xx][yy] == 0) {
			pp.setXY(xx, yy);
			return pp;
		}

		xx = x+1; yy = y;
		if (xx>=0 && xx<len && yy>=0 && yy<len && arr[xx][yy] == 0) {
			pp.setXY(xx, yy);
			return pp;
		}

		pp.setXY(-1, -1);
		return pp; 
	}
	
	static void printPath(Stack<Point> stk, int len) {

		int[][] arr = new int[len][len];
		
		Point p;
		
		System.out.println("------------------------");
		while(!stk.isEmpty()) {
			p = stk.pop();
			arr[p.x][p.y] = 1; 
		}
		
		for(int i=0; i<len; i++) {
			for(int k=0; k<len;k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
		
	}
}

class Point {
    int x;
    int y;
     
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
    	return this.x;
    }

    int getY() {
    	return this.y;
    }
}
