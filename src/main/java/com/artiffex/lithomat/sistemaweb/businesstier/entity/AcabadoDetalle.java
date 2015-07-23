package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Date;

public class AcabadoDetalle implements Serializable {

	private static final long serialVersionUID = 4436125546745262982L;

	private int idAcabadoDetalle;
	private Acabado acabado;
	private ProcesoExterno procesoExterno;
	private float ancho;
	private float alto;
	private int cantidadProcesoExterno;
	private String especificaciones;
	private float precioTotalPesos;
	private Date fechaEnvio;
	private Date fechaEntrega;
	private boolean activo;
	
	
	public int getIdAcabadoDetalle() {
		return idAcabadoDetalle;
	}
	public void setIdAcabadoDetalle(int idAcabadoDetalle) {
		this.idAcabadoDetalle = idAcabadoDetalle;
	}
	public Acabado getAcabado() {
		return acabado;
	}
	public void setAcabado(Acabado acabado) {
		this.acabado = acabado;
	}
	public ProcesoExterno getProcesoExterno() {
		return procesoExterno;
	}
	public void setProcesoExterno(ProcesoExterno procesoExterno) {
		this.procesoExterno = procesoExterno;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public int getCantidadProcesoExterno() {
		return cantidadProcesoExterno;
	}
	public void setCantidadProcesoExterno(int cantidadProcesoExterno) {
		this.cantidadProcesoExterno = cantidadProcesoExterno;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	public float getPrecioTotalPesos() {
		return precioTotalPesos;
	}
	public void setPrecioTotalPesos(float precioTotalPesos) {
		this.precioTotalPesos = precioTotalPesos;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
