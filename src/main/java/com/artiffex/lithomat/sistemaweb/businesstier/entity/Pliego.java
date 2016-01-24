package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Pliego implements Serializable {

	private static final long serialVersionUID = 4965649073027809752L;

	private int idPliego;
	private TipoTrabajoDetalle tipoTrabajoDetalle;
	private int rebaseEnMilimetros;
	private int medianilesEnMilimetros;
	private int pinzasEnMilimetros;
	private String observaciones;
	private float numeroDecimal;
	private int hojasRequeridas;
	private int hojasSobrantes;
	private int hojasTotales;
	private int frenteNumEntradasMaquinaTinta;
	private int frenteNumEntradasMaquinaTintaEspecial;
	private int frenteNumEntradasMaquinaBarniz;
	private int frenteNumTotalPlacas;
	private int vueltaNumEntradasMaquinaTinta;
	private int vueltaNumEntradasMaquinaTintaEspecial;
	private int vueltaNumEntradasMaquinaBarniz;
	private boolean vueltaMismasPlacas;
	private int vueltaNumTotalPlacas;
	private TipoVuelta tipoVuelta;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<FechaPrensistaMaquina> fechaPrensistaMaquina = new HashSet<FechaPrensistaMaquina>();
	private Set<CalendarioOrdenProduccion> calendarioOrdenProduccion = new HashSet<CalendarioOrdenProduccion>();
	private Set<CalificacionPliego> calificacionPliego = new HashSet<CalificacionPliego>();
	
	
	public int getIdPliego() {
		return idPliego;
	}
	public void setIdPliego(int idPliego) {
		this.idPliego = idPliego;
	}
	public TipoTrabajoDetalle getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}
	public int getRebaseEnMilimetros() {
		return rebaseEnMilimetros;
	}
	public void setRebaseEnMilimetros(int rebaseEnMilimetros) {
		this.rebaseEnMilimetros = rebaseEnMilimetros;
	}
	public int getMedianilesEnMilimetros() {
		return medianilesEnMilimetros;
	}
	public void setMedianilesEnMilimetros(int medianilesEnMilimetros) {
		this.medianilesEnMilimetros = medianilesEnMilimetros;
	}
	public int getPinzasEnMilimetros() {
		return pinzasEnMilimetros;
	}
	public void setPinzasEnMilimetros(int pinzasEnMilimetros) {
		this.pinzasEnMilimetros = pinzasEnMilimetros;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public float getNumeroDecimal() {
		return numeroDecimal;
	}
	public void setNumeroDecimal(float numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
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
	public int getFrenteNumEntradasMaquinaTinta() {
		return frenteNumEntradasMaquinaTinta;
	}
	public void setFrenteNumEntradasMaquinaTinta(int frenteNumEntradasMaquinaTinta) {
		this.frenteNumEntradasMaquinaTinta = frenteNumEntradasMaquinaTinta;
	}
	public int getFrenteNumEntradasMaquinaTintaEspecial() {
		return frenteNumEntradasMaquinaTintaEspecial;
	}
	public void setFrenteNumEntradasMaquinaTintaEspecial(
			int frenteNumEntradasMaquinaTintaEspecial) {
		this.frenteNumEntradasMaquinaTintaEspecial = frenteNumEntradasMaquinaTintaEspecial;
	}
	public int getFrenteNumEntradasMaquinaBarniz() {
		return frenteNumEntradasMaquinaBarniz;
	}
	public void setFrenteNumEntradasMaquinaBarniz(int frenteNumEntradasMaquinaBarniz) {
		this.frenteNumEntradasMaquinaBarniz = frenteNumEntradasMaquinaBarniz;
	}
	public int getFrenteNumTotalPlacas() {
		return frenteNumTotalPlacas;
	}
	public void setFrenteNumTotalPlacas(int frenteNumTotalPlacas) {
		this.frenteNumTotalPlacas = frenteNumTotalPlacas;
	}
	public int getVueltaNumEntradasMaquinaTinta() {
		return vueltaNumEntradasMaquinaTinta;
	}
	public void setVueltaNumEntradasMaquinaTinta(int vueltaNumEntradasMaquinaTinta) {
		this.vueltaNumEntradasMaquinaTinta = vueltaNumEntradasMaquinaTinta;
	}
	public int getVueltaNumEntradasMaquinaTintaEspecial() {
		return vueltaNumEntradasMaquinaTintaEspecial;
	}
	public void setVueltaNumEntradasMaquinaTintaEspecial(
			int vueltaNumEntradasMaquinaTintaEspecial) {
		this.vueltaNumEntradasMaquinaTintaEspecial = vueltaNumEntradasMaquinaTintaEspecial;
	}
	public int getVueltaNumEntradasMaquinaBarniz() {
		return vueltaNumEntradasMaquinaBarniz;
	}
	public void setVueltaNumEntradasMaquinaBarniz(int vueltaNumEntradasMaquinaBarniz) {
		this.vueltaNumEntradasMaquinaBarniz = vueltaNumEntradasMaquinaBarniz;
	}
	public boolean isVueltaMismasPlacas() {
		return vueltaMismasPlacas;
	}
	public void setVueltaMismasPlacas(boolean vueltaMismasPlacas) {
		this.vueltaMismasPlacas = vueltaMismasPlacas;
	}
	public int getVueltaNumTotalPlacas() {
		return vueltaNumTotalPlacas;
	}
	public void setVueltaNumTotalPlacas(int vueltaNumTotalPlacas) {
		this.vueltaNumTotalPlacas = vueltaNumTotalPlacas;
	}
	public TipoVuelta getTipoVuelta() {
		return tipoVuelta;
	}
	public void setTipoVuelta(TipoVuelta tipoVuelta) {
		this.tipoVuelta = tipoVuelta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<FechaPrensistaMaquina> getFechaPrensistaMaquina() {
		return fechaPrensistaMaquina;
	}
	public void setFechaPrensistaMaquina(
			Set<FechaPrensistaMaquina> fechaPrensistaMaquina) {
		this.fechaPrensistaMaquina = fechaPrensistaMaquina;
	}
	public Set<CalendarioOrdenProduccion> getCalendarioOrdenProduccion() {
		return calendarioOrdenProduccion;
	}
	public void setCalendarioOrdenProduccion(
			Set<CalendarioOrdenProduccion> calendarioOrdenProduccion) {
		this.calendarioOrdenProduccion = calendarioOrdenProduccion;
	}
	public Set<CalificacionPliego> getCalificacionPliego() {
		return calificacionPliego;
	}
	public void setCalificacionPliego(Set<CalificacionPliego> calificacionPliego) {
		this.calificacionPliego = calificacionPliego;
	}
}
