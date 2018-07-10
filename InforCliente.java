import java.net.Socket;



public class InforCliente {
	public Socket mSocket = null;
	public Cliente mCliente = null;
	public String mNombre = null;
	
	public String getmNombre() {
		return mNombre;
	}
	public void setmNombre(String mNombre) {
		this.mNombre = mNombre;
	}
}
