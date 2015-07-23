package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProveedorExterno implements Serializable {

	private static final long serialVersionUID = -7388779953734508086L;

	private int idProveedorExterno;
	private String razonSocial;
	private String calle;
	private String numExterior;
	private String numInterior;
	private String colonia;
	private String delegacionMunicipio;
	private String estado;
	private String codigoPostal;
	private String pais;
	private String telefono;
	private String email;
	private String observaciones;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<ProcesoExterno> procesoExterno = new HashSet<ProcesoExterno>();
	
	
	public int getIdProveedorExterno() {
		return idProveedorExterno;
	}
	public void setIdProveedorExterno(int idProveedorExterno) {
		this.idProveedorExterno = idProveedorExterno;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumExterior() {
		return numExterior;
	}
	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}
	public String getNumInterior() {
		return numInterior;
	}
	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<ProcesoExterno> getProcesoExterno() {
		return procesoExterno;
	}
	public void setProcesoExterno(Set<ProcesoExterno> procesoExterno) {
		this.procesoExterno = procesoExterno;
	}

}
