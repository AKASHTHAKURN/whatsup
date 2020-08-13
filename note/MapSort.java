package collection.sort.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.TreeMap;

public class MapSort {

	public static void main(String[] args) {

//		MapSortKey();
//		MapSortValue();
		MapSortObject();
	}

	// TreeMap을 사용한 key 정렬
	public static void MapSortKey() {
			
	 	//TreeMap<String, String> tm = new TreeMap<>(hm); 
		TreeMap<String, String> tm = new TreeMap<>(Collections.reverseOrder()); 
		//tm.putAll(hm); // hashmap을 넣을 때	
		
		tm.put("aaa", 	"ZAKK"); 
		tm.put("bbb", 	"ABBA"); 
		tm.put("ccc",    "COX"); 
		tm.put("ddd", 	"JAMES"); 
		tm.put("eee", 	"FOX"); 

		for(String s : tm.keySet())
			System.out.println(s + " " +  tm.get(s));
	}
	
	// key & value 정렬
	public static void MapSortValue() {
		
		Map<String, String> m = new HashMap<>(); 
		
		m.put("aaa", 	"ZAKK"); 
		m.put("bbb", 	"ABBA"); 
		m.put("ccc",    "COX"); 
		m.put("ddd", 	"JAMES"); 
		m.put("eee", 	"FOX"); 

		List<Map.Entry<String, String>> list = new ArrayList<>(m.entrySet());
		
		// key 정렬
		Collections.sort(list, (g1, g2) -> g1.getKey().compareTo(g2.getKey()));
		
		// value 정렬
		Collections.sort(list, (g1, g2) -> g2.getValue().compareTo(g1.getValue()));
//		Collections.sort(list, (g1, g2) -> g2.getValue() - g1.getValue());
		
		for(Entry<String, String> s :list)
			System.out.println(s.getKey() + " " + s.getValue());
	}
	
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
}

class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math; 

    public Grade(String str, int k, int e, int m)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
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
