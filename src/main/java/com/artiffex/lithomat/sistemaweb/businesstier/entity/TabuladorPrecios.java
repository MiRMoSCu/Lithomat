package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class TabuladorPrecios implements Serializable {

	private static final long serialVersionUID = 1735346727407618938L;

	private int idTabuladorPrecios;
	private Maquina maquina;
	private String nombreInsumo;
	private String descripcion;
	private int inicioTabulador;
	private int finTabulador;
	private float precioComplejidadSencilla;
	private float precioComplejidadRegular;
	private float precioComplejidadDificil;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	
	
	public int getIdTabuladorPrecios() {
		return idTabuladorPrecios;
	}
	public void setIdTabuladorPrecios(int idTabuladorPrecios) {
		this.idTabuladorPrecios = idTabuladorPrecios;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
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
	public float getPrecioComplejidadSencilla() {
		return precioComplejidadSencilla;
	}
	public void setPrecioComplejidadSencilla(float precioComplejidadSencilla) {
		this.precioComplejidadSencilla = precioComplejidadSencilla;
	}
	public float getPrecioComplejidadRegular() {
		return precioComplejidadRegular;
	}
	public void setPrecioComplejidadRegular(float precioComplejidadRegular) {
		this.precioComplejidadRegular = precioComplejidadRegular;
	}
	public float getPrecioComplejidadDificil() {
		return precioComplejidadDificil;
	}
	public void setPrecioComplejidadDificil(float precioComplejidadDificil) {
		this.precioComplejidadDificil = precioComplejidadDificil;
	}
	public TipoPrecio getTipoPrecio() {
		return tipoPrecio;
	}
	public void setTipoPrecio(TipoPrecio tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
		
}
