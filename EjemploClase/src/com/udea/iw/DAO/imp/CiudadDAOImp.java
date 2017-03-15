package com.udea.iw.DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.udea.iw.DAO.CiudadDAO;
import com.udea.iw.DAO.DataSource;
import com.udea.iw.DTO.Ciudad;
import com.udea.iw.Exception.ReizzelException;

public class CiudadDAOImp implements CiudadDAO{
	public List<Ciudad> obtener() throws ReizzelException{
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try {
			//Realiza la conexion por medio del DTO
			con = DataSource.getConnection(); 
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while(rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
						
			}
		}catch (ReizzelException e) {
			throw new ReizzelException("DAO Exception",e);
		}catch (SQLException e) {
			throw new ReizzelException("No se puede establecer la conexion",e);
		}finally {
			try { //Se necesitan cerrar las conexiones
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				throw new ReizzelException("Error cerrando",e);
			}
		}
		return lista;
	}
	public Ciudad obtener(Long codigo) throws ReizzelException{
		Ciudad ciudad = null;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			con = DataSource.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo=?");
			ps.setLong(1, codigo); //Se usa para evitar SQL Injection
			rs= ps.executeQuery();
			if(rs.next()) {
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		}catch(SQLException e){
			System.out.println("No se pudo realizar la conexion");
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ciudad;
		}
		
}
