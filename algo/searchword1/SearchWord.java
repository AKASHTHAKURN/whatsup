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

public class SearchWord {

	public static void main(String[] args) {
		String []sample = loadData();
		
		List<String> validWord = findValidWord(sample);
		System.out.println(validWord);
		
		String searchWord = searchWord(validWord);
		System.out.println(searchWord);
	}
	
	public static String[] loadData() {
		//테스트 샘플 1
		/*String[] sample = { "korea", "1korea", "worldcup", "worl2d", "WorldCUp", "WorldCup", "movie", "sunday3",
		"KOREA" };*/
		
		//테스트 샘플 2
		String[] sample = { "Enter2prise","developer", "solu7tion","Develop6", "Enterprise", "develop","developer2", "develoPment","enterprise2", "developer3","Development", "solution", "Enter1Prise3", "developer5", "application", "Solution",
		"solu7tion8" };
		return sample;
	}
	
	
	public static List<String> findValidWord(String []sample){
		List<String> validList = null;
//		-------------------------------------------
		
		
//		--------------------------------------------
		return validList;
	}
	
	
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------
		
		
//		--------------------------------------------		
		return searchWord;
	}

}
