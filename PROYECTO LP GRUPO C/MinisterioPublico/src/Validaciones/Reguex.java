package Validaciones;

public class Reguex {
	
	//USUARIO
	
	public static String NOMBRE_USUARIO = ".{3,16}";
	public static String APELLIDO_USUARIO = ".{3,16}";
	public static String USER_USUARIO = "[A-Za-z0-9]{4,8}";
	public static String CLAVE_USUARIO = "[A-Za-z]{4,8}";
	
	//ENTIDAD PEDIDO
	
	public static String ID_PEDIDO = "[PD]\\d{3}";
	public static String ENTIDAD_PEDIDO = ".{5,10}";
	public static String RUC_PEDIDO = "\\d{11}";
	
	//PARTICIPANTE
	
	public static String ID_PARTICIPANTE="[PA]\\d{3}";
	public static String ENTIDAD_PARTICIPANTE =".{5,10}";
	public static String RUC_PARTICIPANTE = "\\d{11}";
	
	public static String TELEFONO_PARTICIPANTE = "\\d{7,9}";
	public static String CORREO_PARTICIPANTE = "\\.+@\\[hotmail, outlook, gmail].com";
	
	
	//MIEMBRO DEL CEP
	
	public static String ID_CEP = "[M][C]\\d{3}";
	public static String NOMBRE_CEP="[a-zA-Z\\s]{2,20}";
	public static String APELLIDO_CEP="[a-zA-Z\\ï¿½\\s]{2,20}";
	public static String DNI_CEP = "\\d{8}";
	public static String FUNCION_CEP ="[a-zA-Z\\s]{2,20}";
	public static String DEPENDENCIA_CEP ="[a-zA-Z\\s]{2,20}";
	
	//PROPUESTA
	
	public static String ID_PROPUESTA = "";
	
	//APELACION
	
	public static String ID_APELACION = "[A][P]\\d{3}";
	public static String DESCRIPCION_APE=".{2,450}";
	public static String ESTADO_APE="[a-zA-Z\\ï¿½\\s]{2,20}";
	
	
	// EVALUACION DE PROPUESTA
	public static String ID_EVALUACION="[EVPR]\\d{3}";
	public static String PUNTTECNICO_EVALUACION = "\\d{0,3}";
	public static String PUNTECONOMICO_EVALUACION= "\\d{0,3}";
	
	// PRONUNCIAMIENTO
	public static String ID_PRONUNCIAMIENTO="[P][A]\\d{3}";
	public static String NOMBRE_ACESOR="[a-zA-Z\\ñ\\s]{2,20}";
	public static String DNI_ACESOR = "\\d{8}";
	public static String CONCLUSION=".{2,500}";
	
}
