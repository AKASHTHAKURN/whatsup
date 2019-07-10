package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Queue(LinkedList) 사용
// add() or offer(), poll()

/*
 * 
 * 문제 유형이 큐를 써야 되는거다
 * 큐를 쓰면 편하게 할 수 있다 (링크드리스트)
 * 
 * 최적화 하려면 루프를 줄일수 있는 방법 적용
 * - 함수호출 횟수
 * - 루프를 도는 횟수
 * 
 * => 성능이슈
 * 
 */


//
// 큐를 사용
//

/*
	LinkedList<String> qu = new LinkedList<String>(); // 큐의 생성
	//Deque<String> qu = new ArrayDeque<String>();
	
	// add() 메소드를 이용한 요소의 저장
	qu.add("넷");
	qu.add("둘");
	qu.add("셋");
	qu.add("하나");
	
	// peek() 메소드를 이용한 요소의 반환
	System.out.println(qu.peek());
	System.out.println(qu);
	
	// poll() 메소드를 이용한 요소의 반환 및 제거
	System.out.println(qu.poll());
	System.out.println(qu);
	
	// remove() 메소드를 이용한 요소의 제거
	qu.remove("하나");
	System.out.println(qu);

	// 출력 iterator
	Iterator<Integer> it = qu.iterator();
	while(it.hasNext())
		System.out.print(it.next() + " ");
	System.out.println();
	
	// 출력 foreach
	for(Integer n : qu)
		System.out.print(n + " ");
	System.out.println();

	result :
	넷
	[넷, 둘, 셋, 하나]
	넷
	[둘, 셋, 하나]
	[둘, 셋]
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
		//LinkedList<Integer> qu = new LinkedList<Integer>(); // 큐의 생성
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
