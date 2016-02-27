package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ParametrosBusquedaCliente implements Serializable {

	private static final long serialVersionUID = 3525002938864040876L;
	
	private boolean busquedaPorTipoCliente;
	private boolean busquedaPorNombreMoral;
	private boolean busquedaPorNombreRepresentante;
	private boolean busquedaPorCodigoPostal;
	private boolean busquedaPorRfc;
	private int idTipoCliente;
	private String nombreMoral;
	private String nombreRepresentante;
	private String codigoPostal;
	private String rfc;
	
	
	public boolean isBusquedaPorTipoCliente() {
		return busquedaPorTipoCliente;
	}
	public void setBusquedaPorTipoCliente(boolean busquedaPorTipoCliente) {
		this.busquedaPorTipoCliente = busquedaPorTipoCliente;
	}
	public boolean isBusquedaPorNombreMoral() {
		return busquedaPorNombreMoral;
	}
	public void setBusquedaPorNombreMoral(boolean busquedaPorNombreMoral) {
		this.busquedaPorNombreMoral = busquedaPorNombreMoral;
	}
	public boolean isBusquedaPorNombreRepresentante() {
		return busquedaPorNombreRepresentante;
	}
	public void setBusquedaPorNombreRepresentante(
			boolean busquedaPorNombreRepresentante) {
		this.busquedaPorNombreRepresentante = busquedaPorNombreRepresentante;
	}
	public boolean isBusquedaPorCodigoPostal() {
		return busquedaPorCodigoPostal;
	}
	public void setBusquedaPorCodigoPostal(boolean busquedaPorCodigoPostal) {
		this.busquedaPorCodigoPostal = busquedaPorCodigoPostal;
	}
	public boolean isBusquedaPorRfc() {
		return busquedaPorRfc;
	}
	public void setBusquedaPorRfc(boolean busquedaPorRfc) {
		this.busquedaPorRfc = busquedaPorRfc;
	}
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public String getNombreMoral() {
		return nombreMoral;
	}
	public void setNombreMoral(String nombreMoral) {
		this.nombreMoral = nombreMoral;
	}
	public String getNombreRepresentante() {
		return nombreRepresentante;
	}
	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}
