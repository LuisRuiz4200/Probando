package clases;

public class Apelacion {
	
	private String codPedido;
	private String codPropuesta;
	private String codApelacion;
	private String fecha;
	private String descripcion;
	private String Motivo;
	
	public Apelacion(String codPedido, String codPropuesta, String codApelacion, String fecha, String descripcion,
			String motivo) {
		
		this.codPedido = codPedido;
		this.codPropuesta = codPropuesta;
		this.codApelacion = codApelacion;
		this.fecha = fecha;
		this.descripcion = descripcion;
		Motivo = motivo;
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
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

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	
	
}
