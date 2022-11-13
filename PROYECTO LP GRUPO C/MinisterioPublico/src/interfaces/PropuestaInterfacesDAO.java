package interfaces;

import java.util.ArrayList;

import clases.Propuesta;

public interface PropuestaInterfacesDAO {
	// Actualizar
	public int actualizarPropuesta(Propuesta prop);

	// Buscar Propuesta
	public Propuesta buscarPropuesta(String idProp);
	
	// Registrar Propuesta
	public int registrarPropuesta(Propuesta prop);
	
	// Listar Propuesta
	public ArrayList<Propuesta> listarPropuestas();

}
