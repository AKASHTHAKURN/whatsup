package ssp.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Ŭ���Ʈ�� ��û�ϸ� ����� �Ѵ�
 */

public class Validator_SocketServer_Loop {
    public static void main(String[] args) throws IOException, InterruptedException {

    	//char[] test = {'a', 'b','c'};
    	//System.out.println(String.valueOf(test, 0, 3));
    	
    	while (true) {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(9876);
				System.out.println("������ �غ�Ǿ����ϴ�.");
			} catch(IOException e) {
				e.printStackTrace();
			}
	
			System.out.println("�����û�� ��ٸ��ϴ�.");
			
			Socket socket = serverSocket.accept();
			
			System.out.println(socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
			System.out.println("getPort():"+socket.getPort());
	        System.out.println("getLocalPort():" + socket.getLocalPort());
			
			//InputStream input = socket.getInputStream();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
	        
			int readSize;
			int bufSize = 256;
			byte[] byteBuf = new byte[bufSize];
			
			int i=0;
			//for(int i=0; i<10; i++)
			while(true)
			{
	
				try {
					String rcv = dis.readUTF();		// while �� ��� EOF �߻�, Ŭ���̾�Ʈ������ ������ �������
					System.out.println(rcv);
					
					String tmp[] = rcv.split("#");
					System.out.println(tmp[0] + " " + tmp[1]);
	
					String fileName = tmp[0];
					int fileSize = Integer.parseInt(tmp[1]);
					
					OutputStream outputStream = new FileOutputStream("./" + "recv_" + String.valueOf(i) + "_" + fileName);
					
					int len = fileSize;
					while (len > 0) {	
						
						readSize = dis.read(byteBuf, 0, Math.min(bufSize, len));
						//readSize = input.read(byteBuf, 0, Math.min(bufSize, len));
						
						len -= readSize;
						
			        	outputStream.write(byteBuf, 0, readSize);
			        }
			        outputStream.close();			
	
					i++;
	
				} catch (Exception e) {
					// EOF �߻�
					System.out.println(e);
					if (socket != null) { 
						socket.close(); 
						break;
					}
				}
			}
	        
			dis.close();
			
			// accept -> close ����� �ٽ� accept �Ҽ� �ִ�
			serverSocket.close(); 
			
			socket.close();
			
			System.out.println("done");
    	}	
    }
}