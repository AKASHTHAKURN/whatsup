package socket.text;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;


/*

	Socket ����
	
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
	// OutputStream -> write byte[] �� ���� (�⺻����)
	
	// DataOutputStream -> �پ��� ���·� write ����
	
	// BufferedWriter -> String, char[] 
	
	// PrintWriter -> print�� ��밡��, BufferedWriter ���ٴ� �̰� ���
	
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

/*
 * Text �ۼ���
 */

public class SocketClient_Text 
{
	static String serverIp = "127.0.0.1";
	static int portNo = 9876;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException, InterruptedException {    

		sendFile("./SEND/sample.txt");
	}
	
	public static void sendFile(String fileName) throws IOException, IOException {

		Socket socket = new Socket(serverIp, 9876); 
		System.out.println("������ �������Դϴ�. ����IP :" + serverIp);

//==============================================================================
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String line;
		while((line = br.readLine()) != null) { 
			bw.write(line + "\r\n");	
		} 

		br.close();
		bw.close();
//==============================================================================

		System.out.println("client end");
	}
}