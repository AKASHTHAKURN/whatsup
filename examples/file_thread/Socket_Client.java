package ssp.file;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

public class Socket_Client {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결중입니다. 서버IP :" + serverIp);
			Socket socket = new Socket(serverIp, 9876); 

			//BufferedReader mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           // PrintWriter mOut = new PrintWriter(socket.getOutputStream());
            
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
            
            //mOut.println("ABCDFILE.TXT");
            //mOut.flush();
			output.write("ABCDFILE.TXT".getBytes());  // string to byte array
            System.out.println("SEND: ABCDFILE.TXT");
            
            int count = 0;	// 0:ACK 1:ERR 2:retry
            int mode = 2;
            
            byte[] rcvBuf = new byte[30];
            char[] rcv = new char[30];
            
            
            
			while(true) {

				int size;
				
				try {
					size = input.read(rcvBuf);
				} catch (java.net.SocketException e) {
					//e.printStackTrace();
					break;
				}
				

			
				for(int i=0; i<size; i++)
					rcv[i] = (char)rcvBuf[i];
				
				System.out.println("RECV: " + String.valueOf(rcv));

				if (mode == 1 && count == 3) {
		            //mOut.println("ERR");
					output.write("ERR".getBytes());
		            System.out.println("SEND: ERR");

				} else if (mode == 2 && count == 7) {
		            //mOut.println("15");
					output.write("15".getBytes());
		            System.out.println("SEND: 15");
				} else {
					//mOut.println("ACK");
					output.write("ACK".getBytes());
					System.out.println("SEND: ACK");
				}
				//mOut.flush();
				
	            count++;
	            Thread.sleep(200);
			}

			input.close();
			output.close();
			socket.close();
			
			System.out.println("done");

	} // main

}
