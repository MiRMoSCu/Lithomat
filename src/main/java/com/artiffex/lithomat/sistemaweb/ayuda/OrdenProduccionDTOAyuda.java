package com.artiffex.lithomat.sistemaweb.ayuda;

import java.io.Serializable;

public class OrdenProduccionDTOAyuda implements Serializable {
	
	private static final long serialVersionUID = 3617712322700987548L;
	
	public int idOrdenProduccion;
	public String nut;
	public String nombre;
	public String descripcion;
	
	
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
