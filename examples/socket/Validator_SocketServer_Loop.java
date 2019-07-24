package ssp.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라언트가 요청하면 끊어야 한다
 */

public class Validator_SocketServer_Loop {
    public static void main(String[] args) throws IOException, InterruptedException {

    	//char[] test = {'a', 'b','c'};
    	//System.out.println(String.valueOf(test, 0, 3));
    	
    	while (true) {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(9876);
				System.out.println("서버가 준비되었습니다.");
			} catch(IOException e) {
				e.printStackTrace();
			}
	
			System.out.println("연결요청을 기다립니다.");
			
			Socket socket = serverSocket.accept();
			
			System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
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
					String rcv = dis.readUTF();		// while 일 경우 EOF 발생, 클라이언트에서는 접속이 끊기거임
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
					// EOF 발생
					System.out.println(e);
					if (socket != null) { 
						socket.close(); 
						break;
					}
				}
			}
	        
			dis.close();
			
			// accept -> close 해줘야 다시 accept 할수 있다
			serverSocket.close(); 
			
			socket.close();
			
			System.out.println("done");
    	}	
    }
}