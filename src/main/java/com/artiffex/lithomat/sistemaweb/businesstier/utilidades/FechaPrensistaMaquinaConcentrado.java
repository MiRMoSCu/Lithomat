package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FechaPrensistaMaquinaConcentrado implements Serializable {

	private static final long serialVersionUID = -5451918168202116377L;
	
	private Date fechaImpresion;
	private String prensista;
	private String prensistaAyudante;
	private String maquina;
	private BigDecimal hojasBuenas;
	private BigDecimal cambioPlacas;
	
	
	public Date getFechaImpresion() {
		return fechaImpresion;
	}
	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}
	public String getPrensista() {
		return prensista;
	}
	public void setPrensista(String prensista) {
		this.prensista = prensista;
	}
	public String getPrensistaAyudante() {
		return prensistaAyudante;
	}
	public void setPrensistaAyudante(String prensistaAyudante) {
		this.prensistaAyudante = prensistaAyudante;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public BigDecimal getHojasBuenas() {
		return hojasBuenas;
	}
	public void setHojasBuenas(BigDecimal hojasBuenas) {
		this.hojasBuenas = hojasBuenas;
	}
	public BigDecimal getCambioPlacas() {
		return cambioPlacas;
	}
	public void setCambioPlacas(BigDecimal cambioPlacas) {
		this.cambioPlacas = cambioPlacas;
	}
}
