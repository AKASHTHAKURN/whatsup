package collections.sc;

import java.util.*;

/*
 * 컬렉션을 사용할 때는 데이터 타입은 가급적 해당 컬렉션을 대표하는 인터페이스를 사용하는 것이 좋다
 * 
 * ArrayList -> List
 * HashMap -> Map
 * HashSet -> Set 
 * 
 * 이렇게 해야 변경이 쉽다
 */

public class S06_Iterator {

	public static void main(String[] args) {

		/*
		 * 상위클래스로 선언하면 쉽게 변경이 가능하다
		 */
		
		Collection<Integer> hs = new HashSet<Integer>();
		//Collection<Integer> hs = new ArrayList<Integer>();

		hs.add(5);
		hs.add(1);
		hs.add(3);
		hs.add(2);
		hs.add(13);
		hs.add(7);
		
		Iterator<Integer> it = hs.iterator();	// generic 사용
		
		while(it.hasNext()) {
			int val = it.next();				// generic 사용하여 형변환 필요없다
			System.out.println(val);
			//System.out.println(it.next());
		}
	}

}
