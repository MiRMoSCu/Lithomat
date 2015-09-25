package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoPapelExtendido implements Serializable {

	private static final long serialVersionUID = -8998432000371416953L;

	private int idTipoPapelExtendido;
	private ProveedorPapel proveedorPapel;
	private String nombre;
	private int gramaje;
	private float kilogramos;
	private float ancho; 	// es el lado mas grande
	private float alto;		// es el lado mas pequenio
	private String descripcion;
	private float precio;
	private TipoPrecio tipoPrecio;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	
	
	public int getIdTipoPapelExtendido() {
		return idTipoPapelExtendido;
	}
	public void setIdTipoPapelExtendido(int idTipoPapelExtendido) {
		this.idTipoPapelExtendido = idTipoPapelExtendido;
	}
	public ProveedorPapel getProveedorPapel() {
		return proveedorPapel;
	}
	public void setProveedorPapel(ProveedorPapel proveedorPapel) {
		this.proveedorPapel = proveedorPapel;
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
	public Set<TipoTrabajoDetalle> getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(Set<TipoTrabajoDetalle> tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
	}

}
