package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CalificacionTrabajoDetalleDTO implements Serializable {

	private static final long serialVersionUID = -2279538980827888654L;
	
	private int idCalificacionTrabajoDetalle;
	private double tipoTrabajoDetalleCosteTotal;
	private double papelCosteTotal;
	private double placasCosteTotal;
	private double tintaCosteTotal;
	private double tintaEspecialCosteTotal;
	private double frenteBarnizCosteTotal;
	private double vueltaBarnizCosteTotal;
	private double costosExtraCosteTotal;
	// campos utilizados para mostrar información en pantalla
	private String descripcion;
	private String maquinaDescripcion;
	private int repeticionesXPliego;
	private int numeroPaginasPublicacion;
	private String tamanioPublicacion;
	private boolean clienteProporcionaPapel;
	private boolean clienteProporcionaTinta;
	private boolean clienteProporcionaTintaEspecial;
	private boolean clienteProporcionaBarniz;
	private boolean clienteProporcionaPlacas;
	
	
	public int getIdCalificacionTrabajoDetalle() {
		return idCalificacionTrabajoDetalle;
	}
	public void setIdCalificacionTrabajoDetalle(int idCalificacionTrabajoDetalle) {
		this.idCalificacionTrabajoDetalle = idCalificacionTrabajoDetalle;
	}
	public double getTipoTrabajoDetalleCosteTotal() {
		return tipoTrabajoDetalleCosteTotal;
	}
	public void setTipoTrabajoDetalleCosteTotal(double tipoTrabajoDetalleCosteTotal) {
		this.tipoTrabajoDetalleCosteTotal = tipoTrabajoDetalleCosteTotal;
	}
	public double getPapelCosteTotal() {
		return papelCosteTotal;
	}
	public void setPapelCosteTotal(double papelCosteTotal) {
		this.papelCosteTotal = papelCosteTotal;
	}
	public double getPlacasCosteTotal() {
		return placasCosteTotal;
	}
	public void setPlacasCosteTotal(double placasCosteTotal) {
		this.placasCosteTotal = placasCosteTotal;
	}
	public double getTintaCosteTotal() {
		return tintaCosteTotal;
	}
	public void setTintaCosteTotal(double tintaCosteTotal) {
		this.tintaCosteTotal = tintaCosteTotal;
	}
	public double getTintaEspecialCosteTotal() {
		return tintaEspecialCosteTotal;
	}
	public void setTintaEspecialCosteTotal(double tintaEspecialCosteTotal) {
		this.tintaEspecialCosteTotal = tintaEspecialCosteTotal;
	}
	public double getFrenteBarnizCosteTotal() {
		return frenteBarnizCosteTotal;
	}
	public void setFrenteBarnizCosteTotal(double frenteBarnizCosteTotal) {
		this.frenteBarnizCosteTotal = frenteBarnizCosteTotal;
	}
	public double getVueltaBarnizCosteTotal() {
		return vueltaBarnizCosteTotal;
	}
	public void setVueltaBarnizCosteTotal(double vueltaBarnizCosteTotal) {
		this.vueltaBarnizCosteTotal = vueltaBarnizCosteTotal;
	}
	public double getCostosExtraCosteTotal() {
		return costosExtraCosteTotal;
	}
	public void setCostosExtraCosteTotal(double costosExtraCosteTotal) {
		this.costosExtraCosteTotal = costosExtraCosteTotal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMaquinaDescripcion() {
		return maquinaDescripcion;
	}
	public void setMaquinaDescripcion(String maquinaDescripcion) {
		this.maquinaDescripcion = maquinaDescripcion;
	}
	public int getRepeticionesXPliego() {
		return repeticionesXPliego;
	}
	public void setRepeticionesXPliego(int repeticionesXPliego) {
		this.repeticionesXPliego = repeticionesXPliego;
	}
	public int getNumeroPaginasPublicacion() {
		return numeroPaginasPublicacion;
	}
	public void setNumeroPaginasPublicacion(int numeroPaginasPublicacion) {
		this.numeroPaginasPublicacion = numeroPaginasPublicacion;
	}
	public String getTamanioPublicacion() {
		return tamanioPublicacion;
	}
	public void setTamanioPublicacion(String tamanioPublicacion) {
		this.tamanioPublicacion = tamanioPublicacion;
	}
	public boolean isClienteProporcionaPapel() {
		return clienteProporcionaPapel;
	}
	public void setClienteProporcionaPapel(boolean clienteProporcionaPapel) {
		this.clienteProporcionaPapel = clienteProporcionaPapel;
	}
	public boolean isClienteProporcionaTinta() {
		return clienteProporcionaTinta;
	}
	public void setClienteProporcionaTinta(boolean clienteProporcionaTinta) {
		this.clienteProporcionaTinta = clienteProporcionaTinta;
	}
	public boolean isClienteProporcionaTintaEspecial() {
		return clienteProporcionaTintaEspecial;
	}
	public void setClienteProporcionaTintaEspecial(
			boolean clienteProporcionaTintaEspecial) {
		this.clienteProporcionaTintaEspecial = clienteProporcionaTintaEspecial;
	}
	public boolean isClienteProporcionaBarniz() {
		return clienteProporcionaBarniz;
	}
	public void setClienteProporcionaBarniz(boolean clienteProporcionaBarniz) {
		this.clienteProporcionaBarniz = clienteProporcionaBarniz;
	}
	public boolean isClienteProporcionaPlacas() {
		return clienteProporcionaPlacas;
	}
	public void setClienteProporcionaPlacas(boolean clienteProporcionaPlacas) {
		this.clienteProporcionaPlacas = clienteProporcionaPlacas;
	}
}
