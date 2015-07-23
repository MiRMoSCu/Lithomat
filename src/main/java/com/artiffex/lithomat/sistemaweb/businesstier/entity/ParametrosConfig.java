package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class ParametrosConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -992432966271104516L;
	
	private int idParametrosConfig;
	private String nombre;
	private String descripcion;
	private String fillerVarchar1;
	private String fillerVarchar2;
	private int fillerInt1;
	private int fillerInt2;
	private double fillerNumeric1;
	private double fillerNumeric2;
	private boolean fillerBool1;
	private boolean fillerBool2;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	
	
	public int getIdParametrosConfig() {
		return idParametrosConfig;
	}
	public void setIdParametrosConfig(int idParametrosConfig) {
		this.idParametrosConfig = idParametrosConfig;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFillerVarchar1() {
		return fillerVarchar1;
	}
	public void setFillerVarchar1(String fillerVarchar1) {
		this.fillerVarchar1 = fillerVarchar1;
	}
	public String getFillerVarchar2() {
		return fillerVarchar2;
	}
	public void setFillerVarchar2(String fillerVarchar2) {
		this.fillerVarchar2 = fillerVarchar2;
	}
	public int getFillerInt1() {
		return fillerInt1;
	}
	public void setFillerInt1(int fillerInt1) {
		this.fillerInt1 = fillerInt1;
	}
	public int getFillerInt2() {
		return fillerInt2;
	}
	public void setFillerInt2(int fillerInt2) {
		this.fillerInt2 = fillerInt2;
	}
	public double getFillerNumeric1() {
		return fillerNumeric1;
	}
	public void setFillerNumeric1(double fillerNumeric1) {
		this.fillerNumeric1 = fillerNumeric1;
	}
	public double getFillerNumeric2() {
		return fillerNumeric2;
	}
	public void setFillerNumeric2(double fillerNumeric2) {
		this.fillerNumeric2 = fillerNumeric2;
	}
	public boolean isFillerBool1() {
		return fillerBool1;
	}
	public void setFillerBool1(boolean fillerBool1) {
		this.fillerBool1 = fillerBool1;
	}
	public boolean isFillerBool2() {
		return fillerBool2;
	}
	public void setFillerBool2(boolean fillerBool2) {
		this.fillerBool2 = fillerBool2;
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
