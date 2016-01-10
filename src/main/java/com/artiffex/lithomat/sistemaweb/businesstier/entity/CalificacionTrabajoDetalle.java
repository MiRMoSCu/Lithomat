package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CalificacionTrabajoDetalle implements Serializable {

	private static final long serialVersionUID = -7631501597091728908L;

	private int idCalificacionTrabajoDetalle;
	private TipoTrabajoDetalle tipoTrabajoDetalle;
	private double tipoTrabajoDetalleCosteTotal;
	private double papelCosteTotal;
	private double placasCosteTotal;
	private double tintaCosteTotal;
	private double tintaEspecialCosteTotal;
	private double frenteBarnizCosteTotal;
	private double vueltaBarnizCosteTotal;
	private boolean activo;
	
	
	public int getIdCalificacionTrabajoDetalle() {
		return idCalificacionTrabajoDetalle;
	}
	public void setIdCalificacionTrabajoDetalle(int idCalificacionTrabajoDetalle) {
		this.idCalificacionTrabajoDetalle = idCalificacionTrabajoDetalle;
	}
	public TipoTrabajoDetalle getTipoTrabajoDetalle() {
		return tipoTrabajoDetalle;
	}
	public void setTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		this.tipoTrabajoDetalle = tipoTrabajoDetalle;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
