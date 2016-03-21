package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class DescuentoTabuladorPreciosDTO implements Serializable {

	private static final long serialVersionUID = 214234296436262295L;
	
	private int idDescuentoTabuladorPrecios;
	private int idTipoTrabajoDetalle;
	private float precioTabulador;
	private String tipoPrecio;
	private boolean activo;
	
	
	public int getIdDescuentoTabuladorPrecios() {
		return idDescuentoTabuladorPrecios;
	}
	public void setIdDescuentoTabuladorPrecios(int idDescuentoTabuladorPrecios) {
		this.idDescuentoTabuladorPrecios = idDescuentoTabuladorPrecios;
	}
	public int getIdTipoTrabajoDetalle() {
		return idTipoTrabajoDetalle;
	}
	public void setIdTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		this.idTipoTrabajoDetalle = idTipoTrabajoDetalle;
	}
	public float getPrecioTabulador() {
		return precioTabulador;
	}
	public void setPrecioTabulador(float precioTabulador) {
		this.precioTabulador = precioTabulador;
	}
	public String getTipoPrecio() {
		return tipoPrecio;
	}
	public void setTipoPrecio(String tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
