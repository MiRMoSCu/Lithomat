package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class FechaPrensistaMaquinaDTOGrid implements Serializable {

	private static final long serialVersionUID = 5382464768526885107L;
	
	private String nut;
	private String nombreOrdenProduccion;
	private String nombrePartida;
	private String descripcionTipoTrabajoDetalle;
	private Integer idPliego;
	private Integer noPliego;
	private Integer hojasRequeridas;
	
	
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getNombreOrdenProduccion() {
		return nombreOrdenProduccion;
	}
	public void setNombreOrdenProduccion(String nombreOrdenProduccion) {
		this.nombreOrdenProduccion = nombreOrdenProduccion;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public String getDescripcionTipoTrabajoDetalle() {
		return descripcionTipoTrabajoDetalle;
	}
	public void setDescripcionTipoTrabajoDetalle(
			String descripcionTipoTrabajoDetalle) {
		this.descripcionTipoTrabajoDetalle = descripcionTipoTrabajoDetalle;
	}
	public Integer getIdPliego() {
		return idPliego;
	}
	public void setIdPliego(Integer idPliego) {
		this.idPliego = idPliego;
	}
	public Integer getNoPliego() {
		return noPliego;
	}
	public void setNoPliego(Integer noPliego) {
		this.noPliego = noPliego;
	}
	public Integer getHojasRequeridas() {
		return hojasRequeridas;
	}
	public void setHojasRequeridas(Integer hojasRequeridas) {
		this.hojasRequeridas = hojasRequeridas;
	}
}
