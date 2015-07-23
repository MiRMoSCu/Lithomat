package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProcesoExterno implements Serializable {

	private static final long serialVersionUID = 2260094603323488311L;

	private int idProcesoExterno;
	private ProveedorExterno proveedorExterno;
	private String nombreProceso;
	private String observaciones;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<AcabadoDetalle> acabadoDetalle = new HashSet<AcabadoDetalle>();
	
	
	public int getIdProcesoExterno() {
		return idProcesoExterno;
	}
	public void setIdProcesoExterno(int idProcesoExterno) {
		this.idProcesoExterno = idProcesoExterno;
	}
	public ProveedorExterno getProveedorExterno() {
		return proveedorExterno;
	}
	public void setProveedorExterno(ProveedorExterno proveedorExterno) {
		this.proveedorExterno = proveedorExterno;
	}
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	public Set<AcabadoDetalle> getAcabadoDetalle() {
		return acabadoDetalle;
	}
	public void setAcabadoDetalle(Set<AcabadoDetalle> acabadoDetalle) {
		this.acabadoDetalle = acabadoDetalle;
	}
	
}
