package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CalificacionPartidaDTO implements Serializable {

	private static final long serialVersionUID = -2070847079408219671L;
	
	private	int	cantidad;
	private double partidaCosteTotal;
	private double impresionPartidaCosteTotal;
	private double procesosPartidaCosteTotal;
	// campos utilizados en pantalla
	private String nombreTipoTrabajo;
	private String nombrePartida;
	private	String descripcionPartida;
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPartidaCosteTotal() {
		return partidaCosteTotal;
	}
	public void setPartidaCosteTotal(double partidaCosteTotal) {
		this.partidaCosteTotal = partidaCosteTotal;
	}
	public double getImpresionPartidaCosteTotal() {
		return impresionPartidaCosteTotal;
	}
	public void setImpresionPartidaCosteTotal(double impresionPartidaCosteTotal) {
		this.impresionPartidaCosteTotal = impresionPartidaCosteTotal;
	}
	public double getProcesosPartidaCosteTotal() {
		return procesosPartidaCosteTotal;
	}
	public void setProcesosPartidaCosteTotal(double procesosPartidaCosteTotal) {
		this.procesosPartidaCosteTotal = procesosPartidaCosteTotal;
	}
	public String getNombreTipoTrabajo() {
		return nombreTipoTrabajo;
	}
	public void setNombreTipoTrabajo(String nombreTipoTrabajo) {
		this.nombreTipoTrabajo = nombreTipoTrabajo;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
}
