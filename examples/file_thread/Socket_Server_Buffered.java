package ssp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Socket_Server_Buffered {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		
		serverSocket = new ServerSocket(9876);
		
		System.out.println(getTime() + "서버가 준비되었습니다.");
				
		Socket socket = serverSocket.accept();

		System.out.println(getTime()+ socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// BufferedWriter, PrintWriter 둘 다 동작
		//BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		
		for (int i=0; i<10; i++) {
			
			char[] rcvBuf = new char[20];

			int readSize = input.read(rcvBuf);
			String answer = String.valueOf(rcvBuf, 0, readSize); // data, offset, count
			System.out.println("[" + answer + "]" + "size=" + readSize);		// [ABCDFILE.TXT     ] -> 공백이 있다
			System.out.println("RECV : " + answer);
			
			String send = "ZABFHCJC";
			output.write(send);
			/*
			 * 반드시 fulsh 해줘야 나간다
			 */
			output.flush();
			System.out.println("SEND : " + send);
		}
		
		input.close();
		output.close();
		socket.close();
		
		System.out.println("done");
	}
	
	// 현재시간을 문자열로 반환하는 함수
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
