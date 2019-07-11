package ssp.datastructure;

import java.util.*;

public class HashMap_4_SortValue_String {
	public static void main(String[] args) {
	    Map<String,String> map = new HashMap<String,String>();

	    map.put("d", "6");
	    map.put("a", "3");
	    map.put("c", "100");
	    map.put("b", "2");

	    
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

	// key(String)�� ����ִ� List�� ��ȯ
	public static List sortByValue(final Map map){
	    List<String> list = new ArrayList<>();
	    list.addAll(map.keySet());
	     
	    Collections.sort(list,new Comparator<Object>(){
	        public int compare(Object o1,Object o2){
	            Object v1 = map.get(o1);
	            Object v2 = map.get(o2);
	             
	            return ((Comparable) v1).compareTo(v2);
	        }
	    });
	    //Collections.reverse(list); // �ּ��� ��������, ������ ��������
	    return list;
	}
}
