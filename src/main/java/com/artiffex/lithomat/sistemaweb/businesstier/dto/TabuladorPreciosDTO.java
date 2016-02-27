package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class TabuladorPreciosDTO implements Serializable {

	private static final long serialVersionUID = -3549087765543224841L;
	
	private int idTabuladorPrecios;
	private String maquina;
	private String nombreInsumo;
	private String descripcion;
	private int inicioTabulador;
	private int finTabulador;
	private String tipoComplejidad;
	private float precio;
	private String tipoPrecio;
	
	
	public int getIdTabuladorPrecios() {
		return idTabuladorPrecios;
	}
	public void setIdTabuladorPrecios(int idTabuladorPrecios) {
		this.idTabuladorPrecios = idTabuladorPrecios;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getNombreInsumo() {
		return nombreInsumo;
	}
	public void setNombreInsumo(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getInicioTabulador() {
		return inicioTabulador;
	}
	public void setInicioTabulador(int inicioTabulador) {
		this.inicioTabulador = inicioTabulador;
	}
	public int getFinTabulador() {
		return finTabulador;
	}
	public void setFinTabulador(int finTabulador) {
		this.finTabulador = finTabulador;
	}
	public String getTipoComplejidad() {
		return tipoComplejidad;
	}
	public void setTipoComplejidad(String tipoComplejidad) {
		this.tipoComplejidad = tipoComplejidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getTipoPrecio() {
		return tipoPrecio;
	}
	public void setTipoPrecio(String tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}
}
