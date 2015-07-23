package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class DisenioDetalle implements Serializable {
	
	private static final long serialVersionUID = -854374610272517582L;

	private int idDisenioDetalle;
	private Disenio disenio;
	private ProcesoDisenio procesoDisenio;
	private int cantidad;
	private String especificaciones;
	private float precioTotalPesos;
	private boolean activo;
	
	
	public int getIdDisenioDetalle() {
		return idDisenioDetalle;
	}
	public void setIdDisenioDetalle(int idDisenioDetalle) {
		this.idDisenioDetalle = idDisenioDetalle;
	}
	public Disenio getDisenio() {
		return disenio;
	}
	public void setDisenio(Disenio disenio) {
		this.disenio = disenio;
	}
	public ProcesoDisenio getProcesoDisenio() {
		return procesoDisenio;
	}
	public void setProcesoDisenio(ProcesoDisenio procesoDisenio) {
		this.procesoDisenio = procesoDisenio;
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
