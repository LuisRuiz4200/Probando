package clases;

public class TipoUsuario {

	private int idTipoUser;
	private String desTipoUser;
	
	
	public TipoUsuario(int idTipoUser, String desTipoUser) {
		this.idTipoUser = idTipoUser;
		this.desTipoUser = desTipoUser;
	}


	public int getIdTipoUser() {
		return idTipoUser;
	}


	public void setIdTipoUser(int idTipoUser) {
		this.idTipoUser = idTipoUser;
	}


	public String getDesTipoUser() {
		return desTipoUser;
	}


	public void setDesTipoUser(String desTipoUser) {
		this.desTipoUser = desTipoUser;
	}
	
	
	
}
