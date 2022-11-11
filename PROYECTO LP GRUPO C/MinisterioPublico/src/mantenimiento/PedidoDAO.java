package mantenimiento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clases.*;

import utils.MySQLConexion8;

public class PedidoDAO {
	
	//metch
	
	public int registrarPedido(Pedido ped) {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_pedido values (id_ped = ?, entidad_ped = ?, tipo_ped = ?, objeto_ped = ?, descripcion_ped = ?, descripcion_ped = ?, fecha_ped=?,estado_ped=?)";
			
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
	
	public int actualizarPedido() {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			
			
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

	public int eliminarPedido() {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			
			
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

}
