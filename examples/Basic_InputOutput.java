package ssp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Basic_InputOutput {

	public static void main(String[] args) {
		

	}

	/*
	 * �ܼ� �Է� �ޱ�
	 */
	static void consoleInput() {

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
		}
		scanner.close();

	}
	
	/*
	 * Test file read write
	 */
	static void copyTextFile(String inputFile, String outputFile) throws IOException  {
	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		String line;
		while((line = bufferedReader.readLine()) != null) { 
			System.out.println(line); 
			
			/*
			 * �ٹٲ� �Ҷ� CR->LF ������ "\r\n" �߰����ش�
			 * �޸��忡�� �� �ٲٸ� ���Ͱ��� �Էµ� 0x0A 0x0D
			 */
			bufferedWriter.write(line + "\r\n");	
		} 

		bufferedReader.close();
		bufferedWriter.close();
	}

	/*
	 * Binary file read write
	 */
	static void copyBinaryFile(String inputFile, String outputFile) throws IOException  {
			
		InputStream inputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(outputFile);  // FileOutputStream(outputFile, true) -> append 

        // ������ ���ۻ����� ��ŭ read
		final int BUFFER_SIZE = 4096;
        byte[] buffer = new byte[BUFFER_SIZE];

		int readLen;
        while ((readLen = inputStream.read(buffer)) != -1) {
            
        	outputStream.write(buffer, 0, readLen);
            
            System.out.println("readLen = " + readLen);
        }
            
        inputStream.close();
        outputStream.close();
	}

}
