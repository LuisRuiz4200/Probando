package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Propuesta;
import utils.MySQLConexion8;

public interface PropuestaInterfacesDAO {
	// Actualizar
	public int actualizarPropuesta(Propuesta prop);

	// Buscar Propuesta
	public Propuesta buscarPropuesta(String idProp);

	// Registrar Propuesta
	public int registrarPropuesta(Propuesta prop);

	// Listar Propuesta
	public ArrayList<Propuesta> listarPropuestas();

	// Listar Propuesta x IdPedido
	public ArrayList<Propuesta> buscarXPedido(String id_ped);
}
