import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class TreeMap_1_sort_key {

	public static void main(String[] args) {

		/* TreeMap 정렬 */
		TreeMap<String,String> m = new TreeMap<String,String>();	
//		TreeMap<String,String> m = new TreeMap<String,String>(Collections.reverseOrder());	// 역정렬 

		m.put("z kit@gmail.com", "Michael Knight"); 
		m.put("k knife@gmail.com", "Mac Guyver"); 
		m.put("d superman@gmail.com", "Clark Kent"); 
		m.put("b atman@gmail.com", "Bruce Wayne"); 
		m.put("a ronman@gmail.com", "Tony Stark"); 	

		for(String key : m.keySet())
			System.out.println(key +":"+ m.get(key));

		/* HashMap 생성 후 TreeMap 에 넣어서 정렬 */
		HashMap<String, String> ht = new HashMap<String, String>(); 
		ht.put("Banana", "바나나"); 
		ht.put("Orange", "오렌지"); 
		ht.put("Grapes", "포도"); 
		ht.put("Strawberry", "딸기"); 
		ht.put("Apple", "사과"); 

		// 오름차순
//		TreeMap<String,String> tm = new TreeMap<String,String>(ht);	

		// 내림차순
		TreeMap<String,String> tm = new TreeMap<String,String>(Collections.reverseOrder());	
		tm.putAll(ht);

		for(String key : tm.keySet())
			System.out.println(key +":"+ m.get(key));
		
	}

}
