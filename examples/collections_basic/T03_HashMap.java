package collections.sc;

import java.util.HashMap;

public class T03_HashMap {

	public static void main(String[] args) {

		/*
		 * 맵 데이터 정렬은 어떻게 하나
		 */
		
		
		HashMap<String, String> m = new HashMap<String, String>(); 
		
		m.put("kit@gmail.com", "Michael Knight"); 
		m.put("knife@gmail.com", "Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", "Bruce Wayne"); 
		m.put("ironman@gmail.com", "Tony Stark"); 
		
		disp(m);
		
		// 삭제
		m.remove("superman@gmail.com"); 
		
		disp(m);
		
		// 변경
		m.replace("batman@gmail.com", "Robin"); 
		
		disp(m);
	}

	static void disp(HashMap<String, String> m) {
		for ( String key : m.keySet() ) { 
			System.out.println( key + " : " +m.get( key ) ); 
		}
		System.out.println(); 
	}
}
