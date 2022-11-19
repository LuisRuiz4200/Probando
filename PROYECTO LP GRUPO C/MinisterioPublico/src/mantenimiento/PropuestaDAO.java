package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import interfaces.PropuestaInterfacesDAO;
import utils.MySQLConexion8;

public class PropuestaDAO implements PropuestaInterfacesDAO {

	@Override
	public Propuesta buscarPropuesta(String idParti) {
		Propuesta prop = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			// paso 2: Instruccion SQL - consulta
			String sql = "select * from tb_propuesta where codigo_parti = ?";
			// paso 3
			pstm = con.prepareStatement(sql);
			// paso 4
			pstm.setString(1, idParti);
			// paso 5:
			res = pstm.executeQuery();
			//
			if (res.next()) {
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
			System.out.println("Error en la instruciï¿½n SQL - Consultar Propuesta " + e.getMessage());
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
		return prop;
	}

	@Override
	public int actualizarPropuesta(Propuesta prop) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			// paso 1 : Establecer la conexiï¿½n con la BD
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
			System.out.println(">>>> Error en la instrucciï¿½n de actualizar " + e.getMessage());
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

	@Override
	public int registrarPropuesta(Propuesta prop) {
		// declaraion de variables
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			// paso 1 : Establecer la conexión con la BD
			con = MySQLConexion8.getConexion();

			// paso 2: Definir la instruccion SQL-- REGISTRO
			String sql = "insert into tb_propuesta values (?,?,?,?,?,?,?)";

			// paso 3 : preparar la instruccion --> obtener los comandos SQL
			pstm = con.prepareStatement(sql);

			// paso 4: obtener los parametros
			pstm.setString(1, prop.getCodPedido());
			pstm.setString(2, prop.getCodPropuesta());
			pstm.setString(3, prop.getCodParticipante());
			pstm.setString(4, prop.getFecha());
			pstm.setString(5, prop.getPropTecnica());
			pstm.setString(6, prop.getPropEconomica());
			pstm.setString(7, prop.getEstado());

			// paso 5: ejecucion de la instruccion
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción del registro " + e.getMessage());
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
	public ArrayList<Propuesta> listarPropuestas() {
		ArrayList<Propuesta> listaProp = new ArrayList<Propuesta>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Propuesta prop = null;

		try {
			// paso 1: conectarse a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: Establecer la instrucción SQL -- consulta
			String sql = "SELECT * FROM tb_propuesta";
			// paso 3 : Enviar la instruccion al objeto "pstm" -->
			pstm = con.prepareStatement(sql);
			// paso 4 : parametros -- NO HAY
			// paso 5: ejecutar la instrucción SQL
			res = pstm.executeQuery();
			// bucle --> para realizar el recorrido al objeto res
			while (res.next()) {
				// crear objeto de tipo "Usuario"
				prop = new Propuesta();
				// setear --> asignar los valores obtenidos del objeto "res" a los atributos
				// privados
				prop.setCodPedido(res.getString(1));
				prop.setCodPropuesta(res.getString(2));
				prop.setCodParticipante(res.getString(3));
				prop.setFecha(res.getString(4));
				prop.setPropTecnica(res.getString(5));
				prop.setPropEconomica(res.getString(6));
				prop.setEstado(res.getString(7));

				// añadir el objeto a la lista
				listaProp.add(prop);
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
		return listaProp;
	}
	
	@Override
	public ArrayList<Propuesta> buscarXPedido(String id_ped) {
		ArrayList<Propuesta> list = new ArrayList<Propuesta>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_propuesta where id_ped = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id_ped);
			res = pstm.executeQuery();

			while (res.next()) {
				Propuesta prop = new Propuesta();
				prop.setCodPedido(res.getString(1));
				prop.setCodPropuesta(res.getString(2));
				prop.setCodParticipante(res.getString(3));
				prop.setFecha(res.getString(4));
				prop.setPropTecnica(res.getString(5));
				prop.setPropEconomica(res.getString(6));
				prop.setEstado(res.getString(7));

				list.add(prop);
			}

		} catch (Exception e) {
			System.out.println("Error en la instruccion " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos " + e.getMessage());
			}
		}
		return list;
	}


	//ADICIONAL 
	
	public Propuesta buscarXIdPropuesta(String idProp) {
		Propuesta prop = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			con = MySQLConexion8.getConexion();
			// paso 2: Instruccion SQL - consulta
			String sql = "select * from tb_propuesta where id_prop = ?";
			// paso 3
			pstm = con.prepareStatement(sql);
			// paso 4
			pstm.setString(1, idProp);
			// paso 5:
			res = pstm.executeQuery();
			//
			if (res.next()) {
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
			System.out.println("Error en la instruccion SQL - Consultar Propuesta " + e.getMessage());
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
		return prop;
	}
	
	//REPORTE DE PROPUESTAS
	
	public ArrayList<Propuesta> reporteXFecha (String fechaInicio, String fechaFin){
		
		ArrayList<Propuesta> list = new ArrayList <Propuesta>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql ="select * from tb_propuesta where fecha_prop >= ? and fecha_prop <= ? ";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, fechaInicio);
			pstm.setString(2, fechaFin);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Propuesta prop = new Propuesta (
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						);
				
				list.add(prop);
			}
			

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Reporte de propuesta " + e.getMessage());
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
		return list;
		
		
	}
	
}
