package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.EvaluacionPropuesta;
import utils.MySQLConexion8;

public class EvaluacionPropuestaDAO {

public int registrarEvaluacionPropuesta(EvaluacionPropuesta evProp) {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_evaluacionpropuesta values (?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,evProp.getIdPropuesta());
			pstm.setString(2,evProp.getIdEvapropuesta());
			pstm.setDouble(3,evProp.getPuntTecnica());
			pstm.setDouble(4,evProp.getPuntEconomica());
			pstm.setString(5,evProp.getFecha());
			pstm.setString(6,evProp.getEstadoPropuesta());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
		
		
	}
	
	public int actualizarEvaluacionPropuesta(EvaluacionPropuesta evaProp) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "update tb_evaluacionpropuesta"
					+ " set puntTecnica_evaProp = ?,"
					+ "puntTecnica_evaProp =?, fecha_evaProp = ?, estado_evaProp = ?, "
					+ "where id_evaProp = ? ";
			
			pstm = con.prepareStatement(sql);
			
			
			pstm.setDouble(1, evaProp.getPuntTecnica());
			pstm.setDouble(2, evaProp.getPuntEconomica());
			pstm.setString(3, evaProp.getFecha());
			pstm.setString(4, evaProp.getEstadoPropuesta());
			pstm.setString(5, evaProp.getIdEvapropuesta());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
	}

	public int EliminarEvaluacionPropuesta( String idEvaProp) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_evaluacionpropuesta where id_evaProp = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1, idEvaProp);
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
	}
	
	public ArrayList<EvaluacionPropuesta> listarEvaluacionPropuesta(){
		ArrayList <EvaluacionPropuesta> list = new ArrayList<EvaluacionPropuesta>();;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_evaluacionpropuesta"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				EvaluacionPropuesta ped = new EvaluacionPropuesta(
						res.getString(1),
						res.getString(2),
						res.getDouble(3),
						res.getDouble(4),
						res.getString(5),
						res.getString(6)
						);
				
				list.add(ped);
			}
			
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
				if (res !=null)res.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return list;	
	}

	
	public EvaluacionPropuesta buscarXIdParticipante(String idPropuesta) {
		
		EvaluacionPropuesta part= null;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_evaluacionpropuesta"
					+ " where id_evaProp = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setString (1,idPropuesta);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				part = new EvaluacionPropuesta(
						res.getString(1),
						res.getString(2),
						res.getDouble(3),
						res.getDouble(4),
						res.getString(5),
						res.getString(6)
						
						);
			
			}
			
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
				if (res !=null)res.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		
		return part;
		
	}
	
	
}
