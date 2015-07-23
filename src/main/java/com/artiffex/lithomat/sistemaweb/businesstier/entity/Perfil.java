package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Perfil implements Serializable {

	private static final long serialVersionUID = 8135220841662470881L;

	private int idPerfil;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<ModuloXPerfilXUsuario> moduloXPerfilXUsuario = new HashSet<ModuloXPerfilXUsuario>();
	

	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<ModuloXPerfilXUsuario> getModuloXPerfilXUsuario() {
		return moduloXPerfilXUsuario;
	}
	public void setModuloXPerfilXUsuario(
			Set<ModuloXPerfilXUsuario> moduloXPerfilXUsuario) {
		this.moduloXPerfilXUsuario = moduloXPerfilXUsuario;
	}
	
}
