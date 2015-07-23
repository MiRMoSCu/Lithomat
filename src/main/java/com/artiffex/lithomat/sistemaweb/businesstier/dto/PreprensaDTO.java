package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class PreprensaDTO implements Serializable {
	
	private static final long serialVersionUID = 8669657703569779509L;
	
	private int idPreprensa;
	private String indicacionTareaRealizar;
	private String materialesRecibe;
	private String observaciones;
	
	
	public int getIdPreprensa() {
		return idPreprensa;
	}
	public void setIdPreprensa(int idPreprensa) {
		this.idPreprensa = idPreprensa;
	}
	public String getIndicacionTareaRealizar() {
		return indicacionTareaRealizar;
	}
	public void setIndicacionTareaRealizar(String indicacionTareaRealizar) {
		this.indicacionTareaRealizar = indicacionTareaRealizar;
	}
	public String getMaterialesRecibe() {
		return materialesRecibe;
	}
	public void setMaterialesRecibe(String materialesRecibe) {
		this.materialesRecibe = materialesRecibe;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
