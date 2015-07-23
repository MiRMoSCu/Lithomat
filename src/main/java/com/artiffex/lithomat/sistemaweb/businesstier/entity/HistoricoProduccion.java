package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.Date;

public class HistoricoProduccion implements Serializable {

	private static final long serialVersionUID = 4364298142209826853L;

	private int idHistoricoProduccion;
	private Date fecha;
	private double punto_equilibrio;
	private double offset;
	private double perdida;
	private double ganancia;
	private double disenio;
	private double preprensa;
	private double transporte;
	private double corte;
	private double otros;
	private boolean activo;
	
	
	public int getIdHistoricoProduccion() {
		return idHistoricoProduccion;
	}
	public void setIdHistoricoProduccion(int idHistoricoProduccion) {
		this.idHistoricoProduccion = idHistoricoProduccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getPunto_equilibrio() {
		return punto_equilibrio;
	}
	public void setPunto_equilibrio(double punto_equilibrio) {
		this.punto_equilibrio = punto_equilibrio;
	}
	public double getOffset() {
		return offset;
	}
	public void setOffset(double offset) {
		this.offset = offset;
	}
	public double getPerdida() {
		return perdida;
	}
	public void setPerdida(double perdida) {
		this.perdida = perdida;
	}
	public double getGanancia() {
		return ganancia;
	}
	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}
	public double getDisenio() {
		return disenio;
	}
	public void setDisenio(double disenio) {
		this.disenio = disenio;
	}
	public double getPreprensa() {
		return preprensa;
	}
	public void setPreprensa(double preprensa) {
		this.preprensa = preprensa;
	}
	public double getTransporte() {
		return transporte;
	}
	public void setTransporte(double transporte) {
		this.transporte = transporte;
	}
	public double getCorte() {
		return corte;
	}
	public void setCorte(double corte) {
		this.corte = corte;
	}
	public double getOtros() {
		return otros;
	}
	public void setOtros(double otros) {
		this.otros = otros;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
