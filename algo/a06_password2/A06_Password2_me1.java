package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Queue(LinkedList) ���
// add() or offer(), poll()

/*
 * 
 * ���� ������ ť�� ��� �Ǵ°Ŵ�
 * ť�� ���� ���ϰ� �� �� �ִ� (��ũ�帮��Ʈ)
 * 
 * ����ȭ �Ϸ��� ������ ���ϼ� �ִ� ��� ����
 * - �Լ�ȣ�� Ƚ��
 * - ������ ���� Ƚ��
 * 
 * => �����̽�
 * 
 */


//
// ť�� ���
//

/*
	LinkedList<String> qu = new LinkedList<String>(); // ť�� ����
	//Deque<String> qu = new ArrayDeque<String>();
	
	// add() �޼ҵ带 �̿��� ����� ����
	qu.add("��");
	qu.add("��");
	qu.add("��");
	qu.add("�ϳ�");
	
	// peek() �޼ҵ带 �̿��� ����� ��ȯ
	System.out.println(qu.peek());
	System.out.println(qu);
	
	// poll() �޼ҵ带 �̿��� ����� ��ȯ �� ����
	System.out.println(qu.poll());
	System.out.println(qu);
	
	// remove() �޼ҵ带 �̿��� ����� ����
	qu.remove("�ϳ�");
	System.out.println(qu);

	// ��� iterator
	Iterator<Integer> it = qu.iterator();
	while(it.hasNext())
		System.out.print(it.next() + " ");
	System.out.println();
	
	// ��� foreach
	for(Integer n : qu)
		System.out.print(n + " ");
	System.out.println();

	result :
	��
	[��, ��, ��, �ϳ�]
	��
	[��, ��, �ϳ�]
	[��, ��]
*/

public class A06_Password2_me1 {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//9550 9556 9550 9553 9558 9551 9551 9551
		//2419 2418 2423 2415 2422 2419 2420 2415 
		//10 6 12 8 9 4 1 3

		//String in = "10 6 12 8 9 4 1 3";
		//String in = "9550 9556 9550 9553 9558 9551 9551 9551";
		String in = "2419 2418 2423 2415 2422 2419 2420 2415";
		
		String[] temp = in.split(" ");
		//LinkedList<Integer> qu = new LinkedList<Integer>(); // ť�� ����
		Deque<Integer> qu = new ArrayDeque<Integer>();

		for (int i=0; i<temp.length; i++)
			qu.add(Integer.parseInt(temp[i]));

		System.out.println(qu);
		
		boolean loop = true;
		while(loop == true) {
			
			for (int i=1; i<=5; i++) {
			
				int num = qu.poll() - i;

				if (num <= 0) {
					qu.add(0);
					loop = false;
					break;
				} 

				//qu.add(num);
				qu.offer(num);
			}
		}

		// iterator
		Iterator<Integer> it = qu.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// foreach
		for(Integer n : qu)
			System.out.print(n + " ");
		System.out.println();
		
		// poll
		while(!qu.isEmpty())
		{
			System.out.print(qu.poll()+" ");
		}
		System.out.println();
		
		
		
		
	}
}
