package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.*;
import utils.MySQLConexion8;


public class UsuarioDAO {

	
	public int regitrarUsuario(Usuario usuario) {
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_usuario values (?,?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1,usuario.getCodigoUsuario());
			pstm.setString(2, usuario.getNombreUsuario());
			pstm.setString(3, usuario.getApellidoUsuario());
			pstm.setString(4, usuario.getUserUsuario());
			pstm.setString(5, usuario.getClaveUsuario());
			pstm.setString(6, usuario.getFechaNacUsuario());
			pstm.setInt(7, usuario.getTipoUsuario());
			pstm.setString(8, usuario.getEstadoUsario());
			
			res = pstm.executeUpdate();
			
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD" + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
				if(pstm!= null) pstm.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR LAS CONEXIONES" + e.getMessage());
			}
		}
		
		return res;
	}
	
	public int ModificarUsuario(Usuario usuario) {
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "update tb_usuario set nombre_user = ?, apellido_user = ?, usuario_user = ?, "
					+ "clave_user = ?, tipo_user= ?, estado_user=? where codigo_user = ?;";
			
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1, usuario.getNombreUsuario());
			pstm.setString(2, usuario.getApellidoUsuario());
			pstm.setString(3, usuario.getUserUsuario());
			pstm.setString(4, usuario.getClaveUsuario());
			pstm.setString(5, usuario.getFechaNacUsuario());
			pstm.setInt(6, usuario.getTipoUsuario());
			pstm.setString(7, usuario.getEstadoUsario());
			pstm.setInt(8,usuario.getCodigoUsuario());
			
			res = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD" + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
				if(pstm!= null) pstm.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR LAS CONEXIONES" + e.getMessage());
			}
		}
		
		return res;
	}
	
	public int eliminarUsuario(int codUsuario) {
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_usuario where codigo_user = ? ";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, codUsuario);
			
			res = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD" + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
				if(pstm!= null) pstm.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR LAS CONEXIONES" + e.getMessage());
			}
		}
		
		return res;
	}
	
	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_usuario";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				
				Usuario user = new Usuario(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getInt(7),
						res.getString(8)
						);
				list.add(user);
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
	
	public Usuario validarAcceso (String usuario, String clave) {
		
		Usuario user = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_usuario where usuario_user = ? and clave_user = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, usuario);
			pstm.setString(2,clave);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				
				user = new Usuario(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getInt(7),
						res.getString(8)
						);
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
		
		
		return user;
	}
	
}
