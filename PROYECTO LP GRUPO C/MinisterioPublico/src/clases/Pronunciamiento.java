package clases;

public class Pronunciamiento {
    private int idApel; 
	private int idPronun;
	private String nomGerente;
	private String dni;
	private String fecha;
	private String desApelacion;
	private String pronApelacion;
	
	
	//Constructor
	public Pronunciamiento() {
	
	}
	public Pronunciamiento(int idApel, int idPronun, String nomGerente, String dni, String fecha, String desApelacion,
			String pronApelacion) {
		super();
		this.idApel = idApel;
		this.idPronun = idPronun;
		this.nomGerente = nomGerente;
		this.dni = dni;
		this.fecha = fecha;
		this.desApelacion = desApelacion;
		this.pronApelacion = pronApelacion;
	}

	// Set/Get
	public int getIdApel() {
		return idApel;
	}
	public void setIdApel(int idApel) {
		this.idApel = idApel;
	}
	public int getIdPronun() {
		return idPronun;
	}
	public void setIdPronun(int idPronun) {
		this.idPronun = idPronun;
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
	public String getPronApelacion() {
		return pronApelacion;
	}
	public void setPronApelacion(String pronApelacion) {
		this.pronApelacion = pronApelacion;
	}
	
	
}
