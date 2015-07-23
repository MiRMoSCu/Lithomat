package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class TurnoLaboral implements Serializable {

	private static final long serialVersionUID = 259669977836165181L;

	private int idTurnoLaboral;
	private String descripcion;
	private Time horaInicio;
	private Time horaFin;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<FechaPrensistaMaquina> fechaPrensistaMaquina = new HashSet<FechaPrensistaMaquina>();
	
	
	public int getIdTurnoLaboral() {
		return idTurnoLaboral;
	}
	public void setIdTurnoLaboral(int idTurnoLaboral) {
		this.idTurnoLaboral = idTurnoLaboral;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
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
