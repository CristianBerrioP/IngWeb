import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReizzelTest {
	public void consultarCiudades(){
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Busca el driver especial para la base de datos, en este caso, mysql
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reizzel","root","root");//Conecta el driver con el localhost/ip y la base de datos correspondiente
			ps = con.prepareStatement("Select * From ciudades");//Se prepara la sentencia sql pero no se envia
			rs = ps.executeQuery();//Se envia y ejecuta la sentencia sql anteriormente preparada
			while(rs.next()){
				System.out.print(rs.getString("codigo")+":"+rs.getString("Nombre"));
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
