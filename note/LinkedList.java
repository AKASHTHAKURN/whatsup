package tct_summary;

// LinkedList는 값을 중간에 추가할 수 있다, 추가시 인덱스 자동 조정
// ArrayList는 값을 중간에 추가하기 힘들다

import java.util.LinkedList;

public class LinkedList_Ex {

	public static void main(String[] args) {

		LinkedList<String> li = new LinkedList<String>();

		li.add("hello0");
		li.add("hello1");
		li.add("hello2");
		li.add("hello3");
		li.add("hello4");

		li.add(2, "hello2add");
		li.addFirst("hellofirst");
		li.addLast("hellolast");		
		
		// index는 0 부터 시작
		for(int i=0; i<li.size(); i++)
			System.out.println( i + " : " + li.get(i));

		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.addFirst(1);//가장 앞에 데이터 추가
		list.addLast(2);//가장 뒤에 데이터 추가
		list.add(3);//데이터 추가
		list.add(5);
		list.add(3, 4);	// 인덱스 3 뒤에 4 추가
		
		for(int i:list)
			System.out.println(i);

	}
}
