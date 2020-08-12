/*
 * LinkedList는 값을 중간에 추가할 수 있다, 추가시 인덱스 자동 조정
 * ArrayList는 값을 중간에 추가하기 힘들다
 */

import java.util.LinkedList;

public class LinkedList_Ex {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();//타입설정 int타입만 사용가능
		
		list.addFirst(1);//가장 앞에 데이터 추가

		list.addLast(2);//가장 뒤에 데이터 추가
		
		list.add(3);//데이터 추가
		
		list.add(5);
		
		list.add(3, 4);	// 인덱스 3 뒤에 4 추가
		
		for(int i:list)
			System.out.println(i);
	}
}
