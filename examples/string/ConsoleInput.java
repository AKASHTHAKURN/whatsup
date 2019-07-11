package ssp.string_proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
	[java]�ֿܼ� �Է��ϴ� ���
	
	1. InputStreamReaderŬ������ �̿�
	
	  InputStreamReader in = new InputStreamReader(System.in);
	  BufferedReader br = new BufferedReader(in);
	  System.out.print("�̸� �Է� : ");
	  String irum = br.readLine();
	  System.out.print("���� �Է� : ");
	  String nai = br.readLine();
	  System.out.println("�̸��� " + irum + ", ���̴� " + nai);
	  br.close();
	  in.close();
	
	2. Scanner�� �̿�
	
	  Scanner scanner = new Scanner(System.in); // System.in - ǥ�� �Է���ġ
	  System.out.print("�̸� �Է� : ");
	  //String ir = scanner.next();  // next �� ���� �������� ���ڸ� �޴´�, ������ ������ ���ο� ���ڿ��� �ν�
	  String ir = scanner.nextLine();
	  System.out.println(ir);
	  System.out.print("�̸� �Է� : ");
	  int n = scanner.nextInt();
	  System.out.println(n + 5);  // ���ڸ� �ޱ� ������ ������ ����
	  System.out.print("������ �Է� : ");
	  double d = scanner.nextDouble();
	  System.out.print("������ : " + d);

 */

public class ConsoleInput {

	public static void main(String[] args) throws IOException {

		//scannerInput();
    	Scanner scan = new Scanner(System.in);      // ���� �Է��� ���ڷ� Scanner ����
        
    	//
    	// next �� ���� �������� ���ڸ� �޴´�, ������ ������ ���ο� ���ڿ��� �ν�
        //
    	int n1 = scan.nextInt();	// �����Է�            
        String s1 = scan.next();    // ���ڿ� �Է�
        String s2 = scan.nextLine();    // ���� ��� �Է� (n1, s1 ���� ���� �޴´�, ���� �ȹٲ�����Ƿ�)
        
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
		  System.out.print("�̸� �Է� : ");
		  String irum = br.readLine();
		  System.out.print("���� �Է� : ");
		  String nai = br.readLine();
		  System.out.println("�̸��� " + irum + ", ���̴� " + nai);
		  br.close();
		  in.close();
	}
	
	static void scannerInput()  {
		
		  
		Scanner scanner = new Scanner(System.in); // System.in - ǥ�� �Է���ġ
		System.out.print("�̸� �Է� : ");
	  
		//String ir = scanner.next();  // next �� ���� �������� ���ڸ� �޴´�, ������ ������ ���ο� ���ڿ��� �ν�
		String ir = scanner.nextLine();
		System.out.println(ir);
	  
		System.out.print("���� �Է� : ");
		int n = scanner.nextInt();
		System.out.println(n + 5);  // ���ڸ� �ޱ� ������ ������ ����
	  
		System.out.print("������ �Է� : ");
		double d = scanner.nextDouble();
		System.out.print("������ : " + d);
		
	}

}
