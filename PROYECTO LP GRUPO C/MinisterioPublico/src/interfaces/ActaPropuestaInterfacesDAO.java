package interfaces;

import java.util.ArrayList;

import clases.ActaPropuesta;

public interface ActaPropuestaInterfacesDAO {
	// Buscar Acta por id
	public ActaPropuesta buscarActaPropuesta(String idActa);

	// Buscar Acta por id propuesta
	public ActaPropuesta buscarActaPropuestaxProp(String idProp);

	// Listar Actas
	public ArrayList<ActaPropuesta> listarActasPropuestas();

	// Registrar Propuesta
	public int registrarActaPropuesta(ActaPropuesta aprop);

	// Actualizar
	public int actualizarPropuesta(ActaPropuesta aprop);
}
