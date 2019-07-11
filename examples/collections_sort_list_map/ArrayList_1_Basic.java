package ssp.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/*
 * ����Ʈ�� ��ü�� �����ͷ� �߰�
 */

//ArrayList<Score> al = new ArrayList<Score>(); 
//al.add(new Score("Tommy Lee",  100, 95, 90));


public class ArrayList_1_Basic {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>(); 

		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark");
		
		/*
		 *  ���� (���ٽ� ���) ��������
		 */
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2));	// *-1 �ϸ� �������� 
		
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
		System.out.println(); 

	}

}
