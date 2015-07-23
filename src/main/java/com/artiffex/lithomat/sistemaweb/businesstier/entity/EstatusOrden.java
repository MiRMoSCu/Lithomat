package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class EstatusOrden implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8857090089647966837L;
	
	private int idEstatusOrden;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<HistorialEstatus> historialEstatus = new HashSet<HistorialEstatus>();
	
	
	public int getIdEstatusOrden() {
		return idEstatusOrden;
	}
	public void setIdEstatusOrden(int idEstatusOrden) {
		this.idEstatusOrden = idEstatusOrden;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<HistorialEstatus> getHistorialEstatus() {
		return historialEstatus;
	}
	public void setHistorialEstatus(Set<HistorialEstatus> historialEstatus) {
		this.historialEstatus = historialEstatus;
	}
}
