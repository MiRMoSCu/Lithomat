package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.util.Date;

public class FechaPrensistaMaquinaDTO implements Serializable {

	private static final long serialVersionUID = 5382464768526885107L;

	private String prensista;
	private String turnoLaboral; 
	private String maquina;
	private Date fechaImpresion;
	private String prensistaAyudante;
	private int hojasRequeridas;
	private int hojasBuenas;
	private int hojasMalas;
	private int hojasLimpias;
	private int hojasAdicionales;
	private int cambioPlacas;
	private int laminasExtra;
	private float frenteKilosTinta;
	private float vueltaKilosTinta;
	
	
	public String getPrensista() {
		return prensista;
	}
	public void setPrensista(String prensista) {
		this.prensista = prensista;
	}
	public String getTurnoLaboral() {
		return turnoLaboral;
	}
	public void setTurnoLaboral(String turnoLaboral) {
		this.turnoLaboral = turnoLaboral;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public Date getFechaImpresion() {
		return fechaImpresion;
	}
	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}
	public String getPrensistaAyudante() {
		return prensistaAyudante;
	}
	public void setPrensistaAyudante(String prensistaAyudante) {
		this.prensistaAyudante = prensistaAyudante;
	}
	public int getHojasRequeridas() {
		return hojasRequeridas;
	}
	public void setHojasRequeridas(int hojasRequeridas) {
		this.hojasRequeridas = hojasRequeridas;
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
	public int getCambioPlacas() {
		return cambioPlacas;
	}
	public void setCambioPlacas(int cambioPlacas) {
		this.cambioPlacas = cambioPlacas;
	}
	public int getLaminasExtra() {
		return laminasExtra;
	}
	public void setLaminasExtra(int laminasExtra) {
		this.laminasExtra = laminasExtra;
	}
	public float getFrenteKilosTinta() {
		return frenteKilosTinta;
	}
	public void setFrenteKilosTinta(float frenteKilosTinta) {
		this.frenteKilosTinta = frenteKilosTinta;
	}
	public float getVueltaKilosTinta() {
		return vueltaKilosTinta;
	}
	public void setVueltaKilosTinta(float vueltaKilosTinta) {
		this.vueltaKilosTinta = vueltaKilosTinta;
	}
}
