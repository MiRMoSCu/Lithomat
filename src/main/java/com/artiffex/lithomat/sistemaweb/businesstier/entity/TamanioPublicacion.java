package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TamanioPublicacion implements Serializable {

	private static final long serialVersionUID = 7951734777182734993L;

	private int idTamanioPublicacion;
	private String nombre;
	private String tamanioFraccion;
	private int numeroPaginas;
	private float numeroDecimal;
	private int numeroDoblez;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	
	
	public int getIdTamanioPublicacion() {
		return idTamanioPublicacion;
	}
	public void setIdTamanioPublicacion(int idTamanioPublicacion) {
		this.idTamanioPublicacion = idTamanioPublicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTamanioFraccion() {
		return tamanioFraccion;
	}
	public void setTamanioFraccion(String tamanioFraccion) {
		this.tamanioFraccion = tamanioFraccion;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public float getNumeroDecimal() {
		return numeroDecimal;
	}
	public void setNumeroDecimal(float numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
	}
	public int getNumeroDoblez() {
		return numeroDoblez;
	}
	public void setNumeroDoblez(int numeroDoblez) {
		this.numeroDoblez = numeroDoblez;
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
