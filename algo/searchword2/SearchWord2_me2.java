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

public class SearchWord2_me2 {

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

		for (int i=0; i<sample.length; i++) {
			validList.add(sample[i].replaceAll("[0-9]", "")) ;
		}

		//String test = "1aavSDvbn2*34&5%0A".replaceAll("[a-zA-Z_0-9]", ""); // 
		//System.out.println(test);
		
		/*
		// �迭���� ���� ����
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
	 * - �ʿ��� Ű, ���(ī��Ʈ) �ִ´� -> containsKey ���, �빮�ڷ� �ٲپ �Է��Ѵ�
	 * 	 HashMap ��� -> List ���� Map �� �ξ� ����
	 * 
	 * ���1. keySet�� ArrayList �� �ְ� collections.sort �� ������ �������鼭 maxcount ã�´� (�ڿ��� ã�´�)
	 * 
	 * ���2. keySet�� TreeMap�� �ִ´�, Iterator ����Ѵ�
	 * 
	 * 
	 */
	public static String searchWord(List<String> validList) {
		String searchWord = null;
//		-------------------------------------------

		// �ʿ� ���ڿ��� ī��Ʈ�� �Է�
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String str : validList) {
			
			str = str.toUpperCase(); // �빮�ڷ� ��ȯ
			
			// containsKey�� Ȯ���ؼ� ���� ������ 1, ������ ���������� +1 ���ش�
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
		//Collections.reverse(list); // reverse ���ָ� ������ �ȴ�
		
		int mx = 0;
		for (String s : list) {
			
			if (map.get(s) >= mx) {
				searchWord = s;
				mx = map.get(s);
			}
		}
		*/

		/*		
		Map�迭�� TreeMap�� ��� key�� �̿��� ������ ���� �մϴ�.
		HashMap->TreeMap���� ġȯ ��
		
		Iterator<String> iteratorKey = treeMap.keySet().iterator(); ->��������
		Iterator<String> iteratorKey = treeMap.descendingKeySet().iterator(); ->��������
		 */
 
		
		// 2. Ʈ���ʿ� �ְ� ���ĺ� ����, �������� �̹Ƿ� ���� �ִ� ���� ����ؾ� �Ѵ�
		// �������� ������ ���

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
		// �������� ����
		for(String str : tmap.keySet()) {		
		
		// �������� ����
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
