package ssp.datastructure;

import java.util.*;

public class ArrayList_2_Sort_Comparator {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>(); 
		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark"); 
		
		// 정렬 (오름차순), 기본적으로 오름차순으로 구현되어 있다
		// 이때 Compare를 오버라이드 구현할 필요 없다
		Collections.sort(al); 
		for (String name : al) {
			System.out.println(name); 
		} 
		System.out.println(); 
		
		// 정렬 Comparator
		// 내림차순 정렬을 위해 Comparator 인퍼페이스를 구현
		Comparator<String> co = new Comparator<String>() {
			public int compare(String o1, String o2) { 
				return (o2.compareTo(o1)); 				// 내림차순
				//return (o1.compareTo(o2)) * -1;		// 혹은 오름차순 결과에 -1을 곱하면 내림차순이 됨 
			} 
		}; 
		
		Collections.sort(al, co); 
		for (String name : al) { 
			System.out.println(name); 
		} 
		System.out.println(); 

		// 정렬 (람다식 사용) 오름차순
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2));	// *-1 하면 내림차순 
		for (String name : al) { 
			System.out.println(name);
		}
	}

}
