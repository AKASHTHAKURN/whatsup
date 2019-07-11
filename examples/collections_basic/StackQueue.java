package collections.sc;

import java.util.*;
/*
 * queue : add(), poll()
 * stack : push(), pop()
 * 
 */
public class StackQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		queueTest();
		//stackTest();
	}
	
	static void queueTest() {
		//LinkedList<String> qu = new LinkedList<String>(); // 큐의 생성
		
		Deque<String> qu = new ArrayDeque<String>();
		
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

		System.out.println(qu.add("다섯"));
		System.out.println(qu);
		
		// remove() 메소드를 이용한 요소의 제거
		qu.remove("하나");
		System.out.println(qu);

		// 출력 iterator
		Iterator<String> it = qu.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		
		// 출력 foreach
		for(String n : qu)
			System.out.print(n + " ");
		System.out.println();		
	}
	
	static void stackTest() {

		Stack<Integer> st = new Stack<Integer>(); // 스택의 생성
		//Deque<Integer> st = new ArrayDeque<Integer>();

		// push() 메소드를 이용한 요소의 저장
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);

		// peek() 메소드를 이용한 요소의 반환, stack 꺼낼수 있는값
		System.out.println(st.peek());
		System.out.println(st.peek());
		System.out.println(st.peek());
		System.out.println(st);

		// pop() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(st.pop());
		System.out.println(st);

		// search() 메소드를 이용한 요소의 위치 검색
		System.out.println(st.search(1));
		System.out.println(st.search(3));		
		
		
		// 출력 iterator
		Iterator<Integer> it = st.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		
		// 출력 foreach
		for(Integer n : st)
			System.out.print(n + " ");
		System.out.println();		

	}

}
