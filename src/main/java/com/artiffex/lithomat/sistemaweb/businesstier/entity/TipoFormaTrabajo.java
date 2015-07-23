package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoFormaTrabajo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 803450633665087739L;
	
	private int idTipoFormaTrabajo;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<Partida> partida = new HashSet<Partida>();
	
	
	public int getIdTipoFormaTrabajo() {
		return idTipoFormaTrabajo;
	}
	public void setIdTipoFormaTrabajo(int idTipoFormaTrabajo) {
		this.idTipoFormaTrabajo = idTipoFormaTrabajo;
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
	public Set<Partida> getPartida() {
		return partida;
	}
	public void setPartida(Set<Partida> partida) {
		this.partida = partida;
	}
}
