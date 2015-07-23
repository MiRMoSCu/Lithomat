package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class OrdenProduccion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7997731418779776076L;
	
	private int idOrdenProduccion;
	private Usuario usuario;
	private Cliente cliente;
	private TipoComprobanteFiscal tipoComprobanteFiscal;
	private String nut;
	private String nombre;
	private String descripcion;
	private Timestamp fechaCotizacion;
	private Timestamp fechaPrometidaEntrega;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private Timestamp fechaEntrega;
	private Timestamp fechaGeneracion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<HistorialEstatus> historialEstatus = new HashSet<HistorialEstatus>();
	private Set<Cobranza> cobranza = new HashSet<Cobranza>();
	private Set<CalificacionOrdenProduccion> calificacionOrdenProduccion = new HashSet<CalificacionOrdenProduccion>();
	private Set<Partida> partida = new HashSet<Partida>();
	
	
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public TipoComprobanteFiscal getTipoComprobanteFiscal() {
		return tipoComprobanteFiscal;
	}
	public void setTipoComprobanteFiscal(TipoComprobanteFiscal tipoComprobanteFiscal) {
		this.tipoComprobanteFiscal = tipoComprobanteFiscal;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
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
	public Timestamp getFechaCotizacion() {
		return fechaCotizacion;
	}
	public void setFechaCotizacion(Timestamp fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}
	public Timestamp getFechaPrometidaEntrega() {
		return fechaPrometidaEntrega;
	}
	public void setFechaPrometidaEntrega(Timestamp fechaPrometidaEntrega) {
		this.fechaPrometidaEntrega = fechaPrometidaEntrega;
	}
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
	public Set<HistorialEstatus> getHistorialEstatus() {
		return historialEstatus;
	}
	public void setHistorialEstatus(Set<HistorialEstatus> historialEstatus) {
		this.historialEstatus = historialEstatus;
	}
	public Set<Cobranza> getCobranza() {
		return cobranza;
	}
	public void setCobranza(Set<Cobranza> cobranza) {
		this.cobranza = cobranza;
	}
	public Set<CalificacionOrdenProduccion> getCalificacionOrdenProduccion() {
		return calificacionOrdenProduccion;
	}
	public void setCalificacionOrdenProduccion(
			Set<CalificacionOrdenProduccion> calificacionOrdenProduccion) {
		this.calificacionOrdenProduccion = calificacionOrdenProduccion;
	}
	public Set<Partida> getPartida() {
		return partida;
	}
	public void setPartida(Set<Partida> partida) {
		this.partida = partida;
	}
}
