package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class FechaPrensistaMaquina implements Serializable {

	private static final long serialVersionUID = 7898226661242722956L;

	private int idFechaPrensistaMaquina;
	private Pliego pliego;
	private Prensista prensista;
	private TurnoLaboral turnoLaboral;
	private Maquina maquina;
	private Date fechaImpresion;
	private int idPrensistaAyudante;
	private int hojasBuenas;
	private int hojasMalas;
	private int hojasLimpias;
	private int hojasAdicionales;
	private int cambioPlacas;
	private int laminasExtra;
	private float frenteKilosTinta;
	private float vueltaKilosTinta;
	private String usuario;
	private Timestamp fechaGeneracion;
	private boolean activo;
	
	
	public int getIdFechaPrensistaMaquina() {
		return idFechaPrensistaMaquina;
	}
	public void setIdFechaPrensistaMaquina(int idFechaPrensistaMaquina) {
		this.idFechaPrensistaMaquina = idFechaPrensistaMaquina;
	}
	public Pliego getPliego() {
		return pliego;
	}
	public void setPliego(Pliego pliego) {
		this.pliego = pliego;
	}
	public Prensista getPrensista() {
		return prensista;
	}
	public void setPrensista(Prensista prensista) {
		this.prensista = prensista;
	}
	public TurnoLaboral getTurnoLaboral() {
		return turnoLaboral;
	}
	public void setTurnoLaboral(TurnoLaboral turnoLaboral) {
		this.turnoLaboral = turnoLaboral;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public Date getFechaImpresion() {
		return fechaImpresion;
	}
	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}
	public int getIdPrensistaAyudante() {
		return idPrensistaAyudante;
	}
	public void setIdPrensistaAyudante(int idPrensistaAyudante) {
		this.idPrensistaAyudante = idPrensistaAyudante;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
}
