package fileio;

import java.io.*;

/*
 * 
 *  	INPUT ���� ���� ���� ��ϰ� ũ�⸦ ����Ͻÿ�.
 *  	ũ�Ⱑ 2Kbyte�� �Ѵ� ���ϵ��� ��� OUTPUT ������ �����Ͻÿ�. OUTPUT ������ �������� ���� ��� �����Ͻÿ�.
 *   	��, ���� ���� �� ���̳ʸ� ������ ���ۿ� �а� ���� ������� �����ϰ�, ������ ũ��� 512Byte�� �����Ͻÿ�
 *   
 */

public class FileIOEx03_DirList_FileCopy {

	final static int SIZE_LIMIT = 2048;
	
	public static void main(String[] args) {

		File dir = new File("./input");
		File [] flist = dir.listFiles();
		
		File outFolder = new File("./output");
		if (!outFolder.exists()) {
			outFolder.mkdirs();
		}
		
		System.out.println("dir input ====");
		dispList(flist);
		
		flist = outFolder.listFiles();
		System.out.println("dir output ====");
		dispList(flist);

	}

	public static void dispList(File[] flist) {
		for (File file : flist ) 
		{
		
			if (file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");
			} 
			else 
			{
				System.out.println(file.getName() + "  :  " + file.length() + "bytes");
				if (file.length() >= SIZE_LIMIT) { FileCopy(file); }
			}
	
		}

	}
	
	public static void FileCopy(File file) {
		final int BUF_SIZE = 512;
		int readLen;
		byte[] buffer = new byte[BUF_SIZE];
		
		try {
			FileInputStream fis = new FileInputStream("./input/" + file.getName());
			FileOutputStream fos = new FileOutputStream("./output/" + file.getName());
			
			/*
			 *  ������ ���� ���� ���� ���� ���̰��� �������� ������ ���� !!! <ERROR>
			 *  �̷��� �ϸ� �ȵ�
			 */
			
			/*
			while((readLen = fis.read(buffer)) != -1 ) {
				System.out.println("readLen = " + readLen);
				fos.write(buffer);
			}
			 */

			// readLen ��ŭ write �ϵ��� ����
			while((readLen = fis.read(buffer)) != -1 ) {
				System.out.println("readLen = " + readLen);
				fos.write(buffer, 0, readLen);
			}

			fis.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
}
