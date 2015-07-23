package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class TipoFormacion implements Serializable {

	private static final long serialVersionUID = -7787289201461334495L;

	private int idTipoFormacion;
	private String descripcion;
	private int numMultiplo;
	private boolean activo;
	
	
	public int getIdTipoFormacion() {
		return idTipoFormacion;
	}
	public void setIdTipoFormacion(int idTipoFormacion) {
		this.idTipoFormacion = idTipoFormacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumMultiplo() {
		return numMultiplo;
	}
	public void setNumMultiplo(int numMultiplo) {
		this.numMultiplo = numMultiplo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
