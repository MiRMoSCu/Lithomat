package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class PreprensaDetalle implements Serializable {

	private static final long serialVersionUID = -2703826178092667872L;

	private int idPreprensaDetalle;
	private Preprensa preprensa;
	private ProcesoPreprensa procesoPreprensa;
	private int cantidad;
	private String especificaciones;
	private float precioTotalPesos;
	private boolean activo;
	
	
	public int getIdPreprensaDetalle() {
		return idPreprensaDetalle;
	}
	public void setIdPreprensaDetalle(int idPreprensaDetalle) {
		this.idPreprensaDetalle = idPreprensaDetalle;
	}
	public Preprensa getPreprensa() {
		return preprensa;
	}
	public void setPreprensa(Preprensa preprensa) {
		this.preprensa = preprensa;
	}
	public ProcesoPreprensa getProcesoPreprensa() {
		return procesoPreprensa;
	}
	public void setProcesoPreprensa(ProcesoPreprensa procesoPreprensa) {
		this.procesoPreprensa = procesoPreprensa;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	public float getPrecioTotalPesos() {
		return precioTotalPesos;
	}
	public void setPrecioTotalPesos(float precioTotalPesos) {
		this.precioTotalPesos = precioTotalPesos;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
