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
	Java 개발자라면 아마도 Map을 이야기할 때 HashMap을 주로 생각할 것이다. 
	HashMap은 내부적으로 Entry<K,V>[] Entry Array로 구성되어 있다. Array의 index를 hash 함수를 통혜 계산한다.
	위 그림처럼 Entry로 저장이 되는데, 내부적으로 Hash 값에 의해 어떤 Bucket에 담길지 결정이 된다.
	만약 Hash 값이 같다면 같은 Bucket에 List로 연결될 것이다.(마치 LinkedList처럼 Entry 안에 next Entry를 저장하는 변수가 있음)
	Hash 값을 이용하여 저장하기 때문에 순서를 보장하지 않는다. get() 메서드는 Hash 값으로 해당 Array에 바로 접근이 가능하기 때문에 성능은 O(1)으로 빠르다.

	[결론]
	대부분의 Java 개발자가 HashMap을 주로 사용하는 이유는 get() 메서드의 성능이 O(1)로 빠르기 때문인 것 같습니다. 
	-> 특별한 이유가 없다면 get() 성능이 빠른 HashMap을 사용하자. 
	-> 순서 보장이 필요하다면 TreeMap이나 LinkedHashMap을 고려해 볼 수도 있다. 
	
	만약 동기화 이슈가 있다면 HashTable도 고려할 수 있다. 다만 동기화 수준에 따라 ConcurrentHashMap을 사용해도 성능 상 효과를 볼 수 있을 것이다.
*/

/*
	public interface Map<K,V> {
	    int size();
	    boolean isEmpty();
	    boolean containsKey(Object key);
	    boolean containsValue(Object value);
	    V get(Object key);
	    V put(K key, V value);
	    V replace(K key, V value);	// value를 변경
	    V remove(Object key);
	    void putAll(Map<? extends K, ? extends V> m); // copy map
	}
*/

public class Map_01_sort_key {

	public static void main(String[] args) {

		// 기본 사용
		Map<String, String> hm = new HashMap<>(); 
		// 정렬
		Map<String, String> tma = new TreeMap<>(); 
		Map<String, String> tmd = new TreeMap<String, String>(Collections.reverseOrder());
		// 순서유지 됨
		Map<String, String> lhm = new LinkedHashMap<>(); 
		

		Map<String, String> m = new HashMap<>(); 
		
		// 추가
		m.put("zit@gmail.com", 		"Michael Knight"); 
		m.put("knife@gmail.com", 	"Mac Guyver"); 
		m.put("superman@gmail.com", "Clark Kent"); 
		m.put("batman@gmail.com", 	"Bruce Wayne"); 
		m.put("ironman@gmail.com", 	"Tony Stark"); 
		// 삭제
		m.remove("superman@gmail.com"); 
		// 변경
		m.replace("batman@gmail.com", "Robin"); 
		printList(m);

		// 1. TreeMap에 넣고 Key 오름차순 정렬
		Map<String, String> tm = new TreeMap<String, String>(m);
		printIterator(tm);
		
		// 2. TreeMap에 넣고 Key 역정혈, putAll() 사용해서 입력 (copy map) 
		Map<String, String> rm = new TreeMap<String, String>(Collections.reverseOrder());
		rm.putAll(tm);
		printList(rm);

		// 3. List에 넣고 compare 정렬
		List<Map.Entry<String, String>> list = new ArrayList<Entry<String, String>>(m.entrySet());
		Collections.sort(list, (g1, g2) -> g1.getKey().compareTo(g2.getKey()));
		for(Entry<String, String> s : list)
			System.out.println(  s.getKey()+ ": " + s.getValue() );
	
	}

	// <==============================================================
	// 출력1 -> 제일 간단
	static void printList(Map<String, String> m) {
		for(String s : m.keySet()) 
			System.out.println(s + ": " + m.get(s));
		System.out.println("===============================");
	}

	// 출력2 -> Iterator 간단
	static void printIterator(Map<String, String> m) {
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + ": " + m.get(key));
		}
	}
	// ==============================================================>


	/* 사용하기 어렵다, 참조만 할 것 */
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
