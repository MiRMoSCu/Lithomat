package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CalificacionProcesosDTO implements Serializable {
	
	private static final long serialVersionUID = 6788821796028514223L;
	
	private int idCalificacionPartida;
	private double procesosPartidaCosteTotal;
	private double disenioCosteTotal;
	private double preprensaCosteTotal;
	private double transporteCosteTotal;
	private double acabadoCosteTotal;
	private double offsetCosteTotal;
	private boolean activo;
	// campos para transferir informacion
	private String htmlTablaCostosExtras;
	private String htmlTablaProcesosDisenio;
	private String htmlTablaProcesosPreprensa;
	private String htmlTablaProcesosTransporte;
	private String htmlTablaProcesosAcabado;
	
	
	public int getIdCalificacionPartida() {
		return idCalificacionPartida;
	}
	public void setIdCalificacionPartida(int idCalificacionPartida) {
		this.idCalificacionPartida = idCalificacionPartida;
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
	public String getHtmlTablaCostosExtras() {
		return htmlTablaCostosExtras;
	}
	public void setHtmlTablaCostosExtras(String htmlTablaCostosExtras) {
		this.htmlTablaCostosExtras = htmlTablaCostosExtras;
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
