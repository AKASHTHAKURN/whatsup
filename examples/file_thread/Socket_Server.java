package ssp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Socket_Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		
		serverSocket = new ServerSocket(9876);
		
		System.out.println(getTime() + "서버가 준비되었습니다.");
				
		Socket socket = serverSocket.accept();

		System.out.println(getTime()+ socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//InputStream input = socket.getInputStream();
		
		
		//PrintWriter output = new PrintWriter(socket.getOutputStream());
		//BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		OutputStream output = socket.getOutputStream();

		int readSize;
		char[] rcvBuf = new char[20];
		//byte[] rcvBuf = new byte[20];
		
		for (int i=0; i<10; i++) {
			
			readSize = input.read(rcvBuf);
			
			//for (int k=0; k<readSize; k++)
			//	rcv[k] = (char)rcvBuf[k];
			
			String answer = String.valueOf(rcvBuf, 0, readSize); // data, offset, count
			//String answer = String.valueOf(rcvBuf); 
			//String answer = (String)rcvBuf.toString();
			
			System.out.println("[" + answer + "]" + "size=" + readSize);		// [ABCDFILE.TXT     ] -> 공백이 있다
			
			System.out.println("RECV : " + answer);
			
			String send = "ZABFHCJC";
			
			//output.write(send);
			//output.write(send.toCharArray(), 0,send.length());

			output.write("ZABFHCJC".getBytes());  // string to byte array
			

			System.out.println("SEND : " + "ZABFHCJC");
		}
		
		input.close();
		output.close();
		socket.close();
		
		System.out.println("done");
	}
	
	static String readSocket(BufferedReader input) throws IOException {
		
		char[] buf = new char[30];
		//byte[] buf = new byte[30];
		int size = input.read(buf);
		
		/*
		 * 버퍼에서 size 만큼만 뽑아내야 한다
		 */
		
		//String answer = String.copyValueOf(buf);
		//String answer = String.copyValueOf(buf, 0, size); // data, offset, count
		/*
		 * returns char array to string
		 */
		String answer = String.valueOf(buf, 0, size); // data, offset, count

		/*
		 * readLine() 을 사용하면 안된다
		 * String answer = input.readLine();
		 */
		
		System.out.println("[" + answer + "]" + "size=" + size);		// [ABCDFILE.TXT     ] -> 공백이 있다
		
		
		//
		// 대실수, 받은 size 만큼만 처리해야 한다
		// 위에 공백은 버퍼에 있는 공백임
		//
		
		//answer = answer.trim();						// trim 으로 공백을 제거 (앞, 뒤 공백을 제거해 준다)

		return answer;
	}
	
	// 현재시간을 문자열로 반환하는 함수
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
