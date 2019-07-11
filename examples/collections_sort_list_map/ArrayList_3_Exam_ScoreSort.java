package ssp.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*	
 * 	DS_Sample1.txt에는 학생들의 성적 데이터가 저장되어 있다.
 * 
 * 	Console화면에서 ‘PRINT’를 입력하면 이름 순(오름차순)으로 출력하시오.
 * 
 *  Console화면에서 ‘KOREAN’, ‘ENGLISH’, ‘MATH’를 입력하면 해당 과목 성적 순(내림차순)으로 출력해 보시오
 *  
 *  QUIT’을 입력하면 프로그램을 종료시킨다
 */

/*
	- 정수형 비교일 때는 빼기 연산으로 처리
	- String 비교는 compareTo 사용
*/

public class ArrayList_3_Exam_ScoreSort {

	public static void main(String[] args) throws IOException {

		// 파일에서 성적 읽어오기
		ArrayList<Score> al = new ArrayList<>();  // <Score> 없어도 된다		 

		String inputFile = "DS_Sample1.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		String line;
		while((line = bufferedReader.readLine()) != null) { 
			String[] arr = line.split(" ");		
			al.add( new Score(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3])) );
		} 
		bufferedReader.close();

		// 콘솔로 사용자 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();
			
			if (input.equals("QUIT") || input.equals("quit")) {
				break;
			}
			else if (input.equals("PRINT")) {
		        Collections.sort(al, new Comparator<Score>() {
		            @Override
		            public int compare(Score b1, Score b2) {
		            	return  b1.getName().compareTo(b2.getName());
		            }
		        });		
			}
			else if (input.equals("KOR")) {
		        Collections.sort(al, new Comparator<Score>() {
		            @Override
		            public int compare(Score b1, Score b2) {
		            	return  b2.getKor()-b1.getKor();
		            }
		        });		
			}
			else if (input.equals("MAT")) {
		        Collections.sort(al, new Comparator<Score>() {
		            @Override
		            public int compare(Score b1, Score b2) {
		            	return  b2.getMat()-b1.getMat();
		            }
		        });		
			}
			else if (input.equals("ENG")) {
		        Collections.sort(al, new Comparator<Score>() {
		            @Override
		            public int compare(Score b1, Score b2) {
		            	return  b2.getEng()-b1.getEng();
		            }
		        });		
			}
			else {
				continue;
			}

			Iterator<Score> itr = al.iterator(); 
    		while (itr.hasNext()) {
    			Score val = itr.next();
    			System.out.println(String.format("%-5s %3d %3d %3d",val.getName(), val.getKor(), val.getEng(), val.getMat()));
    		}        	
    		
			//for (Score score : al) { 
			//	System.out.println(score); 
			//} 
			//System.out.println(); 
		}

		br.close();
	}

}

// 성적 데이터를 담기 위한 클래스
class Score {
	String name;
	int kor;
	int mat;
	int eng;
	
	Score(String name, int kor, int mat, int eng) {
		
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
