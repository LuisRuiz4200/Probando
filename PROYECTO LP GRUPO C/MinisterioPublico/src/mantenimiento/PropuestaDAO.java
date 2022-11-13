package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Propuesta;
import interfaces.PropuestaInterfacesDAO;
import utils.MySQLConexion8;

public class PropuestaDAO implements PropuestaInterfacesDAO{

	@Override
	public Propuesta buscarPropuesta(String idProp) {
		Propuesta prop = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		
		try {
			con = MySQLConexion8.getConexion();
			//paso 2: Instruccion SQL - consulta 
			String sql = "select * from tb_propuesta where id_prop = ?";
			//paso 3
			pstm = con.prepareStatement(sql);
			//paso 4
			pstm.setString(1, idProp);
			//paso 5:
			res = pstm.executeQuery();
			//
			if(res.next()) {
				prop = new Propuesta();
				prop.setCodPedido(res.getString(1));
				prop.setCodPropuesta(res.getString(2));
				prop.setCodParticipante(res.getString(3));
				prop.setFecha(res.getString(4));
				prop.setPropTecnica(res.getString(5));
				prop.setPropEconomica(res.getString(6));
				prop.setEstado(res.getString(7));
			}
				
		} catch (Exception e) {
			System.out.println("Error en la instrución SQL - Consultar Propuesta "+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con != null )con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}		
		return prop;
	}

	@Override
	public int actualizarPropuesta(Propuesta prop) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// paso 1 : Establecer la conexión con la BD
			con = MySQLConexion8.getConexion();

			// paso 2: Definir la instruccion SQL-- ACTUALIZAR
			String sql = "update tb_propuesta set estado_prop = ? where id_prop = ?";

			// paso 3 : preparar la instruccion --> obtener los comandos SQL
			pstm = con.prepareStatement(sql);

			// paso 4: obtener los parametros
			pstm.setString(1, prop.getEstado());
			pstm.setString(2, prop.getCodPropuesta());

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
