package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class MaterialAyudaDTO implements Serializable {

	private static final long serialVersionUID = 7147275791100384024L;
	
	private int idMaterialAyudaXPartida;
	private String nombreMaterialAyuda;
	private String nombreResponsableInsumo;
	private String observaciones;
	
	
	public int getIdMaterialAyudaXPartida() {
		return idMaterialAyudaXPartida;
	}
	public void setIdMaterialAyudaXPartida(int idMaterialAyudaXPartida) {
		this.idMaterialAyudaXPartida = idMaterialAyudaXPartida;
	}
	public String getNombreMaterialAyuda() {
		return nombreMaterialAyuda;
	}
	public void setNombreMaterialAyuda(String nombreMaterialAyuda) {
		this.nombreMaterialAyuda = nombreMaterialAyuda;
	}
	public String getNombreResponsableInsumo() {
		return nombreResponsableInsumo;
	}
	public void setNombreResponsableInsumo(String nombreResponsableInsumo) {
		this.nombreResponsableInsumo = nombreResponsableInsumo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
