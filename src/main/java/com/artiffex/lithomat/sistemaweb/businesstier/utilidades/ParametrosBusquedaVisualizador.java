package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaVisualizador implements Serializable {

	private static final long serialVersionUID = -2867442092094826678L;
	
	private int tipoBusqueda;
	private String nut;
	private String nombre;
	private String descripcion;
	private String fechaCotizacionInicio;
	private String fechaCotizacionFin;
	private String cliente;
	private int idEstatusOrden;
	
	
	public int getTipoBusqueda() {
		return tipoBusqueda;
	}
	public void setTipoBusqueda(int tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
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
	public String getFechaCotizacionInicio() {
		return fechaCotizacionInicio;
	}
	public void setFechaCotizacionInicio(String fechaCotizacionInicio) {
		this.fechaCotizacionInicio = fechaCotizacionInicio;
	}
	public String getFechaCotizacionFin() {
		return fechaCotizacionFin;
	}
	public void setFechaCotizacionFin(String fechaCotizacionFin) {
		this.fechaCotizacionFin = fechaCotizacionFin;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getIdEstatusOrden() {
		return idEstatusOrden;
	}
	public void setIdEstatusOrden(int idEstatusOrden) {
		this.idEstatusOrden = idEstatusOrden;
	}
}
