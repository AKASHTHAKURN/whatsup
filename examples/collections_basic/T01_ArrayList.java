package collections.sc;

import java.util.ArrayList;
import java.util.Iterator;

public class T01_ArrayList {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>(); 

		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark"); 
		
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

	}

}
