package collections.sc;

import java.io.*;
import java.util.*;


public class E01_Exam_List {

	public static void main(String[] args) throws IOException {

		
	/*
	 * - ������ �о �迭�� ����
	 * - �ַܼ� ���� �޴� �Է�
	 * - ��ɿ� ���� 	
	 */

		ArrayList<Score> al = new ArrayList<Score>();
		
		String line = null;
		String fileName = "./DS_Sample1.txt"; // ��������, �����
		
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while((line = bufferedReader.readLine()) != null) { 
			String[] arr = line.split(" ");
			Score score = new Score( arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]) );
			al.add(score);
		} 
		bufferedReader.close();	

		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	String strInput = br.readLine();
        	if (strInput.equals("PRINT"))
        	{

        	}
        	else if (strInput.equals("QUIT"))
        	{
        		break;	
        	}
        	else
        	{
        		continue;
        	}
        		
            Collections.sort(al);
    		Score sc;
    		for(int i=0; i<al.size(); i++) {
    			sc = (Score)al.get(i);
    			sc.display(sc);
    		}
    	
   
    	}

        	/*		
			Comparator<String> co = new Comparator<String>() {
				public int compare(String o1, String o2) { 
					return (o2.compareTo(o1)); 				// ��������
				} 
			}; 
			
			Collections.sort(al, co);
	         */
	}
}

class Score implements Comparable {

	String name;
	int kor;
	int eng;
	int mat;
	
	Score(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor =kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public void display(Score sc) {
		System.out.println(sc.name + " " + sc.kor + " " + sc.eng + " " + sc.mat);
	}

	@Override
	public int compareTo(Object o) {

		return (this.name).compareTo(((Score)o).name);	// �̸��� ����
		//return (this.kor - ((Score)o).kor) * -1;
	}
	
}
