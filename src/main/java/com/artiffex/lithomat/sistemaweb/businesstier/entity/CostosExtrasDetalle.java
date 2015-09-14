package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CostosExtrasDetalle implements Serializable {
	
	private static final long serialVersionUID = -2491101489030489130L;

	private int idCostosExtrasDetalle;
	private TipoTrabajoDetalle tipoTrabajoDetalle;
	private ResponsableInsumo responsableInsumo;
	private CostosExtras costosExtras;
	private int cantidad;
	private String especificacion;
	private float precioTotalPesos;
	private boolean activo;
	
	
	public int getIdCostosExtrasDetalle() {
		return idCostosExtrasDetalle;
	}
	public void setIdCostosExtrasDetalle(int idCostosExtrasDetalle) {
		this.idCostosExtrasDetalle = idCostosExtrasDetalle;
	}
	public TipoTrabajoDetalle getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}
	public ResponsableInsumo getResponsableInsumo() {
		return responsableInsumo;
	}
	public void setResponsableInsumo(ResponsableInsumo responsableInsumo) {
		this.responsableInsumo = responsableInsumo;
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
	public String getEspecificacion() {
		return especificacion;
	}
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
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
