package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class ReporteCotizacionDTO implements Serializable {
	
	private static final long serialVersionUID = -183960911881863027L;
	
	public int cantidad;
	public String descripcion;
	public double precioUnitario;
	public double precioCliente;
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getPrecioCliente() {
		return precioCliente;
	}
	public void setPrecioCliente(double precioCliente) {
		this.precioCliente = precioCliente;
	} 
	
}
