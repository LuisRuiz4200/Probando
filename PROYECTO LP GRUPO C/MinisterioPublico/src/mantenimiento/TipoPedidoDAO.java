package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.*;
import utils.MySQLConexion8;

public class TipoPedidoDAO {

	//LISTAR TIPO DE PEDIDO EN UN OBJETO CLASE
	
	public ArrayList<TipoPedido> listarTipoPedido(){
		
		ArrayList <TipoPedido> list = new ArrayList<TipoPedido>();;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_tipoPedido"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				TipoPedido tipPed = new TipoPedido(
						res.getInt(1),
						res.getString(2)
						
						);
				
				list.add(tipPed);
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
