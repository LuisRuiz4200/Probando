package clases;

public class Comite {
   // incializamos entradas 
   private int codPedido;
   private int codMiembro;
   private String nombMiembro;
   private String apeMiembro;
   private String dni;
   private String funcion;
   private String Dependencia;

   
   //Constructor vacio
   public Comite() {
	}
   
   //Constructor
   public Comite(int codPedido, int codMiembro, String nombMiembro, String apeMiembro, String dni, String funcion,
			String dependencia) {
		super();
		this.codPedido = codPedido;
		this.codMiembro = codMiembro;
		this.nombMiembro = nombMiembro;
		this.apeMiembro = apeMiembro;
		this.dni = dni;
		this.funcion = funcion;
		Dependencia = dependencia;
	}
   
   // Set/Get
   
   public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public int getCodMiembro() {
		return codMiembro;
	}

	public void setCodMiembro(int codMiembro) {
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
