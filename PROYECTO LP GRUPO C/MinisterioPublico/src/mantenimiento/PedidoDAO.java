package mantenimiento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;

import utils.MySQLConexion8;

public class PedidoDAO {
	
	public int registrarPedido(Pedido ped) {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_pedido values (?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,ped.getCodigo());
			pstm.setString(2,ped.getEntidad());
			pstm.setInt(3,ped.getTipo());
			pstm.setInt(4,ped.getObjeto());
			pstm.setString(5,ped.getDescripcion());
			pstm.setString(6,ped.getFecha());
			pstm.setString(7,ped.getEstado());
			
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
	
	public int actualizarPedido(Pedido ped) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql;
			sql = "update tb_pedido set "
					+ "entidad_ped = ?, id_tipoPedido = ?, id_objetoPedido = ?, descripcion_ped = ?, fecha_ped=?,estado_ped=?"
					+ "where id_ped = ?";
			
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1,ped.getEntidad());
			pstm.setInt(2,ped.getTipo());
			pstm.setInt(3,ped.getObjeto());
			pstm.setString(4,ped.getDescripcion());
			pstm.setString(5,ped.getFecha());
			pstm.setString(6,ped.getEstado());
			
			pstm.setString(7,ped.getCodigo());
			
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

	public int eliminarPedido(int idPedido) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_objetoPedido where id_objetoPedido = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, idPedido);
			
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
	
	public ArrayList<Pedido> listarPedido(){
		ArrayList <Pedido> list = new ArrayList<Pedido>();;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_pedido"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Pedido ped = new Pedido(
						res.getString(1),
						res.getString(2),
						res.getInt(3),
						res.getInt(4),
						res.getString(5),
						res.getString(6),
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
