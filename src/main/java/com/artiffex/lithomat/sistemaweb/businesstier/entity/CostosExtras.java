package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CostosExtras implements Serializable {

	private static final long serialVersionUID = -2060284715195512325L;

	private int idCostosExtras;
	private String nombre;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<CostosExtrasDetalle> costosExtrasDetalle = new HashSet<CostosExtrasDetalle>();
	
	
	public int getIdCostosExtras() {
		return idCostosExtras;
	}
	public void setIdCostosExtras(int idCostosExtras) {
		this.idCostosExtras = idCostosExtras;
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
	public Set<CostosExtrasDetalle> getCostosExtrasDetalle() {
		return costosExtrasDetalle;
	}
	public void setCostosExtrasDetalle(Set<CostosExtrasDetalle> costosExtrasDetalle) {
		this.costosExtrasDetalle = costosExtrasDetalle;
	}
	
}
