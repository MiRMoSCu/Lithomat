package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class OrdenTrabajoPliego implements Serializable {

	private static final long serialVersionUID = -2227244248046533529L;
	
	private Integer id;
	private String papel;
	private Integer hojasRequeridas;
	private Integer hojasSobrantes;
	private Integer hojasTotales;
	private String frenteEntMaq;
	private String vueltaEntMaq;
	private Integer rebases;
	private Integer medianiles;
	private Integer pinzas;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public Integer getHojasRequeridas() {
		return hojasRequeridas;
	}
	public void setHojasRequeridas(Integer hojasRequeridas) {
		this.hojasRequeridas = hojasRequeridas;
	}
	public Integer getHojasSobrantes() {
		return hojasSobrantes;
	}
	public void setHojasSobrantes(Integer hojasSobrantes) {
		this.hojasSobrantes = hojasSobrantes;
	}
	public Integer getHojasTotales() {
		return hojasTotales;
	}
	public void setHojasTotales(Integer hojasTotales) {
		this.hojasTotales = hojasTotales;
	}
	public String getFrenteEntMaq() {
		return frenteEntMaq;
	}
	public void setFrenteEntMaq(String frenteEntMaq) {
		this.frenteEntMaq = frenteEntMaq;
	}
	public String getVueltaEntMaq() {
		return vueltaEntMaq;
	}
	public void setVueltaEntMaq(String vueltaEntMaq) {
		this.vueltaEntMaq = vueltaEntMaq;
	}
	public Integer getRebases() {
		return rebases;
	}
	public void setRebases(Integer rebases) {
		this.rebases = rebases;
	}
	public Integer getMedianiles() {
		return medianiles;
	}
	public void setMedianiles(Integer medianiles) {
		this.medianiles = medianiles;
	}
	public Integer getPinzas() {
		return pinzas;
	}
	public void setPinzas(Integer pinzas) {
		this.pinzas = pinzas;
	}
}
