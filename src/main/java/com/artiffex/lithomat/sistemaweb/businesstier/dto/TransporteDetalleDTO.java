package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class TransporteDetalleDTO implements Serializable {

	private static final long serialVersionUID = -6079530378441348136L;
	
	public String nombreProcesoTransporte;
	public int cantidad;
	public String especificaciones;
	
	
	public String getNombreProcesoTransporte() {
		return nombreProcesoTransporte;
	}
	public void setNombreProcesoTransporte(String nombreProcesoTransporte) {
		this.nombreProcesoTransporte = nombreProcesoTransporte;
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
