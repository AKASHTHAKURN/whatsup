package socket.text;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Text �ۼ���
 */
public class SocketServer_Text {

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket listener = null;

		listener = new ServerSocket(9876);

		System.out.println("������ �����û�� ��ٸ��ϴ�.");
		Socket socket = listener.accept();
		System.out.println(socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
		
//==============================================================================
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("./RECV/sample.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line + "/r/n");
		}
		br.close();
		bw.close();
//==============================================================================
		
		System.out.println("server end");
    }
}