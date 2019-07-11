package ssp.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
	[java]�ֿܼ� �Է��ϴ� ���
	
	1. Scanner�� �̿� -> �̰� ����� ��

	2. InputStreamReaderŬ������ �̿�

	// ���� or �ܼ� �Է��� Scanner ����� �� 
	// BufferedReader ����� String ���θ� �Է¹޾Ƽ� �������� ��ȯ ���
 */

public class File_01_Input_from_file_or_console {

	public static void main(String[] args) throws IOException {
 
		// �����Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if (input.equals("quit")) {
				break;
			}
		}	
		br.close();
		
		// �ܼ��Է�
		System.setIn(new FileInputStream("ABCDFILE.txt")); // ������ �ܼ� �Է�	
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

	static void scannerInputFromConsole()  {
		
		/*
		 * String, int, float ������ �Է� ���� �� �ִ�
		 */
		  
		Scanner scanner = new Scanner(System.in); // System.in - ǥ�� �Է���ġ
		System.out.print("�̸� �Է� : ");
	  
		// next �� ���� �������� ���ڸ� �޴´�, ������ ������ ���ο� ���ڿ��� �ν�
		// ���ڿ� �� ������ �ְų� ���� ��ü�� �޾Ƽ� split �� ��� �ݵ�� nextLine ���
		//String ir = scanner.next(); // ���ڿ� �� ������ ���� ��� ��� ����  
		String ir = scanner.nextLine();
		System.out.println(ir);
	  
		System.out.print("���� �Է� : ");
		int n = scanner.nextInt();
		System.out.println(n + 5);  // ���ڸ� �ޱ� ������ ������ ����
	  
		System.out.print("������ �Է� : ");
		double d = scanner.nextDouble();
		System.out.print("������ : " + d);
		
		scanner.close();
		
	}

	static void scannerInputFromFile() throws FileNotFoundException  {
		
		/*
		 * String, int, float ������ �Է� ���� �� �ִ�
		 */
		System.setIn(new FileInputStream("ABCDFILE.txt"));	
		
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		scanner.close();
	}	

	
	static void consoleInputStreamReader() throws IOException {
		
		// String ���θ� �Է°���

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
		 * ������ String ���� �Է� �޴´�, ���������� ��ȯ�ؾ� �Ѵ�
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸� �Է� : ");
		String irum = br.readLine();
		
		System.out.print("���� �Է� : ");
		String nai = br.readLine();
		
		System.out.println("�̸��� " + irum + ", ���̴� " + nai);

		br.close();
	}
	
}
