package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 4694380466211635839L;
	
	private int idUsuario;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String usuario;
	private String contrasenia;
	private boolean activo;
	// esta clase esta relacionada [uno <usuario> a muchos <ordenProduccion>] con las tablas:
	private Set<PerfilXUsuario> perfilXUsuario = new HashSet<PerfilXUsuario>();
	private Set<OrdenProduccion> ordenProduccion = new HashSet<OrdenProduccion>();
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<PerfilXUsuario> getPerfilXUsuario() {
		return perfilXUsuario;
	}
	public void setPerfilXUsuario(Set<PerfilXUsuario> perfilXUsuario) {
		this.perfilXUsuario = perfilXUsuario;
	}
	public Set<OrdenProduccion> getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(Set<OrdenProduccion> ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
}
