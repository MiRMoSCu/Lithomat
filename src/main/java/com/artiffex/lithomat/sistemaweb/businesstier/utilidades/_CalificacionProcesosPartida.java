package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;

public class _CalificacionProcesosPartida implements Serializable {

	private static final long serialVersionUID = 2585102229363074568L;
	
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
	// campos para transferir informacion
	private String htmlTablaProcesosDisenio;
	private String htmlTablaProcesosPreprensa;
	private String htmlTablaProcesosTransporte;
	private String htmlTablaProcesosAcabado;
	
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
	public String getHtmlTablaProcesosDisenio() {
		return htmlTablaProcesosDisenio;
	}
	public void setHtmlTablaProcesosDisenio(String htmlTablaProcesosDisenio) {
		this.htmlTablaProcesosDisenio = htmlTablaProcesosDisenio;
	}
	public String getHtmlTablaProcesosPreprensa() {
		return htmlTablaProcesosPreprensa;
	}
	public void setHtmlTablaProcesosPreprensa(String htmlTablaProcesosPreprensa) {
		this.htmlTablaProcesosPreprensa = htmlTablaProcesosPreprensa;
	}
	public String getHtmlTablaProcesosTransporte() {
		return htmlTablaProcesosTransporte;
	}
	public void setHtmlTablaProcesosTransporte(String htmlTablaProcesosTransporte) {
		this.htmlTablaProcesosTransporte = htmlTablaProcesosTransporte;
	}
	public String getHtmlTablaProcesosAcabado() {
		return htmlTablaProcesosAcabado;
	}
	public void setHtmlTablaProcesosAcabado(String htmlTablaProcesosAcabado) {
		this.htmlTablaProcesosAcabado = htmlTablaProcesosAcabado;
	}
	
}
