package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class HistorialEstatus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1908614976969295736L;
	
	private int idHistorialEstatus;
	private OrdenProduccion ordenProduccion;
	private EstatusOrden estatusOrden;
	private Timestamp fecha;
	private String observaciones;
	private boolean activo;
	
	
	public int getIdHistorialEstatus() {
		return idHistorialEstatus;
	}
	public void setIdHistorialEstatus(int idHistorialEstatus) {
		this.idHistorialEstatus = idHistorialEstatus;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public EstatusOrden getEstatusOrden() {
		return estatusOrden;
	}
	public void setEstatusOrden(EstatusOrden estatusOrden) {
		this.estatusOrden = estatusOrden;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
