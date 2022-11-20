package interfaces;

import clases.ActaPropuesta;

public interface ActaPropuestaInterfacesDAO {
	// Buscar Acta por id
	public ActaPropuesta buscarActaPropuesta(String idActa);

	// Buscar Acta por id propuesta
	public ActaPropuesta buscarActaPropuestaxProp(String idProp);
}
