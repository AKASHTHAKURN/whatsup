package ssp.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * InputStream/OutputStream ����Ͽ� byte ������ read/write
 * byte �迭�� ó��
 * 
 */
public class Socket_Server_Byte {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;

		try {
			// ���������� �����Ͽ� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(9876);
			System.out.println("������ �غ�Ǿ����ϴ�.");
		} catch(IOException e) {
			e.printStackTrace();
		}

		// ��������
		System.out.println("�����û�� ��ٸ��ϴ�.");
		Socket socket = serverSocket.accept();
		System.out.println(socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
		
		System.out.println("getPort():"+socket.getPort());
        System.out.println("getLocalPort():" + socket.getLocalPort());
		
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		char[] charBuf = new char[20];
		byte[] byteBuf = new byte[20];
		
		for (int i=0; i<10; i++) {
			// read
			int readSize = input.read(byteBuf);

			// byte �迭�� char �迭�� ��ȯ (����ǥ�� ����)
			for (int k=0; k<readSize; k++)
				charBuf[k] = (char)byteBuf[k];

			// char �迭�� String ���� ��ȯ
			String answer = String.valueOf(charBuf, 0, readSize); // data, offset, count
			System.out.println("RECV : " + "[" + answer + "]" + " " + readSize);		// [ABCDFILE.TXT     ] -> ������ �ִ�
			
			// ���ڸ� byte �迭�� ��ȯ�Ͽ� ����
			output.write("ZABFHCJC".getBytes());  // string to byte array
			System.out.println("SEND : " + "[ZABFHCJC]");
		}
		
		input.close();
		output.close();
		socket.close();
		
		System.out.println("done");
	}


}
