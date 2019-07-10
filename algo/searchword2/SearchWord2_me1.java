package com.lgcns.algorithm.searchword2;

import java.util.*;

//# sample = {"korea","1korea","worldcup","worl2d","WorldCUp","WorldCup","movie","sunday3","KOREA"}
//# ���ĺ� ��ҹ��ڿ� ���ڷθ� ������ ���ڿ� ��Ͽ��� ��ȿ�� �˻�� ã��
//# ���� ���� �̿�� �˻�� ã�´�.
//# ���ڰ� ���Ե� ���ڴ� ���ڸ� �����Ͽ� ���ڷθ� ������ �ܾ ����� ����Ѵ�. 
//# ��ȿ�� ���ڸ� �̴´�
//# ��ȿ�� �˻��� ��� = {"korea","korea","worldcup","world","WorldCUp","WorldCup","movie","sunday","KOREA"}
//
//# �̷��� ã���� ���ڿ� ��Ͽ��� ��� �󵵰� ���� ���� �ܾ �˻��Ѵ�.
//# ��ҹ��ڴ� �������� �ʰ� �󵵰� ���� ���� �ܾ�� �빮�ڷ� ����Ѵ�.
//  ���� ��� �󵵰� ���� �ܾ ������ �����ϴٸ� �� �߿��� ���� ū �ܾ�(���ĺ� �� �ڿ� �ִ� �ܾ�)�� �����Ѵ�. 
//# KOREA - 3
//# WORLDCPU - 3
//# MOVIE - 1
//  SUNDAY - 1
//# �ǽð� �˻��� ���� 1�� : WORLDCUP


/*
	6) ��Ÿ����
           .          -  ���ڸ� ã��
          \s      -  ���� ���� ã��
          \S      -  ���� ���ڰ� �ƴѰ� ã��  [^\\s]
          \S+     -  ���� ���� ���ڰ� �ƴ� �� ã��
          \d      -  ��� ���� ã��
                          String test = "12345A".replaceAll("\\d", "");  // A
                          String test = "12345A".replaceAll("[0-9]", ""); // A
          \D      - ���ڰ� �ƴѰ� ã��
                          String test = "12345A".replaceAll("\\d", "");  // 12345
                          String test = "12345A".replaceAll("[^0-9]", ""); // 12345
          \w      - ��� ���� �� ���� ã�� 
                          String test = "12345A".replaceAll(\\w, "");  // 
                          String test = "12345A".replaceAll("[a-zA-Z_0-9]", ""); // 
          \w      - ��� ���� �� ����  �ܿ� ����  ã�� 
                          String test = "12345A$".replaceAll(\\W, "");  // $ 
                          String test = "12345A".replaceAll("[^a-zA-Z_0-9]", ""); // $ 
          \b       - ù����  ex) \\b(\\w) : ��� �ܾ��� ù ����
 */

public class SearchWord2_me1 {

	public static void main(String[] args) {
		String []sample = loadData();
		
		List<String> validWord = findValidWord(sample);
		System.out.println(validWord);
		
		String searchWord = searchWord(validWord);
		System.out.println(searchWord);
	}
	
	public static String[] loadData() {
		//�׽�Ʈ ���� 1
		//String[] sample = { "korea", "1korea", "worldcup", "worl2d", "WorldCUp", "WorldCup", "movie", "sunday3",
		//"KOREA" };
		
		//�׽�Ʈ ���� 2
		String[] sample = { "Enter2prise","developer", "solu7tion","Develop6", "Enterprise", "develop","developer2", "develoPment","enterprise2", "developer3","Development", "solution", "Enter1Prise3", "developer5", "application", "Solution",
		"solu7tion8" };
		return sample;
	}
	
	
	/*
	 * ����ȭ�� ����� replaceAll ��� replaceAll("[0-9] "")  ---> ���� ���ڷ� �ٲپ� ������ 
	 */
	
	public static List<String> findValidWord(String []sample){
		List<String> validList = null;
//		-------------------------------------------
		
		validList = new ArrayList<String>();

		/*
		for (int i=0; i<sample.length; i++) {
			validList.add(sample[i].replaceAll("[0-9]", "")) ;
		}
		*/
		
		for (int i=0; i<sample.length; i++) {
			
			String temp = "";
			for (int k=0; k<sample[i].length(); k++) {
				
				char a = sample[i].charAt(k);
				//System.out.println(a);
				
				
				if(sample[i].charAt(k) < '0' || sample[i].charAt(k) > '9') {
					//temp += Character.toString(a);
					temp += a;
					
				}
				else {
					//temp += "";
					//System.out.println(temp);
				}
				
				
			}
			validList.add(temp);
			
		}	
		

//		--------------------------------------------
		return validList;
	}
	
	/*
	 * TreeMap�� �ٷγ����� �ߺ����ŵǰ� ���ĵȴ�
	 */
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------

		Map<String, Integer> map = new TreeMap<String, Integer>();

		for(String str : validList) {
			
			str = str.toUpperCase(); // �빮�ڷ� ��ȯ
			
			if (map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			} else {
				map.put(str, 1);
			}
		}

		Iterator<String> iteratorKey = map.keySet().iterator();
		
		int max = 0;
		while(iteratorKey.hasNext()) {
			if (max <= map.get(iteratorKey.next())) {
				String str = iteratorKey.next();
				max = map.get(str);
				searchWord = str;
			}
		}
		
//		--------------------------------------------		
		return searchWord;
	}

}
