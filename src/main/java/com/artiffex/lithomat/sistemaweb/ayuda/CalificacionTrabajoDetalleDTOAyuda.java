package com.artiffex.lithomat.sistemaweb.ayuda;

import java.io.Serializable;

public class CalificacionTrabajoDetalleDTOAyuda implements Serializable {
	
	private static final long serialVersionUID = -4695316234335854725L;
	
	public int idTipoPapelExtendido;
	public int papelCantidadTotal;
	public float papelPrecioUnitario;
	public float papelCosteTotal;
	
	
	public int getIdTipoPapelExtendido() {
		return idTipoPapelExtendido;
	}
	public void setIdTipoPapelExtendido(int idTipoPapelExtendido) {
		this.idTipoPapelExtendido = idTipoPapelExtendido;
	}
	public int getPapelCantidadTotal() {
		return papelCantidadTotal;
	}
	public void setPapelCantidadTotal(int papelCantidadTotal) {
		this.papelCantidadTotal = papelCantidadTotal;
	}
	public float getPapelPrecioUnitario() {
		return papelPrecioUnitario;
	}
	public void setPapelPrecioUnitario(float papelPrecioUnitario) {
		this.papelPrecioUnitario = papelPrecioUnitario;
	}
	public float getPapelCosteTotal() {
		return papelCosteTotal;
	}
	public void setPapelCosteTotal(float papelCosteTotal) {
		this.papelCosteTotal = papelCosteTotal;
	}
	
}
