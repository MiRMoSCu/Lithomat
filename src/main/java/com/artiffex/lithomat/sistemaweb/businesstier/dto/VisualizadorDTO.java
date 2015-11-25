package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.sql.Date;

public class VisualizadorDTO implements Serializable {

	private static final long serialVersionUID = 7324757893468068456L;

	private Integer idOrdenProduccion;
	private String nut;
	private String nombre;
	private String descripcion;
	private Date fechaCotizacion;
	private String nombreMoral;
	private Integer idEstatusOrden;
	private String nombreEstatus;
	
	
	public Integer getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(Integer idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
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
	public Date getFechaCotizacion() {
		return fechaCotizacion;
	}
	public void setFechaCotizacion(Date fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}
	public String getNombreMoral() {
		return nombreMoral;
	}
	public void setNombreMoral(String nombreMoral) {
		this.nombreMoral = nombreMoral;
	}
	public Integer getIdEstatusOrden() {
		return idEstatusOrden;
	}
	public void setIdEstatusOrden(Integer idEstatusOrden) {
		this.idEstatusOrden = idEstatusOrden;
	}
	public String getNombreEstatus() {
		return nombreEstatus;
	}
	public void setNombreEstatus(String nombreEstatus) {
		this.nombreEstatus = nombreEstatus;
	}

}
