package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class RegistroColaImpresionDTO implements Serializable {

	private static final long serialVersionUID = -7976372927329947970L;
	
	private String nut;				// tabla: orden_produccion
	private String nombreCliente;	// tabla: cliente
	private String decripcion;		// tabla: partida
	private String papel;			// tabla: tipo_papel_extendido
	private String medida;			// tabla: tipo_papel_extendido
	private int tiro;				// tabla: pliego (hojas_totales)
	private String tintas;			// tabla: combinacion_tintas
	private String coloresFrente;	// tabla: combinacion_tintas
	private String coloresVuelta;	// tabla: combinacion_tintas
	private String placas;			// tabla: frente_num_total_placas + vuelta_num_total_placas
	private String maquina;			// tabla: maquina
	private String observaciones;	//        vacio
	
	
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
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
