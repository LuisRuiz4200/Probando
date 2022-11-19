package clases;

public class Pronunciamiento {
	//INCIALIZAMOS ENTRADAS 
	private String idPronun;
	private String idApel; 
	private String nomGerente;
	private String dni;
	private String fecha;
	private String desApelacion;
	private String estado;
	
	
	//CONSTRUCTOR VACIO
	public Pronunciamiento() {
		
	}
	
	//CONSTRUCTOR
	public Pronunciamiento(String idPronun, String idApel, String nomGerente, String dni, String fecha,
			String desApelacion, String estado) {
		super();
		this.idPronun = idPronun;
		this.idApel = idApel;
		this.nomGerente = nomGerente;
		this.dni = dni;
		this.fecha = fecha;
		this.desApelacion = desApelacion;
		this.estado = estado;
	}
 
	//SET/GET
	public String getIdPronun() {
		return idPronun;
	}

	public void setIdPronun(String idPronun) {
		this.idPronun = idPronun;
	}

	public String getIdApel() {
		return idApel;
	}

	public void setIdApel(String idApel) {
		this.idApel = idApel;
	}

	public String getNomGerente() {
		return nomGerente;
	}

	public void setNomGerente(String nomGerente) {
		this.nomGerente = nomGerente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDesApelacion() {
		return desApelacion;
	}

	public void setDesApelacion(String desApelacion) {
		this.desApelacion = desApelacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
