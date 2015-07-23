package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class InsumoCalificacion implements Serializable {

	private static final long serialVersionUID = -1665129590680690008L;

	private int idInsumoCalificacion;
	private int idOrdenProduccion;
	private int idDisenio;
	private int idPreprensa;
	private int idTransporte;
	private int idAcabado;
	private int idOffset;
	private int idProcesoExterno;
	private int cantidad;
	private String concepto;
	private double precioUnitario;
	private double subTotal;
	private int iva;
	private double total;
	private int idCargoInsumo;
	private String observaciones;
	private boolean activo;
	
	
	public int getIdInsumoCalificacion() {
		return idInsumoCalificacion;
	}
	public void setIdInsumoCalificacion(int idInsumoCalificacion) {
		this.idInsumoCalificacion = idInsumoCalificacion;
	}
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public int getIdDisenio() {
		return idDisenio;
	}
	public void setIdDisenio(int idDisenio) {
		this.idDisenio = idDisenio;
	}
	public int getIdPreprensa() {
		return idPreprensa;
	}
	public void setIdPreprensa(int idPreprensa) {
		this.idPreprensa = idPreprensa;
	}
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public int getIdAcabado() {
		return idAcabado;
	}
	public void setIdAcabado(int idAcabado) {
		this.idAcabado = idAcabado;
	}
	public int getIdOffset() {
		return idOffset;
	}
	public void setIdOffset(int idOffset) {
		this.idOffset = idOffset;
	}
	public int getIdProcesoExterno() {
		return idProcesoExterno;
	}
	public void setIdProcesoExterno(int idProcesoExterno) {
		this.idProcesoExterno = idProcesoExterno;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdCargoInsumo() {
		return idCargoInsumo;
	}
	public void setIdCargoInsumo(int idCargoInsumo) {
		this.idCargoInsumo = idCargoInsumo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
