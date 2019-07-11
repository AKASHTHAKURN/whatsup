package ssp.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * InputStream/OutputStream 사용하여 byte 단위로 read/write
 * byte 배열로 처리
 * 
 */
public class Socket_Server_Byte {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;

		try {
			// 서버소켓을 생성하여 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(9876);
			System.out.println("서버가 준비되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}

		// 서버소켓
		System.out.println("연결요청을 기다립니다.");
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
		
		System.out.println("getPort():"+socket.getPort());
        System.out.println("getLocalPort():" + socket.getLocalPort());
		
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		char[] charBuf = new char[20];
		byte[] byteBuf = new byte[20];
		
		for (int i=0; i<10; i++) {
			// read
			int readSize = input.read(byteBuf);

			// byte 배열을 char 배열로 변환 (문자표시 위해)
			for (int k=0; k<readSize; k++)
				charBuf[k] = (char)byteBuf[k];

			// char 배열을 String 으로 변환
			String answer = String.valueOf(charBuf, 0, readSize); // data, offset, count
			System.out.println("RECV : " + "[" + answer + "]" + " " + readSize);		// [ABCDFILE.TXT     ] -> 공백이 있다
			
			// 문자를 byte 배열로 변환하여 전송
			output.write("ZABFHCJC".getBytes());  // string to byte array
			System.out.println("SEND : " + "[ZABFHCJC]");
		}
		
		input.close();
		output.close();
		socket.close();
		
		System.out.println("done");
	}


}
