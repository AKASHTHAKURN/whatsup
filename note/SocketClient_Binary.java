package socket.binary;

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

// Binary 송수신
// read  : FileInputStream
// write : DataOutputStream

public class SocketClient_Binary {
	static String serverIp = "127.0.0.1";
	static int portNo = 9876;
	static int BUF_SIZE = 128;

	public static void main(String[] args)
			throws IOException, NoSuchAlgorithmException, ParseException, InterruptedException {
		sendFile("./SEND/sample.txt");
	}

	public static void sendFile(String fileName) throws IOException, IOException {

		Socket socket = new Socket(serverIp, 9876);

		System.out.println(socket);

		FileInputStream fis = new FileInputStream(fileName);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		int readLen = 0;
		byte[] buffer = new byte[BUF_SIZE];

		while ((readLen = fis.read(buffer)) != -1) {
			dos.write(buffer, 0, readLen);
		}

		fis.close();
		dos.close();

		System.out.println("client end");
	}
}
