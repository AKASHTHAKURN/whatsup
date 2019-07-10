//ť ��ü�� LinkedList�� �����Ͽ� ����

package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A06_Password2_sol {
	
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		int T;
		System.setIn(new FileInputStream("data/password2_input.txt"));
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int testcase=1;testcase<=T;testcase++)
		{
			queue = new LinkedList<Integer>();
			
			for(int i=0;i<8;i++)
			{
				queue.offer(scanner.nextInt());
			}
			
			//ť�̿�
			
			int cnt=1;			
			
			//2��°����Ŭ�̵Ǹ� �ٽ� cnt�� 1�̵�!
			while(true)
			{
				int num=queue.poll()-cnt;
				if(cnt==5) cnt=0;				
				if(num<=0) num=0;

				queue.offer(num);
				
				if(num==0) break;	
				cnt++;	
			}
			
			System.out.print("#"+testcase+" ");
			
			while(!queue.isEmpty())
			{
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
			
		}
		
		scanner.close();
	}
}
