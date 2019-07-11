package fileio;

/*
 * Text File Read & Print
 * - ����η� Ư������ �а� ����
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOEx01_ReadPrint {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String line = null;
		String fileName = "./input/iread.txt"; // ���������� input ����
		
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while((line = bufferedReader.readLine()) != null) { 
			System.out.println(line); 
		} 
		
		bufferedReader.close();
		//fileReader.close();	// ��� �Ǵ°�
	}

}
