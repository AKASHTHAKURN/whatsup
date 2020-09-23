package socket.binary;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Binary 송수신
// read :  DataInputStream, 
// write : FileOutputStream

public class SocketServer_Binary {

	static int BUF_SIZE = 128;

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket listener = new ServerSocket(9876);

		System.out.println("서버가 연결요청을 기다립니다.");

		Socket socket = listener.accept();

		System.out.println(socket);
		System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

		DataInputStream dis = new DataInputStream(socket.getInputStream());
		FileOutputStream fos = new FileOutputStream("./RECV/" + "sample.txt");

		int readLen = 0;
		byte[] buffer = new byte[BUF_SIZE];

		while ((readLen = dis.read(buffer)) != -1) {
			fos.write(buffer, 0, readLen);
		}

		dis.close();
		fos.close();

		System.out.println("server end");
	}
}
