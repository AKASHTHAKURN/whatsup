package com.lgcns.algorithm.searchword2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//# sample = {"korea","1korea","worldcup","worl2d","WorldCUp","WorldCup","movie","sunday3","KOREA"}
//# 알파벳 대소문자와 숫자로만 구성된 문자열 목록에서 유효한 검색어를 찾고
//# 가장 많이 이용된 검색어를 찾는다.
//# 숫자가 포함된 문자는 숫자를 제거하여 문자로만 구성된 단어를 만들어 사용한다. 
//# 유효한 문자만 뽑는다
//# 유효한 검색어 목록 = {"korea","korea","worldcup","world","WorldCUp","WorldCup","movie","sunday","KOREA"}
//
//# 이렇게 찾아진 문자열 목록에서 사용 빈도가 가장 높은 단어를 검색한다.
//# 대소문자는 구분하지 않고 빈도가 가장 높은 단어는 대문자로 출력한다.
//  만약 사용 빈도가 같은 단어가 여러개 존재하다면 그 중에서 가장 큰 단어(알파벳 중 뒤에 있는 단어)를 선택한다. 
//# KOREA - 3
//# WORLDCPU - 3
//# MOVIE - 1
//  SUNDAY - 1
//# 실시간 검색어 순위 1위 : WORLDCUP

public class SearchWord_sol4 {

	public static void main(String[] args) {
		//테스트 샘플 1
		//String[] sample = { "korea", "1korea", "worldcup", "worl2d", "WorldCUp", "WorldCup", "movie", "sunday3",
		//		"KOREA" };

		//테스트 샘플 2
		String[] sample = { "Enter2prise","developer", "solu7tion","Develop6", "Enterprise", "develop","developer2", "develoPment","enterprise2", "developer3","Development", "solution", "Enter1Prise3", "developer5", "application", "Solution",
		"solu7tion8" };

		
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
			String tmp = "";			
			for(int i=0; i<word.length();i++) {
				char c = word.charAt(i);
				if(c >= '0' && c <= '9') {
					tmp +="";
				}else {
					tmp += c;
				}
			}
			
			validList.add(tmp);
		}
//		--------------------------------------------
		return validList;
	}

	public static String searchWord(List<String> validList) {
		String searchWord = null;
		// -------------------------------------------

		Map<String, Integer> wordcnt = new HashMap<>();

		for (String word : validList) {
			word = word.toUpperCase();
			if (wordcnt.containsKey(word)) {
				wordcnt.put(word, wordcnt.get(word) + 1);
			} else {
				wordcnt.put(word, 1);
			}
		}
		
		System.out.println(wordcnt);

		int max = 0;
		List<String> keylist = new ArrayList<>(wordcnt.keySet());
		Collections.sort(keylist);
		for (String word : keylist) {
			int cnt = wordcnt.get(word);
			if (max <= cnt) {
				max = cnt;
				searchWord = word;
			}
		}

		// --------------------------------------------
		return searchWord;
	}

}
