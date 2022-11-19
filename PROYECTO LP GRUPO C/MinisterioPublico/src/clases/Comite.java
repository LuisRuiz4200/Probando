package clases;

public class Comite {
   //INCIALIZAMOS ENTRADAS 
   private String codPedido;
   private String codMiembro;
   private String nombMiembro;
   private String apeMiembro;
   private String dni;
   private String funcion;
   private String Dependencia;

   //CONSTRUCTOR VACIO
   public Comite() {
	}
   
   //CONSTRUCTOR
   public Comite(String codPedido, String codMiembro, String nombMiembro, String apeMiembro, String dni, String funcion,
			String dependencia) {
		super();
		this.codPedido = codPedido;
		this.codMiembro = codMiembro;
		this.nombMiembro = nombMiembro;
		this.apeMiembro = apeMiembro;
		this.dni = dni;
		this.funcion = funcion;
		this.Dependencia = dependencia;
	}
   
   //SET/GET
   public String getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}
	public String getCodMiembro() {
		return codMiembro;
	}
	public void setCodMiembro (String codMiembro) {
		this.codMiembro = codMiembro;
	}
	public String getNombMiembro() {
		return nombMiembro;
	}
	public void setNombMiembro(String nombMiembro) {
		this.nombMiembro = nombMiembro;
	}
	public String getApeMiembro() {
		return apeMiembro;
	}
	public void setApeMiembro(String apeMiembro) {
		this.apeMiembro = apeMiembro;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getDependencia() {
		return Dependencia;
	}
	public void setDependencia(String dependencia) {
		Dependencia = dependencia;
	}
}
