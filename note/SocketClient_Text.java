package socket.text;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/*
	Socket 정리
	
	[read]
	InputStream in = socket.getInputStream();
		in.read(buffer, 0, BUF_SIZE);
	
	DataInputStream dis = new DataInputStream(socket.getInputStream());
		dis.readInt();
		dis.read(buffer, 0, BUF_SIZE);
		dis.readUTF();
	
	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		br.readLine();
	
	[write]
	// OutputStream -> write byte[] 만 가능 (기본형태)
	
	// DataOutputStream -> 다양한 형태로 write 가능
	
	// BufferedWriter -> String, char[] 
	
	// PrintWriter -> print문 사용가능, BufferedWriter 보다는 이걸 써라
	
	OutputStream out = socket.getOutputStream();
		out.write(b, off, len);
	
	DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(str);
		dos.write(b, off, len);
			
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(str + "\r\n");
	
	PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // autoflush
		pw.println(str);
*/

//
// Text file 송수신
//
public class SocketClient_Text 
{
	static String serverIp = "127.0.0.1";
	static int portNo = 9876;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException, InterruptedException {    

		sendFile("./SEND/sample.txt");
	}
	
	public static void sendFile(String fileName) throws IOException
	{
		Socket socket = new Socket(serverIp, 9876);
		
	System.out.println(socket);
	System.out.println("connected to server IP:"  + socket.getInetAddress() + " Port:" +socket.getPort());
		
		// 파일을 읽어서 소켓에 쓰기
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String line;
		while((line = br.readLine()) != null) 
		{ 
			bw.write(line + "\r\n");	
		} 
		br.close();
		bw.close();

	System.out.println("client end");
	}
}
