package ssp.string_proc;

import java.util.*;

public class ArraryEx {

	public static void main(String[] args) {

		// �迭���� �� ����
		int[] ids;			// ����
		ids = new int[5];	// ����
		
		// �迭 ����� ������ ����
		char[] chs = new char[5];
		String[] sts = new String[10];

		// �迭�� �ʱ�ȭ, �ʱ�ȭ ���� ������ '0'���� ǥ�õ�
		ids[0] = 10; 
		ids[1] = 20;
		for (int i : ids)
			System.out.println(i);
		
		// �迭�� ������ �ʱ�ȭ�� ���ÿ� -> �̶� ����� �����ϸ� �ȵȴ�
		int[] score = new int[] {50,60,70,100,90};

		String[] actors = new String[] {"James","Ronn","Dean"};
		
		// �迭�� ����
		System.out.println(sts.length);
		
		/*
		 *  0 0 0 0
		 *  
		 *  0 0 0 0 
		 *  0 0 0 0 
		 */
		// 2���� �迭 ����
		String[][] test = new String[3][4]; // [��][��]
		System.out.println("column : " + test.length); // ����� 3
		System.out.println("row : " + test[0].length); // ������ 4
		
		// List �迭 ���� ��� �ϳ�
		// exception �߻���
		ArrayList<String> list[] = new ArrayList[5];

		list[0].add("kin");
		
	}

}
