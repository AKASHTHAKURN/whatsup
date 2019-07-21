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
	
}
