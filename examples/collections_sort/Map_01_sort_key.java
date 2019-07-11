package collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*
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
*/

public class Map_01_sort_key {

	public static void main(String[] args) {

		// �⺻ ���
		Map<String, String> hm = new HashMap<>(); 
		// ����
		Map<String, String> tma = new TreeMap<>(); 
		Map<String, String> tmd = new TreeMap<String, String>(Collections.reverseOrder());
		// �������� ��
		Map<String, String> lhm = new LinkedHashMap<>(); 
		

		Map<String, String> m = new HashMap<>(); 
		
		// �߰�
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		// ����
		m.remove("superman@gmail.com"); 
		// ����
		m.replace("batman@gmail.com", "Robin"); 
		printList(m);

		// 1. TreeMap�� �ְ� Key �������� ����
		Map<String, String> tm = new TreeMap<String, String>(m);
		printIterator(tm);
		
		// 2. TreeMap�� �ְ� Key ������, putAll() ����ؼ� �Է� (copy map) 
		Map<String, String> rm = new TreeMap<String, String>(Collections.reverseOrder());
		rm.putAll(tm);
		printList(rm);

		// 3. List�� �ְ� compare ����
		List<Map.Entry<String, String>> list = new ArrayList<Entry<String, String>>(m.entrySet());
		Collections.sort(list, (g1, g2) -> g1.getKey().compareTo(g2.getKey()));
		for(Entry<String, String> s : list)
			System.out.println(  s.getKey()+ ": " + s.getValue() );
	
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
