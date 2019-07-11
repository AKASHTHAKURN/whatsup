package collections.sort;

import java.util.*;

/*
 * Comparable �������̽��� �����ؼ� �������̵� �ؾ� �ϴ�  �޼ҵ尡 compareTo() �޼ҵ� �Դϴ�. 
 * �������� ��ȯ�ϴµ�, �ڽŰ� ���ڷ� �־��� �ڽŰ� ���� Ÿ���� ��ü�� ���Ͽ� 
 * ������ 0, �ڽ��� ũ�� ���, �ڽ��� ������ ������ ��ȯ�ϵ��� ����� �˴ϴ�. 
 */

/*
 *	- TreeSet�� ��� ������ �񱳸� compareTo() Ȥ�� compare() �Լ��� ���ؼ� ����
 *  - TreeSet���� �⺻ ���� �� 
 */

// HashSet �׽�Ʈ �� �� ��

public class TreeSet_01_sort_element {

	public static void main(String[] args) {

		//================================================================================//
		// element ����
		// - ������������ �⺻���� �ǰ� ������ �� descendingSet() ���
		//================================================================================//
		TreeSet<String> sl = new TreeSet<String>();
		
		sl.add("ddd");
		sl.add("aaa");
		sl.add("fff");

		// �⺻����
		for(String s : sl) 
            System.out.println(s);

		// �⺻���� �� ������ descendingSet()
		Set<String> intsReverse = (TreeSet<String>) sl.descendingSet(); 

		Iterator<String> it = intsReverse.iterator();
		while(it.hasNext())
			System.out.println(it.next());

		for(String s : intsReverse) 
            System.out.println(s);

		//===================================================================

		//�������� ����
        NavigableSet<String> decendingSet = sl.descendingSet();
        for(String s : decendingSet)
            System.out.print(s+" ");
        System.out.println();
        
        //�������� ����
        NavigableSet<String> ascendingSet = decendingSet.descendingSet();
        for(String s : ascendingSet)
            System.out.print(s+" ");
        System.out.println();
 
        //===================================================================
		
		// ���� �˻�
        TreeSet<Integer> scores = new TreeSet<Integer>();

        scores.add(new Integer(100));
        scores.add(new Integer(12));
        scores.add(new Integer(64));
        scores.add(new Integer(88));
        scores.add(new Integer(97));
        scores.add(new Integer(45));
        
        NavigableSet<Integer> result3 = scores.subSet(50, true, 100, false);
        System.out.println("50 �̻� 100 �̸� ������ ���� �˻�");
        System.out.println("===================");
        for(Integer score : result3){
            System.out.println(score);
        }
        System.out.println();

        NavigableSet<Integer> result = scores.headSet(88, false);
        System.out.println("88 �̸��� ���� �˻�");
        System.out.println("===================");
        for(Integer score : result){
            System.out.println(score);
        }
        System.out.println();
        
        NavigableSet<Integer> result2 = scores.tailSet(88, true);
        System.out.println("88 �̻��� ���� �˻�");
        System.out.println("===================");
        for(Integer score : result2){
            System.out.println(score);
        }
        System.out.println();
    }
}


