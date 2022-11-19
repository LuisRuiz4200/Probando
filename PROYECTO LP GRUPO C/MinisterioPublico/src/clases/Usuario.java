package clases;

public class Usuario {

	private int codigoUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String userUsuario;
	private String claveUsuario;
	private String fechaNacUsuario;
	private int tipoUsuario;
	private String estadoUsario;
	

	public Usuario() {};
	
	public Usuario(int codigoUsuario, String nombreUsuario, String apellidoUsuario, String userUsuario,
			String claveUsuario, String fechaNacUsuario, int tipoUsuario, String estadoUsario) {
		this.codigoUsuario = codigoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.userUsuario = userUsuario;
		this.claveUsuario = claveUsuario;
		this.fechaNacUsuario = fechaNacUsuario;
		this.tipoUsuario = tipoUsuario;
		this.estadoUsario = estadoUsario;
	}


	public int getCodigoUsuario() {
		return codigoUsuario;
	}


	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getApellidoUsuario() {
		return apellidoUsuario;
	}


	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}


	public String getUserUsuario() {
		return userUsuario;
	}


	public void setUserUsuario(String userUsuario) {
		this.userUsuario = userUsuario;
	}


	public String getClaveUsuario() {
		return claveUsuario;
	}


	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}


	public int getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public String getEstadoUsario() {
		return estadoUsario;
	}


	public void setEstadoUsario(String estadoUsario) {
		this.estadoUsario = estadoUsario;
	}


	public String getFechaNacUsuario() {
		return fechaNacUsuario;
	}


	public void setFechaNacUsuario(String fechaNacUsuario) {
		this.fechaNacUsuario = fechaNacUsuario;
	}
	
	
	
}
