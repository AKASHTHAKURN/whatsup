package ssp.datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import collections.sort.Grade;

/*
 * value 에 class를 넣고 그 중 한 요소로 순/역정렬
 */

public class HashMap_5_SortValue_Class {
	public static void main(String[] args) throws IOException {
	   
		Map<Integer,ScoreMap> map = new HashMap<Integer,ScoreMap>();

		String inputFile = "DS_Sample1.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		int num = 1;
		String line;
		while((line = bufferedReader.readLine()) != null) { 
			String[] arr = line.split(" ");		
			map.put( num++, new ScoreMap(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]))) ;
		
		} 
		bufferedReader.close();

		for ( Integer key : map.keySet() ) { 
			System.out.println( key + " : " + map.get( key ) ); 
		}
	    
	    	System.out.println("---------sort 후------------");

	    	List<Map.Entry<Integer, ScoreMap>> list = new ArrayList<Map.Entry<Integer, ScoreMap>>(map.entrySet());
		
	    	// 문자열 정렬
		Collections.sort( list, (g1, g2) -> g1.getValue().getName().compareTo( g2.getValue().getName() ) );
		// 숫자 정렬
		Collections.sort( list, (g1, g2) -> g2.getValue().getKor() -  g1.getValue().getKor() );
		
		for(Entry<Integer, ScoreMap> n : list) {
			System.out.printf("%d %6s %3d %3d %3d\n", 
					n.getKey(),
					n.getValue().getName(),
					n.getValue().getKor(), 
					n.getValue().getMat(), 
					n.getValue().getEng()  );
		}
		System.out.println();
	}

}

class ScoreMap {
	String name;
	int kor;
	int mat;
	int eng;
	
	ScoreMap(String name, int kor, int mat, int eng) {
		
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		
	}

	int getKor() {
		return this.kor;
	}
	int getMat() {
		return this.mat;
	}
	int getEng() {
		return this.eng;
	}
	String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", mat=" + mat + ", eng=" + eng + "]";
	}
}
