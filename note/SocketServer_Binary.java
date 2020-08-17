package socket.binary;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Binary �ۼ���
 * DataInputStream, FileOutputStream
 * 
 */

public class SocketServer_Binary {

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket listener = null;

		listener = new ServerSocket(9876);

		System.out.println("������ �����û�� ��ٸ��ϴ�.");
		Socket socket = listener.accept();
		System.out.println(socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");

//==============================================================================
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		FileOutputStream fos = new FileOutputStream("./RECV/" + "sample.txt");
		
        int readLen = 0;
        byte[] buffer = new byte[128];

        while ((readLen = dis.read(buffer)) != -1) {
        	fos.write(buffer, 0, readLen);
        }

        dis.close();
		fos.close();
//==============================================================================
		
		System.out.println("server end");
    }
}