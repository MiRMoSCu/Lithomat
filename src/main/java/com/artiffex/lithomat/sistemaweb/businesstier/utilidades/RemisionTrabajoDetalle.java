package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class RemisionTrabajoDetalle implements Serializable {

	private static final long serialVersionUID = -6925377886564154390L;
	
	private String descripcion;
	private double tipoTrabajoDetalleCosteTotal;
	private List<RemisionPliego> listaRemisionPliego;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getTipoTrabajoDetalleCosteTotal() {
		return tipoTrabajoDetalleCosteTotal;
	}
	public void setTipoTrabajoDetalleCosteTotal(double tipoTrabajoDetalleCosteTotal) {
		this.tipoTrabajoDetalleCosteTotal = tipoTrabajoDetalleCosteTotal;
	}
	public List<RemisionPliego> getListaRemisionPliego() {
		return listaRemisionPliego;
	}
	public void setListaRemisionPliego(List<RemisionPliego> listaRemisionPliego) {
		this.listaRemisionPliego = listaRemisionPliego;
	}
}
