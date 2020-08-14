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
	 * 콘솔 입력 받기
	 */
	static void consoleInput() {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
		}
		sc.close();

	}
	
	/*
	 * Text file read write
	 */
	static void copyTextFile(String inputFile, String outputFile) throws IOException  {
	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		String line;
		while((line = bufferedReader.readLine()) != null) { 
			System.out.println(line); 
			
			/*
			 * 줄바꿈 할때 CR->LF 순으로 "\r\n" 추가해준다
			 * 메모장에서 행 바꾸면 위와같이 입력됨 0x0A 0x0D
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

		// 설정한 버퍼사이즈 만큼 read
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
