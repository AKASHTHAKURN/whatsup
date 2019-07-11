package ssp.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/*
 * 리스트에 객체를 데이터로 추가
 */

//ArrayList<Score> al = new ArrayList<Score>(); 
//al.add(new Score("Tommy Lee",  100, 95, 90));


public class ArrayList_1_Basic {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>(); 

		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark");
		
		/*
		 *  정렬 (람다식 사용) 오름차순
		 */
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2));	// *-1 하면 내림차순 
		
		// 출력방식 1
		for (String name : al) { 
			System.out.println(name); 
		} 
		System.out.println(); 
		
		al.remove("Clark Kent"); 
		
		// 출력방식 2
		for (int i=0; i<al.size(); i++) { 
			System.out.println(al.get(i)); 
		} 
		System.out.println(); 
		
		al.remove(al.get(0)); 
		
		// 지정된 인덱스 내용을 변경
		al.set(0, "Taejin Kim");
		
		// 출력방식 3
		Iterator<String> itr = al.iterator(); 
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		System.out.println(); 

	}

}
