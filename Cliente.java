import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente  extends Thread{
	private ServerAdmin exServerAdmin;
	private InforCliente mInforCli;
	private static BufferedReader mIn;
	private static BufferedWriter out;
	
	public Cliente(InforCliente inforCli, ServerAdmin mSeverAdmin) throws IOException {
		this.mInforCli=inforCli;
		this.exServerAdmin=mSeverAdmin;
		Socket socket=inforCli.mSocket;
		
		mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.println("Cliente Conectado...");
	}
	public void run(){
		
		String mMensaje;
		try {
			while((mMensaje=mIn.readLine())!=null) {
				
				//System.out.println(mMensaje);
				exServerAdmin.tratadoMensajes(mMensaje);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
