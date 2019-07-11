package collections.sc;

import java.util.*;

public class T02_ListSortComparator {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>(); 
		al.add("Michael Knight"); 
		al.add("Mac Guyver"); 
		al.add("Clark Kent"); 
		al.add("Bruce Wayne"); 
		al.add("Tony Stark"); 
		
		/*
		 * ���� (��������), �⺻������ ������������ �����Ǿ� �ִ�
		 */
		Collections.sort(al); 
		for (String name : al) {
			System.out.println(name); 
		} 
		System.out.println(); 
		
		/*
		 * ���� Comparator
		 * �������� ������ ���� Comparator �������̽��� ����
		 */
		Comparator<String> co = new Comparator<String>() {
			public int compare(String o1, String o2) { 
				return (o2.compareTo(o1)); 				// ��������
				//return (o1.compareTo(o2)) * -1;		// Ȥ�� �������� ����� -1�� ���ϸ� ���������� �� 
			} 
		}; 
		
		Collections.sort(al, co); 
		for (String name : al) { 
			System.out.println(name); 
		} 
		System.out.println(); 

		/*
		 * ���� (���ٽ� ���)
		 */
		Collections.sort(al, (g1, g2) -> g1.compareTo(g2)); 
		for (String name : al) { 
			System.out.println(name);
		}
	}

}
