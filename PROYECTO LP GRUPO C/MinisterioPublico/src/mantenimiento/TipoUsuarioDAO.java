package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.TipoUsuario;
import utils.MySQLConexion8;

public class TipoUsuarioDAO {

	
	public ArrayList<TipoUsuario> listarTipoUsuario() {
		ArrayList<TipoUsuario> list = new ArrayList<TipoUsuario>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_tipouser";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				
				TipoUsuario tipoUser = new TipoUsuario(
						res.getInt(1),
						res.getString(2)
						);
				list.add(tipoUser);
			}
			
			
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD" + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
				if(pstm!= null) pstm.close();
				if (res!=null) res.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR LAS CONEXIONES" + e.getMessage());
			}
		}
		
		return list;
	}
	
}
