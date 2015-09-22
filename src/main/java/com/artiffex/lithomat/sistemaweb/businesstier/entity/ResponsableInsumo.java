package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ResponsableInsumo implements Serializable {

	private static final long serialVersionUID = 7933843489329520359L;

	private int idResponsableInsumo;
	private String nombre;
	private String descripcion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<CostoExtraDetalle> costoExtraDetalle = new HashSet<CostoExtraDetalle>();
	private Set<MaterialAyudaXPartida> materialAyudaXPartida = new HashSet<MaterialAyudaXPartida>();
	
	
	public int getIdResponsableInsumo() {
		return idResponsableInsumo;
	}
	public void setIdResponsableInsumo(int idResponsableInsumo) {
		this.idResponsableInsumo = idResponsableInsumo;
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
	public Set<CostoExtraDetalle> getCostoExtraDetalle() {
		return costoExtraDetalle;
	}
	public void setCostoExtraDetalle(Set<CostoExtraDetalle> costoExtraDetalle) {
		this.costoExtraDetalle = costoExtraDetalle;
	}
	public Set<MaterialAyudaXPartida> getMaterialAyudaXPartida() {
		return materialAyudaXPartida;
	}
	public void setMaterialAyudaXPartida(
			Set<MaterialAyudaXPartida> materialAyudaXPartida) {
		this.materialAyudaXPartida = materialAyudaXPartida;
	}
}
