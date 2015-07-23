package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.Date;

public class FechaPrensistaMaquina implements Serializable {

	private static final long serialVersionUID = 7898226661242722956L;

	private int idFechaPrensistaMaquina;
	private Prensista prensista;
	private TurnoLaboral turnoLaboral;
	private Maquina maquina;
	private Pliego pliego;
	private Date fecha;
	private int idPrensistaAyudante;
	private int numeroMillarImpreso;
	private int numeroCambioPlacas;
	private boolean activo;
	
	
	public int getIdFechaPrensistaMaquina() {
		return idFechaPrensistaMaquina;
	}
	public void setIdFechaPrensistaMaquina(int idFechaPrensistaMaquina) {
		this.idFechaPrensistaMaquina = idFechaPrensistaMaquina;
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
	public Pliego getPliego() {
		return pliego;
	}
	public void setPliego(Pliego pliego) {
		this.pliego = pliego;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdPrensistaAyudante() {
		return idPrensistaAyudante;
	}
	public void setIdPrensistaAyudante(int idPrensistaAyudante) {
		this.idPrensistaAyudante = idPrensistaAyudante;
	}
	public int getNumeroMillarImpreso() {
		return numeroMillarImpreso;
	}
	public void setNumeroMillarImpreso(int numeroMillarImpreso) {
		this.numeroMillarImpreso = numeroMillarImpreso;
	}
	public int getNumeroCambioPlacas() {
		return numeroCambioPlacas;
	}
	public void setNumeroCambioPlacas(int numeroCambioPlacas) {
		this.numeroCambioPlacas = numeroCambioPlacas;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
