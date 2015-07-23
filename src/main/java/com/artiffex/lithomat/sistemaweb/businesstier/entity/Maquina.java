package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Maquina implements Serializable {

	private static final long serialVersionUID = 7964240048697226207L;

	private int idMaquina;
	private String nombre;
	private String descripcion;
	private int numColores;
	private int anchoPlaca;
	private int altoPlaca;
	private int anchoMaxPapel;
	private int altoMaxPapel;
	private int anchoMinPapel;
	private int altoMinPapel;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	private Set<TipoPlaca> tipoPlaca = new HashSet<TipoPlaca>();
	private Set<TabuladorPrecios> tabuladorPrecios = new HashSet<TabuladorPrecios>();
	private Set<CalendarioOrdenProduccion> calendarioOrdenProduccion = new HashSet<CalendarioOrdenProduccion>();
	private Set<FechaPrensistaMaquina> fechaPrensistaMaquina = new HashSet<FechaPrensistaMaquina>();
	
	
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumColores() {
		return numColores;
	}
	public void setNumColores(int numColores) {
		this.numColores = numColores;
	}
	public int getAnchoPlaca() {
		return anchoPlaca;
	}
	public void setAnchoPlaca(int anchoPlaca) {
		this.anchoPlaca = anchoPlaca;
	}
	public int getAltoPlaca() {
		return altoPlaca;
	}
	public void setAltoPlaca(int altoPlaca) {
		this.altoPlaca = altoPlaca;
	}
	public int getAnchoMaxPapel() {
		return anchoMaxPapel;
	}
	public void setAnchoMaxPapel(int anchoMaxPapel) {
		this.anchoMaxPapel = anchoMaxPapel;
	}
	public int getAltoMaxPapel() {
		return altoMaxPapel;
	}
	public void setAltoMaxPapel(int altoMaxPapel) {
		this.altoMaxPapel = altoMaxPapel;
	}
	public int getAnchoMinPapel() {
		return anchoMinPapel;
	}
	public void setAnchoMinPapel(int anchoMinPapel) {
		this.anchoMinPapel = anchoMinPapel;
	}
	public int getAltoMinPapel() {
		return altoMinPapel;
	}
	public void setAltoMinPapel(int altoMinPapel) {
		this.altoMinPapel = altoMinPapel;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<TipoTrabajoDetalle> getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(Set<TipoTrabajoDetalle> tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}
	public Set<TipoPlaca> getTipoPlaca() {
		return tipoPlaca;
	}
	public void setTipoPlaca(Set<TipoPlaca> tipoPlaca) {
		this.tipoPlaca = tipoPlaca;
	}
	public Set<TabuladorPrecios> getTabuladorPrecios() {
		return tabuladorPrecios;
	}
	public void setTabuladorPrecios(Set<TabuladorPrecios> tabuladorPrecios) {
		this.tabuladorPrecios = tabuladorPrecios;
	}
	public Set<CalendarioOrdenProduccion> getCalendarioOrdenProduccion() {
		return calendarioOrdenProduccion;
	}
	public void setCalendarioOrdenProduccion(
			Set<CalendarioOrdenProduccion> calendarioOrdenProduccion) {
		this.calendarioOrdenProduccion = calendarioOrdenProduccion;
	}
	public Set<FechaPrensistaMaquina> getFechaPrensistaMaquina() {
		return fechaPrensistaMaquina;
	}
	public void setFechaPrensistaMaquina(
			Set<FechaPrensistaMaquina> fechaPrensistaMaquina) {
		this.fechaPrensistaMaquina = fechaPrensistaMaquina;
	}
	
}
