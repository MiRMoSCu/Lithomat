package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class AcabadoDTO implements Serializable {

	private static final long serialVersionUID = -2801511171153196956L;
	
	private int idAcabado;
	private String indicacionTareaRealizar;
	private String materialesRecibe;
	private String observaciones;
	
	
	public int getIdAcabado() {
		return idAcabado;
	}
	public void setIdAcabado(int idAcabado) {
		this.idAcabado = idAcabado;
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
