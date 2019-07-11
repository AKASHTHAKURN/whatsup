package fileio;

/*
 * Text File Read & Print
 * - 상대경로로 특정폴더 읽고 쓰기
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOEx01_ReadPrint {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String line = null;
		String fileName = "./input/iread.txt"; // 현재폴더의 input 폴더
		
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while((line = bufferedReader.readLine()) != null) { 
			System.out.println(line); 
		} 
		
		bufferedReader.close();
		//fileReader.close();	// 없어도 되는가
	}

}
