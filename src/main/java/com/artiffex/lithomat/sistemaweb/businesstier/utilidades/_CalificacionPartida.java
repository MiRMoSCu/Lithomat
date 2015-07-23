package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class _CalificacionPartida implements Serializable {
	
	// NO EXISTE UNA TABLA EN LA BD CON ESTA DESCRIPCION
	// PERO ES NECESARIA PARA:
	// la descripcion que se genera al dar click en el "arbol" resultado de cotizar
	
	private static final long serialVersionUID = 5915497637290292092L;
	
	private String	nombreTipoTrabajo;
	private String	nombrePartida;
	private	int		cantidad;
	private	String	descripcionPartida;
	private float	costeTotal;
	
	
	public String getNombreTipoTrabajo() {
		return nombreTipoTrabajo;
	}
	public void setNombreTipoTrabajo(String nombreTipoTrabajo) {
		this.nombreTipoTrabajo = nombreTipoTrabajo;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
	public float getCosteTotal() {
		return costeTotal;
	}
	public void setCosteTotal(float costeTotal) {
		this.costeTotal = costeTotal;
	}
	
}
