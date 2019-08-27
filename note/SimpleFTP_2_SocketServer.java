import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFTP_SocketServer {

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket listener = null;

		while(true)
		{
			listener = new ServerSocket(9876);

			System.out.println("서버가 연결요청을 기다립니다.");
			Socket socket = listener.accept();
			System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
	        
			int readSize;
			int bufSize = 256;
			byte[] byteBuf = new byte[bufSize];
			
			try {
				// 
				String tmp[] = dis.readUTF().split("#");

				String fileName = tmp[0];
				int fileSize = Integer.parseInt(tmp[1]);
				
				OutputStream outputStream = new FileOutputStream("./RECV/" + fileName);
				
				int len = fileSize;
				while (len > 0) {	
					readSize = dis.read(byteBuf, 0, Math.min(bufSize, len));
					len -= readSize;
		        	outputStream.write(byteBuf, 0, readSize);
		        }

				outputStream.close();
				System.out.println("recv : " + tmp[0] + " " + tmp[1] + " bytes\n");

			} catch (Exception e) {
				// 클라이언트가 종료되었을 경우 while 상태에서 dis.readUTF() 시 EOF 발생 시 처리 
				if (socket != null) socket.close(); 
			} finally {
				listener.close();
	        } 		
		}
        
    }
}