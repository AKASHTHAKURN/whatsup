//ť ��ü�� LinkedList�� �����Ͽ� ����
//�Է°��� Ŭ ��� ������ ���̴� ���
// 1~5 ���� ���ʷ� ���ִ� ���̹Ƿ� ��� ���� 15�� ���� �������� ���ؼ��� ó���ϸ� �ȴ�
// �� ����Ʈ�� ������ ���� �־��ִ� ��

package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class A06_Password2_sol2 {
	
	static Queue<Integer> queue;
	static List<Integer> sample;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		int T;
		System.setIn(new FileInputStream("data/password2_input.txt"));
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for(int testcase=1;testcase<=T;testcase++)
		{
			sample = new ArrayList<Integer>();
			queue = new LinkedList<Integer>();

			int minValue = scanner.nextInt();
			int tmp;
			
			sample.add(minValue);
			for(int i=1;i<8;i++)
			{
				tmp = scanner.nextInt();
				if(tmp < minValue) minValue = tmp;
				sample.add(tmp);
			}
			
			for(int i=0;i<8;i++)
			{
				if(minValue/15 > 15)
					queue.offer(sample.get(i)-((minValue/15-1)*15));
				else
					queue.offer(sample.get(i));
			}

			//ť�̿�
			
			int cnt=1;			
			
			//2��°����Ŭ�̵Ǹ� �ٽ� cnt�� 1�̵�!
			while(true)
			{
//				System.out.println(queue);
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
