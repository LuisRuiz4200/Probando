package interfaces;

import clases.Propuesta;

public interface PropuestaInterfacesDAO {
	// Actualizar
	public int actualizarPropuesta(Propuesta prop);

	// Buscar Propuesta
	public Propuesta buscarPropuesta(String idProp);

}
