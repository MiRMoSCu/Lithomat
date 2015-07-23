package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class UnidadMedida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3929040944657374129L;
	
	private int idUnidadMedida;
	private String descripcion;
	private boolean activo;
	
	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
