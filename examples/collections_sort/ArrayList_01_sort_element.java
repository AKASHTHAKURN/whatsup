package collections.sort;

import java.util.*;

//
// �� ��� ������� ���� Lamda ����� ��
//

/*
 * Comparable �������̽��� �����ؼ� �������̵� �ؾ� �ϴ�  �޼ҵ尡 compareTo() �޼ҵ� �Դϴ�. 
 * �������� ��ȯ�ϴµ�, �ڽŰ� ���ڷ� �־��� �ڽŰ� ���� Ÿ���� ��ü�� ���Ͽ� 
 * ������ 0, �ڽ��� ũ�� ���, �ڽ��� ������ ������ ��ȯ�ϵ��� ����� �˴ϴ�. 
 * �� ���������� �̸��� ���Ͽ� ������������ �����մϴ�.
 */

public class ArrayList_01_sort_element {
    public static void main(String[] args) {

    	ArrayList<String> al = new ArrayList<String>();
        
    	al.add("���ؿ�");
    	al.add("�ֵ���");
    	al.add("����ȣ");
    	al.add("������");
    	al.add("�����");
    	al.set(0, "����Ź");	// ������ index ����

        // �������� �����մϴ�.
        Collections.sort(al);
        for(String s : al)
            System.out.println(s);

        System.out.println("index[0] -> " + al.get(0));
        System.out.println(al.indexOf("����ȣ"));

        // ����Ʈ�� ������
        Collections.reverse(al); 
        for(String s : al) {
            System.out.println(s);
        }
    }
}

