package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class PerfilXUsuario implements Serializable {

	private static final long serialVersionUID = 3726711525645751230L;
	
	private int idPerfilXUsuario;
	private Usuario usuario;
	private Perfil perfil;
	private boolean activo;
	
	
	public int getIdPerfilXUsuario() {
		return idPerfilXUsuario;
	}
	public void setIdPerfilXUsuario(int idPerfilXUsuario) {
		this.idPerfilXUsuario = idPerfilXUsuario;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
