package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Prensista implements Serializable {

	private static final long serialVersionUID = -8344761215481624556L;

	private int idPrensista;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<FechaPrensistaMaquina> fechaPrensistaMaquina = new HashSet<FechaPrensistaMaquina>();
	
	
	public int getIdPrensista() {
		return idPrensista;
	}
	public void setIdPrensista(int idPrensista) {
		this.idPrensista = idPrensista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
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
	
}
