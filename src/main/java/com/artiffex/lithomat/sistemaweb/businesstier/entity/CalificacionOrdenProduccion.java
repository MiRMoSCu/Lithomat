package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CalificacionOrdenProduccion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4913956952064195216L;
	
	private int idCalificacionOrdenProduccion;
	private OrdenProduccion ordenProduccion;
	private double precioBruto;
	private float tipoClientePrecio;
	private int tipoClienteIdTipoPrecio;
	private double precioCliente;
	private int porcentajeDescuento;
	private double precioBrutoConDescuento;
	private double precioNeto;
	private String observaciones;
	private String condicionesProduccion;
	private Timestamp fechaGeneracion;
	private boolean activo;
	
	public int getIdCalificacionOrdenProduccion() {
		return idCalificacionOrdenProduccion;
	}
	public void setIdCalificacionOrdenProduccion(int idCalificacionOrdenProduccion) {
		this.idCalificacionOrdenProduccion = idCalificacionOrdenProduccion;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public double getPrecioBruto() {
		return precioBruto;
	}
	public void setPrecioBruto(double precioBruto) {
		this.precioBruto = precioBruto;
	}
	public float getTipoClientePrecio() {
		return tipoClientePrecio;
	}
	public void setTipoClientePrecio(float tipoClientePrecio) {
		this.tipoClientePrecio = tipoClientePrecio;
	}
	public int getTipoClienteIdTipoPrecio() {
		return tipoClienteIdTipoPrecio;
	}
	public void setTipoClienteIdTipoPrecio(int tipoClienteIdTipoPrecio) {
		this.tipoClienteIdTipoPrecio = tipoClienteIdTipoPrecio;
	}
	public double getPrecioCliente() {
		return precioCliente;
	}
	public void setPrecioCliente(double precioCliente) {
		this.precioCliente = precioCliente;
	}
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public double getPrecioBrutoConDescuento() {
		return precioBrutoConDescuento;
	}
	public void setPrecioBrutoConDescuento(double precioBrutoConDescuento) {
		this.precioBrutoConDescuento = precioBrutoConDescuento;
	}
	public double getPrecioNeto() {
		return precioNeto;
	}
	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getCondicionesProduccion() {
		return condicionesProduccion;
	}
	public void setCondicionesProduccion(String condicionesProduccion) {
		this.condicionesProduccion = condicionesProduccion;
	}
	public Timestamp getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Timestamp fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
