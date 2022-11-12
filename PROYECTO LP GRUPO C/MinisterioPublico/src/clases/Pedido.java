package clases;

public class Pedido {
	
	private String codigo;
	private String entidad;
	private int tipo;
	private int objeto;
	private String descripcion;
	private String  fecha;
	private String estado;
	
	
	public Pedido(String codigo, String entidad, int tipo, int objeto, String descripcion, String fecha,
			String estado) {
		
		this.codigo = codigo;
		this.entidad = entidad;
		this.tipo = tipo;
		this.objeto = objeto;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getEntidad() {
		return entidad;
	}


	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getObjeto() {
		return objeto;
	}


	public void setObjeto(int objeto) {
		this.objeto = objeto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	
	

	
	
	
	
}
