package clases;

public class ActaPropuesta {
	
	private String idActaPropuesta;
	private String idPropuesta;
	private String fecha;
	private String desActaPropuesta;
	private String tipoActa;
	private String estadoActa;
	
	// Constructor vacio 
	public ActaPropuesta() {
	}
	
	// Constructor
	public ActaPropuesta(String idActaPropuesta, String idPropuesta, String fecha, String desActaPropuesta, String tipoActa,
			String estadoActa) {
		super();
		this.idActaPropuesta = idActaPropuesta;
		this.idPropuesta = idPropuesta;
		this.fecha = fecha;
		this.desActaPropuesta = desActaPropuesta;
		this.tipoActa = tipoActa;
		this.estadoActa = estadoActa;
	}
	
	// Set/Get
	public String getIdActaPropuesta() {
		return idActaPropuesta;
	}
	public void setIdActaPropuesta(String idActaPropuesta) {
		this.idActaPropuesta = idActaPropuesta;
	}
	public String getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(String idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDesActaPropuesta() {
		return desActaPropuesta;
	}
	public void setDesActaPropuesta(String desActaPropuesta) {
		this.desActaPropuesta = desActaPropuesta;
	}
	public String getTipoActa() {
		return tipoActa;
	}
	public void setTipoActa(String tipoActa) {
		this.tipoActa = tipoActa;
	}
	public String getEstadoActa() {
		return estadoActa;
	}
	public void setEstadoActa(String estadoActa) {
		this.estadoActa = estadoActa;
	}
	
}
