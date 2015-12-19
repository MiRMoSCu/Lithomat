package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

public class OrdenTrabajoTipoTrabajoDetalle implements Serializable {

	private static final long serialVersionUID = -6465897234822846136L;
	
	private String maquina;
	private String tipoPlaca;
	private String descripcion;
	private float ancho;
	private float alto;
	private float anchoExtendido;
	private float altoExtendido;
	private String tipoPapel;
	private Integer numeroPaginas;
	private String tamanioPublicacion;
	private Integer repeticionesPorPliego;
	private String frenteCombinacionTintas;
	private String frenteTintaEspecial;
	private String frenteTipoBarniz;
	private String vueltaCombinacionTintas;
	private String vueltaTintaEspecial;
	private String vueltaTipoBarniz;
	private List<OrdenTrabajoPliego> listaOrdenTrabajoPliego;
	
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getTipoPlaca() {
		return tipoPlaca;
	}
	public void setTipoPlaca(String tipoPlaca) {
		this.tipoPlaca = tipoPlaca;
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
	public String getTipoPapel() {
		return tipoPapel;
	}
	public void setTipoPapel(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public String getTamanioPublicacion() {
		return tamanioPublicacion;
	}
	public void setTamanioPublicacion(String tamanioPublicacion) {
		this.tamanioPublicacion = tamanioPublicacion;
	}
	public Integer getRepeticionesPorPliego() {
		return repeticionesPorPliego;
	}
	public void setRepeticionesPorPliego(Integer repeticionesPorPliego) {
		this.repeticionesPorPliego = repeticionesPorPliego;
	}
	public String getFrenteCombinacionTintas() {
		return frenteCombinacionTintas;
	}
	public void setFrenteCombinacionTintas(String frenteCombinacionTintas) {
		this.frenteCombinacionTintas = frenteCombinacionTintas;
	}
	public String getFrenteTintaEspecial() {
		return frenteTintaEspecial;
	}
	public void setFrenteTintaEspecial(String frenteTintaEspecial) {
		this.frenteTintaEspecial = frenteTintaEspecial;
	}
	public String getFrenteTipoBarniz() {
		return frenteTipoBarniz;
	}
	public void setFrenteTipoBarniz(String frenteTipoBarniz) {
		this.frenteTipoBarniz = frenteTipoBarniz;
	}
	public String getVueltaCombinacionTintas() {
		return vueltaCombinacionTintas;
	}
	public void setVueltaCombinacionTintas(String vueltaCombinacionTintas) {
		this.vueltaCombinacionTintas = vueltaCombinacionTintas;
	}
	public String getVueltaTintaEspecial() {
		return vueltaTintaEspecial;
	}
	public void setVueltaTintaEspecial(String vueltaTintaEspecial) {
		this.vueltaTintaEspecial = vueltaTintaEspecial;
	}
	public String getVueltaTipoBarniz() {
		return vueltaTipoBarniz;
	}
	public void setVueltaTipoBarniz(String vueltaTipoBarniz) {
		this.vueltaTipoBarniz = vueltaTipoBarniz;
	}
	public List<OrdenTrabajoPliego> getListaOrdenTrabajoPliego() {
		return listaOrdenTrabajoPliego;
	}
	public void setListaOrdenTrabajoPliego(
			List<OrdenTrabajoPliego> listaOrdenTrabajoPliego) {
		this.listaOrdenTrabajoPliego = listaOrdenTrabajoPliego;
	}
}
