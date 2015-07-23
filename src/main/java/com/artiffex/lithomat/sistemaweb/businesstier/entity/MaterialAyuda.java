package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MaterialAyuda implements Serializable {

	private static final long serialVersionUID = 2305670043669035395L;

	private int idMaterialAyuda;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<MaterialAyudaXPartida> materialAyudaXPartida = new HashSet<MaterialAyudaXPartida>();
	
	
	public int getIdMaterialAyuda() {
		return idMaterialAyuda;
	}
	public void setIdMaterialAyuda(int idMaterialAyuda) {
		this.idMaterialAyuda = idMaterialAyuda;
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
	public Set<MaterialAyudaXPartida> getMaterialAyudaXPartida() {
		return materialAyudaXPartida;
	}
	public void setMaterialAyudaXPartida(
			Set<MaterialAyudaXPartida> materialAyudaXPartida) {
		this.materialAyudaXPartida = materialAyudaXPartida;
	}
		
}
