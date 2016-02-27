package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaTabuladorPrecios implements Serializable {

	private static final long serialVersionUID = 6974216210435264691L;
	
	private boolean busquedaPorMaquina;
	private boolean busquedaPorComplejidad;
	private int idMaquina;
	private int idTipoComplejidad;
	
	
	public boolean isBusquedaPorMaquina() {
		return busquedaPorMaquina;
	}
	public void setBusquedaPorMaquina(boolean busquedaPorMaquina) {
		this.busquedaPorMaquina = busquedaPorMaquina;
	}
	public boolean isBusquedaPorComplejidad() {
		return busquedaPorComplejidad;
	}
	public void setBusquedaPorComplejidad(boolean busquedaPorComplejidad) {
		this.busquedaPorComplejidad = busquedaPorComplejidad;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public int getIdTipoComplejidad() {
		return idTipoComplejidad;
	}
	public void setIdTipoComplejidad(int idTipoComplejidad) {
		this.idTipoComplejidad = idTipoComplejidad;
	}
}
