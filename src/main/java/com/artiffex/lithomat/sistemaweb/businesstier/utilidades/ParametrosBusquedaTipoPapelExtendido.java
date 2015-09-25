package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaTipoPapelExtendido implements Serializable {

	private static final long serialVersionUID = 1212106463187065222L;
	
	public boolean busquedaPorNombre;
	public boolean busquedaPorAncho;
	public boolean busquedaPorAlto;
	public boolean busquedaPorGramaje;
	public boolean busquedaPorKilogramos;
	public boolean busquedaPorProveedor;
	public String nombrePapel;
	public Float ancho;
	public Float alto;
	public Integer gramaje;
	public Float kilogramos;
	public Integer idProveedorPapel;
	
	
	public boolean isBusquedaPorNombre() {
		return busquedaPorNombre;
	}
	public void setBusquedaPorNombre(boolean busquedaPorNombre) {
		this.busquedaPorNombre = busquedaPorNombre;
	}
	public boolean isBusquedaPorAncho() {
		return busquedaPorAncho;
	}
	public void setBusquedaPorAncho(boolean busquedaPorAncho) {
		this.busquedaPorAncho = busquedaPorAncho;
	}
	public boolean isBusquedaPorAlto() {
		return busquedaPorAlto;
	}
	public void setBusquedaPorAlto(boolean busquedaPorAlto) {
		this.busquedaPorAlto = busquedaPorAlto;
	}
	public boolean isBusquedaPorGramaje() {
		return busquedaPorGramaje;
	}
	public void setBusquedaPorGramaje(boolean busquedaPorGramaje) {
		this.busquedaPorGramaje = busquedaPorGramaje;
	}
	public boolean isBusquedaPorKilogramos() {
		return busquedaPorKilogramos;
	}
	public void setBusquedaPorKilogramos(boolean busquedaPorKilogramos) {
		this.busquedaPorKilogramos = busquedaPorKilogramos;
	}
	public boolean isBusquedaPorProveedor() {
		return busquedaPorProveedor;
	}
	public void setBusquedaPorProveedor(boolean busquedaPorProveedor) {
		this.busquedaPorProveedor = busquedaPorProveedor;
	}
	public String getNombrePapel() {
		return nombrePapel;
	}
	public void setNombrePapel(String nombrePapel) {
		this.nombrePapel = nombrePapel;
	}
	public Float getAncho() {
		return ancho;
	}
	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}
	public Float getAlto() {
		return alto;
	}
	public void setAlto(Float alto) {
		this.alto = alto;
	}
	public Integer getGramaje() {
		return gramaje;
	}
	public void setGramaje(Integer gramaje) {
		this.gramaje = gramaje;
	}
	public Float getKilogramos() {
		return kilogramos;
	}
	public void setKilogramos(Float kilogramos) {
		this.kilogramos = kilogramos;
	}
	public Integer getIdProveedorPapel() {
		return idProveedorPapel;
	}
	public void setIdProveedorPapel(Integer idProveedorPapel) {
		this.idProveedorPapel = idProveedorPapel;
	}
}
