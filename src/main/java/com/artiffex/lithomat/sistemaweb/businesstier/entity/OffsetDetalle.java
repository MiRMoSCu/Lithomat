package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class OffsetDetalle implements Serializable {

	private static final long serialVersionUID = 2007615197433149508L;
	
	private int idOffsetDetalle;
	private Pliego pliego;
	private int hojasBuenas;
	private int hojasMalas;
	private int hojasLimpias;
	private int hojasAdicionales;
	private int laminasExtras;
	private int kilosTintaFrente;
	private int kilosTintaVuelta;
	private boolean activo;
	
	
	public int getIdOffsetDetalle() {
		return idOffsetDetalle;
	}
	public void setIdOffsetDetalle(int idOffsetDetalle) {
		this.idOffsetDetalle = idOffsetDetalle;
	}
	public Pliego getPliego() {
		return pliego;
	}
	public void setPliego(Pliego pliego) {
		this.pliego = pliego;
	}
	public int getHojasBuenas() {
		return hojasBuenas;
	}
	public void setHojasBuenas(int hojasBuenas) {
		this.hojasBuenas = hojasBuenas;
	}
	public int getHojasMalas() {
		return hojasMalas;
	}
	public void setHojasMalas(int hojasMalas) {
		this.hojasMalas = hojasMalas;
	}
	public int getHojasLimpias() {
		return hojasLimpias;
	}
	public void setHojasLimpias(int hojasLimpias) {
		this.hojasLimpias = hojasLimpias;
	}
	public int getHojasAdicionales() {
		return hojasAdicionales;
	}
	public void setHojasAdicionales(int hojasAdicionales) {
		this.hojasAdicionales = hojasAdicionales;
	}
	public int getLaminasExtras() {
		return laminasExtras;
	}
	public void setLaminasExtras(int laminasExtras) {
		this.laminasExtras = laminasExtras;
	}
	public int getKilosTintaFrente() {
		return kilosTintaFrente;
	}
	public void setKilosTintaFrente(int kilosTintaFrente) {
		this.kilosTintaFrente = kilosTintaFrente;
	}
	public int getKilosTintaVuelta() {
		return kilosTintaVuelta;
	}
	public void setKilosTintaVuelta(int kilosTintaVuelta) {
		this.kilosTintaVuelta = kilosTintaVuelta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
		
}
