package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class TintaEspecial implements Serializable {

	private static final long serialVersionUID = -1716223246586585210L;

	private int idTintaEspecial;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	
	
	public int getIdTintaEspecial() {
		return idTintaEspecial;
	}
	public void setIdTintaEspecial(int idTintaEspecial) {
		this.idTintaEspecial = idTintaEspecial;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
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
