package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class AvisoMantenimientoMaquina implements Serializable {

	private static final long serialVersionUID = 4035870984858549698L;

	private int idAvisoMantenimientoMaquina;
	private Timestamp fecha;
	private String aviso;
	private int idUsuario;
	private boolean activo;
	
	
	public int getIdAvisoMantenimientoMaquina() {
		return idAvisoMantenimientoMaquina;
	}
	public void setIdAvisoMantenimientoMaquina(int idAvisoMantenimientoMaquina) {
		this.idAvisoMantenimientoMaquina = idAvisoMantenimientoMaquina;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
