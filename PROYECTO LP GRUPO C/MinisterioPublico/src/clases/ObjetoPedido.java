package clases;

public class ObjetoPedido {
	
	private int idObjetoPedido;
	private String desObjetoPedido;
	
	
	public ObjetoPedido(int idObjetoPedido, String desObjetoPedido) {
		
		this.idObjetoPedido = idObjetoPedido;
		this.desObjetoPedido = desObjetoPedido;
	}


	public int getIdObjetoPedido() {
		return idObjetoPedido;
	}


	public void setIdObjetoPedido(int idObjetoPedido) {
		this.idObjetoPedido = idObjetoPedido;
	}


	public String getDesObjetoPedido() {
		return desObjetoPedido;
	}


	public void setDesObjetoPedido(String desObjetoPedido) {
		this.desObjetoPedido = desObjetoPedido;
	}
	
	
	
	
}
