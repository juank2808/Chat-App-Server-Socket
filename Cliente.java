import java.io.BufferedReader;
import java.io.PrintWriter;

public class Cliente  extends Thread{
	private ServerAdmin exServerAdmin;
	private InforCliente mInforCli;
	private PrintWriter mOut;
	private BufferedReader mIn;

	public Cliente(InforCliente inforCli, ServerAdmin mSeverAdmin) {
		this.mInforCli=inforCli;
		this.exServerAdmin=mSeverAdmin;
		
		System.out.println("Cliente Conectado...");
	}
	public void run(){
		
	}
}
