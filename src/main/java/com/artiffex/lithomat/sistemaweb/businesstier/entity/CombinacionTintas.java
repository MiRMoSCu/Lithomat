package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CombinacionTintas implements Serializable {

	private static final long serialVersionUID = -222347391310671323L;

	private int idCombinacionTintas;
	private int numTintas;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> frenteTipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	private Set<TipoTrabajoDetalle> vueltaTipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	
	
	public int getIdCombinacionTintas() {
		return idCombinacionTintas;
	}
	public void setIdCombinacionTintas(int idCombinacionTintas) {
		this.idCombinacionTintas = idCombinacionTintas;
	}
	public int getNumTintas() {
		return numTintas;
	}
	public void setNumTintas(int numTintas) {
		this.numTintas = numTintas;
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
	public Set<TipoTrabajoDetalle> getFrenteTipoTrabajoDetalle() {
		return frenteTipoTrabajoDetalle;
	}
	public void setFrenteTipoTrabajoDetalle(
			Set<TipoTrabajoDetalle> frenteTipoTrabajoDetalle) {
		this.frenteTipoTrabajoDetalle = frenteTipoTrabajoDetalle;
	}
	public Set<TipoTrabajoDetalle> getVueltaTipoTrabajoDetalle() {
		return vueltaTipoTrabajoDetalle;
	}
	public void setVueltaTipoTrabajoDetalle(
			Set<TipoTrabajoDetalle> vueltaTipoTrabajoDetalle) {
		this.vueltaTipoTrabajoDetalle = vueltaTipoTrabajoDetalle;
	}
}
