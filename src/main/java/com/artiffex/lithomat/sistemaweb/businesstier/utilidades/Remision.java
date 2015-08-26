package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class Remision implements Serializable {

	private static final long serialVersionUID = -2348656573688879379L;
	
	private String nombre;
	private double gananciaClientePorcentaje;
	private double costeTotalProcesosPartida;
	private double subpartidasCosteTotal;
	private double disenioCosteTotal;
	private double preprensaCosteTotal;
	private double transporteCosteTotal;
	private double acabadoCosteTotal;
	private double offsetCosteTotal;
	private double costoExtraTotal;
	private List<_CalificacionTrabajoDetalle> listaCalificacionTrabajoDetalle;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getGananciaClientePorcentaje() {
		return gananciaClientePorcentaje;
	}
	public void setGananciaClientePorcentaje(double gananciaClientePorcentaje) {
		this.gananciaClientePorcentaje = gananciaClientePorcentaje;
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
	public List<_CalificacionTrabajoDetalle> getListaCalificacionTrabajoDetalle() {
		return listaCalificacionTrabajoDetalle;
	}
	public void setListaCalificacionTrabajoDetalle(
			List<_CalificacionTrabajoDetalle> listaCalificacionTrabajoDetalle) {
		this.listaCalificacionTrabajoDetalle = listaCalificacionTrabajoDetalle;
	}
	
}
