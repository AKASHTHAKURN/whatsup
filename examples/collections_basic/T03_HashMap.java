package collections.sc;

import java.util.HashMap;

public class T03_HashMap {

	public static void main(String[] args) {

		/*
		 * �� ������ ������ ��� �ϳ�
		 */
		
		
		HashMap<String, String> m = new HashMap<String, String>(); 
		
		m.put("kit@gmail.com", "Michael Knight"); 
		m.put("knife@gmail.com", "Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", "Bruce Wayne"); 
		m.put("ironman@gmail.com", "Tony Stark"); 
		
		disp(m);
		
		// ����
		m.remove("superman@gmail.com"); 
		
		disp(m);
		
		// ����
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
