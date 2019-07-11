package collections.sc;

import java.util.HashSet;
import java.util.Iterator;

/*
 *
 * - Set�� �ߺ��� ������� �ʴ´�
 * - ����� ���� iterator ��� or foreach
 * - Set�� �ߺ��� ������� �ʰ� ��������� ������, List�� �ߺ��� ����ϰ� ����Ǵ� ������ �����ȴ�
 * - �޼ҵ� iterator�� �������̽� Collection�� ���ǵǾ� �ִ�. 
 *   ���� Collection�� �����ϰ� �ִ� ��� �÷����� �����ӿ�ũ�� �� �޼ҵ带 �����ϰ� ������ �����Ѵ�. 
 *   �޼ҵ� iterator�� ȣ�� ����� �������̽� iterator�� ������ ��ü�� �����Ѵ�
 */

public class S03_HashSet {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();
		hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        
		// output by iterator
        Iterator hi = hs.iterator();		// ������ HashSet�� iterator�� ����
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
		
		// output by foreach
        for (String ss : hs)
			System.out.println(ss);

/*		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(5);
		hs.add(1);
		hs.add(3);
		hs.add(2);
		hs.add(13);
		hs.add(7);
		
		// output by iterator
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		// output by foreach
		for (Integer s : hs)
			System.out.println(s);
*/        
	}
}
