package ssp.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* HashMap 출력 시 무조건 foreach, keyset() 사용해라 */

public class HashMap_1_Basic {

	public static void main(String[] args) {

		// 맵 데이터 정렬은 어떻게 하나

		HashMap<String, String> m = new HashMap<>(); 

		// 추가
		m.put("kit@gmail.com", "Michael Knight"); 
		m.put("knife@gmail.com", "Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", "Bruce Wayne"); 
		m.put("ironman@gmail.com", "Tony Stark"); 
		
		// 삭제
		m.remove("superman@gmail.com"); 
		
		// 변경
		m.replace("batman@gmail.com", "Robin"); 

		// key 있는지 체크하고 value 꺼내서 업데이트
		String keyy = "knife@gmail.com";
		if (m.containsKey(keyy)) {
			m.put(keyy, m.get(keyy) + " is my best actor");
		}
		
		// ===== foreach 출력 -> 제일 간편한다
		for ( String key : m.keySet() ) { 
			System.out.println( key + " : " + m.get( key ) ); 
		}
		System.out.println(); 

		// 리스트 출력 -> 어렵다
		iteratorUsingForEach(m);
		iteratorUsingIterator(m);
	}

	static void disp(HashMap<String, String> m) {
		for ( String key : m.keySet() ) { 
			System.out.println( key + " : " + m.get( key ) ); 
		}
		System.out.println(); 
	}
    
	// 어렵다, key 와 value 데이터형이 바뀔경우 추가로 선언해 줘야 한다
	static void iteratorUsingForEach(HashMap<String, String> m){
        Set<Map.Entry<String, String>> entries = m.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
		System.out.println(); 
    }
    static void iteratorUsingIterator(HashMap<String, String> map){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, String> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
		System.out.println(); 
    }	
}
