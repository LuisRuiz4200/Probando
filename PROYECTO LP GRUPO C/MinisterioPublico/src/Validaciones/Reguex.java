package Validaciones;

public class Reguex {
	
	//PARTICIPANTE
	
	public static String ID_PARTICIPANTE="[P][D]\\d{3}";
	public static String ENTIDAD_PARTICIPANTE ="[a-zA-Z\\s]{2,35}";
	public static String RUC_PARTICIPANTE = "\\d{11}";
	
	public static String TELEFONO_PARTICIPANTE = "\\d{9}";
	public static String CORREO_PARTICIPANTE = "";
	
	
	//MIEMBRO DEL CEP
	
	public static String ID_CEP = "[M][C]\\d{3}";
	public static String NOMBRE_CEP="[a-zA-Z\\s]{2,20}";
	public static String APELLIDO_CEP="[a-zA-Z\\ñ\\s]{2,20}";
	public static String DNI_CEP = "\\d{8}";
	public static String FUNCION_CEP ="[a-zA-Z\\s]{2,20}";
	public static String DEPENDENCIA_CEP ="[a-zA-Z\\s]{2,20}";
	
	//PROPUESTA
	
	public static String ID_PROPUESTA = "";
	
	//APELACION
	
	public static String ID_APELACION = "[A][P]\\d{3}";
	public static String DESCRIPCION_APE=".{2,450}";
	public static String ESTADO_APE="[a-zA-Z\\ñ\\s]{2,20}";
	
	
	// EVALUACION DE PROPUESTA
	public static String ID_EVALUACION="";
	public static String PUNTTECNICO_EVALUACION = "";
	public static String PUNTECONOMICO_EVALUACION= "";
	
	
	
}
