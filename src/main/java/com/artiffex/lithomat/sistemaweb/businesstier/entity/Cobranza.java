package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Date;

public class Cobranza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8705094924036512303L;
	
	private int idCobranza;
	private OrdenProduccion ordenProduccion;
	private Date fecha;
	private boolean pendiente;
	private double cargo;
	private double abono;
	private double saldo;
	private boolean activo;
	
	public int getIdCobranza() {
		return idCobranza;
	}
	public void setIdCobranza(int idCobranza) {
		this.idCobranza = idCobranza;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPendiente() {
		return pendiente;
	}
	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
	public double getCargo() {
		return cargo;
	}
	public void setCargo(double cargo) {
		this.cargo = cargo;
	}
	public double getAbono() {
		return abono;
	}
	public void setAbono(double abono) {
		this.abono = abono;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
