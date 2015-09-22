package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CostoExtra implements Serializable {

	private static final long serialVersionUID = -2060284715195512325L;

	private int idCostoExtra;
	private String nombre;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<CostoExtraDetalle> costoExtraDetalle = new HashSet<CostoExtraDetalle>();
	
	
	public int getIdCostoExtra() {
		return idCostoExtra;
	}
	public void setIdCostoExtra(int idCostoExtra) {
		this.idCostoExtra = idCostoExtra;
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
	public Set<CostoExtraDetalle> getCostoExtraDetalle() {
		return costoExtraDetalle;
	}
	public void setCostoExtraDetalle(Set<CostoExtraDetalle> costoExtraDetalle) {
		this.costoExtraDetalle = costoExtraDetalle;
	}
}
