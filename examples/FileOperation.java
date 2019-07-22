package ssp.file;

import java.io.*;
import java.util.Scanner;

/*
 *	File file = new File("xxx");
 *	File(".");						// ������ġ �����
 *	File("./ABCDWR.TXT");			// ������ġ�� ����
 *	File("./big/ABCDWR.TXT");		// ���� ��ġ���� big �������� ����
 *  File("../test.txt")				// ���������� test.txt  	
 * 	File("D:\\");					// ������
 *  File("/test.txt")				// �����Ű�� ���� ���� ����, D �϶� D:\test.txt  	
 *  
 *  - file read and write (text and binary file)
 *  - file delete
 *  - file rename
 *  - dir(ls)
 *  - file search (�������丮 ����)
 *  - mkdir
 *  - file append write
 *  - RandomAccessFile (seek)
 * 
 */

public class FileOperation {

	public static void main(String[] args) throws IOException {

		/*
		FileController.copyTextFile("read.txt", "read.copy.txt");	
		FileController.copyBinaryFile("./read.txt", "./read.bin");
		FileController.fileDirList(".");
		FileController.whenAppendToFileUsingFileWriter_thenCorrect();
		System.out.println( "result : " + FileController.fileSearch("iread.txt", ".") );
		 */
		//FileController.fileRename("abc","123");
		//FileController.testFilePrint(FileController.fileSearch("iread.txt", "."));
		//FileController.mkDir("./mkdir");

		//System.out.println( "result : " +  );

		//String path = FileController.fileSearch("iread.txt", ".");
		//System.out.println(path);
		//File file = new File(path);
		//System.out.println(file.getName() + " " + file.length() + "bytes");
		
		FileController.fileDirList("./input");
		
	}

}

class FileController {

	static void testFilePrint(String inputFile)  {

		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while((line = bufferedReader.readLine()) != null) { 
				System.out.println(line); 
			} 
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	/*
	 * File Delete
	 */
	static void fileDelete(String fileName) {

		//File file = new File("./BIGFILE/ABCDFILE.TXT");
		//File file = new File("./BIGFILE/" + inputFile);
		
		File file = new File(fileName);
		
		if( file.exists() == true ){
            if( file.delete() == true ){
            	System.out.println("���ϻ��� ����");
            }else{
                System.out.println("���ϻ��� ����");
            }
        }else{
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
	}

	/*
	 * dir
	 */
	static void fileDirList(String path) throws IOException {
		
		File dir = new File(path); 
		
		//System.out.println(dir.getPath());			// �����
		//System.out.println(dir.getAbsolutePath());	// full path
		//System.out.println();
		
		// ������ ���丮 ���� ���ϰ� ���丮�� ����Ʈ�� ����
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				//System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			
				/*
				 * �̰� ������ ���ȣ��� ��� ���丮 ���� ǥ���Ѵ�
				 */
				fileDirList(file.getPath());
			} 
			else {
				System.out.println(file.getName());				// test.txt
				//System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> �̻��ϰ� �����µ� ....�߶󳻴� �����
				//System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> ���������� ǥ�� �̰ɽ��
				//System.out.println(file.getPath());				// .\test.txt
			}
		}
	}

	/*
	 * search file
	 * return : file name(with path)
	 */
	static String fileSearch(String filename, String pathname) throws IOException {

		String result = "";
		
		File dir = new File(pathname);  
		
		// ������ ���丮 ���� ���ϰ� ���丮�� ����Ʈ�� ����
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) 
			{
				System.out.println(file.getPath());
				//System.out.println("[" + file.getName() + "]");
				result = fileSearch(filename, file.getPath());
				
				/* ���� ����� �ȴ� */
				if (result != "")
					return result;
			} 
			else 
			{
				//System.out.println(file.getName());
				if (filename.equals(file.getName())) {
					System.out.println("   FIND -> " + file.getPath());
					
					return file.getPath();
					// or
					//return file.getCanonicalFile().toString();
				}
			}
		}
		
		return "";
	}	

	/*
	 * File Rename
	 */
	static void fileRename(String src, String dest) {

		//File fileToMove = new File("./ABCDWR.TXT");
		//File file = new File("./ABCDFILE.TXT");

		File file = new File(src);
		File fileToMove = new File(dest);

		boolean isMoved = file.renameTo(fileToMove);
	
		System.out.println(isMoved);
		
	}
	
	/*
	 * Make Folder
	 */
	static void mkDir(String folderName) {
		// Create Folder
		//File destFolder = new File("./OUTPUT");

		File destFolder = new File(folderName);
		
		if(!destFolder.exists()) {
			destFolder.mkdirs(); 
		}        	
	}

	 /*
	  * File append
	  * boolean append �� true�� ����
	  */
	 public static void whenAppendToFileUsingFileWriter_thenCorrect() throws IOException {
	  
	    FileWriter fw = new FileWriter("./a.txt", true); 					// boolean append
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write("Spain");
	    bw.newLine();
	    bw.close();
	    
	    FileOutputStream fos = new FileOutputStream("./b.txt", true);		// boolean append
	    fos.write("Spain\r\n".getBytes()); // String�� byte �迭�� ����
	    fos.close();
	}
	
	 /*
	  * File seek
	  * RandomAccessFile ���
	  */
	public static void fileSeekExample() throws IOException {
		
		// �о���� ������
		int seekSize = 5;
 
		// �б� �������� ������ ����.
		RandomAccessFile rdma = new RandomAccessFile("./test.txt","r");
		String line = "";
 
		// ��ü ���ڿ��� ���
		while ((line = rdma.readLine()) != null) {
			System.out.println(line);			
		}
 
		// ���ڿ� �� ����
		System.out.println("total length : " + rdma.length()+"\n");
 
		byte[] data = null;
 
		// ���� ������ = �ѱ���/seekSize + (�ѱ���%seekSize�� �������� 0�̸� 0�� ��ȯ 0�̾ƴϸ� 1�� ��ȯ)
		long size = rdma.length()/seekSize+(rdma.length()%seekSize == 0 ? 0:1);
		
		for (int i = 0; i < size; i++) {
			data = new byte[seekSize];
 
			// seekSize ��ŭ ������Ű�� read
			rdma.seek(i*seekSize);
			rdma.read(data);
 
			// ����Ʈ �����͸� ���ڿ��� ��ȯ(trim()�� ����� ������ ����) 
			System.out.printf("pointer : %02d  str : %s \n" , rdma.getFilePointer(), new String(data).trim());
		}	
 
		// ���� �ݱ�
		rdma.close();		
	}
	 
	// ============================================================================================= // 
	 
	 /*
	  * File append example
	  */
	public static void fileAppend() throws IOException {

		String textFileName = null;
		String contentToBeSaved = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("������ ���� �̸��� �Է��ϼ���: ");
		textFileName = scanner.nextLine();
		System.out.print("������ �ؽ�Ʈ ������ �Է��ϼ���: ");
		contentToBeSaved = scanner.nextLine();
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(textFileName, true));	// boolean append
		
		//bufferedWriter.write(contentToBeSaved + " ");
		bufferedWriter.write(contentToBeSaved);
		
		bufferedWriter.close();
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

}
