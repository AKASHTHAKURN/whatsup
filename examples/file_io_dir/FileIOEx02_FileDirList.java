package fileio;

import java.io.*;

/*
 * File Directory list 출력
 */

public class FileIOEx02_FileDirList {

	public static void main(String[] args) throws IOException {

		// 메서드가 static 이면 다음과 같이 쓴다
		FileController.fileDirList(".");	
		//FileController fc = new FileController();
		//fc.fileDirList("D://cygwin64");
		
		/*
		// 현재 디렉토리 설정
		File dir = new File("."); 
//		File dir = new File("D:\\");
		
		System.out.println(dir.getPath());			// 상대경로
		System.out.println(dir.getAbsolutePath());	// full path
		System.out.println();
		
		// 설정한 디렉토리 내의 파일과 디렉토리를 리스트에 저장
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			} 
			else {
				System.out.println(file.getName());				// test.txt
				System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> 이상하게 나오는데 ....잘라내는 방법은
				System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> 정상적으로 표시 이걸써라
				System.out.println(file.getPath());				// .\test.txt
			}
		}
		*/
	}
	
	
	
}

class FileController {

	static void fileDirList(String path) throws IOException {

		
		File dir = new File(path); 
		//File dir = new File(".");		// 현재 디렉토리 설정	 
		//File dir = new File("D:\\");
		
		System.out.println(dir.getPath());			// 상대경로
		System.out.println(dir.getAbsolutePath());	// full path
		System.out.println();
		
		// 설정한 디렉토리 내의 파일과 디렉토리를 리스트에 저장
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			} 
			else {
				System.out.println(file.getName());				// test.txt
				System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> 이상하게 나오는데 ....잘라내는 방법은
				System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> 정상적으로 표시 이걸써라
				System.out.println(file.getPath());				// .\test.txt
			}
		}
	}
	
}