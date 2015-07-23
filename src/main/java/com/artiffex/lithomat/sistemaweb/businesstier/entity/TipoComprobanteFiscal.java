package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoComprobanteFiscal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7822434021896082178L;
	
	private int idTipoComprobanteFiscal;
	private String nombre;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno <tipoComprobanteFiscal> a muchos <ordenProduccion>] con las tablas:
	private Set<OrdenProduccion> ordenProduccion = new HashSet<OrdenProduccion>();
	
	
	public int getIdTipoComprobanteFiscal() {
		return idTipoComprobanteFiscal;
	}
	public void setIdTipoComprobanteFiscal(int idTipoComprobanteFiscal) {
		this.idTipoComprobanteFiscal = idTipoComprobanteFiscal;
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
	public Set<OrdenProduccion> getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(Set<OrdenProduccion> ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
}
