package interfaces;

import clases.Propuesta;

public interface PropuestaInterfacesDAO {
	// Actualizar
	public int actualizarPropuesta(Propuesta prop);

	// Buscar Propuesta
	public int buscarPropuesta(int cod);

}
