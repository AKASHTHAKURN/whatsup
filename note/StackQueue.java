import java.util.*;

/*
 * queue : add(), poll()
 * stack : push(), pop()
 */

public class StackQueue {

	public static void main(String[] args) {

		queueTest();
		stackTest();
	}
	
	static void queueTest() {

		System.out.println("--- 큐테스트");
		
		Deque<String> qu = new ArrayDeque<String>();
//	LinkedList<String> qu = new LinkedList<String>();
		
		// add() 메소드를 이용한 요소의 저장
		qu.add("넷");
		qu.add("둘");
		qu.add("셋");
		qu.add("하나");
		
		// peek() 메소드를 이용한 요소값 반환
		System.out.println(qu.peek());
		System.out.println(qu);
		
		// poll() 메소드를 이용한 요소값 반환 및 제거
		System.out.println(qu.poll());
		System.out.println(qu);

		// add() 요소 추가
		System.out.println(qu.add("다섯"));
		System.out.println(qu.add("하나"));
		System.out.println(qu);
		
		// remove() 메소드를 이용한 특정 요소의 제거 --> 만일 '하나'가 두개이면 앞부분 한개만 제거
		System.out.println(qu.remove("하나"));	// 첫번째 제거
		System.out.println(qu.remove("하나"));  // 두번째 제거
		System.out.println(qu.remove("하나"));  // 없는거 제거 ,false
		System.out.println(qu);

		for(String n : qu)
			System.out.print(n + " ");
		System.out.println();		

		/*
		Iterator<String> it = qu.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		*/
	}
	
	static void stackTest() {

		System.out.println("--- 스텍테스트");

		Stack<Integer> st = new Stack<Integer>();
//	Deque<Integer> st = new ArrayDeque<Integer>();

		// push() 메소드를 이용한 요소의 저장
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);

		// peek() 메소드를 이용한 요소의 반환, stack 꺼낼수 있는값
		System.out.println(st.peek());
		System.out.println(st);

		// pop() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(st.pop());
		System.out.println(st);

		// search() 메소드를 이용한 요소의 위치 검색
		// ArrayDeque 클래스는 Stack 클래스와는 달리 search() 메소드는 미지원
		System.out.println(st.search(1));
		System.out.println(st.search(3));		
		
		for(Integer n : st)
			System.out.print(n + " ");
		System.out.println();		

		/*		
		Iterator<Integer> it = st.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		*/		
	}
}
