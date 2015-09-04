package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class OrdenTrabajoPartida implements Serializable {

	private static final long serialVersionUID = -7391707563318274113L;
	
	private String tipoTrabajo;
	private Integer cantidad;
	private String nombrePartida;
	private String descripcionPartida;
	private String observacionesGenerales;
	private String observacionesAprobacion;
	private List<OrdenTrabajoTipoTrabajoDetalle> listaOrdenTrabajoTipoTrabajoDetalle;
	
	
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}
	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}
	public String getObservacionesAprobacion() {
		return observacionesAprobacion;
	}
	public void setObservacionesAprobacion(String observacionesAprobacion) {
		this.observacionesAprobacion = observacionesAprobacion;
	}
	public List<OrdenTrabajoTipoTrabajoDetalle> getListaOrdenTrabajoTipoTrabajoDetalle() {
		return listaOrdenTrabajoTipoTrabajoDetalle;
	}
	public void setListaOrdenTrabajoTipoTrabajoDetalle(
			List<OrdenTrabajoTipoTrabajoDetalle> listaOrdenTrabajoTipoTrabajoDetalle) {
		this.listaOrdenTrabajoTipoTrabajoDetalle = listaOrdenTrabajoTipoTrabajoDetalle;
	}
}
