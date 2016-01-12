package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class RemisionOrdenProduccion implements Serializable {

	private static final long serialVersionUID = -3314958460588528679L;
	
	private String nut;
	private String nombreCliente;
	private String nombreOrdenProduccion;
	private double precioCliente;
	private int porcentajeDescuento;
	private double precioClienteConDescuento;
	private double precioNeto;
	private List<RemisionPartida> listaRemisionPartida;
	
	
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNombreOrdenProduccion() {
		return nombreOrdenProduccion;
	}
	public void setNombreOrdenProduccion(String nombreOrdenProduccion) {
		this.nombreOrdenProduccion = nombreOrdenProduccion;
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
	public double getPrecioClienteConDescuento() {
		return precioClienteConDescuento;
	}
	public void setPrecioClienteConDescuento(double precioClienteConDescuento) {
		this.precioClienteConDescuento = precioClienteConDescuento;
	}
	public double getPrecioNeto() {
		return precioNeto;
	}
	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}
	public List<RemisionPartida> getListaRemisionPartida() {
		return listaRemisionPartida;
	}
	public void setListaRemisionPartida(List<RemisionPartida> listaRemisionPartida) {
		this.listaRemisionPartida = listaRemisionPartida;
	}
}
