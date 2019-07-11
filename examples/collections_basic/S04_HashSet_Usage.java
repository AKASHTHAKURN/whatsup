package collections.sc;

import java.util.*;

/*
 * 	���տ��
 * 
 * 	A.containsAll(B) : A�� B ���θ� �����ϴ°�?
 * 	
 * 	A.addAll(B); : ������
 * 	
 * 	A.retainAll(B); ������, retain �����ϴ�, A�� B�� ����ִ°�
 * 	
 * 	A.removeAll(B); ������, A���� B�� ����
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
         * �ϳ��� Ǯ��� ���� �� ��
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
