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
		
		System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
				
		Socket socket = serverSocket.accept();

		System.out.println(getTime()+ socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// BufferedWriter, PrintWriter �� �� ����
		//BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		
		for (int i=0; i<10; i++) {
			
			char[] rcvBuf = new char[20];

			int readSize = input.read(rcvBuf);
			String answer = String.valueOf(rcvBuf, 0, readSize); // data, offset, count
			System.out.println("[" + answer + "]" + "size=" + readSize);		// [ABCDFILE.TXT     ] -> ������ �ִ�
			System.out.println("RECV : " + answer);
			
			String send = "ZABFHCJC";
			output.write(send);
			/*
			 * �ݵ�� fulsh ����� ������
			 */
			output.flush();
			System.out.println("SEND : " + send);
		}
		
		input.close();
		output.close();
		socket.close();
		
		System.out.println("done");
	}
	
	// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
