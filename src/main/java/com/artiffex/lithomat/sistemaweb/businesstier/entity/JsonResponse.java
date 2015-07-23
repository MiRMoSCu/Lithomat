package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class JsonResponse implements Serializable {

	private static final long serialVersionUID = 7026079444950971723L;

	private int 	estatusOperacion;
	private String 	textoJson;
	private String 	textoHTML;
	private int 	idOrdenProduccion;
	private int 	idPartida;
	private int 	idTipoTrabajoDetalle;
	private int 	idDisenio;
	private int 	idPreprensa;
	private int 	idTransporte;
	private int 	idAcabado;
	private int 	idOffset;
	private double	precioNeto;
	
	
	public int getEstatusOperacion() {
		return estatusOperacion;
	}
	public void setEstatusOperacion(int estatusOperacion) {
		this.estatusOperacion = estatusOperacion;
	}
	public String getTextoJson() {
		return textoJson;
	}
	public void setTextoJson(String textoJson) {
		this.textoJson = textoJson;
	}
	public String getTextoHTML() {
		return textoHTML;
	}
	public void setTextoHTML(String textoHTML) {
		this.textoHTML = textoHTML;
	}
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public int getIdTipoTrabajoDetalle() {
		return idTipoTrabajoDetalle;
	}
	public void setIdTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		this.idTipoTrabajoDetalle = idTipoTrabajoDetalle;
	}
	public int getIdDisenio() {
		return idDisenio;
	}
	public void setIdDisenio(int idDisenio) {
		this.idDisenio = idDisenio;
	}
	public int getIdPreprensa() {
		return idPreprensa;
	}
	public void setIdPreprensa(int idPreprensa) {
		this.idPreprensa = idPreprensa;
	}
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public int getIdAcabado() {
		return idAcabado;
	}
	public void setIdAcabado(int idAcabado) {
		this.idAcabado = idAcabado;
	}
	public int getIdOffset() {
		return idOffset;
	}
	public void setIdOffset(int idOffset) {
		this.idOffset = idOffset;
	}
	public double getPrecioNeto() {
		return precioNeto;
	}
	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}
}
