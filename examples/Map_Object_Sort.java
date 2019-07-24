package my.java.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Exam_Map_Sort {

	public static void main(String[] args) {

		Map<String, String> m = new HashMap<>(); 
		
		m.put("aaa", 	"ZAKK"); 
		m.put("bbb", 	"ABBA"); 
		m.put("ccc",    "COX"); 
		m.put("ddd", 	"JAMES"); 
		m.put("eee", 	"FOX"); 

		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key +" : " + m.get(key));
		}
		System.out.println();
		
		for(String s : m.keySet())
			System.out.println(s + " : " + m.get(s));
		System.out.println();

		/*
		 * TreeMap 정렬 (only key)
		 */
		TreeMap<String, String> tm = new TreeMap<>(Collections.reverseOrder());
		tm.putAll(m);

		for(String s : tm.keySet())
			System.out.println(s + " : " + tm.get(s));
		System.out.println();


		/*
		 * Map key & value 정렬 
		 */
		List<Map.Entry<String,String>> list = new ArrayList<>(m.entrySet());

		// key 정렬
		Collections.sort(list, (g1, g2) -> g1.getKey().compareTo(g2.getKey()));
		for(Entry<String, String> s : list)
			System.out.println(  s.getKey()+ ": " + s.getValue() );
		System.out.println();
		
		// value 정렬
		Collections.sort(list, (g1, g2) -> g1.getValue().compareTo(g2.getValue()));
		for(Entry<String, String> s : list)
			System.out.println(  s.getKey()+ ": " + s.getValue() );
		System.out.println();


		/*
		 * Map value(object) 정렬
		 */
		Map<Integer, Grade> map = new HashMap<Integer, Grade>();
		
		map.put( 1, new Grade("kim",  85, 70, 70) );
		map.put( 5, new Grade("lee",  35, 30, 90) );
		map.put( 3, new Grade("park", 55, 40, 30) );
		map.put( 4, new Grade("kim",  45, 50, 80) );
		map.put( 2, new Grade("aha",  25, 70, 20) );
		
		for(Integer i : map.keySet())
			System.out.println(i + " " + map.get(i).getKor()  );
		System.out.println();
		
		List<Map.Entry<Integer, Grade>> al = new ArrayList<>(map.entrySet());
		Collections.sort( al, (g1, g2) -> g2.getValue().getKor() - g1.getValue().getKor() );
		for(Entry<Integer, Grade> e : al ) {
			System.out.println(e.getKey() + " " + e.getValue().getKor());
		}
	}
}
/*
class Grade {
	private String strName;
	private int kor;
	private int eng;
	private int mat;
	
	Grade(String strName, int kor, int eng, int mat) {
		
		this.strName = strName;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	
	public String getName() {
		return this.strName;
	}
	
	public int getKor() {
		return this.kor;
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public int getMat() {
		return this.mat;
	}
}
*/