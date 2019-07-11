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

/*
 * - ArraryList�� �ߺ��� ���
 * - ���׸��� ����� ��
 * - Set�� �ߺ��� ������� �ʰ� ������ ������, List�� �ߺ��� ����ϰ� ����Ǵ� ������ �����ȴ�
 * 
 */
public class S01_ArrayList {

    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; ������ �߻��Ѵ�.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }
         
        ArrayList<String> al = new ArrayList<String>();

        al.add("one");
        al.add("two");
        al.add("three");
        
        for(int i=0; i<al.size(); i++){
        	String value = al.get(i);				// generic ����ϸ� ����ȯ �ʿ����
        	System.out.println("val = " + value);
        	System.out.println(al.get(i));
        }

        /*
         *  �迭�� ����� ArrayList
         *  - generics�� ��� ����ϴ°�?
         */
        List<String> [] list = new ArrayList[5];
        list[0].add("hello");
        list[1].add("hello");
        
    }

}
