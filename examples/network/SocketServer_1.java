package network;

import java.io.*;
import java.net.*;

public class SocketServer_1 {

	public static void main(String[] args) throws IOException {

		System.out.println("Start");

		ServerSocket listner = new ServerSocket(9090);;
		
		
		try {
			Socket socket = listner.accept();
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("test");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			listner.close();
			System.out.println("Done");
		}
	}

}
