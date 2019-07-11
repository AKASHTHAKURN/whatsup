package collections.sc;

import java.util.ArrayList;
import java.util.Iterator;

public class T01_ArrayList {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>(); 

		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark"); 
		
		// ��¹�� 1
		for (String name : al) { 
			System.out.println(name); 
		} 
		System.out.println(); 
		
		al.remove("Clark Kent"); 
		
		// ��¹�� 2
		for (int i=0; i<al.size(); i++) { 
			System.out.println(al.get(i)); 
		} 
		System.out.println(); 
		
		al.remove(al.get(0)); 
		
		// ������ �ε��� ������ ����
		al.set(0, "Taejin Kim");
		
		// ��¹�� 3
		Iterator<String> itr = al.iterator(); 
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}

	}

}
