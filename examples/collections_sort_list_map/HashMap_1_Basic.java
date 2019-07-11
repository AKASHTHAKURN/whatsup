package ssp.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap_1_Basic {

	public static void main(String[] args) {

		// �� ������ ������ ��� �ϳ�

		HashMap<String, String> m = new HashMap<>(); 

		// �߰�
		m.put("kit@gmail.com", "Michael Knight"); 
		m.put("knife@gmail.com", "Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", "Bruce Wayne"); 
		m.put("ironman@gmail.com", "Tony Stark"); 
		
		// ����
		m.remove("superman@gmail.com"); 
		
		// ����
		m.replace("batman@gmail.com", "Robin"); 

		// key �ִ��� üũ�ϰ� value ������ ������Ʈ
		String keyy = "knife@gmail.com";
		if (m.containsKey(keyy)) {
			m.put(keyy, m.get(keyy) + " is my best actor");
		}
		
		// foreach ��� -> ���� �����Ѵ�
		for ( String key : m.keySet() ) { 
			System.out.println( key + " : " + m.get( key ) ); 
		}
		System.out.println(); 

		// ����Ʈ ��� -> ��ƴ�
		iteratorUsingForEach(m);
		iteratorUsingIterator(m);
	}

	static void disp(HashMap<String, String> m) {
		for ( String key : m.keySet() ) { 
			System.out.println( key + " : " + m.get( key ) ); 
		}
		System.out.println(); 
	}
    
	// ��ƴ�, key �� value ���������� �ٲ��� �߰��� ������ ��� �Ѵ�
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
