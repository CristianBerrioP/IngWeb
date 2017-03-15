package com.edu.udea.iw.DAO;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.udea.iw.DAO.CiudadDAO;
import com.udea.iw.DAO.imp.CiudadDAOImp;
import com.udea.iw.DTO.Ciudad;
import com.udea.iw.Exception.ReizzelException;

public class ReizzelTest {
	@Test
	public void testObtener() {
		//Test para el metodo obtener()
		CiudadDAOImp ciudadDao = null;
		List<Ciudad> lista = null; //En lista se guardara el query
		
		try {
			ciudadDao = new CiudadDAOImp(); //Se usa la interfaz para crear el objeto
			lista = ciudadDao.obtener();
			assertTrue(lista.size()>0);  //Envia solo si se obtienen datos
		}catch(ReizzelException e) {
			e.printStackTrace(); //Envia el error a consola
			fail(e.getMessage());  //Mensaje de error
		}
	}
}
