package ssp.string_proc;

import java.util.*;

public class ArraryEx {

	public static void main(String[] args) {

		// 배열선언 및 생성
		int[] ids;			// 선언
		ids = new int[5];	// 생성
		
		// 배열 선언과 생성을 동시
		char[] chs = new char[5];
		String[] sts = new String[10];

		// 배열의 초기화, 초기화 안한 구간은 '0'으로 표시됨
		ids[0] = 10; 
		ids[1] = 20;
		for (int i : ids)
			System.out.println(i);
		
		// 배열의 생성과 초기화를 동시에 -> 이때 사이즈를 지정하면 안된다
		int[] score = new int[] {50,60,70,100,90};

		String[] actors = new String[] {"James","Ronn","Dean"};
		
		// 배열의 길이
		System.out.println(sts.length);
		
		/*
		 *  0 0 0 0
		 *  
		 *  0 0 0 0 
		 *  0 0 0 0 
		 */
		// 2차원 배열 길이
		String[][] test = new String[3][4]; // [행][열]
		System.out.println("column : " + test.length); // 행길이 3
		System.out.println("row : " + test[0].length); // 열길이 4
		
		// List 배열 선언 어떻게 하나
		// exception 발생함
		ArrayList<String> list[] = new ArrayList[5];

		list[0].add("kin");
		
	}

}
