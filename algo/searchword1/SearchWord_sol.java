package com.lgcns.algorithm.searchword1;

import java.util.ArrayList;
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

public class SearchWord_sol {

	public static void main(String[] args) {
		String []sample = {"korea","1korea","worldcup","worl2d","WorldCUp","WorldCup","movie","sunday3","KOREA"};
		
		List<String> validWord = findValidWord(sample);
		System.out.println(validWord);
		
		String searchWord = searchWord(validWord);
		System.out.println(searchWord);
	}
	
	
	public static List<String> findValidWord(String []sample){
		List<String> validList = null;
//		-------------------------------------------
		validList = new ArrayList<String>();
		
		for(String word : sample) {
			boolean check = true;			
			for(int i=0; i<word.length();i++) {
				char c = word.charAt(i);
				if(c >= '0' && c <= '9') {
					check = false;
					break;
				}
			}
			if(check)
				validList.add(word);
		}
		
//		--------------------------------------------
		return validList;
	}
	
	
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------
		List<String> wordList = new ArrayList<String>();
		List<Integer> cntList = new ArrayList<Integer>();		
		
		for(String word : validList) {
			word = word.toUpperCase();
			int inx = -1;
			if(wordList.contains(word)) {
				inx = wordList.indexOf(word);
				cntList.set(inx, cntList.get(inx)+1);
				
			}else {
				wordList.add(word);
				cntList.add(wordList.size()-1, 1);
			}
		}
				
		
		int max = 0;
		for(int i=0; i<cntList.size();i++) {			
			if(max < cntList.get(i)) {
				max = cntList.get(i);
				
				searchWord = wordList.get(i);
			}
		}
		
		
//		--------------------------------------------		
		return searchWord;
	}

}
