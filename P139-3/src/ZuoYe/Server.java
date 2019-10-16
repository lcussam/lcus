package ZuoYe;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
public class Server
{
	public static HashMap<String, PrintWriter> users= new HashMap<String,PrintWriter>();
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(888);
		while(true){
			System.out.println("运行成功");
			Socket socket = server.accept();
			Socket handler = new Socket(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}
