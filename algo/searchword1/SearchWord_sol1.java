package com.lgcns.algorithm.searchword1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//# sample = {"korea","1korea","worldcup","worl2d","WorldCUp","WorldCup","movie","sunday3","KOREA"}
//# 알파벳 대소문자와 숫자로만 구성된 문자열 목록에서 유효한 검색어를 찾고
//# 가장 많이 이용된 검색어를 찾는다.
//# 숫자가 포함된 문자는 유효하지 않는 문자로 판단하여 제거하고
//# 유효한 문자만 뽑는다
//# 유효한 검색어 목록 = {"korea","worldcup","WorldCUp","WorldCup","movie","KOREA"}
//
//# 이렇게 찾아진 문자열 목록에서 사용 빈도가 가장 높은 단어를 검색한다.
//# 대소문자는 구분하지 않고 빈도가 가장 높은 단어는 대문자로 출력한다.
//# KOREA - 2
//# WORLDCPU - 3
//# MOVIE - 1
//# 실시간 검색어 순위 1위 : WORLDCUP

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
