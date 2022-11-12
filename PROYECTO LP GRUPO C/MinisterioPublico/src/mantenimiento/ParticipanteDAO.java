package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Participante;
import utils.MySQLConexion8;

public class ParticipanteDAO {
	public int registrarParticipante(Participante part) {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_participante values (?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,part.getCodPedido());
			pstm.setString(2,part.getCodParticipante());
			pstm.setString(3,part.getEntidad());
			pstm.setInt(4,part.getRuc());
			pstm.setString(5,part.getCorreo());
			pstm.setInt(6,part.getTelefono());
			pstm.setString(7,part.getEstado());
			
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
	
	public int actualizarPartcipante(Participante part) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "update tb_participante ser --- where id_participante = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,part.getCodPedido());
			pstm.setString(2,part.getEntidad());
			pstm.setInt(3,part.getRuc());
			pstm.setString(4,part.getCorreo());
			pstm.setInt(5,part.getTelefono());
			pstm.setString(6,part.getEstado());
			pstm.setString(7,part.getCodParticipante());
			
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

	public int eliminarParticipante(int idParticipante) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_partcipante where id_participante = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, idParticipante);
			
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
	
	public ArrayList<Participante> listarPedido(){
		ArrayList <Participante> list = new ArrayList<Participante>();;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_pedido"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Participante ped = new Participante(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getString(5),
						res.getInt(6),
						res.getString(7)
						
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

}
