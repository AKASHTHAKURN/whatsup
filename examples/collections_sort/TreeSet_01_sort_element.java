package collections.sort;

import java.util.*;

/*
 * Comparable 인터페이스를 구현해서 오버라이딩 해야 하는  메소드가 compareTo() 메소드 입니다. 
 * 정수값을 반환하는데, 자신과 인자로 주어진 자신과 같은 타입의 객체를 비교하여 
 * 같으면 0, 자신이 크면 양수, 자신이 작으면 음수를 반환하도록 만들면 됩니다. 
 */

/*
 *	- TreeSet은 모든 원소의 비교를 compareTo() 혹은 compare() 함수를 통해서 수행
 *  - TreeSet으로 기본 정렬 후 
 */

// HashSet 테스트 해 볼 것

public class TreeSet_01_sort_element {

	public static void main(String[] args) {

		//================================================================================//
		// element 정렬
		// - 오름차순으로 기본정렬 되고 역정렬 시 descendingSet() 사용
		//================================================================================//
		TreeSet<String> sl = new TreeSet<String>();
		
		sl.add("ddd");
		sl.add("aaa");
		sl.add("fff");

		// 기본정렬
		for(String s : sl) 
            System.out.println(s);

		// 기본정렬 후 역정렬 descendingSet()
		Set<String> intsReverse = (TreeSet<String>) sl.descendingSet(); 

		Iterator<String> it = intsReverse.iterator();
		while(it.hasNext())
			System.out.println(it.next());

		for(String s : intsReverse) 
            System.out.println(s);

		//===================================================================

		//내림차순 정렬
        NavigableSet<String> decendingSet = sl.descendingSet();
        for(String s : decendingSet)
            System.out.print(s+" ");
        System.out.println();
        
        //오름차순 정렬
        NavigableSet<String> ascendingSet = decendingSet.descendingSet();
        for(String s : ascendingSet)
            System.out.print(s+" ");
        System.out.println();
 
        //===================================================================
		
		// 범위 검색
        TreeSet<Integer> scores = new TreeSet<Integer>();

        scores.add(new Integer(100));
        scores.add(new Integer(12));
        scores.add(new Integer(64));
        scores.add(new Integer(88));
        scores.add(new Integer(97));
        scores.add(new Integer(45));
        
        NavigableSet<Integer> result3 = scores.subSet(50, true, 100, false);
        System.out.println("50 이상 100 미만 사이의 점수 검색");
        System.out.println("===================");
        for(Integer score : result3){
            System.out.println(score);
        }
        System.out.println();

        NavigableSet<Integer> result = scores.headSet(88, false);
        System.out.println("88 미만인 점수 검색");
        System.out.println("===================");
        for(Integer score : result){
            System.out.println(score);
        }
        System.out.println();
        
        NavigableSet<Integer> result2 = scores.tailSet(88, true);
        System.out.println("88 이상인 점수 검색");
        System.out.println("===================");
        for(Integer score : result2){
            System.out.println(score);
        }
        System.out.println();
    }
}


