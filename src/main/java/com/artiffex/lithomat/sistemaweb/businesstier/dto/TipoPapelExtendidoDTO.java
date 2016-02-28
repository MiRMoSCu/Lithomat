package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TipoPapelExtendidoDTO implements Serializable {

	private static final long serialVersionUID = 4738689854461267361L;
	
	private int idTipoPapelExtendido;
	private String razonSocial;
	private String nombre;
	private int gramaje;
	private float kilogramos;
	private BigDecimal ancho;
	private BigDecimal alto;
	private String descripcion;
	private float precio;
	private String nombrePrecio;
	
	
	public int getIdTipoPapelExtendido() {
		return idTipoPapelExtendido;
	}
	public void setIdTipoPapelExtendido(int idTipoPapelExtendido) {
		this.idTipoPapelExtendido = idTipoPapelExtendido;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGramaje() {
		return gramaje;
	}
	public void setGramaje(int gramaje) {
		this.gramaje = gramaje;
	}
	public float getKilogramos() {
		return kilogramos;
	}
	public void setKilogramos(float kilogramos) {
		this.kilogramos = kilogramos;
	}
	public BigDecimal getAncho() {
		return ancho;
	}
	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}
	public BigDecimal getAlto() {
		return alto;
	}
	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombrePrecio() {
		return nombrePrecio;
	}
	public void setNombrePrecio(String nombrePrecio) {
		this.nombrePrecio = nombrePrecio;
	}
}
