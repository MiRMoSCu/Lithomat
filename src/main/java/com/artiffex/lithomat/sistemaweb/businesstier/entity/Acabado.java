package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Acabado implements Serializable {

	private static final long serialVersionUID = -4889707082448849592L;

	private int idAcabado;
	private Partida partida;
	private String indicacionTareaRealizar;
	private String resumenEntendidoRealizar;
	private String materialesRecibe;
	private String observaciones;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private Timestamp fechaGeneracion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<AcabadoDetalle> acabadoDetalle = new HashSet<AcabadoDetalle>();
	
	public int getIdAcabado() {
		return idAcabado;
	}
	public void setIdAcabado(int idAcabado) {
		this.idAcabado = idAcabado;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public String getIndicacionTareaRealizar() {
		return indicacionTareaRealizar;
	}
	public void setIndicacionTareaRealizar(String indicacionTareaRealizar) {
		this.indicacionTareaRealizar = indicacionTareaRealizar;
	}
	public String getResumenEntendidoRealizar() {
		return resumenEntendidoRealizar;
	}
	public void setResumenEntendidoRealizar(String resumenEntendidoRealizar) {
		this.resumenEntendidoRealizar = resumenEntendidoRealizar;
	}
	public String getMaterialesRecibe() {
		return materialesRecibe;
	}
	public void setMaterialesRecibe(String materialesRecibe) {
		this.materialesRecibe = materialesRecibe;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Timestamp getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Timestamp fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<AcabadoDetalle> getAcabadoDetalle() {
		return acabadoDetalle;
	}
	public void setAcabadoDetalle(Set<AcabadoDetalle> acabadoDetalle) {
		this.acabadoDetalle = acabadoDetalle;
	}
	
}
