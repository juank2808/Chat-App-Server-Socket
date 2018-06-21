import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente  extends Thread{
	private ServerAdmin exServerAdmin;
	private InforCliente mInforCli;
	private PrintWriter mOut;
	private BufferedReader mIn;

	public Cliente(InforCliente inforCli, ServerAdmin mSeverAdmin) {
		this.mInforCli=inforCli;
		this.exServerAdmin=mSeverAdmin;
		Socket socket=inforCli.mSocket;
		
		System.out.println("Cliente Conectado...");
	}
	public void run(){
		
	}
}
