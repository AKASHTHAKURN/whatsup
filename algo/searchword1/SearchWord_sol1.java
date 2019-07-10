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

public class SearchWord_sol1 {

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
		
		for (String word : sample) {
			if(!word.matches(".*[0-9].*"))
				validList.add(word);
		}
		
//		--------------------------------------------
		return validList;
	}
	
	
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------
		Map<String, Integer> wordcnt = new HashMap<>();
		
		for(String word : validList) {
			word = word.toUpperCase();
			if(wordcnt.containsKey(word)) {
				wordcnt.put(word, wordcnt.get(word)+1);
			}else {
				wordcnt.put(word, 1);
			}
		}
		
//		System.out.println(wordcnt);
		
		int max = 0;
		for(String word : wordcnt.keySet()) {
			int cnt = wordcnt.get(word);
			if(max < cnt) {
				max = cnt;
				searchWord = word;
			}
		}
		
		
//		--------------------------------------------		
		return searchWord;
	}

}
