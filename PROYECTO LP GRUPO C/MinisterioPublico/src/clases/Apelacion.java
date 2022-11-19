package clases;

public class Apelacion {
	//INCIALIZAMOS ENTRADAS 
	private String codApelacion;
	private String codPropuesta;
	private String fecha;
	private String descripcion;
	private String estado;
	
	//CONSTRUCTOR VACIO
	public Apelacion() {
	}
	//CONSTRUCTOR
	public Apelacion( String codApelacion, String codPropuesta, String fecha, String descripcion,
			String estado) {
		super();
		this.codApelacion = codApelacion;
		this.codPropuesta = codPropuesta;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	//SET/GET
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
