package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class TipoTrabajoDetalleDTO implements Serializable {

	private static final long serialVersionUID = -7801851443352675944L;
	
	private int idTipoTrabajoDetalle;
	private String descripcion;
	private float ancho;
	private float alto;
	private float anchoExtendido;
	private float altoExtendido;
	private boolean clienteProporcionaPapel;
	private boolean clienteProporcionaTinta;
	private boolean clienteProporcionaTintaEspecial;
	private boolean clienteProporcionaBarniz;
	private boolean clienteProporcionaPlacas;
	private String descripcionTipoPapelExtendido;
	private int repeticionesXPliego;
	private int numeroPaginasPublicacion;
	private String descripcionTamanioPublicacion;
	private String frenteDescripcionNumTintas;
	private int frenteNumTintaEspecial;
	private String frenteDescripcionTintaEspecial;
	private String frenteDescripcionTipoBarniz;
	private String vueltaDescripcionNumTintas;
	private int vueltaNumTintaEspecial;
	private String vueltaDescripcionTintaEspecial;
	private String vueltaDescripcionTipoBarniz;
	private String nombreMaquina;
	private String descripcionPlaca;
	
	
	public int getIdTipoTrabajoDetalle() {
		return idTipoTrabajoDetalle;
	}
	public void setIdTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		this.idTipoTrabajoDetalle = idTipoTrabajoDetalle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public float getAnchoExtendido() {
		return anchoExtendido;
	}
	public void setAnchoExtendido(float anchoExtendido) {
		this.anchoExtendido = anchoExtendido;
	}
	public float getAltoExtendido() {
		return altoExtendido;
	}
	public void setAltoExtendido(float altoExtendido) {
		this.altoExtendido = altoExtendido;
	}
	public boolean isClienteProporcionaPapel() {
		return clienteProporcionaPapel;
	}
	public void setClienteProporcionaPapel(boolean clienteProporcionaPapel) {
		this.clienteProporcionaPapel = clienteProporcionaPapel;
	}
	public boolean isClienteProporcionaTinta() {
		return clienteProporcionaTinta;
	}
	public void setClienteProporcionaTinta(boolean clienteProporcionaTinta) {
		this.clienteProporcionaTinta = clienteProporcionaTinta;
	}
	public boolean isClienteProporcionaTintaEspecial() {
		return clienteProporcionaTintaEspecial;
	}
	public void setClienteProporcionaTintaEspecial(
			boolean clienteProporcionaTintaEspecial) {
		this.clienteProporcionaTintaEspecial = clienteProporcionaTintaEspecial;
	}
	public boolean isClienteProporcionaBarniz() {
		return clienteProporcionaBarniz;
	}
	public void setClienteProporcionaBarniz(boolean clienteProporcionaBarniz) {
		this.clienteProporcionaBarniz = clienteProporcionaBarniz;
	}
	public boolean isClienteProporcionaPlacas() {
		return clienteProporcionaPlacas;
	}
	public void setClienteProporcionaPlacas(boolean clienteProporcionaPlacas) {
		this.clienteProporcionaPlacas = clienteProporcionaPlacas;
	}
	public String getDescripcionTipoPapelExtendido() {
		return descripcionTipoPapelExtendido;
	}
	public void setDescripcionTipoPapelExtendido(
			String descripcionTipoPapelExtendido) {
		this.descripcionTipoPapelExtendido = descripcionTipoPapelExtendido;
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
	public String getDescripcionTamanioPublicacion() {
		return descripcionTamanioPublicacion;
	}
	public void setDescripcionTamanioPublicacion(
			String descripcionTamanioPublicacion) {
		this.descripcionTamanioPublicacion = descripcionTamanioPublicacion;
	}
	public String getFrenteDescripcionNumTintas() {
		return frenteDescripcionNumTintas;
	}
	public void setFrenteDescripcionNumTintas(String frenteDescripcionNumTintas) {
		this.frenteDescripcionNumTintas = frenteDescripcionNumTintas;
	}
	public int getFrenteNumTintaEspecial() {
		return frenteNumTintaEspecial;
	}
	public void setFrenteNumTintaEspecial(int frenteNumTintaEspecial) {
		this.frenteNumTintaEspecial = frenteNumTintaEspecial;
	}
	public String getFrenteDescripcionTintaEspecial() {
		return frenteDescripcionTintaEspecial;
	}
	public void setFrenteDescripcionTintaEspecial(
			String frenteDescripcionTintaEspecial) {
		this.frenteDescripcionTintaEspecial = frenteDescripcionTintaEspecial;
	}
	public String getFrenteDescripcionTipoBarniz() {
		return frenteDescripcionTipoBarniz;
	}
	public void setFrenteDescripcionTipoBarniz(String frenteDescripcionTipoBarniz) {
		this.frenteDescripcionTipoBarniz = frenteDescripcionTipoBarniz;
	}
	public String getVueltaDescripcionNumTintas() {
		return vueltaDescripcionNumTintas;
	}
	public void setVueltaDescripcionNumTintas(String vueltaDescripcionNumTintas) {
		this.vueltaDescripcionNumTintas = vueltaDescripcionNumTintas;
	}
	public int getVueltaNumTintaEspecial() {
		return vueltaNumTintaEspecial;
	}
	public void setVueltaNumTintaEspecial(int vueltaNumTintaEspecial) {
		this.vueltaNumTintaEspecial = vueltaNumTintaEspecial;
	}
	public String getVueltaDescripcionTintaEspecial() {
		return vueltaDescripcionTintaEspecial;
	}
	public void setVueltaDescripcionTintaEspecial(
			String vueltaDescripcionTintaEspecial) {
		this.vueltaDescripcionTintaEspecial = vueltaDescripcionTintaEspecial;
	}
	public String getVueltaDescripcionTipoBarniz() {
		return vueltaDescripcionTipoBarniz;
	}
	public void setVueltaDescripcionTipoBarniz(String vueltaDescripcionTipoBarniz) {
		this.vueltaDescripcionTipoBarniz = vueltaDescripcionTipoBarniz;
	}
	public String getNombreMaquina() {
		return nombreMaquina;
	}
	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	public String getDescripcionPlaca() {
		return descripcionPlaca;
	}
	public void setDescripcionPlaca(String descripcionPlaca) {
		this.descripcionPlaca = descripcionPlaca;
	}
	
}
