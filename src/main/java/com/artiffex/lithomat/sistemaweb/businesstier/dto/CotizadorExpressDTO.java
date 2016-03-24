package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CotizadorExpressDTO implements Serializable {

	private static final long serialVersionUID = 7379811967908856425L;
	
	private String tintaDescripcion;
	private String tintaEspecialDescripcion;
	private String barnizDescripcion;
	private String placasDescripcion;
	private float tintaCosteTotal;
	private float tintaEspecialCosteTotal;
	private float barnizCosteTotal;
	private float placasCosteTotal;
	private float cotizacionCosteTotal;
	
	
	public String getTintaDescripcion() {
		return tintaDescripcion;
	}
	public void setTintaDescripcion(String tintaDescripcion) {
		this.tintaDescripcion = tintaDescripcion;
	}
	public String getTintaEspecialDescripcion() {
		return tintaEspecialDescripcion;
	}
	public void setTintaEspecialDescripcion(String tintaEspecialDescripcion) {
		this.tintaEspecialDescripcion = tintaEspecialDescripcion;
	}
	public String getBarnizDescripcion() {
		return barnizDescripcion;
	}
	public void setBarnizDescripcion(String barnizDescripcion) {
		this.barnizDescripcion = barnizDescripcion;
	}
	public String getPlacasDescripcion() {
		return placasDescripcion;
	}
	public void setPlacasDescripcion(String placasDescripcion) {
		this.placasDescripcion = placasDescripcion;
	}
	public float getTintaCosteTotal() {
		return tintaCosteTotal;
	}
	public void setTintaCosteTotal(float tintaCosteTotal) {
		this.tintaCosteTotal = tintaCosteTotal;
	}
	public float getTintaEspecialCosteTotal() {
		return tintaEspecialCosteTotal;
	}
	public void setTintaEspecialCosteTotal(float tintaEspecialCosteTotal) {
		this.tintaEspecialCosteTotal = tintaEspecialCosteTotal;
	}
	public float getBarnizCosteTotal() {
		return barnizCosteTotal;
	}
	public void setBarnizCosteTotal(float barnizCosteTotal) {
		this.barnizCosteTotal = barnizCosteTotal;
	}
	public float getPlacasCosteTotal() {
		return placasCosteTotal;
	}
	public void setPlacasCosteTotal(float placasCosteTotal) {
		this.placasCosteTotal = placasCosteTotal;
	}
	public float getCotizacionCosteTotal() {
		return cotizacionCosteTotal;
	}
	public void setCotizacionCosteTotal(float cotizacionCosteTotal) {
		this.cotizacionCosteTotal = cotizacionCosteTotal;
	}
}
