package clases;

public class Apelacion {
	private String codPropuesta;
	private String codApelacion;
	private String fecha;
	private String descripcion;
	private String estado;
	
	
	public Apelacion() {
	}

	public Apelacion(String codPropuesta, String codApelacion, String fecha, String descripcion,
			String estado) {
		super();
		this.codPropuesta = codPropuesta;
		this.codApelacion = codApelacion;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;
	}




	

	public String getCodPropuesta() {
		return codPropuesta;
	}

	public void setCodPropuesta(String codPropuesta) {
		this.codPropuesta = codPropuesta;
	}

	public String getCodApelacion() {
		return codApelacion;
	}

	public void setCodApelacion(String codApelacion) {
		this.codApelacion = codApelacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
}
