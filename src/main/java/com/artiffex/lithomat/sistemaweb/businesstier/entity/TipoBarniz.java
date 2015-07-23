package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoBarniz implements Serializable {

	private static final long serialVersionUID = 7771396170514593047L;

	private int idTipoBarniz;
	private String descripcion;
	private int numEntradasMaquina;
	private int numPlacas;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	
	
	public int getIdTipoBarniz() {
		return idTipoBarniz;
	}
	public void setIdTipoBarniz(int idTipoBarniz) {
		this.idTipoBarniz = idTipoBarniz;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumEntradasMaquina() {
		return numEntradasMaquina;
	}
	public void setNumEntradasMaquina(int numEntradasMaquina) {
		this.numEntradasMaquina = numEntradasMaquina;
	}
	public int getNumPlacas() {
		return numPlacas;
	}
	public void setNumPlacas(int numPlacas) {
		this.numPlacas = numPlacas;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public TipoPrecio getTipoPrecio() {
		return tipoPrecio;
	}
	public void setTipoPrecio(TipoPrecio tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
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
