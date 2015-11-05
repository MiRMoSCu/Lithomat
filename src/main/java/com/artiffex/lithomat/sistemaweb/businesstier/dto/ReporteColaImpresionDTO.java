package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class ReporteColaImpresionDTO implements Serializable {

	private static final long serialVersionUID = -7976372927329947970L;
	
	private String nut;
	private String nombreCliente;
	private String decripcion;
	private String papel;
	private String medida;
	private int tiro;
	private String tintas;
	private String coloresFrente;
	private String coloresVuelta;
	private String placas;
	private String Observaciones;
	
	
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
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public int getTiro() {
		return tiro;
	}
	public void setTiro(int tiro) {
		this.tiro = tiro;
	}
	public String getTintas() {
		return tintas;
	}
	public void setTintas(String tintas) {
		this.tintas = tintas;
	}
	public String getColoresFrente() {
		return coloresFrente;
	}
	public void setColoresFrente(String coloresFrente) {
		this.coloresFrente = coloresFrente;
	}
	public String getColoresVuelta() {
		return coloresVuelta;
	}
	public void setColoresVuelta(String coloresVuelta) {
		this.coloresVuelta = coloresVuelta;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
}
