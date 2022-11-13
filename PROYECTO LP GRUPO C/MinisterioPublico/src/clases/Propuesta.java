package clases;

public class Propuesta {

	private String codPedido;
	private String codParticipante;
	private String codPropuesta;
	private String fecha;
	private String propTecnica;
	private String propEconomica;
	private String estado;

	// Constructores
	public Propuesta() {

	}

	public Propuesta(String codPedido, String codParticipante, String codPropuesta, String fecha, String propTecnica,
			String propEconomica, String estado) {

		this.codPedido = codPedido;
		this.codParticipante = codParticipante;
		this.codPropuesta = codPropuesta;
		this.fecha = fecha;
		this.propTecnica = propTecnica;
		this.propEconomica = propEconomica;
		this.estado = estado;
	}

	// getters y setters
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

	public String getCodPropuesta() {
		return codPropuesta;
	}

	public void setCodPropuesta(String codPropuesta) {
		this.codPropuesta = codPropuesta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPropTecnica() {
		return propTecnica;
	}

	public void setPropTecnica(String propTecnica) {
		this.propTecnica = propTecnica;
	}

	public String getPropEconomica() {
		return propEconomica;
	}

	public void setPropEconomica(String propEconomica) {
		this.propEconomica = propEconomica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
