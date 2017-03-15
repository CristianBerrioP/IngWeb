package com.udea.iw.DAO;

import java.util.List;

import com.udea.iw.DTO.Ciudad;
import com.udea.iw.Exception.ReizzelException;
/*
 @author Cristian Berrio
 Version 4.7.1 Eclipse
 */
public interface CiudadDAO {
	/*Devuelve la lista de las ciudades*/
	public List<Ciudad> obtener() throws ReizzelException;
	/*Devuelve la lista de los codigos*/
	public Ciudad obtener(Long codigo) throws ReizzelException;
}
