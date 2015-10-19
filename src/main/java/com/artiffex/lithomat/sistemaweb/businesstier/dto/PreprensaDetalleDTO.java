package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class PreprensaDetalleDTO implements Serializable {

	private static final long serialVersionUID = 2658658110188654100L;
	
	public String nombreProcesoPreprensa;
	public int cantidad;
	public String especificaciones;
	
	
	public String getNombreProcesoPreprensa() {
		return nombreProcesoPreprensa;
	}
	public void setNombreProcesoPreprensa(String nombreProcesoPreprensa) {
		this.nombreProcesoPreprensa = nombreProcesoPreprensa;
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
}
