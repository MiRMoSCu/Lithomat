package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProcesoPreprensa implements Serializable {

	private static final long serialVersionUID = 3424961758756793050L;

	private int idProcesoPreprensa;
	private String nombreProceso;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<PreprensaDetalle> preprensaDetalle = new HashSet<PreprensaDetalle>();
	
	
	public int getIdProcesoPreprensa() {
		return idProcesoPreprensa;
	}
	public void setIdProcesoPreprensa(int idProcesoPreprensa) {
		this.idProcesoPreprensa = idProcesoPreprensa;
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
	public Set<PreprensaDetalle> getPreprensaDetalle() {
		return preprensaDetalle;
	}
	public void setPreprensaDetalle(Set<PreprensaDetalle> preprensaDetalle) {
		this.preprensaDetalle = preprensaDetalle;
	}

}
