package collections.sc;

import java.util.*;

/*
 * �÷����� ����� ���� ������ Ÿ���� ������ �ش� �÷����� ��ǥ�ϴ� �������̽��� ����ϴ� ���� ����
 * 
 * ArrayList -> List
 * HashMap -> Map
 * HashSet -> Set 
 * 
 * �̷��� �ؾ� ������ ����
 */

public class S06_Iterator {

	public static void main(String[] args) {

		/*
		 * ����Ŭ������ �����ϸ� ���� ������ �����ϴ�
		 */
		
		Collection<Integer> hs = new HashSet<Integer>();
		//Collection<Integer> hs = new ArrayList<Integer>();

		hs.add(5);
		hs.add(1);
		hs.add(3);
		hs.add(2);
		hs.add(13);
		hs.add(7);
		
		Iterator<Integer> it = hs.iterator();	// generic ���
		
		while(it.hasNext()) {
			int val = it.next();				// generic ����Ͽ� ����ȯ �ʿ����
			System.out.println(val);
			//System.out.println(it.next());
		}
	}

}
