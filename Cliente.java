import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class Cliente  extends Thread{
	private ServerAdmin exServerAdmin;
	private InforCliente mInforCli;
	private PrintWriter mOut;
	private BufferedReader mIn;
	private static Vector listMsjs = new Vector();
	
	public Cliente(InforCliente inforCli, ServerAdmin mSeverAdmin) throws IOException {
		this.mInforCli=inforCli;
		this.exServerAdmin=mSeverAdmin;
		Socket socket=inforCli.mSocket;
		
		mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		mOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		System.out.println("Cliente Conectado...");
	}
	public synchronized static void addMensaje(String mensaje) {
		
		System.out.println(mensaje);
		//I need to know i can't send messages 
		listMsjs.add(mensaje);
		
	}
	public synchronized void getSiguienteMensaje() throws InterruptedException, IOException{
		String mensaje = null;
		while (listMsjs.size()==0)
			System.out.println("mi mensaje "+mensaje);
			wait();
			mensaje = (String)listMsjs.get(0);
			listMsjs.remove(0);
			mOut.println(mensaje);
			
			mOut.flush();
		
	}
	public void run(){
		
		String mMensaje;
		try {
			while((mMensaje=mIn.readLine())!=null) {
				System.out.println(mMensaje);
				exServerAdmin.tratadoMensajes(mMensaje);
				
				//System.out.println("mis clientes: "+exServerAdmin.getClientes().toString());
				getSiguienteMensaje();
			}
		}catch (IOException | InterruptedException e) {
        	System.out.println(e);
        }
		mInforCli.mCliente.interrupt();
	}
}
