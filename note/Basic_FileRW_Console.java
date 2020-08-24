package tct_summary;

import java.io.*;
import java.util.*;

public class Basic_FileRW_Console {

	// 콘솔 입력 받기
	static void consoleInput() 
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) 
		{
			String str = sc.nextLine();
		}
		sc.close();
	}
	
	// Text file read write
	static void copyTextFile(String inputFile, String outputFile) throws IOException  
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
		
		String line;
		while((line = bufferedReader.readLine()) != null) 
		{ 
			String[] tmp = line.split("#");
			
			//줄바꿈 할때 CR->LF 순으로 "\r\n" 추가해준다, 메모장에서 행 바꾸면 위와같이 입력됨 0x0A 0x0D
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

// 클래스 템플릿
class SampleClass {
	
	private String name;
	
	SampleClass(String name) {
		
		this.name = name;
	}

	// alt+shift+s -> Generate getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
// end of file
