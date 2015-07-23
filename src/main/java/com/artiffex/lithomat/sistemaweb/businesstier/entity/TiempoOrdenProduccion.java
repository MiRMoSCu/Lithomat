package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

import java.sql.Timestamp;

public class TiempoOrdenProduccion implements Serializable {

	private static final long serialVersionUID = -2567643539257036317L;

	private int idTiempoOrdenProduccion;
	private int idOrdenProduccion;
	private Timestamp fechaRecepcion;
	private Timestamp fechaInicio;
	private Timestamp fechaTermino;
	private Timestamp fechaEntrega;
	private boolean activo;
	
	
	public int getIdTiempoOrdenProduccion() {
		return idTiempoOrdenProduccion;
	}
	public void setIdTiempoOrdenProduccion(int idTiempoOrdenProduccion) {
		this.idTiempoOrdenProduccion = idTiempoOrdenProduccion;
	}
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Timestamp getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Timestamp fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
