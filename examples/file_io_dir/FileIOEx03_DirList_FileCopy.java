package fileio;

import java.io.*;

/*
 * 
 *  	INPUT 폴더 내의 파일 목록과 크기를 출력하시오.
 *  	크기가 2Kbyte가 넘는 파일들은 모두 OUTPUT 폴더로 복사하시오. OUTPUT 폴더가 존재하지 않을 경우 생성하시오.
 *   	단, 파일 복사 시 바이너리 파일을 버퍼에 읽고 쓰는 방식으로 구현하고, 버퍼의 크기는 512Byte로 설정하시오
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
			 *  마지막 파일 쓸때 버퍼 끝의 더미값이 쓰여지는 문제가 있음 !!! <ERROR>
			 *  이렇게 하면 안됨
			 */
			
			/*
			while((readLen = fis.read(buffer)) != -1 ) {
				System.out.println("readLen = " + readLen);
				fos.write(buffer);
			}
			 */

			// readLen 만큼 write 하도록 수정
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
