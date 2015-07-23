package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class MaterialAyudaXPartida implements Serializable {

	private static final long serialVersionUID = -4330947587335835603L;

	private int idMaterialAyudaXPartida;
	private Partida partida;
	private MaterialAyuda materialAyuda;
	private ResponsableInsumo responsableInsumo;
	private String observaciones;
	private boolean activo;
	
	
	public int getIdMaterialAyudaXPartida() {
		return idMaterialAyudaXPartida;
	}
	public void setIdMaterialAyudaXPartida(int idMaterialAyudaXPartida) {
		this.idMaterialAyudaXPartida = idMaterialAyudaXPartida;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public MaterialAyuda getMaterialAyuda() {
		return materialAyuda;
	}
	public void setMaterialAyuda(MaterialAyuda materialAyuda) {
		this.materialAyuda = materialAyuda;
	}
	public ResponsableInsumo getResponsableInsumo() {
		return responsableInsumo;
	}
	public void setResponsableInsumo(ResponsableInsumo responsableInsumo) {
		this.responsableInsumo = responsableInsumo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
