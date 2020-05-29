package ssp.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


// 리스트 정렬
// 람다 : 숫자 정렬은 빼기, 문자열 정열은 compareTo 사용


public class ArrayList_1_Basic {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>(); 

		al.add("Zakk Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark");
		
		// 오름차순
		Collections.sort(al);
		
		// 내림차순 *sort() 먼저 실행하고 reverse()
		Collections.reverse(al);

		// 람다 오름차순
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2));	

		// 람다 내림차순
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2) * -1);

		
		// 출력 index
		for (int i=0; i<al.size(); i++) { 
			System.out.println(al.get(i)); 
		} 
		System.out.println(); 

		// 출력 foreach
		for (String name : al) { 
			System.out.println(name); 
		} 
		System.out.println(); 
		
		// remove 
		al.remove("Clark Kent"); 
		
		// remove index
		al.remove(al.get(0)); 
		
		// 지정된 인덱스 내용을 변경
		al.set(0, "Taejin Kim");
		
		// 출력 iterator
		Iterator<String> itr = al.iterator(); 
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}

		/* 숫자 정렬 */
		ArrayList<Integer> li = new ArrayList<Integer>(); 

		li.add(111); 
		li.add(2121); 
		li.add(311); 
		li.add(20); 
		li.add(121); 
		
		Collections.sort(li);

		// 람다 오름차순
		Collections.sort(li, (g1, g2) -> g1 -g2);	

		// 람다 내림차순
		Collections.sort(li, (g1, g2) -> g2 - g1);
		
		// 출력 foreach
		for (Integer n : li) { 
			System.out.println(n); 
		} 
		
	}

}
