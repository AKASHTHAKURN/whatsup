package ssp.basic;

import java.io.*;

public class ExecuteProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	/*
	 * signage.exe 에 스트림을 
	 */
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
}
