package clases;

public class EvaluacionPropuesta {
 
	
	private String idPropuesta;
	private String idEvapropuesta;
	private double puntTecnica;
	private double puntEconomica;
	private String fecha;
	private String estadoPropuesta;
	
	//Constructor Vacio
	public EvaluacionPropuesta() {
	
	}
	
	//Constructor 
	public EvaluacionPropuesta(String idPropuesta, String idEvapropuesta, double puntTecnica, double puntEconomica,
			String fecha, String estadoPropuesta) {
		super();
		this.idPropuesta = idPropuesta;
		this.idEvapropuesta = idEvapropuesta;
		this.puntTecnica = puntTecnica;
		this.puntEconomica = puntEconomica;
		this.fecha = fecha;
		this.estadoPropuesta = estadoPropuesta;
	}
	
	// Set/Get
	public String getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(String idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public String getIdEvapropuesta() {
		return idEvapropuesta;
	}
	public void setIdEvapropuesta(String idEvapropuesta) {
		this.idEvapropuesta = idEvapropuesta;
	}
	public double getPuntTecnica() {
		return puntTecnica;
	}
	public void setPuntTecnica(double puntTecnica) {
		this.puntTecnica = puntTecnica;
	}
	public double getPuntEconomica() {
		return puntEconomica;
	}
	public void setPuntEconomica(double puntEconomica) {
		this.puntEconomica = puntEconomica;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstadoPropuesta() {
		return estadoPropuesta;
	}
	public void setEstadoPropuesta(String estadoPropuesta) {
		this.estadoPropuesta = estadoPropuesta;
	}
	
}
