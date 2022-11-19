package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import utils.MySQLConexion8;

public class ApelacionDAO {
	
	// DEFINIR 
	public int resgistrarApelacion (Apelacion ape) {
        int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
		    String sql = "insert into tb_apelacion values (?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			

			pstm.setString(1,ape.getCodApelacion());
			pstm.setString(2,ape.getCodPropuesta());
			pstm.setString(3,ape.getFecha());
			pstm.setString(4,ape.getDescripcion());
			pstm.setString(5,ape.getEstado());
			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		return res;
	}
	
	public int modificarApelacion (Apelacion ape) {
        int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_apelacion set fecha_apel= ?, "
					+ "descripcion_apel = ?, estado_apel = ?"
					+ "where id_prop= ? and id_apel = ?";
			
			pstm = con.prepareStatement(sql);
	
			pstm.setString(1,ape.getFecha());
			pstm.setString(2,ape.getDescripcion());
			pstm.setString(3,ape.getEstado());
			pstm.setString(4,ape.getCodPropuesta());
			pstm.setString(5,ape.getCodApelacion());
			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		} finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		return res;
	}
	
	public int eliminarApelacion ( String codPropuesta, String codApelacion) {
		int res = 0;
		Connection con =null;
		PreparedStatement pstm = null;
		try {
			
            con = MySQLConexion8.getConexion();
			String sql = "delete from tb_apelacion where id_prop= ? and id_apel = ?"; 
						
			pstm = con.prepareStatement(sql);
		
			pstm.setString(1, codPropuesta);
			pstm.setString(2, codApelacion);
			
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}
	
	public ArrayList<Apelacion> listarApelacion(){
		ArrayList <Apelacion> list = new ArrayList<Apelacion>();
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet res = null;
	
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_apelacion"; 			
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			while (res.next()) {
				Apelacion ape = new Apelacion(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5)		
						);
				list.add(ape);
			}
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
				if (res !=null)res.close();
			}catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return list;	
	}
	
	//BUSQUEDA
	
	public Apelacion buscarXIdApelacion(String codApelacion) {
		Apelacion apel = null;
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_apelacion where id_apel = ? ";		
			pstm = con.prepareStatement(sql);
			pstm.setString (1,codApelacion);
			res = pstm.executeQuery();
			while (res.next()) {
				apel = new Apelacion(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5)	
						);
			}		
		}catch(Exception e) {
			System.out.println("Error en la instruccion 'ApelacionDAO' " + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
				if (res !=null)res.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		return apel;
	}
}
