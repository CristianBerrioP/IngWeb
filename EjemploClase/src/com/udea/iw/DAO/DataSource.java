package com.udea.iw.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.udea.iw.Exception.ReizzelException;

/*Esta clase se encarga de enviar las conexiones de las bd*/
public class DataSource{
	private static Connection con;
	private DataSource() {
		System.out.println("DataSource creado");
	}
	private static Connection getConnect() throws ReizzelException { //En el caso del singleton solo es 1 conexion
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudades","root","root");
		}catch(ClassNotFoundException e) {
			throw new ReizzelException("Driver no encontrado", e);
		}catch(SQLException e) {
			throw new ReizzelException("No se puede establecer conexion", e);
		}
		return conn; //Retorna solo 1 conexion
	}
	
	public static Connection getConnection() throws ReizzelException {
		if (con == null) { // Si aun no se ha creado la conexion, se crea y se asigna
				con = getConnect();
			}
		return con; //Retorna solo 1 conexion
		}
}

