package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProcesoTransporte implements Serializable {

	private static final long serialVersionUID = 2200489616134738314L;

	private int idProcesoTransporte;
	private String nombreProceso;
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TransporteDetalle> transporteDetalle = new HashSet<TransporteDetalle>();
	
	
	public int getIdProcesoTransporte() {
		return idProcesoTransporte;
	}
	public void setIdProcesoTransporte(int idProcesoTransporte) {
		this.idProcesoTransporte = idProcesoTransporte;
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
	public Set<TransporteDetalle> getTransporteDetalle() {
		return transporteDetalle;
	}
	public void setTransporteDetalle(Set<TransporteDetalle> transporteDetalle) {
		this.transporteDetalle = transporteDetalle;
	}
	
}
