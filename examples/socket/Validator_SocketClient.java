package ssp.socket;

import java.io.*;
import java.net.Socket;
import java.util.*;
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

public class Validator_SocketClient
{
	private static Scanner scanner;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException, InterruptedException {    

		
		File file = new File("./INSP_007_20180110115200.TXT");
		System.out.println("file szie = " + file.length());
		
		
		String serverIp = "127.0.0.1";
		System.out.println("서버에 연결중입니다. 서버IP :" + serverIp);
		Socket socket = new Socket(serverIp, 9876); 


		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		for(int i=0; i<10; i++)
		{	
			String fileInfo = file.getName() + "#" + String.valueOf(file.length());
			//output.write(fileInfo.getBytes());  // string to byte array
			dos.writeUTF(fileInfo);
			System.out.println("SEND: " + fileInfo);
	
			InputStream inputStream = new FileInputStream(file);
	        byte[] buffer = new byte[128];
	        int readLen = 0;
	        
	        while ((readLen = inputStream.read(buffer)) != -1) {
	        	dos.write(buffer, 0, readLen);
	        	//out.write(buffer, 0, readLen);
	        }
	
	        inputStream.close();
		}
		//output.close();
		dos.close();
		
		System.out.println("program end");
	}
	
	static void mkDir(String folderName) {
	//	File destFolder = new File("./OUTPUT");
		File destFolder = new File(folderName);
		
		if(!destFolder.exists()) {
			destFolder.mkdirs(); 
		}        	
	}
}