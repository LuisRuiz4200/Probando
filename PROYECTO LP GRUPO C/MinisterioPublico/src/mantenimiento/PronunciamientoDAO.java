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
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		
		try {	
			con = MySQLConexion8.getConexion();
			con.setAutoCommit(false);
			
			String sql1 = "insert into tb_proyectopronunciamientoapelacion values (?,?,?,?,?,?,?)";
			pstm1 = con.prepareStatement(sql1);
			
			pstm1.setString(1,proEva.getIdPronun());
			pstm1.setString(2,proEva.getIdApel());
			pstm1.setString(3,proEva.getNomGerente());
			pstm1.setString(4,proEva.getDni());
			pstm1.setString(5,proEva.getFecha());
			pstm1.setString(6,proEva.getDesApelacion());
			pstm1.setString(7,proEva.getEstado());
			
			res = pstm1.executeUpdate();
			
			//CAMBIAR ESTADO DE APELACION A FUNDADO Y NO FUNDADO
			
			String sql2 = "update tb_apelacion set estado_apel = ? where id_apel = ? ";
			pstm2 = con.prepareStatement(sql2);
			
			pstm2.setString(1,proEva.getEstado());
			pstm2.setString(2,proEva.getIdApel());
			
			res= pstm2.executeUpdate();
			con.commit();
			
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion " + e.getMessage());
			
		    res = 0;
		    
		}try {
			con.rollback();
		} catch (Exception e2) {
			System.out.println("Error al restuarar la bd" + e2.getMessage());
		} finally {
			try {
				if (con!=null)con.close();
				if (pstm1!=null)pstm1.close();
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
