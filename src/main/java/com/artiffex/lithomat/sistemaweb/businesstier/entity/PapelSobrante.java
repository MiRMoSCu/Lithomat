package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class PapelSobrante implements Serializable {

	private static final long serialVersionUID = -4063134267904166263L;

	private int idPapelSobrante;
	private int inicioTabulador;
	private int finTabulador;
	private int frenteNumTinta;
	private int vueltaNumTinta;
	private boolean tintaEspecial;
	private int hojasSobrante;
	private boolean activo;
	
	
	public int getIdPapelSobrante() {
		return idPapelSobrante;
	}
	public void setIdPapelSobrante(int idPapelSobrante) {
		this.idPapelSobrante = idPapelSobrante;
	}
	public int getInicioTabulador() {
		return inicioTabulador;
	}
	public void setInicioTabulador(int inicioTabulador) {
		this.inicioTabulador = inicioTabulador;
	}
	public int getFinTabulador() {
		return finTabulador;
	}
	public void setFinTabulador(int finTabulador) {
		this.finTabulador = finTabulador;
	}
	public int getFrenteNumTinta() {
		return frenteNumTinta;
	}
	public void setFrenteNumTinta(int frenteNumTinta) {
		this.frenteNumTinta = frenteNumTinta;
	}
	public int getVueltaNumTinta() {
		return vueltaNumTinta;
	}
	public void setVueltaNumTinta(int vueltaNumTinta) {
		this.vueltaNumTinta = vueltaNumTinta;
	}
	public boolean isTintaEspecial() {
		return tintaEspecial;
	}
	public void setTintaEspecial(boolean tintaEspecial) {
		this.tintaEspecial = tintaEspecial;
	}
	public int getHojasSobrante() {
		return hojasSobrante;
	}
	public void setHojasSobrante(int hojasSobrante) {
		this.hojasSobrante = hojasSobrante;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
		
}
