package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaSemaforo implements Serializable {

	private static final long serialVersionUID = -3424147234795436399L;
	
	private String role;
	private boolean busquedaPorNut;
	private boolean busquedaPorNombreOrdenProduccion;
	private boolean busquedaPorDescripcionOrdenProduccion;
	private boolean busquedaPorNombreMoral;
	private String nut;
	private String nombreOrdenProduccion;
	private String descripcionOrdenProduccion;
	private String nombreMoral;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isBusquedaPorNut() {
		return busquedaPorNut;
	}
	public void setBusquedaPorNut(boolean busquedaPorNut) {
		this.busquedaPorNut = busquedaPorNut;
	}
	public boolean isBusquedaPorNombreOrdenProduccion() {
		return busquedaPorNombreOrdenProduccion;
	}
	public void setBusquedaPorNombreOrdenProduccion(
			boolean busquedaPorNombreOrdenProduccion) {
		this.busquedaPorNombreOrdenProduccion = busquedaPorNombreOrdenProduccion;
	}
	public boolean isBusquedaPorDescripcionOrdenProduccion() {
		return busquedaPorDescripcionOrdenProduccion;
	}
	public void setBusquedaPorDescripcionOrdenProduccion(
			boolean busquedaPorDescripcionOrdenProduccion) {
		this.busquedaPorDescripcionOrdenProduccion = busquedaPorDescripcionOrdenProduccion;
	}
	public boolean isBusquedaPorNombreMoral() {
		return busquedaPorNombreMoral;
	}
	public void setBusquedaPorNombreMoral(boolean busquedaPorNombreMoral) {
		this.busquedaPorNombreMoral = busquedaPorNombreMoral;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getNombreOrdenProduccion() {
		return nombreOrdenProduccion;
	}
	public void setNombreOrdenProduccion(String nombreOrdenProduccion) {
		this.nombreOrdenProduccion = nombreOrdenProduccion;
	}
	public String getDescripcionOrdenProduccion() {
		return descripcionOrdenProduccion;
	}
	public void setDescripcionOrdenProduccion(String descripcionOrdenProduccion) {
		this.descripcionOrdenProduccion = descripcionOrdenProduccion;
	}
	public String getNombreMoral() {
		return nombreMoral;
	}
	public void setNombreMoral(String nombreMoral) {
		this.nombreMoral = nombreMoral;
	}
}
