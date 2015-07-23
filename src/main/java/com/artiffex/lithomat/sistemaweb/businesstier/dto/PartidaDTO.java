package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class PartidaDTO implements Serializable {
	
	
	private static final long serialVersionUID = 5190699278728808218L;
	
	private int idPartida;
	private int idTipoTrabajo;
	private String nombrePartida;
	private int cantidad;
	private String nombreTipoFormaTrabajo;
	private String descripcionPartida;
	private String observacionesGenerales;
	private String observacionesAprobacion;
	
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public int getIdTipoTrabajo() {
		return idTipoTrabajo;
	}
	public void setIdTipoTrabajo(int idTipoTrabajo) {
		this.idTipoTrabajo = idTipoTrabajo;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreTipoFormaTrabajo() {
		return nombreTipoFormaTrabajo;
	}
	public void setNombreTipoFormaTrabajo(String nombreTipoFormaTrabajo) {
		this.nombreTipoFormaTrabajo = nombreTipoFormaTrabajo;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}
	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}
	public String getObservacionesAprobacion() {
		return observacionesAprobacion;
	}
	public void setObservacionesAprobacion(String observacionesAprobacion) {
		this.observacionesAprobacion = observacionesAprobacion;
	}
	
}
