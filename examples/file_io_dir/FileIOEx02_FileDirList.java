package fileio;

import java.io.*;

/*
 * File Directory list ���
 */

public class FileIOEx02_FileDirList {

	public static void main(String[] args) throws IOException {

		// �޼��尡 static �̸� ������ ���� ����
		FileController.fileDirList(".");	
		//FileController fc = new FileController();
		//fc.fileDirList("D://cygwin64");
		
		/*
		// ���� ���丮 ����
		File dir = new File("."); 
//		File dir = new File("D:\\");
		
		System.out.println(dir.getPath());			// �����
		System.out.println(dir.getAbsolutePath());	// full path
		System.out.println();
		
		// ������ ���丮 ���� ���ϰ� ���丮�� ����Ʈ�� ����
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			} 
			else {
				System.out.println(file.getName());				// test.txt
				System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> �̻��ϰ� �����µ� ....�߶󳻴� �����
				System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> ���������� ǥ�� �̰ɽ��
				System.out.println(file.getPath());				// .\test.txt
			}
		}
		*/
	}
	
	
	
}

class FileController {

	static void fileDirList(String path) throws IOException {

		
		File dir = new File(path); 
		//File dir = new File(".");		// ���� ���丮 ����	 
		//File dir = new File("D:\\");
		
		System.out.println(dir.getPath());			// �����
		System.out.println(dir.getAbsolutePath());	// full path
		System.out.println();
		
		// ������ ���丮 ���� ���ϰ� ���丮�� ����Ʈ�� ����
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			} 
			else {
				System.out.println(file.getName());				// test.txt
				System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> �̻��ϰ� �����µ� ....�߶󳻴� �����
				System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> ���������� ǥ�� �̰ɽ��
				System.out.println(file.getPath());				// .\test.txt
			}
		}
	}
	
}