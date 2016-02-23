package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class FechaPrensistaMaquinaDTOGrid implements Serializable {

	private static final long serialVersionUID = 5382464768526885107L;
	
	private String nut;
	private String nombreOrdenProduccion;
	private String nombrePartida;
	private String descripcionTipoTrabajoDetalle;
	private int idPliego;
	private int noPliego;
	private int hojasRequeridas;
	private int hojasSobrantes;
	private int hojasTotales;
	
	
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
	public int getIdPliego() {
		return idPliego;
	}
	public void setIdPliego(int idPliego) {
		this.idPliego = idPliego;
	}
	public int getNoPliego() {
		return noPliego;
	}
	public void setNoPliego(int noPliego) {
		this.noPliego = noPliego;
	}
	public int getHojasRequeridas() {
		return hojasRequeridas;
	}
	public void setHojasRequeridas(int hojasRequeridas) {
		this.hojasRequeridas = hojasRequeridas;
	}
	public int getHojasSobrantes() {
		return hojasSobrantes;
	}
	public void setHojasSobrantes(int hojasSobrantes) {
		this.hojasSobrantes = hojasSobrantes;
	}
	public int getHojasTotales() {
		return hojasTotales;
	}
	public void setHojasTotales(int hojasTotales) {
		this.hojasTotales = hojasTotales;
	}
}
