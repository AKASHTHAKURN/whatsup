package collections.sc;

import java.util.HashSet;
import java.util.Iterator;

/*
 *
 * - Set은 중복을 허용하지 않는다
 * - 출력을 위해 iterator 사용 or foreach
 * - Set는 중복을 허용하지 않고 저장순서가 없지만, List는 중복을 허용하고 저장되는 순서가 유지된다
 * - 메소드 iterator는 인터페이스 Collection에 정의되어 있다. 
 *   따라서 Collection을 구현하고 있는 모든 컬렉션즈 프레임웍크는 이 메소드를 구현하고 있음을 보증한다. 
 *   메소드 iterator의 호출 결과는 인터페이스 iterator를 구현한 객체를 리턴한다
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
        Iterator hi = hs.iterator();		// 생선된 HashSet을 iterator로 연결
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
