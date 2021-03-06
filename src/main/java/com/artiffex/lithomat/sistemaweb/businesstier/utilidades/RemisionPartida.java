package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class RemisionPartida implements Serializable {

	private static final long serialVersionUID = -2348656573688879379L;
	
	private String nombre;
	private int cantidad;
	private double partidaCosteTotal;
	private double procesosPartidaCosteTotal;
	private double disenioCosteTotal;
	private double preprensaCosteTotal;
	private double transporteCosteTotal;
	private double acabadoCosteTotal;
	private double offsetCosteTotal;
	private List<RemisionTrabajoDetalle> listaRemisionTrabajoDetalle;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
	public List<RemisionTrabajoDetalle> getListaRemisionTrabajoDetalle() {
		return listaRemisionTrabajoDetalle;
	}
	public void setListaRemisionTrabajoDetalle(
			List<RemisionTrabajoDetalle> listaRemisionTrabajoDetalle) {
		this.listaRemisionTrabajoDetalle = listaRemisionTrabajoDetalle;
	}
}
