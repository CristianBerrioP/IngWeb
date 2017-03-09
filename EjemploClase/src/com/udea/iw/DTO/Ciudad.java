package com.udea.iw.DTO;
/**/
public class Ciudad {
	//Se hacen privados para manipularlos por getters y setters
	private long codigo;
	private String nombre;
	private String codigoArea; //La ciudad tiene un codigo de Area;
	
	/*Getters y setters*/
	public long getCodigo(){
		return this.codigo;
	}
	public void setCodigo(Long cod){
		this.codigo = cod;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nom){
		this.nombre=nom;
	}
	
	public String getCodigoArea(){
		return this.codigoArea;
	}
	public void setCodigoArea(String codA){
		this.codigoArea = codA;
	}
}
