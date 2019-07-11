package collections.sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;


/*
	public interface Map<K,V> {
	    int size();
	    boolean isEmpty();
	    boolean containsKey(Object key);
	    boolean containsValue(Object value);
	    V get(Object key);
	    V put(K key, V value);
	    V replace(K key, V value);	// value�� ����
	    V remove(Object key);
	    void putAll(Map<? extends K, ? extends V> m); // copy map
	}
	
	Java �����ڶ�� �Ƹ��� Map�� �̾߱��� �� HashMap�� �ַ� ������ ���̴�. 
	HashMap�� ���������� Entry<K,V>[] Entry Array�� �����Ǿ� �ִ�. Array�� index�� hash �Լ��� ���� ����Ѵ�.
	�� �׸�ó�� Entry�� ������ �Ǵµ�, ���������� Hash ���� ���� � Bucket�� ����� ������ �ȴ�.
	���� Hash ���� ���ٸ� ���� Bucket�� List�� ����� ���̴�.(��ġ LinkedListó�� Entry �ȿ� next Entry�� �����ϴ� ������ ����)
	Hash ���� �̿��Ͽ� �����ϱ� ������ ������ �������� �ʴ´�. get() �޼���� Hash ������ �ش� Array�� �ٷ� ������ �����ϱ� ������ ������ O(1)���� ������.

	[���]
	��κ��� Java �����ڰ� HashMap�� �ַ� ����ϴ� ������ get() �޼����� ������ O(1)�� ������ ������ �� �����ϴ�. 
	-> Ư���� ������ ���ٸ� get() ������ ���� HashMap�� �������. 
	-> ���� ������ �ʿ��ϴٸ� TreeMap�̳� LinkedHashMap�� ����� �� ���� �ִ�. 
	
	���� ����ȭ �̽��� �ִٸ� HashTable�� ����� �� �ִ�. �ٸ� ����ȭ ���ؿ� ���� ConcurrentHashMap�� ����ص� ���� �� ȿ���� �� �� ���� ���̴�.
*/

/*
	1. ����
 	- Key ����, ok
 	- Value ����
 	- Value�� ��ü�� �ְ� Ư�� ������� ����

	1.1 Value ����
	1.1.1 Comparator ���

*/

public class Map_02_sort_value {

	public static void main(String[] args) {

// Best way !!
//============================================================================
		Map<String, String> m = new HashMap<>(); 
		
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		printList(m);

		// �����ϱ� ���� List �� map entry�� �ִ´�
        List<Map.Entry<String, String>> list = new ArrayList<>(m.entrySet());
        //List<Map.Entry<String, String>> list = new LinkedList<>(m.entrySet());
        
        Collections.sort(list, (g1, g2) -> g1.getValue().compareTo(g2.getValue()) * -1);
        
        for(Entry<String, String> s : list)
        	System.out.println(s.getKey() + ": " + s.getValue());
//============================================================================

        
		//sortMapValue2();
		//sortMapValue3();
	}

	// ���� ������ ���
	static void sortMapValue1() {
		Map<String, String> m = new HashMap<>(); 
		
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		printList(m);

		// �����ϱ� ���� List �� map entry�� �ִ´�
        List<Map.Entry<String, String>> list = new LinkedList<>(m.entrySet());
        
        Collections.sort(list, (g1, g2) -> g1.getValue().compareTo(g2.getValue()) * -1);
        //Collections.sort( list, (g1, g2) -> g2.getValue() - g1.getValue() ); // ������ ����
        
        for(Entry<String, String> s : list)
        	System.out.println(s.getKey() + ": " + s.getValue());
	}

	static void sortMapValue3() {
		Map<String, String> m = new HashMap<>(); 
		
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		printList(m);

		// value ������������ �����ϰ�, value�� ������ key ������������ ����
        List<Map.Entry<String, String>> list = new LinkedList<>(m.entrySet());

        
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                
            	return o1.getValue().compareTo(o2.getValue()) *-1;
            }
        });
        
        
        for(Entry<String, String> s : list)
        	System.out.println(s.getKey() + ": " + s.getValue());
        
        /*        
        // ���������� ���� LinkedHashMap�� ���
        Map<String, String> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, String>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, String> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }		
		printList(sortedMap);
		*/
	}

	static void sortMapValue2() {
		Map<String, String> m = new HashMap<>(); 
		
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		printList(m);
		
		Iterator it = sortByValue(m).iterator();
		
		while(it.hasNext()) {
			
			String key = (String) it.next();
			System.out.println(key + ": " + m.get(key));
		}
		
		
	}

	public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();

        list.addAll(map.keySet());

        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);	// * -1 
            }
        });

        //Collections.reverse(list); // �ּ��� ��������

        return list;
    }

	
	
	
	// <==============================================================
	// ���1 -> ���� ����
	static void printList(Map<String, String> m) {
		for(String s : m.keySet()) 
			System.out.println(s + ": " + m.get(s));
		System.out.println("===============================");
	}

	// ���2 -> Iterator ����
	static void printIterator(Map<String, String> m) {
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + ": " + m.get(key));
		}
	}
	// ==============================================================>


	/* ����ϱ� ��ƴ�, ������ �� �� */
	// iteratorUsingForEach
	static void iteratorUsingForEach(Map<String, String> m){
        Set<Map.Entry<String, String>> entries = m.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
		System.out.println(); 
    }
	// iteratorUsingIterator
    static void iteratorUsingIterator(Map<String, String> map){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, String> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
		System.out.println(); 
    }		
}
