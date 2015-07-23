package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CalendarioOrdenProduccion implements Serializable {

	private static final long serialVersionUID = -6530167175261042144L;

	private int idCalendarioOrdenProduccion;
	private Pliego pliego;
	private Maquina maquina;
	private int apuntadorPliegoProduccion;
	private int siguientePliegoRealizar;
	private boolean estaEliminado;
	private boolean activo;
	
	
	public int getIdCalendarioOrdenProduccion() {
		return idCalendarioOrdenProduccion;
	}
	public void setIdCalendarioOrdenProduccion(int idCalendarioOrdenProduccion) {
		this.idCalendarioOrdenProduccion = idCalendarioOrdenProduccion;
	}
	public Pliego getPliego() {
		return pliego;
	}
	public void setPliego(Pliego pliego) {
		this.pliego = pliego;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public int getApuntadorPliegoProduccion() {
		return apuntadorPliegoProduccion;
	}
	public void setApuntadorPliegoProduccion(int apuntadorPliegoProduccion) {
		this.apuntadorPliegoProduccion = apuntadorPliegoProduccion;
	}
	public int getSiguientePliegoRealizar() {
		return siguientePliegoRealizar;
	}
	public void setSiguientePliegoRealizar(int siguientePliegoRealizar) {
		this.siguientePliegoRealizar = siguientePliegoRealizar;
	}
	public boolean isEstaEliminado() {
		return estaEliminado;
	}
	public void setEstaEliminado(boolean estaEliminado) {
		this.estaEliminado = estaEliminado;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
