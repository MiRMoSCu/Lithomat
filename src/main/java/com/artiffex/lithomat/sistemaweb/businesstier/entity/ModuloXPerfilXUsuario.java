package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class ModuloXPerfilXUsuario implements Serializable {

	private static final long serialVersionUID = -7964851841735233914L;

	private int idModuloXPerfilXUsuario;
	private Usuario usuario;
	private Perfil perfil;
	private Modulo modulo;
	private SubModulo subModulo;
	private boolean tieneAcceso;
	private boolean permisoAlta;
	private boolean permisoBaja;
	private boolean permisoCambio;
	private boolean permisoConsulta;
	private boolean activo;
	
	
	public int getIdModuloXPerfilXUsuario() {
		return idModuloXPerfilXUsuario;
	}
	public void setIdModuloXPerfilXUsuario(int idModuloXPerfilXUsuario) {
		this.idModuloXPerfilXUsuario = idModuloXPerfilXUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public SubModulo getSubModulo() {
		return subModulo;
	}
	public void setSubModulo(SubModulo subModulo) {
		this.subModulo = subModulo;
	}
	public boolean isTieneAcceso() {
		return tieneAcceso;
	}
	public void setTieneAcceso(boolean tieneAcceso) {
		this.tieneAcceso = tieneAcceso;
	}
	public boolean isPermisoAlta() {
		return permisoAlta;
	}
	public void setPermisoAlta(boolean permisoAlta) {
		this.permisoAlta = permisoAlta;
	}
	public boolean isPermisoBaja() {
		return permisoBaja;
	}
	public void setPermisoBaja(boolean permisoBaja) {
		this.permisoBaja = permisoBaja;
	}
	public boolean isPermisoCambio() {
		return permisoCambio;
	}
	public void setPermisoCambio(boolean permisoCambio) {
		this.permisoCambio = permisoCambio;
	}
	public boolean isPermisoConsulta() {
		return permisoConsulta;
	}
	public void setPermisoConsulta(boolean permisoConsulta) {
		this.permisoConsulta = permisoConsulta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
