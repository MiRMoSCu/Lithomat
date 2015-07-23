package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProcesoDisenio implements Serializable {

	private static final long serialVersionUID = 1964776113428071198L;

	private int idProcesoDisenio;
	private String nombreProceso;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<DisenioDetalle> disenioDetalle = new HashSet<DisenioDetalle>();
	
	
	public int getIdProcesoDisenio() {
		return idProcesoDisenio;
	}
	public void setIdProcesoDisenio(int idProcesoDisenio) {
		this.idProcesoDisenio = idProcesoDisenio;
	}
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
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
	public Set<DisenioDetalle> getDisenioDetalle() {
		return disenioDetalle;
	}
	public void setDisenioDetalle(Set<DisenioDetalle> disenioDetalle) {
		this.disenioDetalle = disenioDetalle;
	}
	
}
