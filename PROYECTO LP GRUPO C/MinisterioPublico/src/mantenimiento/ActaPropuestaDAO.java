package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.ActaPropuesta;
import clases.Propuesta;
import interfaces.ActaPropuestaInterfacesDAO;
import utils.MySQLConexion8;

public class ActaPropuestaDAO implements ActaPropuestaInterfacesDAO{

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
				aprop.setDesActaPropuesta(res.getString(4));;
				aprop.setTipoActa(res.getString(5));;
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
				aprop.setDesActaPropuesta(res.getString(4));;
				aprop.setTipoActa(res.getString(5));;
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

}
