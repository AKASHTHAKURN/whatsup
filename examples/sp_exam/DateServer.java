import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

	public static void main(String[] args) throws IOException {
    
		ServerSocket listener = new ServerSocket(9090);
        
		// 날짜 보낸 후 socket.close 하고 다시 listen 하고 있음
		try {

			while (true) {
				
				System.out.println("wating client...");
                
				Socket socket = listener.accept();
				
				System.out.println("client accepted");

				try {
                	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  // autoflush	
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}