package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoVuelta implements Serializable {

	private static final long serialVersionUID = -2345973103432316108L;

	private int idTipoVuelta;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<Pliego> pliego = new HashSet<Pliego>();
	
	
	public int getIdTipoVuelta() {
		return idTipoVuelta;
	}
	public void setIdTipoVuelta(int idTipoVuelta) {
		this.idTipoVuelta = idTipoVuelta;
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
	public Set<Pliego> getPliego() {
		return pliego;
	}
	public void setPliego(Set<Pliego> pliego) {
		this.pliego = pliego;
	}

}
