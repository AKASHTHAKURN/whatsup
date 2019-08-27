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

public class SimpleFTP_SocketClient
{
	static String serverIp = "127.0.0.1";
	static int portNo = 9876;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException, InterruptedException {    

		sendAllFilesInFolder("./SEND");
		
	}
	
	static void sendAllFilesInFolder(String folderPath) throws IOException {
		
		File dir = new File(folderPath); 
		File[] flist = dir.listFiles();
		
		for(File file : flist) {
			if(!file.isDirectory()) {
				sendFile(file.getPath());
			}
		}
	}
	
	public static void sendFile(String fileName) throws IOException, IOException {

		File file = new File(fileName);

		Socket socket = new Socket(serverIp, 9876); 
		System.out.println("������ �������Դϴ�. ����IP :" + serverIp);

		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		String fileInfo = file.getName() + "#" + String.valueOf(file.length());
		dos.writeUTF(fileInfo);
		System.out.println("send : " + fileInfo);

		InputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[128];
        int readLen = 0;
        
        while ((readLen = inputStream.read(buffer)) != -1) {
        	dos.write(buffer, 0, readLen);
        }

        inputStream.close();
		dos.close();

		System.out.println();
	}
}