package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class TransporteDetalle implements Serializable {

	private static final long serialVersionUID = -1273204496679599115L;

	private int idTransporteDetalle;
	private Transporte transporte;
	private ProcesoTransporte procesoTransporte;
	private int cantidad;
	private String especificaciones;
	private float precioTotalPesos;
	private boolean activo;
	
	
	public int getIdTransporteDetalle() {
		return idTransporteDetalle;
	}
	public void setIdTransporteDetalle(int idTransporteDetalle) {
		this.idTransporteDetalle = idTransporteDetalle;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public ProcesoTransporte getProcesoTransporte() {
		return procesoTransporte;
	}
	public void setProcesoTransporte(ProcesoTransporte procesoTransporte) {
		this.procesoTransporte = procesoTransporte;
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
