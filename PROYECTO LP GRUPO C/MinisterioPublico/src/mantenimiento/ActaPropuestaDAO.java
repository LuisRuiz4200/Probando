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
		PreparedStatement pstm = null;

		try {
			// paso 1 : Establecer la conexión con la BD
			con = MySQLConexion8.getConexion();

			// paso 2: Definir la instruccion SQL-- REGISTRO
			String sql = "insert into tb_actapropuesta values (?,?,?,?,?,?)";

			// paso 3 : preparar la instruccion --> obtener los comandos SQL
			pstm = con.prepareStatement(sql);

			// paso 4: obtener los parametros
			pstm.setString(1, aprop.getIdActaPropuesta());
			pstm.setString(2, aprop.getIdPropuesta());
			pstm.setString(3, aprop.getFecha());
			pstm.setString(4, aprop.getDesActaPropuesta());
			pstm.setString(5, aprop.getTipoActa());
			pstm.setString(6, aprop.getEstadoActa());

			// paso 5: ejecucion de la instruccion
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción de registro " + e.getMessage());
		} finally {
			try {

				if (pstm != null)
					pstm.close();
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

		try {
			// paso 1 : Establecer la conexiï¿½n con la BD
			con = MySQLConexion8.getConexion();

			// paso 2: Definir la instruccion SQL-- ACTUALIZAR
			String sql = "update tb_actapropuesta set fecha_actaProp = ?, descripcion_actaProp = ?, tipo_actaProp = ?  where id_actaProp = ?";

			// paso 3 : preparar la instruccion --> obtener los comandos SQL
			pstm = con.prepareStatement(sql);

			// paso 4: obtener los parametros
			pstm.setString(1, aprop.getFecha());
			pstm.setString(2, aprop.getDesActaPropuesta());
			pstm.setString(3, aprop.getTipoActa());
			pstm.setString(4, aprop.getIdActaPropuesta());

			// paso 5: ejecucion de la instruccion
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción de actualizar " + e.getMessage());
		} finally {
			try {

				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}
		}
		return res;
	}

}
