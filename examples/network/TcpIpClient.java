package network;

import java.net.*;
import java.io.*;

public class TcpIpClient {
	public static void main(String args[]) {
		try {
			String serverIp = "127.0.0.1";

			System.out.println("������ �������Դϴ�. ����IP :" + serverIp);
			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777); 

			// ������ �Է½�Ʈ���� ��´�.
			//InputStream in = socket.getInputStream();
			//DataInputStream dis = new DataInputStream(in);

			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			int count = 0;
			
			while (true) {
				// �������� ���� ���� �����͸� ����Ѵ�.
				//System.out.println((count++) + "�����κ��� ���� �޽��� :"+dis.readUTF());      
				//System.out.println("������ �����մϴ�.");
				//Thread.sleep(100);

				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println("�����͸� �����߽��ϴ�.");
				Thread.sleep(1000);
				
				
			}

			// ��Ʈ���� ������ �ݴ´�.
			//dis.close();
			//socket.close();
			//System.out.println("������ ����Ǿ����ϴ�.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} // main
} // class
