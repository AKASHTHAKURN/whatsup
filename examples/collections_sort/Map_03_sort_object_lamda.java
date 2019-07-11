package collections.sort;

import java.util.*;
import java.util.Map.Entry;

public class Map_03_sort_object_lamda {

	public static void main(String[] args) {

		Map<Integer, Grade> m = new HashMap<Integer, Grade>();
		
		m.put( 1, new Grade("kim",  85, 70, 70) );
		m.put( 5, new Grade("lee",  35, 30, 90) );
		m.put( 3, new Grade("park", 55, 40, 30) );
		m.put( 4, new Grade("kim",  45, 50, 80) );
		m.put( 2, new Grade("aha",  25, 70, 20) );
		printMap(m);
		
		List<Map.Entry<Integer, Grade>> list = new ArrayList<Map.Entry<Integer, Grade>>(m.entrySet());
		
		System.out.println("sort by name ascending");
		Collections.sort( list, (g1, g2) -> g1.getValue().getName().compareTo( g2.getValue().getName() ) );
		printList(list);

		System.out.println("sort by kor descending");
		Collections.sort( list, (g1, g2) -> g2.getValue().getKorean() - g1.getValue().getKorean()  );
		printList(list);
	
	}
	
	static void printList(List<Map.Entry<Integer, Grade>> list) {
		
		for(Entry<Integer, Grade> n : list) {
			System.out.printf("%d %s %d %d %d\n", 
					n.getKey(),
					n.getValue().getName(),
					n.getValue().getKorean(), 
					n.getValue().getMath(), 
					n.getValue().getEnglish()  );
		}
		System.out.println();
	}
	
	static void printMap(Map<Integer, Grade> m) {
		for(Integer n : m.keySet())
			System.out.printf("%d %s %d %d %d\n", n, m.get(n).getName(), m.get(n).getKorean(), m.get(n).getMath(), m.get(n).getEnglish()  );
		System.out.println();
	}

}
