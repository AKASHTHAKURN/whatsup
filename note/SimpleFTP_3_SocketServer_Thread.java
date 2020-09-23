package socket.simple_ftp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 스레드 종료 안되는 문제 있음

public class SimpleFTP_SocketServer_Thread {

	public final static boolean run = true;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		ThreadFTP r = new ThreadFTP();
		Thread thread = new Thread(r);

		thread.start();

		while (true) {

			String cmd = sc.nextLine();

			if (cmd.equals("quit")) {

				// r.shutdown();
				thread.interrupt();
				break;

			}

		}

		System.out.println("wait to join");

		thread.join();

		System.out.println("main end");

	}
}

class ThreadFTP implements Runnable {

	boolean shutdown = false;

	// flag 방식 사용할 경우 콘솔 입력 시 listen에서 블록되어 있는 문제
	public void shutdown() {
		shutdown = true;
	}

	@Override
	public void run() {

		ServerSocket listener = null;

		while (!Thread.currentThread().isInterrupted()) // !shutdown
		// while(!shutdown)
		{
			try {
				listener = new ServerSocket(9876);
				System.out.println("서버가 준비되었습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}

			Socket socket = null;
			try {
				System.out.println("연결요청을 기다립니다.");

				socket = listener.accept(); // 여기서 기다린다

				System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
				System.out.println("getPort():" + socket.getPort());
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

			// int i=0;

			try {
				String rcv = dis.readUTF(); // while 일 경우 EOF 발생, 클라이언트에서는 접속이 끊기거임
				System.out.println("received file info : " + rcv);

				String tmp[] = rcv.split("#");
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

				// i++;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					listener.close();
					System.out.println("finally listener.close() ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // while

		System.out.println("program done");
	}
}
