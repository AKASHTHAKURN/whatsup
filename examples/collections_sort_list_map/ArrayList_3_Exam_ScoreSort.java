package ssp.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*	
 * 	DS_Sample1.txt���� �л����� ���� �����Ͱ� ����Ǿ� �ִ�.
 * 
 * 	Consoleȭ�鿡�� ��PRINT���� �Է��ϸ� �̸� ��(��������)���� ����Ͻÿ�.
 * 
 *  Consoleȭ�鿡�� ��KOREAN��, ��ENGLISH��, ��MATH���� �Է��ϸ� �ش� ���� ���� ��(��������)���� ����� ���ÿ�
 *  
 *  QUIT���� �Է��ϸ� ���α׷��� �����Ų��
 */

/*
	- ������ ���� ���� ���� �������� ó��
	- String �񱳴� compareTo ���
*/

public class ArrayList_3_Exam_ScoreSort {

	public static void main(String[] args) throws IOException {

		// ���Ͽ��� ���� �о����
		ArrayList<Score> al = new ArrayList<>();  // <Score> ��� �ȴ�		 

		String inputFile = "DS_Sample1.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		String line;
		while((line = bufferedReader.readLine()) != null) { 
			String[] arr = line.split(" ");		
			al.add( new Score(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3])) );
		} 
		bufferedReader.close();

		// �ַܼ� ����� �Է¹ޱ�
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

// ���� �����͸� ��� ���� Ŭ����
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
