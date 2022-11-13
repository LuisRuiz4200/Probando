package clases;

public class Participante {
	private String codPedido;
	private String codParticipante;
	private String entidad;
	private int ruc;
	private String correo;
	private int telefono;
	private String estado;
	
	
	
	public Participante(String codPedido, String codParticipante, String entidad, int ruc, String correo, int telefono,
			String estado) {
		
		this.codPedido = codPedido;
		this.codParticipante = codParticipante;
		this.entidad = entidad;
		this.ruc = ruc;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
	}






	public String getCodPedido() {
		return codPedido;
	}



	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}



	public String getCodParticipante() {
		return codParticipante;
	}



	public void setCodParticipante(String codParticipante) {
		this.codParticipante = codParticipante;
	}



	public String getEntidad() {
		return entidad;
	}



	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}



	public int getRuc() {
		return ruc;
	}



	public void setRuc(int ruc) {
		this.ruc = ruc;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
