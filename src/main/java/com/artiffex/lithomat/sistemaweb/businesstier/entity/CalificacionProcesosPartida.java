package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CalificacionProcesosPartida implements Serializable {

	private static final long serialVersionUID = -7877195355320836615L;

	private int idCalificacionProcesosPartida;
	private Partida partida;
	private double costeTotalProcesosPartida;
	private double subpartidasCosteTotal;
	private double disenioCosteTotal;
	private double preprensaCosteTotal;
	private double transporteCosteTotal;
	private double acabadoCosteTotal;
	private double offsetCosteTotal;
	private double costoExtraTotal;
	private boolean activo;
	
	
	public int getIdCalificacionProcesosPartida() {
		return idCalificacionProcesosPartida;
	}
	public void setIdCalificacionProcesosPartida(int idCalificacionProcesosPartida) {
		this.idCalificacionProcesosPartida = idCalificacionProcesosPartida;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public double getCosteTotalProcesosPartida() {
		return costeTotalProcesosPartida;
	}
	public void setCosteTotalProcesosPartida(double costeTotalProcesosPartida) {
		this.costeTotalProcesosPartida = costeTotalProcesosPartida;
	}
	public double getSubpartidasCosteTotal() {
		return subpartidasCosteTotal;
	}
	public void setSubpartidasCosteTotal(double subpartidasCosteTotal) {
		this.subpartidasCosteTotal = subpartidasCosteTotal;
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
	public double getCostoExtraTotal() {
		return costoExtraTotal;
	}
	public void setCostoExtraTotal(double costoExtraTotal) {
		this.costoExtraTotal = costoExtraTotal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
