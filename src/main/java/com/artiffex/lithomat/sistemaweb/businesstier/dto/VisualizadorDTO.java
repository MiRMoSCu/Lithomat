package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.sql.Date;

public class VisualizadorDTO implements Serializable {

	private static final long serialVersionUID = 7324757893468068456L;

	private Integer id_orden_produccion;
	private String nut;
	private String nombre;
	private String descripcion;
	private Date fecha_cotizacion;
	private String nombre_moral;
	private Integer id_estatus_orden;
	private String nombre_estatus;

	public void setId_orden_produccion(Integer id_orden_produccion) {
		this.id_orden_produccion = id_orden_produccion;
	}

	public Integer getId_orden_produccion() {
		return id_orden_produccion;
	}

	public void setNut(String nut) {
		this.nut = nut;
	}

	public String getNut() {
		return nut;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setFecha_cotizacion(Date fecha_cotizacion) {
		this.fecha_cotizacion = fecha_cotizacion;
	}

	public Date getFecha_cotizacion() {
		return fecha_cotizacion;
	}

	public void setNombre_moral(String nombre_moral) {
		this.nombre_moral = nombre_moral;
	}

	public String getNombre_moral() {
		return nombre_moral;
	}

	public void setId_estatus_orden(Integer id_estatus_orden) {
		this.id_estatus_orden = id_estatus_orden;
	}

	public Integer getId_estatus_orden() {
		return id_estatus_orden;
	}

	public void setNombre_estatus(String nombre_estatus) {
		this.nombre_estatus = nombre_estatus;
	}

	public String getNombre_estatus() {
		return nombre_estatus;
	}
}
