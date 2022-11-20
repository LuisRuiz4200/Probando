package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import utils.MySQLConexion8;

public class PronunciamientoDAO {
	
	//REGISTRO DE PROPNUNCIAMIENTO
	public int registrarPronApelacion (Pronunciamiento proEva ) {
        int res = 0;
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {	
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_proyectopronunciamientoapelacion values (?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,proEva.getIdPronun());
			pstm.setString(2,proEva.getIdApel());
			pstm.setString(3,proEva.getNomGerente());
			pstm.setString(4,proEva.getDni());
			pstm.setString(5,proEva.getFecha());
			pstm.setString(6,proEva.getDesApelacion());
			pstm.setString(7,proEva.getEstado());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion " + e.getMessage());
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
	//MODIFICAR PRONUNCIAMIENTO
	public int modificarPronApelacion (Pronunciamiento proEva ) {
        int res = 0;
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {	
			con = MySQLConexion8.getConexion();
			String sql = "update tb_proyectopronunciamientoapelacion set nomGerenteAJ_pronApel = ?, dniGerenteAJ_pronApel = ?, fecha_pronApel = ?, descripcion_pronApel = ?, estado_pronApel = ? "
					+ "where id_pronApel = ? and id_apel = ?";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,proEva.getNomGerente());
			pstm.setString(2,proEva.getDni());
			pstm.setString(3,proEva.getFecha());
			pstm.setString(4,proEva.getDesApelacion());
			pstm.setString(5,proEva.getEstado());
			pstm.setString(6,proEva.getIdPronun());
			pstm.setString(7,proEva.getIdApel());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion " + e.getMessage());
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
	//LISTAR PRONUNCIAMIENTO
	public ArrayList<Pronunciamiento> listarPronunciamiento() {
	
	ArrayList <Pronunciamiento> list = new ArrayList<Pronunciamiento>();
	
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet res = null;
	
	try {
		con = MySQLConexion8.getConexion();
        String sql = "select * from tb_proyectopronunciamientoapelacion";
        pstm = con.prepareStatement(sql);
        res = pstm.executeQuery();
		while (res.next()) {
			Pronunciamiento pro = new Pronunciamiento(
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5),
					res.getString(6),
					res.getString(7)
					);
			list.add(pro);
					
		}
	} catch (Exception e) {
		System.out.println("Error en la Instruccion " + e.getMessage());
	}finally {
		try {
			if (con != null)con.close();
			if (pstm != null)pstm.close();
			if (res != null)res.close();
		} catch (SQLException e2) {
			System.out.println("Error al cerrar la base de datos"+ e2.getMessage());
		    }
	  }
	  return list;
	}
	
	//
	
	
	
}
