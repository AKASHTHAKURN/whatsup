package algorithm.a06.password2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 문제 유형이 큐를 써야 되는거다
 * 큐를 쓰면 편하게 할 수 있다 (링크드리스트)
 * 
 * 최적화 하려면 루프를 줄일수 있는 방법 적용
 * - 함수호출 횟수
 * - 루프를 도는 횟수
 * 
 * => 성능이슈
 * 
 */


/*
 * 배열을 직접 조작해서 풀이 -> 번거롭다
 * 
 */

public class A06_Password2_me2 {
	
	public static void main(String[] args) throws FileNotFoundException
	{

		/*
		System.setIn(new FileInputStream("data/password2_input.txt"));		
		Scanner scanner = new Scanner(System.in);

		String T = scanner.nextLine();
		
		System.out.println(T);
		
		for (int t=0; t<Integer.parseInt(T); t++) {

			String line = scanner.nextLine();
			System.out.println(line);
			
			String[] word = line.split(" ");
			//for(String s : word)
			//	System.out.println(s);
			
			
			
		}
		*/
		String in = "10 6 12 8 9 4 1 3";
		//String in = "9550 9556 9550 9553 9558 9551 9551 9551";
		
		String[] temp = in.split(" ");
		
		int [] word = new int[temp.length];
		int [] result = new int[temp.length];
		
		for (int i=0; i<temp.length; i++)
			word[i] = Integer.parseInt(temp[i]);
		
		
		boolean loop = true;

		int count = 1;
		
		while(loop == true) {
			loop = false;
			for (int i=0; i<word.length; i++) {
				
				// 마지막 인덱스이면 0번째에서 count 뺀값을 넣는다
				if (i == word.length-1) {
					System.out.println("\n" + count + " " + word[0]);

					result[word.length-1] = word[0] - count;
					
					if (result[word.length-1] <= 0) {
						result[word.length-1] = 0;
						loop = false;
						break;
					}

					loop = true;
					
					count++;
					if (count > 5)
						count = 1;
				}
				// 다음 인덱스 값을 복사
				else {
					result[i] = word[i+1];
				}
				
			}
			for(Integer s : result)
				System.out.print(s + " " );
			System.out.println();
			
			System.arraycopy(result, 0, word, 0, word.length);
			for(Integer s : word)
				System.out.print(s + " ");
		}
		
	}
}
