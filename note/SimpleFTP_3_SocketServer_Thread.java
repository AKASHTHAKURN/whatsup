import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SimpleFTP_SocketServer_Thread {

	public final static boolean run = true;
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		ThreadFTP r = new ThreadFTP();
		Thread thread = new Thread(r);

		thread.start();

		while(true) {
			
			String cmd = sc.nextLine();
			
			if(cmd.equals("quit")) {
				
				//r.shutdown();
				thread.interrupt();
				break;
				
			}
			
		}
		
		thread.join();
		

    }
}

class ThreadFTP implements Runnable {

	boolean shutdown = false;

	// flag ��� ����� ��� �ܼ� �Է� �� listen���� ��ϵǾ� �ִ� ����
	public void shutdown() {
        shutdown = true;
    }

	@Override
	public void run() {

		ServerSocket listener = null;

		while(!Thread.currentThread().isInterrupted()) // !shutdown
		//while(!shutdown)
		{
			try {
				listener = new ServerSocket(9876);
				System.out.println("������ �غ�Ǿ����ϴ�.");
			} catch(IOException e) {
				e.printStackTrace();
			}

			Socket socket = null;
			try {
				System.out.println("�����û�� ��ٸ��ϴ�.");
				socket = listener.accept();
				System.out.println(socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				System.out.println("getPort():"+socket.getPort());
		        System.out.println("getLocalPort():" + socket.getLocalPort());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        
			int readSize;
			int bufSize = 256;
			byte[] byteBuf = new byte[bufSize];
			
			int i=0;

			try {
				String rcv = dis.readUTF();		// while �� ��� EOF �߻�, Ŭ���̾�Ʈ������ ������ �������
				System.out.println(rcv);
				
				String tmp[] = rcv.split("#");
				System.out.println(tmp[0] + " " + tmp[1]);

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
		        dis.close();
		        
				i++;

			} catch (Exception e) {
				e.printStackTrace();
			}
	        finally {
	            try {
					System.out.println("finally");
					listener.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        } 		
		}
        
		System.out.println("program done");
	}
}