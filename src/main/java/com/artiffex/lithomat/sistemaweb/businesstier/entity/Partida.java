package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Partida implements Serializable {
	
	private static final long serialVersionUID = 4151926580853583278L;
	
	private int idPartida;
	private OrdenProduccion ordenProduccion;
	private TipoTrabajo tipoTrabajo;
	private TipoFormaTrabajo tipoFormaTrabajo;
	private String nombrePartida;
	private int cantidad;
	private String descripcionPartida;
	private byte[] diagramaFormacion;
	private String observacionesGenerales;
	private String observacionesAprobacion;
	private Timestamp fechaGeneracion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas: 
	private Set<TipoTrabajoDetalle> tipoTrabajoDetalle = new HashSet<TipoTrabajoDetalle>();
	private Set<MaterialAyudaXPartida> materialAyudaXPartida = new HashSet<MaterialAyudaXPartida>();
	private Set<CalificacionPartida> calificacionPartida = new HashSet<CalificacionPartida>();
	private Set<Disenio> disenio = new HashSet<Disenio>();
	private Set<Preprensa> preprensa = new HashSet<Preprensa>();
	private Set<Transporte> transporte = new HashSet<Transporte>();
	private Set<Acabado> acabado = new HashSet<Acabado>();
	private Set<Offset> offset = new HashSet<Offset>();
	
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public TipoFormaTrabajo getTipoFormaTrabajo() {
		return tipoFormaTrabajo;
	}
	public void setTipoFormaTrabajo(TipoFormaTrabajo tipoFormaTrabajo) {
		this.tipoFormaTrabajo = tipoFormaTrabajo;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
	public byte[] getDiagramaFormacion() {
		return diagramaFormacion;
	}
	public void setDiagramaFormacion(byte[] diagramaFormacion) {
		this.diagramaFormacion = diagramaFormacion;
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
	public Timestamp getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Timestamp fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
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
	public Set<MaterialAyudaXPartida> getMaterialAyudaXPartida() {
		return materialAyudaXPartida;
	}
	public void setMaterialAyudaXPartida(
			Set<MaterialAyudaXPartida> materialAyudaXPartida) {
		this.materialAyudaXPartida = materialAyudaXPartida;
	}
	public Set<CalificacionPartida> getCalificacionPartida() {
		return calificacionPartida;
	}
	public void setCalificacionPartida(Set<CalificacionPartida> calificacionPartida) {
		this.calificacionPartida = calificacionPartida;
	}
	public Set<Disenio> getDisenio() {
		return disenio;
	}
	public void setDisenio(Set<Disenio> disenio) {
		this.disenio = disenio;
	}
	public Set<Preprensa> getPreprensa() {
		return preprensa;
	}
	public void setPreprensa(Set<Preprensa> preprensa) {
		this.preprensa = preprensa;
	}
	public Set<Transporte> getTransporte() {
		return transporte;
	}
	public void setTransporte(Set<Transporte> transporte) {
		this.transporte = transporte;
	}
	public Set<Acabado> getAcabado() {
		return acabado;
	}
	public void setAcabado(Set<Acabado> acabado) {
		this.acabado = acabado;
	}
	public Set<Offset> getOffset() {
		return offset;
	}
	public void setOffset(Set<Offset> offset) {
		this.offset = offset;
	}
}
