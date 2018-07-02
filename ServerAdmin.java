import java.util.ArrayList;



public class ServerAdmin extends Thread{
	
	ArrayList<InforCliente> listaClis =new ArrayList<InforCliente>();
	private ArrayList<String> listMsjs = new ArrayList<String>();
	
	public synchronized void addCliente(InforCliente mCliente) {
		System.out.println("cliente"+ mCliente.mCliente.getName());
		listaClis.add(mCliente);
		System.out.println("Cliente añadido...");
	}
	public synchronized String getClientes() throws InterruptedException {
		String clientes = null;
		while(listaClis.size()==0)
		wait();
		clientes = listaClis.get(0).toString();
		return clientes;
		
	}
	private synchronized String getSiguienteMensaje() throws InterruptedException {
		while (listMsjs.size()==0)
			wait();
			String mensaje = (String)listMsjs.get(0);
			listMsjs.remove(0);
			return mensaje;
		
	}
	
	public synchronized void addMensaje(String mensaje) {
		
		listMsjs.add(mensaje);
	}
	public void tratadoMensajes(String mensaje) {
		
		String [] tipoMensaje = mensaje.split(" ");
		System.out.println(tipoMensaje[0]);
		switch(tipoMensaje[0]) {
			case "NICK":
				System.out.println(tipoMensaje[1]);
				;break;
			case "MENSAJE":
				System.out.println(tipoMensaje[1]);
				;break;
		}
		
		
	}
	
	public void run(){
		
		while(true) {
			try {
				String mensajelst = getSiguienteMensaje();
				System.out.println("Estoy en el run Server Admin :"+mensajelst);
				getClientes();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
