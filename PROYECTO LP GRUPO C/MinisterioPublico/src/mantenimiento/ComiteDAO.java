package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Comite;
import clases.Participante;
import utils.MySQLConexion8;

public class ComiteDAO {
	
	public int registrarComite (Comite com) {
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_cep_pedido values (?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,com.getCodPedido());
			pstm.setString(2,com.getCodMiembro());
			pstm.setString(3,com.getNombMiembro());
			pstm.setString(4,com.getApeMiembro());
			pstm.setString(5,com.getDni());
			pstm.setString(6,com.getFuncion());
			pstm.setString(7,com.getDependencia());
			
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
	

	public int actualizarComite(Comite com) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "update tb_cep_pedido set nombre_miembroCEP = ?, apellido_miemborCEP = ?, dni_miembroCEP = ?, funcion_miembroCEP = ?, dependencia_miembroCEP = ?"
					+ "where id_ped = ? and id_miembroCEP = ? ";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,com.getNombMiembro());
			pstm.setString(2,com.getApeMiembro());
			pstm.setString(3,com.getDni());
			pstm.setString(4,com.getFuncion());
			pstm.setString(5,com.getDependencia());
			pstm.setString(6,com.getCodPedido());
			pstm.setString(7,com.getCodMiembro());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		
		
		return res;
	}
	
	public ArrayList<Comite> listarComite(){
		ArrayList <Comite> list = new ArrayList<Comite>();
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_cep_pedido"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Comite com = new Comite(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						
						);
				
				list.add(com);
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

}
