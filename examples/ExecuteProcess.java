package ssp.basic;

import java.io.*;

public class ExecuteProcess {

	// ProcessBuilder 사용

	/* 외부 프로그램 실행결과를 출력할 경우 */
	public static void Cmd() throws IOException {
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
	
	/* 외부 프로그램에서 입력을 받을 경우 */
	public static void sendSignage(ArrayList<String> list) {
		
		Process process = null;
		String[] cmd = new String[] {"SIGNAGE"};

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

	static String codeConv(String msg) throws IOException {

		String[] cmd = new String[] {"CODECONV.EXE", msg};

		Process process = new ProcessBuilder(cmd).start();

		BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );

		//String str;
		//while( (str = stdOut.readLine()) != null ) {
		//    System.out.println(str);
		//}
	
		return stdOut.readLine();
	}
}
