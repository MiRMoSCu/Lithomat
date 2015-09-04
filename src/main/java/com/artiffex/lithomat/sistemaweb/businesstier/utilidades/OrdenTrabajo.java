package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = 7778015678624313625L;
	
	private String nombreCliente;
	private String nombreRepresentante;
	private String telefonoParticular;
	private String telefonoMovil;
	private String nut;
	private String nombreTrabajo;
	private String descripcion;
	private String fechaEntrega;
	private List<OrdenTrabajoPartida> listaOrdenTrabajoPartida;
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	public String getTelefonoParticular() {
		return telefonoParticular;
	}
	public void setTelefonoParticular(String telefonoParticular) {
		this.telefonoParticular = telefonoParticular;
	}
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getNombreTrabajo() {
		return nombreTrabajo;
	}
	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public List<OrdenTrabajoPartida> getListaOrdenTrabajoPartida() {
		return listaOrdenTrabajoPartida;
	}
	public void setListaOrdenTrabajoPartida(
			List<OrdenTrabajoPartida> listaOrdenTrabajoPartida) {
		this.listaOrdenTrabajoPartida = listaOrdenTrabajoPartida;
	}
}
