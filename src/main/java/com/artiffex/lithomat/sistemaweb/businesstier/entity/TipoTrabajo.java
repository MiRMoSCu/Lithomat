package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoTrabajo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6437763219181469292L;
	
	private int idTipoTrabajo;
	private String nombre;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<Partida> partida = new HashSet<Partida>();
	
	
	public int getIdTipoTrabajo() {
		return idTipoTrabajo;
	}
	public void setIdTipoTrabajo(int idTipoTrabajo) {
		this.idTipoTrabajo = idTipoTrabajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
