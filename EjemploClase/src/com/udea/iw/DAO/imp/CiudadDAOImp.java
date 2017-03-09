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
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try{
			con=DataSource.getConnection();
			ps=con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				lista.add(ciudad);
			}
		}catch(SQLException e){
			throw new ReizzelException ("Error consultando", e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(SQLException e){
				throw new ReizzelException("Error cerrando", e);
			}
		}
		return lista;
	}
}
