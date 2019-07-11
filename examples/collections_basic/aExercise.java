package collections.sc;

import java.util.*;
import java.util.Map.Entry;


/*
 * - 중복을 허용하지 않는다
 * - 인서트 순서를 유지하지 않는다
 * 
 */
public class aExercise {

	public static void main(String[] args) {

/*
		HashSet<Integer> hs = new HashSet<Integer>();
		
		hs.add(5);
		hs.add(1);
		hs.add(3);
		hs.add(2);
		hs.add(1);
		hs.add(7);
		
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
*/
		
		HashSet<String> hs = new HashSet<String>();
        hs.add("afour");
        hs.add("bone");
        hs.add("ctwo");
        hs.add("dtwo");
        hs.add("esix");
        hs.add("fthree");
        hs.add("gfive");
        Iterator hi = hs.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }

        System.out.println("==========================");
		
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("kim", 4475);
        hm.put("lee", 3810);
        hm.put("park", 3355);
        hm.put("lee", 1122);
        
        useForeach(hm);
        useIterator(hm); 
        
        ListSort ls = new ListSort();
        ls.process();

	}

    // foreach
	static void useForeach(HashMap m) {
        Set<Map.Entry<String, Integer>> en = m.entrySet();
        for(Map.Entry<String, Integer> ie : en) {
        	System.out.println(ie.getKey() + ":" + ie.getValue());
        }
		
	}

    // iterator
	static void useIterator(HashMap m) {
        Set<Map.Entry<String, Integer>> en = m.entrySet();
        Iterator<Entry<String, Integer>> it = en.iterator();
        while(it.hasNext()) {
        	Map.Entry<String, Integer> entry = it.next();
        	System.out.println(entry.getKey()+ ":" + entry.getValue());
        }
	}
	
	
}

class ListSort {
	
	ListSort() {
		
	}
	
	public void process() {
		
		ArrayList<String> al = new ArrayList<String>(); 
		
		System.out.println();
		
		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark"); 
		
		Collections.sort(al);
		for(String name : al)
			System.out.println(name);
		System.out.println();

		Comparator<String> co = new Comparator<String>() {
			public int compare(String o1, String o2) { 
				return (o2.compareTo(o1)); 	// 내림차순
			} 
		}; 

		Collections.sort(al, co);
		for(String name : al)
			System.out.println(name);
		System.out.println();
	}
	
	
	
	
}

