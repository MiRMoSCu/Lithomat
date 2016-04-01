package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class CotizacionExpressDTOVariables implements Serializable {

	private static final long serialVersionUID = 2407089342516412061L;
	
	private int idTipoCliente;
	private int cantidad;
	private int idTipoTrabajo;
	private int repeticionesXPliego;
	private int numeroPaginasPublicacion;
	private int idTamanioPublicacion;
	private float numeroPliegos;
	private boolean incluyeCostoPapel;
	private int idTipoPapelExtendido;
	private int frenteIdCombinacionTintas;
	private int frenteNumeroTintaEspecial;
	private int frenteIdTipoBarniz;
	private int vueltaIdCombinacionTintas;
	private int vueltaNumeroTintaEspecial;
	private int vueltaIdTipoBarniz;
	private int idMaquina;
	private boolean incluyeCostoPlaca;
	private int idTipoPlaca;
	private boolean vueltaMismasPlacas;
	
	
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdTipoTrabajo() {
		return idTipoTrabajo;
	}
	public void setIdTipoTrabajo(int idTipoTrabajo) {
		this.idTipoTrabajo = idTipoTrabajo;
	}
	public int getRepeticionesXPliego() {
		return repeticionesXPliego;
	}
	public void setRepeticionesXPliego(int repeticionesXPliego) {
		this.repeticionesXPliego = repeticionesXPliego;
	}
	public int getNumeroPaginasPublicacion() {
		return numeroPaginasPublicacion;
	}
	public void setNumeroPaginasPublicacion(int numeroPaginasPublicacion) {
		this.numeroPaginasPublicacion = numeroPaginasPublicacion;
	}
	public int getIdTamanioPublicacion() {
		return idTamanioPublicacion;
	}
	public void setIdTamanioPublicacion(int idTamanioPublicacion) {
		this.idTamanioPublicacion = idTamanioPublicacion;
	}
	public float getNumeroPliegos() {
		return numeroPliegos;
	}
	public void setNumeroPliegos(float numeroPliegos) {
		this.numeroPliegos = numeroPliegos;
	}
	public boolean isIncluyeCostoPapel() {
		return incluyeCostoPapel;
	}
	public void setIncluyeCostoPapel(boolean incluyeCostoPapel) {
		this.incluyeCostoPapel = incluyeCostoPapel;
	}
	public int getIdTipoPapelExtendido() {
		return idTipoPapelExtendido;
	}
	public void setIdTipoPapelExtendido(int idTipoPapelExtendido) {
		this.idTipoPapelExtendido = idTipoPapelExtendido;
	}
	public int getFrenteIdCombinacionTintas() {
		return frenteIdCombinacionTintas;
	}
	public void setFrenteIdCombinacionTintas(int frenteIdCombinacionTintas) {
		this.frenteIdCombinacionTintas = frenteIdCombinacionTintas;
	}
	public int getFrenteNumeroTintaEspecial() {
		return frenteNumeroTintaEspecial;
	}
	public void setFrenteNumeroTintaEspecial(int frenteNumeroTintaEspecial) {
		this.frenteNumeroTintaEspecial = frenteNumeroTintaEspecial;
	}
	public int getFrenteIdTipoBarniz() {
		return frenteIdTipoBarniz;
	}
	public void setFrenteIdTipoBarniz(int frenteIdTipoBarniz) {
		this.frenteIdTipoBarniz = frenteIdTipoBarniz;
	}
	public int getVueltaIdCombinacionTintas() {
		return vueltaIdCombinacionTintas;
	}
	public void setVueltaIdCombinacionTintas(int vueltaIdCombinacionTintas) {
		this.vueltaIdCombinacionTintas = vueltaIdCombinacionTintas;
	}
	public int getVueltaNumeroTintaEspecial() {
		return vueltaNumeroTintaEspecial;
	}
	public void setVueltaNumeroTintaEspecial(int vueltaNumeroTintaEspecial) {
		this.vueltaNumeroTintaEspecial = vueltaNumeroTintaEspecial;
	}
	public int getVueltaIdTipoBarniz() {
		return vueltaIdTipoBarniz;
	}
	public void setVueltaIdTipoBarniz(int vueltaIdTipoBarniz) {
		this.vueltaIdTipoBarniz = vueltaIdTipoBarniz;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public boolean isIncluyeCostoPlaca() {
		return incluyeCostoPlaca;
	}
	public void setIncluyeCostoPlaca(boolean incluyeCostoPlaca) {
		this.incluyeCostoPlaca = incluyeCostoPlaca;
	}
	public int getIdTipoPlaca() {
		return idTipoPlaca;
	}
	public void setIdTipoPlaca(int idTipoPlaca) {
		this.idTipoPlaca = idTipoPlaca;
	}
	public boolean isVueltaMismasPlacas() {
		return vueltaMismasPlacas;
	}
	public void setVueltaMismasPlacas(boolean vueltaMismasPlacas) {
		this.vueltaMismasPlacas = vueltaMismasPlacas;
	}
}
