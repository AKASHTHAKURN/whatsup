package ssp.string_proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
	[java]콘솔에 입력하는 방법
	
	1. InputStreamReader클래스를 이용
	
	  InputStreamReader in = new InputStreamReader(System.in);
	  BufferedReader br = new BufferedReader(in);
	  System.out.print("이름 입력 : ");
	  String irum = br.readLine();
	  System.out.print("나이 입력 : ");
	  String nai = br.readLine();
	  System.out.println("이름은 " + irum + ", 나이는 " + nai);
	  br.close();
	  in.close();
	
	2. Scanner를 이용
	
	  Scanner scanner = new Scanner(System.in); // System.in - 표준 입력장치
	  System.out.print("이름 입력 : ");
	  //String ir = scanner.next();  // next 는 공백 전까지의 문자만 받는다, 공백을 만나면 새로운 문자열로 인식
	  String ir = scanner.nextLine();
	  System.out.println(ir);
	  System.out.print("이름 입력 : ");
	  int n = scanner.nextInt();
	  System.out.println(n + 5);  // 숫자를 받기 때문에 연산이 가능
	  System.out.print("몸무게 입력 : ");
	  double d = scanner.nextDouble();
	  System.out.print("몸무게 : " + d);

 */

public class ConsoleInput {

	public static void main(String[] args) throws IOException {

		//scannerInput();
    	Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        
    	//
    	// next 는 공백 전까지의 문자만 받는다, 공백을 만나면 새로운 문자열로 인식
        //
    	int n1 = scan.nextInt();	// 정수입력            
        String s1 = scan.next();    // 문자열 입력
        String s2 = scan.nextLine();    // 한줄 모두 입력 (n1, s1 까지 같이 받는다, 줄이 안바뀌었으므로)
        
        System.out.println(n1 + " " + s1);
        System.out.println(s2);
		

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		while (true) {
			System.out.print("iunput command : ");
			String input = br.readLine();
			System.out.println("received from console : " + input);
			
			// Don't use like this -> input == "quit" (X) 
			if (input.equals("quit")) {
				break;
			}
		}

		br.close();
		in.close();
	}
	
	static void consoleInput() throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		  BufferedReader br = new BufferedReader(in);
		  System.out.print("이름 입력 : ");
		  String irum = br.readLine();
		  System.out.print("나이 입력 : ");
		  String nai = br.readLine();
		  System.out.println("이름은 " + irum + ", 나이는 " + nai);
		  br.close();
		  in.close();
	}
	
	static void scannerInput()  {
		
		  
		Scanner scanner = new Scanner(System.in); // System.in - 표준 입력장치
		System.out.print("이름 입력 : ");
	  
		//String ir = scanner.next();  // next 는 공백 전까지의 문자만 받는다, 공백을 만나면 새로운 문자열로 인식
		String ir = scanner.nextLine();
		System.out.println(ir);
	  
		System.out.print("나이 입력 : ");
		int n = scanner.nextInt();
		System.out.println(n + 5);  // 숫자를 받기 때문에 연산이 가능
	  
		System.out.print("몸무게 입력 : ");
		double d = scanner.nextDouble();
		System.out.print("몸무게 : " + d);
		
	}

}
