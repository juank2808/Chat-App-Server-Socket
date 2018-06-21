import java.util.ArrayList;



public class ServerAdmin extends Thread{
	
	ArrayList<InforCliente> listaClis =new ArrayList<InforCliente>();
	
	public synchronized void addCliente(InforCliente mCliente) {
		listaClis.add(mCliente);
	}
	public synchronized String getClientes() throws InterruptedException {
		String clientes = null;
		while(listaClis.size()==0)
		wait();
		clientes = listaClis.get(0).toString();
		
		return clientes;
		
	}
	
	public void run(){
		
	}

}
