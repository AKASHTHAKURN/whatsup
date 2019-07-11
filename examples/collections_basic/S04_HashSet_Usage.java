package collections.sc;

import java.util.*;

/*
 * 	집합용법
 * 
 * 	A.containsAll(B) : A가 B 전부를 포함하는가?
 * 	
 * 	A.addAll(B); : 합집함
 * 	
 * 	A.retainAll(B); 교집합, retain 유지하다, A와 B에 모두있는것
 * 	
 * 	A.removeAll(B); 차집합, A에서 B를 제거
 * 
 */

public class S04_HashSet_Usage {

	public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
         
        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);
         
        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);
         
        System.out.println(A.containsAll(B)); // false
        System.out.println(A.containsAll(C)); // true
        
        /*
         * 하나씩 풀어가며 실행 할 것
         */
        //A.addAll(B);
        //A.retainAll(B);
        A.removeAll(B);
         
        Iterator hi = A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
	}

}
