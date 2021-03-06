package tct_summary;

/* 외부 프로그램 실행 및 스트림 입출력 방법 */

import java.io.*;
import java.util.ArrayList;

public class ProcessBuilder_Exam {

	public static void main(String[] args) throws IOException {
		
		cmdDir();
		
		codeConv("dsgsahdgalfhlafjf");
		
		ArrayList<String> list = new ArrayList<>();
		list.add("11:00:06#STA01#NOBUS,00:00:00");
		list.add("11:00:06#STA02#NOBUS,00:00:00");
		list.add("11:00:06#STA03#NOBUS,00:00:00");
		
		sendSignage(list);

		System.out.println("program done");
	}

	/*
	 * 외부 프로그램을 실행시키고 스트림을 받는다
	 */
	// msg 값을 주고 실행하면 코드값을 읽어온다
	static String codeConv(String msg) throws IOException {

		String[] cmd = new String[] {"./data/CODECONV.EXE", msg};

		Process process = new ProcessBuilder(cmd).start();

		BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );

		String str;
		while( (str = stdOut.readLine()) != null ) {
		    System.out.println(str);
		}
	
		return stdOut.readLine();
	}

	/* 
	 * 외부 프로그램을 실행시키고 외부 프로그램에 스트림을 출력 (BufferedWriter)
	 */
	// 스트링 리스트를 보내면 OUTFILE 폴더에 SINAGE.TXT 파일이 생성된다
	public static void sendSignage(ArrayList<String> list) {
		
		Process process = null;
		String[] cmd = new String[] {"./data/SIGNAGE"};

		try {
			process = new ProcessBuilder(cmd).start();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()) ); // signage.exe 에 스트림출력 하는 설정
			
			for(int i=0; i<list.size(); i++) {
				bufferedWriter.write(list.get(i) + "\r\n");	
			}
			
			bufferedWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}	

	
	/* 
	 * dir 을 실행시키고 결과를 스트림으로 읽어온다 (BufferedReader)
	 */
	public static void cmdDir() throws IOException {
		
		String[] cmd = new String[] {"cmd", "/c", "dir"}; // "cmd" 뒷부분에 "/c"를 넣어주면 dir에 대한 수행 결과를 보여준다.
		Process process = null;
		String str = null;

		try {
			process = new ProcessBuilder(cmd).start();
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
