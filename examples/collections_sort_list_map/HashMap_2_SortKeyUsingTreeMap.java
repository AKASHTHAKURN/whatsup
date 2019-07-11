package ssp.datastructure;

import java.util.*; 

// HashMap Key ����(TreeMap)
// TreeMap ����Ͽ� ����, ������
// ���� �� �ݵ�� iterator�� ����ؾ� �Ѵ�


public class HashMap_2_SortKeyUsingTreeMap {
	
	public static void main(String[] args) { 
		HashMap<String, String> ht = new HashMap<String, String>(); 
		ht.put("Banana", "�ٳ���"); 
		ht.put("Orange", "������"); 
		ht.put("Grapes", "����"); 
		ht.put("Strawberry", "����"); 
		ht.put("Apple", "���"); 

		System.out.println("=== before sort ===");
		for ( String key : ht.keySet() ) { 
			System.out.println( key + " : " + ht.get( key ) ); 
		}
		System.out.println("=== after sort ===");
		//==========================================================================================//
		// ���ڿ� ����
		
		TreeMap<String,String> tm = new TreeMap<String,String>(ht); 
		//Iterator<String> keyiterator = tm.keySet( ).iterator( ); 			// Ű�� �������� ���� 
		Iterator<String> keyiterator = tm.descendingKeySet().iterator(); 	// Ű�� �������� ���� 
		while(keyiterator.hasNext()) {
			  String key = keyiterator.next();
			  System.out.println(key+","+tm.get(key));
		}

		HashMap<Integer, String> hm = new HashMap<>(); 
		hm.put(3, "�ٳ���"); 
		hm.put(100, "������"); 
		hm.put(5, "����"); 
		hm.put(23, "����"); 
		//==========================================================================================//
		// ������ ����

		TreeMap<Integer,String> tm2 = new TreeMap<>(hm);
		Iterator<Integer> keyit = tm2.keySet( ).iterator( ); 
		//Iterator<Integer> keyit = tm2.descendingKeySet().iterator(); 	// Ű�� �������� ���� 
		while(keyit.hasNext()) {
			  int key = keyit.next();
			  System.out.println(key+","+tm2.get(key));
		}

		
	} 

}


