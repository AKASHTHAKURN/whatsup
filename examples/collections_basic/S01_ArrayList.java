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

/*
 * - ArraryList는 중복을 허용
 * - 제네릭을 사용할 것
 * - Set는 중복을 허용하지 않고 순서가 없지만, List는 중복을 허용하고 저장되는 순서가 유지된다
 * 
 */
public class S01_ArrayList {

    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; 오류가 발생한다.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }
         
        ArrayList<String> al = new ArrayList<String>();

        al.add("one");
        al.add("two");
        al.add("three");
        
        for(int i=0; i<al.size(); i++){
        	String value = al.get(i);				// generic 사용하면 형변환 필요없다
        	System.out.println("val = " + value);
        	System.out.println(al.get(i));
        }

        /*
         *  배열을 사용한 ArrayList
         *  - generics는 어떻게 사용하는가?
         */
        List<String> [] list = new ArrayList[5];
        list[0].add("hello");
        list[1].add("hello");
        
    }

}
