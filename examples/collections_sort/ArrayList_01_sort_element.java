package collections.sort;

import java.util.*;

//
// 이 방식 사용하지 말고 Lamda 사용할 것
//

/*
 * Comparable 인터페이스를 구현해서 오버라이딩 해야 하는  메소드가 compareTo() 메소드 입니다. 
 * 정수값을 반환하는데, 자신과 인자로 주어진 자신과 같은 타입의 객체를 비교하여 
 * 같으면 0, 자신이 크면 양수, 자신이 작으면 음수를 반환하도록 만들면 됩니다. 
 * 이 예제에서는 이름을 비교하여 오름차순으로 정렬합니다.
 */

public class ArrayList_01_sort_element {
    public static void main(String[] args) {

    	ArrayList<String> al = new ArrayList<String>();
        
    	al.add("마해영");
    	al.add("최동원");
    	al.add("박찬호");
    	al.add("류현진");
    	al.add("김기태");
    	al.set(0, "마동탁");	// 지정된 index 변경

        // 오름차순 정렬합니다.
        Collections.sort(al);
        for(String s : al)
            System.out.println(s);

        System.out.println("index[0] -> " + al.get(0));
        System.out.println(al.indexOf("박찬호"));

        // 리스트를 역정렬
        Collections.reverse(al); 
        for(String s : al) {
            System.out.println(s);
        }
    }
}

