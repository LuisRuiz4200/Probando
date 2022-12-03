package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.ActaPropuesta;
import clases.Propuesta;
import interfaces.ActaPropuestaInterfacesDAO;
import utils.MySQLConexion8;

public class ActaPropuestaDAO implements ActaPropuestaInterfacesDAO {

	@Override
	public ActaPropuesta buscarActaPropuesta(String idActa) {
		ActaPropuesta aprop = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			// paso 2: Instruccion SQL - consulta
			String sql = "select * from tb_actapropuesta where id_actaProp = ?";
			// paso 3
			pstm = con.prepareStatement(sql);
			// paso 4
			pstm.setString(1, idActa);
			// paso 5:
			res = pstm.executeQuery();
			//
			if (res.next()) {
				aprop = new ActaPropuesta();
				aprop.setIdActaPropuesta(res.getString(1));
				aprop.setIdPropuesta(res.getString(2));
				aprop.setFecha(res.getString(3));
				aprop.setDesActaPropuesta(res.getString(4));
				;
				aprop.setTipoActa(res.getString(5));
				;
				aprop.setEstadoActa(res.getString(6));
			}

		} catch (Exception e) {
			System.out.println("Error en la instrución SQL - Consultar actaPropuesta " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}
		}
		return aprop;
	}

	@Override
	public ActaPropuesta buscarActaPropuestaxProp(String idProp) {
		ActaPropuesta aprop = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			// paso 2: Instruccion SQL - consulta
			String sql = "select * from tb_actapropuesta where id_Prop = ?";
			// paso 3
			pstm = con.prepareStatement(sql);
			// paso 4
			pstm.setString(1, idProp);
			// paso 5:
			res = pstm.executeQuery();
			//
			if (res.next()) {
				aprop = new ActaPropuesta();
				aprop.setIdActaPropuesta(res.getString(1));
				aprop.setIdPropuesta(res.getString(2));
				aprop.setFecha(res.getString(3));
				aprop.setDesActaPropuesta(res.getString(4));
				;
				aprop.setTipoActa(res.getString(5));
				;
				aprop.setEstadoActa(res.getString(6));
			}

		} catch (Exception e) {
			System.out.println("Error en la instrución SQL - Consultar actaPropuesta " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}
		}
		return aprop;
	}

	@Override
	public ArrayList<ActaPropuesta> listarActasPropuestas() {
		ArrayList<ActaPropuesta> listaActaProp = new ArrayList<ActaPropuesta>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ActaPropuesta aprop = null;

		try {
			// paso 1: conectarse a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: Establecer la instrucción SQL -- consulta
			String sql = "SELECT * FROM tb_actapropuesta";
			// paso 3 : Enviar la instruccion al objeto "pstm" -->
			pstm = con.prepareStatement(sql);
			// paso 4 : parametros -- NO HAY
			// paso 5: ejecutar la instrucción SQL
			res = pstm.executeQuery();
			// bucle --> para realizar el recorrido al objeto res
			while (res.next()) {
				// crear objeto de tipo "Usuario"
				aprop = new ActaPropuesta();
				// setear --> asignar los valores obtenidos del objeto "res" a los atributos
				// privados
				aprop.setIdActaPropuesta(res.getString(1));
				;
				aprop.setIdPropuesta(res.getString(2));
				aprop.setFecha(res.getString(3));
				aprop.setDesActaPropuesta(res.getString(4));
				aprop.setTipoActa(res.getString(5));
				aprop.setEstadoActa(res.getString(6));

				// añadir el objeto a la lista
				listaActaProp.add(aprop);
			}

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar Propuestas" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		return listaActaProp;
	}

	@Override
	public int registrarActaPropuesta(ActaPropuesta aprop) {
		// declaraion de variables
		int res = 0;
		Connection con = null;
		PreparedStatement pstm1 = null; // Registra actapropuesta
		PreparedStatement pstm2 = null; // Actualiza Propuesta
		String estado_prop = null;

		switch (aprop.getTipoActa()) {
		case "Observaciones":
			estado_prop = "OBSERVADO";
			break;
		case "Resultados":
			estado_prop = "NO ADMITIDA";
			break;
		default:
			break;
		}

		try {
			// Establecer la conexión con la BD
			con = MySQLConexion8.getConexion();
			con.setAutoCommit(false);

			// Definir la instruccion SQL1-- REGISTRO
			String sql = "INSERT INTO tb_actapropuesta VALUES (?,?,?,?,?,?)";

			// preparar la instruccion --> obtener los comandos SQL
			pstm1 = con.prepareStatement(sql);

			// obtener los parametros
			pstm1.setString(1, aprop.getIdActaPropuesta());
			pstm1.setString(2, aprop.getIdPropuesta());
			pstm1.setString(3, aprop.getFecha());
			pstm1.setString(4, aprop.getDesActaPropuesta());
			pstm1.setString(5, aprop.getTipoActa());
			pstm1.setString(6, aprop.getEstadoActa());

			res = pstm1.executeUpdate();

			// actualiza el estado de la propuesta según el resultado del acta
			String sql2 = "UPDATE tb_propuesta SET estado_prop = ? WHERE  id_prop = ?";
			pstm2 = con.prepareStatement(sql2);
			pstm2.setString(1, estado_prop);
			pstm2.setString(2, aprop.getIdPropuesta());

			res = pstm2.executeUpdate();

			// confirmar
			con.commit();

		} catch (Exception e) {
			System.out.println(">>>> Error en la transacción de registro " + e.getMessage());
			res = 0;
			// restaura la bd antes de ejecutar la transacción
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(">>>> Error al restaurar " + e.getMessage());
			}
		} finally {
			try {

				if (pstm1 != null)
					pstm1.close();
				if (pstm2 != null)
					pstm2.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizarPropuesta(ActaPropuesta aprop) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		PreparedStatement pstm2 = null;
		String estado_prop = null;

		switch (aprop.getTipoActa()) {
		case "Observaciones":
			estado_prop = "OBSERVADO";
			break;
		case "Resultados":
			estado_prop = "NO ADMITIDA";
			break;
		default:
			break;
		}

		try {
			// Establecer la conexión con la BD
			con = MySQLConexion8.getConexion();
			con.setAutoCommit(false);

			// Definir la instruccion SQL-- ACTUALIZAR
			String sql = "update tb_actapropuesta set fecha_actaProp = ?, descripcion_actaProp = ?, tipo_actaProp = ?  where id_actaProp = ?";

			// preparar la instruccion --> obtener los comandos SQL
			pstm = con.prepareStatement(sql);

			// obtener los parametros
			pstm.setString(1, aprop.getFecha());
			pstm.setString(2, aprop.getDesActaPropuesta());
			pstm.setString(3, aprop.getTipoActa());
			pstm.setString(4, aprop.getIdActaPropuesta());

			// ejecucion de la instruccion
			res = pstm.executeUpdate();

			String sql2 = "UPDATE tb_propuesta SET estado_prop = ? WHERE  id_prop = ?";
			pstm2 = con.prepareStatement(sql2);
			pstm2.setString(1, estado_prop);
			pstm2.setString(2, aprop.getIdPropuesta());

			res = pstm2.executeUpdate();

			// confirmar
			con.commit();
			
			System.out.println(estado_prop);
			System.out.println(aprop.getIdPropuesta());
			System.out.println(res);

		} catch (Exception e) {
			System.out.println(">>>> Error en la transacción de actualizar " + e.getMessage());
			res = 0;
			// restaura la bd antes de ejecutar la transacción
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(">>>> Error al restaurar " + e.getMessage());
			}
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm2 != null)
					pstm2.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}
		}
		return res;
	}

}
