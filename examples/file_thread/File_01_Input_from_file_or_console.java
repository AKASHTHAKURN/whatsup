package ssp.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
	[java]콘솔에 입력하는 방법
	
	1. Scanner를 이용 -> 이거 사용할 것

	2. InputStreamReader클래스를 이용

	// 파일 or 콘솔 입력은 Scanner 사용할 것 
	// BufferedReader 방식은 String 으로만 입력받아서 정수형은 변환 사용
 */

public class File_01_Input_from_file_or_console {

	public static void main(String[] args) throws IOException {
 
		// 파일입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if (input.equals("quit")) {
				break;
			}
		}	
		br.close();
		
		// 콘솔입력
		System.setIn(new FileInputStream("ABCDFILE.txt")); // 없으면 콘솔 입력	
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

	static void scannerInputFromConsole()  {
		
		/*
		 * String, int, float 등으로 입력 받을 수 있다
		 */
		  
		Scanner scanner = new Scanner(System.in); // System.in - 표준 입력장치
		System.out.print("이름 입력 : ");
	  
		// next 는 공백 전까지의 문자만 받는다, 공백을 만나면 새로운 문자열로 인식
		// 문자열 중 공백이 있거나 라인 전체를 받아서 split 할 경우 반드시 nextLine 사용
		//String ir = scanner.next(); // 문자열 중 공백이 없을 경우 사용 가능  
		String ir = scanner.nextLine();
		System.out.println(ir);
	  
		System.out.print("나이 입력 : ");
		int n = scanner.nextInt();
		System.out.println(n + 5);  // 숫자를 받기 때문에 연산이 가능
	  
		System.out.print("몸무게 입력 : ");
		double d = scanner.nextDouble();
		System.out.print("몸무게 : " + d);
		
		scanner.close();
		
	}

	static void scannerInputFromFile() throws FileNotFoundException  {
		
		/*
		 * String, int, float 등으로 입력 받을 수 있다
		 */
		System.setIn(new FileInputStream("ABCDFILE.txt"));	
		
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		scanner.close();
	}	

	
	static void consoleInputStreamReader() throws IOException {
		
		// String 으로만 입력가능

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();
			if (input.equals("quit")) {
				break;
			}
		}	
		
		br.close();
	}
	
	static void consoleInputStreamReader2() throws IOException {

		/*
		 * 무조건 String 으로 입력 받는다, 정수형으로 변환해야 한다
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 입력 : ");
		String irum = br.readLine();
		
		System.out.print("나이 입력 : ");
		String nai = br.readLine();
		
		System.out.println("이름은 " + irum + ", 나이는 " + nai);

		br.close();
	}
	
}
