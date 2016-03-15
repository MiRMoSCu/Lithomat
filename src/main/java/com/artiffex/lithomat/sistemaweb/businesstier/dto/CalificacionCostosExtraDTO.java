package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CalificacionCostosExtraDTO implements Serializable {

	private static final long serialVersionUID = 7845768110141369944L;
	
	private int idCostoExtraDetalle;
	private double costosExtraCosteTotal;
	private boolean activo;
	// campos para transferir informacion
	private String htmlTablaCostosExtra;
	
	
	public int getIdCostoExtraDetalle() {
		return idCostoExtraDetalle;
	}
	public void setIdCostoExtraDetalle(int idCostoExtraDetalle) {
		this.idCostoExtraDetalle = idCostoExtraDetalle;
	}
	public double getCostosExtraCosteTotal() {
		return costosExtraCosteTotal;
	}
	public void setCostosExtraCosteTotal(double costosExtraCosteTotal) {
		this.costosExtraCosteTotal = costosExtraCosteTotal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getHtmlTablaCostosExtra() {
		return htmlTablaCostosExtra;
	}
	public void setHtmlTablaCostosExtra(String htmlTablaCostosExtra) {
		this.htmlTablaCostosExtra = htmlTablaCostosExtra;
	}
}
