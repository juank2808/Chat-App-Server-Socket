import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	static ServerSocket serverSocket = null;
	public static final int PORT = 1995;
	
	
	public static void main(String[] args) {
		
		try {
			serverSocket = new ServerSocket(1995);
			System.out.println("Server Iniciado...");
			ServerAdmin serVer=new ServerAdmin();
			serVer.start();
		
			while(true) {
				
				Socket socket = serverSocket.accept();
				InforCliente infCli=new InforCliente();
				infCli.mSocket=socket;
					
				System.out.println("Aceptando Conexiones...");
				Cliente cli = new Cliente(infCli,serVer);
				
				infCli.mCliente=cli;
				cli.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
