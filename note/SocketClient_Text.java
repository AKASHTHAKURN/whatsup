package socket.text;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Text file 송수신
public class SocketServer_Text {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ServerSocket listener = new ServerSocket(9876);;

	System.out.println("서버가 연결요청을 기다립니다.");

		Socket socket = listener.accept();
	
	System.out.println(socket);
	System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
		
		// 소켓으로 부터 스트림을 읽어서 파일에 쓰기	
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("./RECV/sample.txt"));
		
		String line;
		while((line = br.readLine()) != null) 
		{
			bw.write(line + "\r\n");
		}
		br.close();
		bw.close();
		
	System.out.println("server end");
    }
}
