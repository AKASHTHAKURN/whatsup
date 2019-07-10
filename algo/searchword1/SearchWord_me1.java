package com.lgcns.algorithm.searchword1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//# sample = {"korea","1korea","worldcup","worl2d","WorldCUp","WorldCup","movie","sunday3","KOREA"}
//# ���ĺ� ��ҹ��ڿ� ���ڷθ� ������ ���ڿ� ��Ͽ��� ��ȿ�� �˻�� ã��
//# ���� ���� �̿�� �˻�� ã�´�.
//# ���ڰ� ���Ե� ���ڴ� ��ȿ���� �ʴ� ���ڷ� �Ǵ��Ͽ� �����ϰ�
//# ��ȿ�� ���ڸ� �̴´�
//# ��ȿ�� �˻��� ��� = {"korea","worldcup","WorldCUp","WorldCup","movie","KOREA"}
//
//# �̷��� ã���� ���ڿ� ��Ͽ��� ��� �󵵰� ���� ���� �ܾ �˻��Ѵ�.
//# ��ҹ��ڴ� �������� �ʰ� �󵵰� ���� ���� �ܾ�� �빮�ڷ� ����Ѵ�.
//# KOREA - 2
//# WORLDCPU - 3
//# MOVIE - 1
//# �ǽð� �˻��� ���� 1�� : WORLDCUP

public class SearchWord_me1 {

	public static void main(String[] args) {
		String []sample = loadData();
		
		List<String> validWord = findValidWord(sample);
		System.out.println(validWord);
		
		String searchWord = searchWord(validWord);
		System.out.println(searchWord);
	}
	
	public static String[] loadData() {
		//�׽�Ʈ ���� 1
		String[] sample = { "korea", "1korea", "worldcup", "worl2d", "WorldCUp", "WorldCup", "movie", "sunday3",
		"KOREA" };
		
		//�׽�Ʈ ���� 2
		/*
		String[] sample = { "Enter2prise","developer", "solu7tion","Develop6", "Enterprise", "develop","developer2", "develoPment","enterprise2", "developer3","Development", "solution", "Enter1Prise3", "developer5", "application", "Solution",
		"solu7tion8" };
		*/
		return sample;
	}
	
	
	public static List<String> findValidWord(String []sample){
		List<String> validList = null;


		
//		-------------------------------------------
		
		
		
		validList = new ArrayList<String>();

		for(int i=0; i<sample.length; i++) {
			
			char[] arr = sample[i].toCharArray();
			
			for (int k=0; k<arr.length; k++) {
				
				//System.out.println(i + "," + k);
				
				if (Character.isDigit(arr[k])) {
					
					for(int j=k; j<arr.length-1; j++) {
						arr[j] = arr[j+1];
					}
					arr[arr.length-1] = 0x00;
				
				}
				
			}
		
			validList.add(String.valueOf(arr));
			
		}
		
		//for(String k : validList){
		//	System.out.println(k);
		//}
		
//		--------------------------------------------
		return validList;
	}
	
	/*
	 * HashMap ���
	 * containsKey ����ؼ� ������ ���� �ִ��� �˻�
	 * 
	 * -> ���� � �����̸� HashMap ���
	 */
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------
		
		
//		--------------------------------------------		
		return searchWord;
	}

}
