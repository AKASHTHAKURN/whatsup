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
		//LinkedList<String> qu = new LinkedList<String>(); // ť�� ����
		
		Deque<String> qu = new ArrayDeque<String>();
		
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

		System.out.println(qu.add("�ټ�"));
		System.out.println(qu);
		
		// remove() �޼ҵ带 �̿��� ����� ����
		qu.remove("�ϳ�");
		System.out.println(qu);

		// ��� iterator
		Iterator<String> it = qu.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		
		// ��� foreach
		for(String n : qu)
			System.out.print(n + " ");
		System.out.println();		
	}
	
	static void stackTest() {

		Stack<Integer> st = new Stack<Integer>(); // ������ ����
		//Deque<Integer> st = new ArrayDeque<Integer>();

		// push() �޼ҵ带 �̿��� ����� ����
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);

		// peek() �޼ҵ带 �̿��� ����� ��ȯ, stack ������ �ִ°�
		System.out.println(st.peek());
		System.out.println(st.peek());
		System.out.println(st.peek());
		System.out.println(st);

		// pop() �޼ҵ带 �̿��� ����� ��ȯ �� ����
		System.out.println(st.pop());
		System.out.println(st);

		// search() �޼ҵ带 �̿��� ����� ��ġ �˻�
		System.out.println(st.search(1));
		System.out.println(st.search(3));		
		
		
		// ��� iterator
		Iterator<Integer> it = st.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		
		// ��� foreach
		for(Integer n : st)
			System.out.print(n + " ");
		System.out.println();		

	}

}
