package com.lgcns.algorithm.searchword2;

import java.util.*;

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


/*
	6) 메타문자
           .          -  문자를 찾음
          \s      -  공백 문자 찾기
          \S      -  공백 문자가 아닌것 찾기  [^\\s]
          \S+     -  여러 공백 문자가 아닌 것 찾기
          \d      -  모든 숫자 찾기
                          String test = "12345A".replaceAll("\\d", "");  // A
                          String test = "12345A".replaceAll("[0-9]", ""); // A
          \D      - 숫자가 아닌것 찾기
                          String test = "12345A".replaceAll("\\d", "");  // 12345
                          String test = "12345A".replaceAll("[^0-9]", ""); // 12345
          \w      - 모든 문자 와 숫자 찾기 
                          String test = "12345A".replaceAll(\\w, "");  // 
                          String test = "12345A".replaceAll("[a-zA-Z_0-9]", ""); // 
          \w      - 모든 문자 와 숫자  외에 것을  찾기 
                          String test = "12345A$".replaceAll(\\W, "");  // $ 
                          String test = "12345A".replaceAll("[^a-zA-Z_0-9]", ""); // $ 
          \b       - 첫글자  ex) \\b(\\w) : 모든 단어의 첫 글자
 */

public class SearchWord2_me2 {

	public static void main(String[] args) {
		String []sample = loadData();
		
		List<String> validWord = findValidWord(sample);
		System.out.println(validWord);
		
		String searchWord = searchWord(validWord);
		System.out.println(searchWord);
	}
	
	public static String[] loadData() {
		//테스트 샘플 1
		//String[] sample = { "korea", "1korea", "worldcup", "worl2d", "WorldCUp", "WorldCup", "movie", "sunday3",
		//"KOREA" };
		
		//테스트 샘플 2
		String[] sample = { "Enter2prise","developer", "solu7tion","Develop6", "Enterprise", "develop","developer2", "develoPment","enterprise2", "developer3","Development", "solution", "Enter1Prise3", "developer5", "application", "Solution",
		"solu7tion8" };
		return sample;
	}
	
	
	/*
	 * 정규화를 사용한 replaceAll 사용 replaceAll("[0-9] "")  ---> 없는 문자로 바꾸어 버린다 
	 */
	
	public static List<String> findValidWord(String []sample){
		List<String> validList = null;
//		-------------------------------------------
		validList = new ArrayList<String>();

		for (int i=0; i<sample.length; i++) {
			validList.add(sample[i].replaceAll("[0-9]", "")) ;
		}

		//String test = "1aavSDvbn2*34&5%0A".replaceAll("[a-zA-Z_0-9]", ""); // 
		//System.out.println(test);
		
		/*
		// 배열에서 직접 제거
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
		*/
//		--------------------------------------------
		return validList;
	}
	
	/*
	 * 
	 * - 맵에다 키, 밸류(카운트) 넣는다 -> containsKey 사용, 대문자로 바꾸어서 입력한다
	 * 	 HashMap 사용 -> List 보다 Map 이 훨씬 좋다
	 * 
	 * 방법1. keySet을 ArrayList 에 넣고 collections.sort 로 정렬후 루프돌면서 maxcount 찾는다 (뒤에서 찾는다)
	 * 
	 * 방법2. keySet을 TreeMap에 넣는다, Iterator 사용한다
	 * 
	 * 
	 */
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------

		// 맵에 문자열과 카운트를 입력
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String str : validList) {
			
			str = str.toUpperCase(); // 대문자로 변환
			
			// containsKey로 확인해서 값이 없으면 1, 있으면 기존값에다 +1 해준다
			if (map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			} else {
				map.put(str, 1);
			}
		}

		// 1. ArrayList -> collections.sort
		/*
		List<String> list = new ArrayList<String>(map.keySet());

		Collections.sort(list);
		//Collections.reverse(list); // reverse 해주면 역정렬 된다
		
		int mx = 0;
		for (String s : list) {
			
			if (map.get(s) >= mx) {
				searchWord = s;
				mx = map.get(s);
			}
		}
		*/

		/*		
		Map계열중 TreeMap의 경우 key를 이용한 정렬이 가능 합니다.
		HashMap->TreeMap으로 치환 후
		
		Iterator<String> iteratorKey = treeMap.keySet().iterator(); ->오름차순
		Iterator<String> iteratorKey = treeMap.descendingKeySet().iterator(); ->내림차순
		 */
 
		
		// 2. 트리맵에 넣고 알파벳 정렬, 오름차순 이므로 끝에 있는 값을 사용해야 한다
		// 내림차순 정렬은 어떻게

		Map<String, Integer> tmap = new TreeMap<String, Integer>(map);
		int max = 0;
		
		Iterator<String> iteratorKey = tmap.keySet().iterator();
		//Iterator<String> iteratorKey = ((TreeMap<String, Integer>) tmap).descendingKeySet().iterator(); 
		
		while(iteratorKey.hasNext()) {
			if (max <= tmap.get(iteratorKey.next())) {
				String str = iteratorKey.next();
				max = tmap.get(str);
				searchWord = str;
			}
		}
		
		
/*
		// 오름차순 정렬
		for(String str : tmap.keySet()) {		
		
		// 내림차순 정렬
		//for(String str : ((TreeMap<String, Integer>) tmap).descendingKeySet()) {		

			System.out.print(str + "=" + tmap.get(str) + " ");
			
			if (max <= tmap.get(str)) {
				max = tmap.get(str);
				searchWord = str.toUpperCase();
			}
			
		}
		System.out.println();
*/
		
		
//		--------------------------------------------		
		return searchWord;
	}

}
