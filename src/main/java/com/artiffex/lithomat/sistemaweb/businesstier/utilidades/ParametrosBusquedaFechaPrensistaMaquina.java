package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaFechaPrensistaMaquina implements Serializable {

	private static final long serialVersionUID = 1659818502977469767L;
	
	private boolean busquedaPorNut;
	private boolean busquedaPorFecha;
	private boolean busquedaPorPrensista;
	private boolean busquedaPorMaquina;
	private String nut;
	private String fechaBusquedaInicio;
	private String fechaBusquedaFin;
	private int idPrensista;
	private int idMaquina;
	
	
	public boolean isBusquedaPorNut() {
		return busquedaPorNut;
	}
	public void setBusquedaPorNut(boolean busquedaPorNut) {
		this.busquedaPorNut = busquedaPorNut;
	}
	public boolean isBusquedaPorFecha() {
		return busquedaPorFecha;
	}
	public void setBusquedaPorFecha(boolean busquedaPorFecha) {
		this.busquedaPorFecha = busquedaPorFecha;
	}
	public boolean isBusquedaPorPrensista() {
		return busquedaPorPrensista;
	}
	public void setBusquedaPorPrensista(boolean busquedaPorPrensista) {
		this.busquedaPorPrensista = busquedaPorPrensista;
	}
	public boolean isBusquedaPorMaquina() {
		return busquedaPorMaquina;
	}
	public void setBusquedaPorMaquina(boolean busquedaPorMaquina) {
		this.busquedaPorMaquina = busquedaPorMaquina;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getFechaBusquedaInicio() {
		return fechaBusquedaInicio;
	}
	public void setFechaBusquedaInicio(String fechaBusquedaInicio) {
		this.fechaBusquedaInicio = fechaBusquedaInicio;
	}
	public String getFechaBusquedaFin() {
		return fechaBusquedaFin;
	}
	public void setFechaBusquedaFin(String fechaBusquedaFin) {
		this.fechaBusquedaFin = fechaBusquedaFin;
	}
	public int getIdPrensista() {
		return idPrensista;
	}
	public void setIdPrensista(int idPrensista) {
		this.idPrensista = idPrensista;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
}
