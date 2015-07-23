package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SubModulo implements Serializable {

	private static final long serialVersionUID = -4196058993974314031L;

	private int idSubModulo;
	private String nombre;
	private String descripcion;
	private String path;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<ModuloXPerfilXUsuario> moduloXPerfilXUsuario = new HashSet<ModuloXPerfilXUsuario>();
	
	
	public int getIdSubModulo() {
		return idSubModulo;
	}
	public void setIdSubModulo(int idSubModulo) {
		this.idSubModulo = idSubModulo;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
