package clases;

public class TipoPedido {

	private int idTipoPedido;
	private String desTipoPedido;
	
	
	public TipoPedido(int idTipoPedido, String desTipoPedido) {
		
		this.idTipoPedido = idTipoPedido;
		this.desTipoPedido = desTipoPedido;
	}


	public int getIdTipoPedido() {
		return idTipoPedido;
	}


	public void setIdTipoPedido(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}


	public String getDesTipoPedido() {
		return desTipoPedido;
	}


	public void setDesTipoPedido(String desTipoPedido) {
		this.desTipoPedido = desTipoPedido;
	}
	
	
	
	
	
	
}
