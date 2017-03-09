package com.udea.iw.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.udea.iw.Exception.ReizzelException;

/*Clase encargada de entregar conexiones activas a la base de datos*/
public class DataSource{
	public static Connection getConnection() throws ReizzelException{
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Busca el driver especial para la base de datos, en este caso, mysql
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reizzel","root","root");//Conecta el driver con el localhost/ip y la base de datos correspondiente
		}catch(ClassNotFoundException e){
			throw new ReizzelException("Driver no encontrado");
		}catch(SQLException e){
			throw new ReizzelException("No puede establecer conexion");
		}
		return con;
	}
}

