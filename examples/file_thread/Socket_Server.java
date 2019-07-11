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
		
		System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
				
		Socket socket = serverSocket.accept();

		System.out.println(getTime()+ socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
		
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
			
			System.out.println("[" + answer + "]" + "size=" + readSize);		// [ABCDFILE.TXT     ] -> ������ �ִ�
			
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
		 * ���ۿ��� size ��ŭ�� �̾Ƴ��� �Ѵ�
		 */
		
		//String answer = String.copyValueOf(buf);
		//String answer = String.copyValueOf(buf, 0, size); // data, offset, count
		/*
		 * returns char array to string
		 */
		String answer = String.valueOf(buf, 0, size); // data, offset, count

		/*
		 * readLine() �� ����ϸ� �ȵȴ�
		 * String answer = input.readLine();
		 */
		
		System.out.println("[" + answer + "]" + "size=" + size);		// [ABCDFILE.TXT     ] -> ������ �ִ�
		
		
		//
		// ��Ǽ�, ���� size ��ŭ�� ó���ؾ� �Ѵ�
		// ���� ������ ���ۿ� �ִ� ������
		//
		
		//answer = answer.trim();						// trim ���� ������ ���� (��, �� ������ ������ �ش�)

		return answer;
	}
	
	// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
