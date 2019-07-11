package ssp.datastructure;

import java.util.*;

public class HashMap_3_SortValue_Integer {
	public static void main(String[] args) {
	    Map<String,Integer> map = new HashMap<String,Integer>();

	    map.put("a", 1023);
	    map.put("b", 2);
	    map.put("c", 100);
	    map.put("d", 6);
	    map.put("e", 10);
	    map.put("f", 5);

	    
	    System.out.println("------------sort �� -------------");
	    System.out.println(map);
	     
	    Iterator<String> it = sortByValue(map).iterator();
	     
	     
	    System.out.println("---------sort ��------------");
	    while(it.hasNext()){
	        String temp = (String) it.next();
	        System.out.println(temp + " = " + map.get(temp));
	    }
	    //System.out.println(map);
	}

	// ArrayList�� �Ѱܼ� Comparator ����Ͽ� ����
	public static List sortByValue(final Map map){
	    List<String> list = new ArrayList<>();
	    list.addAll(map.keySet());
	     
	    Collections.sort(list,new Comparator<Object>(){
	        public int compare(Object o1,Object o2){
	            Object v1 = map.get(o1);
	            Object v2 = map.get(o2);
	            return ((Comparable) v2).compareTo(v1);		// ���� �ٲٸ� ����
	        }
	    });
	    //Collections.reverse(list); // �ּ��� ��������, ������ ��������
	    return list;
	}
}
