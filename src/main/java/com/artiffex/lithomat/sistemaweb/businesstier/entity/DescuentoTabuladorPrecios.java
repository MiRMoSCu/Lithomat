package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class DescuentoTabuladorPrecios implements Serializable {

	private static final long serialVersionUID = 3390369717520769035L;
	
	private int idDescuentoTabuladorPrecios;
	private TipoTrabajoDetalle tipoTrabajoDetalle;
	private float precioTabulador;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	
	
	public int getIdDescuentoTabuladorPrecios() {
		return idDescuentoTabuladorPrecios;
	}
	public void setIdDescuentoTabuladorPrecios(int idDescuentoTabuladorPrecios) {
		this.idDescuentoTabuladorPrecios = idDescuentoTabuladorPrecios;
	}
	public TipoTrabajoDetalle getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}
	public float getPrecioTabulador() {
		return precioTabulador;
	}
	public void setPrecioTabulador(float precioTabulador) {
		this.precioTabulador = precioTabulador;
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
}
