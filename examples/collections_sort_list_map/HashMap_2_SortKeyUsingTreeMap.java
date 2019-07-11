package ssp.datastructure;

import java.util.*; 

// HashMap Key 정렬(TreeMap)
// TreeMap 사용하여 정렬, 역정렬
// 정렬 후 반드시 iterator로 출력해야 한다


public class HashMap_2_SortKeyUsingTreeMap {
	
	public static void main(String[] args) { 
		HashMap<String, String> ht = new HashMap<String, String>(); 
		ht.put("Banana", "바나나"); 
		ht.put("Orange", "오렌지"); 
		ht.put("Grapes", "포도"); 
		ht.put("Strawberry", "딸기"); 
		ht.put("Apple", "사과"); 

		System.out.println("=== before sort ===");
		for ( String key : ht.keySet() ) { 
			System.out.println( key + " : " + ht.get( key ) ); 
		}
		System.out.println("=== after sort ===");
		//==========================================================================================//
		// 문자열 정렬
		
		TreeMap<String,String> tm = new TreeMap<String,String>(ht); 
		//Iterator<String> keyiterator = tm.keySet( ).iterator( ); 			// 키값 오름차순 정렬 
		Iterator<String> keyiterator = tm.descendingKeySet().iterator(); 	// 키값 내림차순 정렬 
		while(keyiterator.hasNext()) {
			  String key = keyiterator.next();
			  System.out.println(key+","+tm.get(key));
		}

		HashMap<Integer, String> hm = new HashMap<>(); 
		hm.put(3, "바나나"); 
		hm.put(100, "오렌지"); 
		hm.put(5, "포도"); 
		hm.put(23, "포도"); 
		//==========================================================================================//
		// 정수형 정렬

		TreeMap<Integer,String> tm2 = new TreeMap<>(hm);
		Iterator<Integer> keyit = tm2.keySet( ).iterator( ); 
		//Iterator<Integer> keyit = tm2.descendingKeySet().iterator(); 	// 키값 내림차순 정렬 
		while(keyit.hasNext()) {
			  int key = keyit.next();
			  System.out.println(key+","+tm2.get(key));
		}

		
	} 

}


