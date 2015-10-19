package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class DisenioDetalleDTO implements Serializable {
	
	private static final long serialVersionUID = 2259177655628112979L;
	
	public String nombreProcesoDisenio;
	public int cantidad;
	public String especificaciones;
	
	
	public String getNombreProcesoDisenio() {
		return nombreProcesoDisenio;
	}
	public void setNombreProcesoDisenio(String nombreProcesoDisenio) {
		this.nombreProcesoDisenio = nombreProcesoDisenio;
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
