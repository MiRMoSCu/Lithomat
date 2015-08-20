package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoComplejidad implements Serializable {

	private static final long serialVersionUID = 2955536842599911930L;
	
	private int idTipoComplejidad;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	
	
	public int getIdTipoComplejidad() {
		return idTipoComplejidad;
	}
	public void setIdTipoComplejidad(int idTipoComplejidad) {
		this.idTipoComplejidad = idTipoComplejidad;
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
	public Set<TipoTrabajoDetalle> getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(Set<TipoTrabajoDetalle> tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}
	
}
