import java.util.ArrayList;



public class ServerAdmin extends Thread{
	InforCliente infcli;
	ArrayList<InforCliente> listaClis =new ArrayList<InforCliente>();
	
	public synchronized void addCliente(InforCliente mCliente) {
		//System.out.println("cliente: "+ mCliente.getmNombre());
		listaClis.add(mCliente);
		System.out.println("Cliente añadido...");
	}
	public synchronized String getClientes() throws InterruptedException {
		String clientes = null;
		while(listaClis.size()==0)
		wait();
		clientes = listaClis.get(0).mNombre;
		return clientes;
		
	}
	public void tratadoMensajes(String mensaje) {
		
		String [] tipoMensaje = mensaje.split(" ");
		switch(tipoMensaje[0]) {
			case "NICK":
				System.out.println(tipoMensaje[1]);
				infcli = new InforCliente();
				infcli.setmNombre(tipoMensaje[1]);
				addCliente(infcli);
				Cliente.addMensaje("LOGIN: "+"Bienvenido! ");
				;break;
			case "MENSAJE":
				System.out.println(tipoMensaje[1]);
				;break;
		}
		
		
	}
	
	public void run(){
		
		while(true) {
			try {
				System.out.println("Server Admin OK");
				getClientes();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
