package tct_summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

// Map 객체를 다중정렬 하려면 List 에 객체를 넣고 한다

public class MapSort {

	public static void main(String[] args) {

//		MapSortKey();
//		MapSortValue();
//		MapSortObject();
		MapSortMultiObject();
	}

	/* TreeMap을 사용한 key 정렬 */
	public static void MapSortKey() {
			
	 	//TreeMap<String, String> tm = new TreeMap<>(hm); 
		TreeMap<String, String> tm = new TreeMap<>(Collections.reverseOrder()); 
		//tm.putAll(hm); // hashmap을 넣을 때	
		
		tm.put("aaa", 	"ZAKK"); 
		tm.put("bbb", 	"ABBA"); 
		tm.put("ccc",    "COX"); 
		tm.put("ddd", 	"JAMES"); 
		tm.put("eee", 	"FOX"); 

		// key 존재 여부 
		if(tm.containsKey("aaa"))
			tm.put("aaa", 	"Slash");
		
		for(String s : tm.keySet())
			System.out.println(s + " " +  tm.get(s));
	}
	
	/* key & value 정렬 */
	public static void MapSortValue() {
		
		Map<String, String> m = new HashMap<>(); 
		
		m.put("aaa", 	"ZAKK"); 
		m.put("bbb", 	"ABBA"); 
		m.put("ccc",    "COX"); 
		m.put("ddd", 	"JAMES"); 
		m.put("eee", 	"FOX"); 

		List<Map.Entry<String, String>> list = new ArrayList<>(m.entrySet());
		
		// key 정렬, 대소문자 무시
		Collections.sort(list, (g1, g2) -> g1.getKey().compareToIgnoreCase(g2.getKey()));
		
		// value 문자 정렬
		Collections.sort(list, (g1, g2) -> g2.getValue().compareTo(g1.getValue()));

		// value 숫자 정렬
		//Collections.sort(list, (g1, g2) -> g2.getValue() - g1.getValue());
		
		for(Entry<String, String> s :list)
			System.out.println(s.getKey() + " " + s.getValue());
	}
	
	/* 객체 정렬 */
	public static void MapSortObject() {

		Map<Integer, Grade> m = new HashMap<Integer, Grade>();
		
		m.put( 1, new Grade("kim",  85, 70, 70) );
		m.put( 5, new Grade("lee",  35, 30, 90) );
		m.put( 3, new Grade("park", 55, 40, 30) );
		m.put( 4, new Grade("kim",  45, 50, 80) );
		m.put( 2, new Grade("aha",  25, 70, 20) );
		
		for(Integer n : m.keySet())
			System.out.printf("%d %s %d %d %d\n", n, m.get(n).getName(), m.get(n).getKorean(), m.get(n).getMath(), m.get(n).getEnglish()  );
		System.out.println();
		
		List<Map.Entry<Integer, Grade>> list = new ArrayList<>(m.entrySet());
		
		Collections.sort( list, (g1, g2) -> g1.getValue().getName().compareTo( g2.getValue().getName() ) );
		
		Collections.sort( list, (g1, g2) -> g2.getValue().getKorean() - g1.getValue().getKorean()  );
		
		for(Entry<Integer, Grade> n : list) {
			System.out.printf("%d %s %d %d %d\n", 
					n.getKey(),
					n.getValue().getName(),
					n.getValue().getKorean(), 
					n.getValue().getMath(), 
					n.getValue().getEnglish()  );
		}
		System.out.println();
	}	
	
	/* 다중 정렬 */
	public static void MapSortMultiObject() {

		Map<Integer, Grade> m = new HashMap<Integer, Grade>();
		
		m.put( 1, new Grade("apple",   70, 70, 70, 1) );
		m.put( 5, new Grade("banana",  90, 30, 90, 5) );
		m.put( 3, new Grade("cupcake", 90, 40, 30, 3) );
		m.put( 4, new Grade("frogen",  90, 50, 80, 4) );
		m.put( 2, new Grade("ginger",  50, 70, 20, 2) );
		
		for(Integer n : m.keySet())
			System.out.printf("%d %s %d %d %d\n", n, m.get(n).getName(), m.get(n).getKorean(), m.get(n).getMath(), m.get(n).getEnglish()  );
		System.out.println();
		
		// list를 다중 정렬
		List<Grade> list = new ArrayList<>(m.values());
		
		Comparator<Grade> reversedKeyComparator = Comparator.comparing(Grade::getName).reversed();
		
		list.sort( Comparator.comparing(Grade::getKorean).reversed().thenComparing(reversedKeyComparator) );

		for(Grade n : list) {
			System.out.printf("%d %s %d %d %d\n", 
					n.getKey(),
					n.getName(),
					n.getKorean(), 
					n.getMath(), 
					n.getEnglish()  );
		}
		System.out.println();

	}	
}

class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math; 
    private int key;
    
    public Grade(String str, int k, int e, int m)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
    }

    public Grade(String str, int k, int e, int m, int key)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
        this.key = key;
    }
    
    public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName()
    {
        return strName;
    }
    public void setName(String strName)
    {
        this.strName = strName;
    }
    public int getKorean()
    {
        return Korean;
    }
    public void setProjectA(int n)
    {
        Korean = n;
    }
    public int getEnglish()
    {
        return English;
    }
    public void setProjectB(int n)
    {
        English = n;
    }
    public int getMath()
    {
        return Math;
    }
    public void setMath(int n)
    {
        Math = n;
    }
}
