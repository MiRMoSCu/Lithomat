package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CostosExtrasDetalle implements Serializable {
	
	private static final long serialVersionUID = -2491101489030489130L;

	private int idCostosExtrasDetalle;
	private Partida partida;
	private CostosExtras costosExtras;
	private int cantidad;
	private String especificaciones;
	private float precioTotalPesos;
	private boolean activo;
	
	
	public int getIdCostosExtrasDetalle() {
		return idCostosExtrasDetalle;
	}
	public void setIdCostosExtrasDetalle(int idCostosExtrasDetalle) {
		this.idCostosExtrasDetalle = idCostosExtrasDetalle;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public CostosExtras getCostosExtras() {
		return costosExtras;
	}
	public void setCostosExtras(CostosExtras costosExtras) {
		this.costosExtras = costosExtras;
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
