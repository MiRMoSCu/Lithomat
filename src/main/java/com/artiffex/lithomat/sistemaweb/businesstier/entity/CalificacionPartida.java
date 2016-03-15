package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CalificacionPartida implements Serializable {

	private static final long serialVersionUID = -7877195355320836615L;

	private int idCalificacionPartida;
	private Partida partida;
	private int cantidadOriginal;
	private double partidaCosteTotal;
	private double impresionPartidaCosteTotal;
	private double procesosPartidaCosteTotal;
	private double disenioCosteTotal;
	private double preprensaCosteTotal;
	private double transporteCosteTotal;
	private double acabadoCosteTotal;
	private double offsetCosteTotal;
	private boolean activo;
	
	
	public int getIdCalificacionPartida() {
		return idCalificacionPartida;
	}
	public void setIdCalificacionPartida(int idCalificacionPartida) {
		this.idCalificacionPartida = idCalificacionPartida;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public int getCantidadOriginal() {
		return cantidadOriginal;
	}
	public void setCantidadOriginal(int cantidadOriginal) {
		this.cantidadOriginal = cantidadOriginal;
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
	public double getDisenioCosteTotal() {
		return disenioCosteTotal;
	}
	public void setDisenioCosteTotal(double disenioCosteTotal) {
		this.disenioCosteTotal = disenioCosteTotal;
	}
	public double getPreprensaCosteTotal() {
		return preprensaCosteTotal;
	}
	public void setPreprensaCosteTotal(double preprensaCosteTotal) {
		this.preprensaCosteTotal = preprensaCosteTotal;
	}
	public double getTransporteCosteTotal() {
		return transporteCosteTotal;
	}
	public void setTransporteCosteTotal(double transporteCosteTotal) {
		this.transporteCosteTotal = transporteCosteTotal;
	}
	public double getAcabadoCosteTotal() {
		return acabadoCosteTotal;
	}
	public void setAcabadoCosteTotal(double acabadoCosteTotal) {
		this.acabadoCosteTotal = acabadoCosteTotal;
	}
	public double getOffsetCosteTotal() {
		return offsetCosteTotal;
	}
	public void setOffsetCosteTotal(double offsetCosteTotal) {
		this.offsetCosteTotal = offsetCosteTotal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
