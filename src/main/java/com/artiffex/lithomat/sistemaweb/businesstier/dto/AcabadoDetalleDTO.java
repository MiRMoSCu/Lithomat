package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class AcabadoDetalleDTO implements Serializable {

	private static final long serialVersionUID = -1689038154495118052L;
	
	public String nombreProcesoAcabado;
	public String nombreProveedor;
	public int cantidad;
	public String especificaciones;
	
	
	public String getNombreProcesoAcabado() {
		return nombreProcesoAcabado;
	}
	public void setNombreProcesoAcabado(String nombreProcesoAcabado) {
		this.nombreProcesoAcabado = nombreProcesoAcabado;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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
