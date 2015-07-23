package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CargoInsumo implements Serializable {

	private static final long serialVersionUID = -2437494244022447094L;

	private int id_cargo_insumo;
	private String nombre;
	private boolean activo;

	public void setId_cargo_insumo(int id_cargo_insumo) {
		this.id_cargo_insumo = id_cargo_insumo;
	}

	public int getId_cargo_insumo() {
		return id_cargo_insumo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}
}
