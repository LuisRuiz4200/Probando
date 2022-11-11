package mantenimiento;

<<<<<<< HEAD
<<<<<<< HEAD
public class PedidoDAO {

=======
=======
>>>>>>> 6b3e7f38faffec0049c299d91307d5fbe485128a
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
	
	public int registrarPedido() {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			
			
		}catch(Exception e) {
			
		}finally {
			
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				
			}
			
		}
		
		
		return res;
		
		
	}
	
<<<<<<< HEAD
>>>>>>> 6b3e7f38faffec0049c299d91307d5fbe485128a
=======
>>>>>>> 6b3e7f38faffec0049c299d91307d5fbe485128a
}
