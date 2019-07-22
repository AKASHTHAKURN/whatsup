package ssp.file;

import java.io.*;
import java.util.Scanner;

/*
 *	File file = new File("xxx");
 *	File(".");						// 현재위치 상대경로
 *	File("./ABCDWR.TXT");			// 현재위치의 파일
 *	File("./big/ABCDWR.TXT");		// 현재 위치에서 big 폴더내의 파일
 *  File("../test.txt")				// 상위폴더의 test.txt  	
 * 	File("D:\\");					// 절대경로
 *  File("/test.txt")				// 실행시키는 곳의 제일 상위, D 일때 D:\test.txt  	
 *  
 *  - file read and write (text and binary file)
 *  - file delete
 *  - file rename
 *  - dir(ls)
 *  - file search (하위디렉토리 포함)
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
	
	/*
	 * File Delete
	 */
	static void fileDelete(String fileName) {

		//File file = new File("./BIGFILE/ABCDFILE.TXT");
		//File file = new File("./BIGFILE/" + inputFile);
		
		File file = new File(fileName);
		
		if( file.exists() == true ){
            if( file.delete() == true ){
            	System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
	}

	/*
	 * dir
	 */
	static void fileDirList(String path) throws IOException {
		
		File dir = new File(path); 
		
		//System.out.println(dir.getPath());			// 상대경로
		//System.out.println(dir.getAbsolutePath());	// full path
		//System.out.println();
		
		// 설정한 디렉토리 내의 파일과 디렉토리를 리스트에 저장
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");				// [src]
				//System.out.println("[" + file.getCanonicalFile()+ "]"); 	// [D:\eclipse\workspace-java\TCT_SP_Exam\src]
			
				/*
				 * 이게 있으면 재귀호출로 모든 디렉토리 파일 표시한다
				 */
				fileDirList(file.getPath());
			} 
			else {
				System.out.println(file.getName());				// test.txt
				//System.out.println(file.getAbsolutePath()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\.\test.txt -> 이상하게 나오는데 ....잘라내는 방법은
				//System.out.println(file.getCanonicalFile()); 	// D:\eclipse\workspace-java\TCT_SP_Exam\test.txt -> 정상적으로 표시 이걸써라
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
		
		// 설정한 디렉토리 내의 파일과 디렉토리를 리스트에 저장
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(file.isDirectory()) 
			{
				System.out.println(file.getPath());
				//System.out.println("[" + file.getName() + "]");
				result = fileSearch(filename, file.getPath());
				
				/* 여기 해줘야 된다 */
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
	  * boolean append 를 true로 설정
	  */
	 public static void whenAppendToFileUsingFileWriter_thenCorrect() throws IOException {
	  
	    FileWriter fw = new FileWriter("./a.txt", true); 					// boolean append
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write("Spain");
	    bw.newLine();
	    bw.close();
	    
	    FileOutputStream fos = new FileOutputStream("./b.txt", true);		// boolean append
	    fos.write("Spain\r\n".getBytes()); // String을 byte 배열로 저장
	    fos.close();
	}
	
	 /*
	  * File seek
	  * RandomAccessFile 사용
	  */
	public static void fileSeekExample() throws IOException {
		
		// 읽어들일 사이즈
		int seekSize = 5;
 
		// 읽기 전용으로 파일을 읽음.
		RandomAccessFile rdma = new RandomAccessFile("./test.txt","r");
		String line = "";
 
		// 전체 문자열을 출력
		while ((line = rdma.readLine()) != null) {
			System.out.println(line);			
		}
 
		// 문자열 총 길이
		System.out.println("total length : " + rdma.length()+"\n");
 
		byte[] data = null;
 
		// 루프 사이즈 = 총길이/seekSize + (총길이%seekSize의 나머지가 0이면 0을 반환 0이아니면 1을 반환)
		long size = rdma.length()/seekSize+(rdma.length()%seekSize == 0 ? 0:1);
		
		for (int i = 0; i < size; i++) {
			data = new byte[seekSize];
 
			// seekSize 만큼 증가시키고 read
			rdma.seek(i*seekSize);
			rdma.read(data);
 
			// 바이트 데이터를 문자열로 변환(trim()을 사용해 공백을 제거) 
			System.out.printf("pointer : %02d  str : %s \n" , rdma.getFilePointer(), new String(data).trim());
		}	
 
		// 파일 닫기
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
		
		System.out.print("저장할 파일 이름을 입력하세요: ");
		textFileName = scanner.nextLine();
		System.out.print("저장할 텍스트 내용을 입력하세요: ");
		contentToBeSaved = scanner.nextLine();
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(textFileName, true));	// boolean append
		
		//bufferedWriter.write(contentToBeSaved + " ");
		bufferedWriter.write(contentToBeSaved);
		
		bufferedWriter.close();
		
		System.out.println("저장이 완료되었습니다.");
	}

}
