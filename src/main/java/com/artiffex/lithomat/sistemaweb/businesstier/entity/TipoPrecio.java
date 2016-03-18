package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoPrecio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -718295408013063437L;
	
	private int idTipoPrecio;
	private String nombre;
	private String descripcion;
	private int factorDivisor;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<TipoCliente> tipoCliente = new HashSet<TipoCliente>();
	private Set<CostoExtra> costoExtra = new HashSet<CostoExtra>();
	private Set<TipoComprobanteFiscal> tipoComprobanteFiscal = new HashSet<TipoComprobanteFiscal>();
	private Set<TipoPapelExtendido> tipoPapelExtendido = new HashSet<TipoPapelExtendido>();
	private Set<TintaEspecial> tintaEspecial = new HashSet<TintaEspecial>();
	private Set<TipoBarniz> tipoBarniz = new HashSet<TipoBarniz>();
	private Set<TipoPlaca> tipoPlaca = new HashSet<TipoPlaca>();
	private Set<TabuladorPrecios> tabuladorPrecios = new HashSet<TabuladorPrecios>();
	private Set<ProcesoExterno> procesoExterno = new HashSet<ProcesoExterno>();
	private Set<ProcesoTransporte> procesoTransporte = new HashSet<ProcesoTransporte>();
	private Set<ProcesoDisenio> procesoDisenio = new HashSet<ProcesoDisenio>();
	private Set<ProcesoPreprensa> procesoPreprensa = new HashSet<ProcesoPreprensa>();
	private Set<ParametrosConfig> parametrosConfig = new HashSet<ParametrosConfig>();
	private Set<DescuentoTabuladorPrecios> descuentoTabuladorPrecios = new HashSet<DescuentoTabuladorPrecios>();
	
	
	public int getIdTipoPrecio() {
		return idTipoPrecio;
	}
	public void setIdTipoPrecio(int idTipoPrecio) {
		this.idTipoPrecio = idTipoPrecio;
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
	public int getFactorDivisor() {
		return factorDivisor;
	}
	public void setFactorDivisor(int factorDivisor) {
		this.factorDivisor = factorDivisor;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<TipoCliente> getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(Set<TipoCliente> tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Set<CostoExtra> getCostoExtra() {
		return costoExtra;
	}
	public void setCostoExtra(Set<CostoExtra> costoExtra) {
		this.costoExtra = costoExtra;
	}
	public Set<TipoComprobanteFiscal> getTipoComprobanteFiscal() {
		return tipoComprobanteFiscal;
	}
	public void setTipoComprobanteFiscal(
			Set<TipoComprobanteFiscal> tipoComprobanteFiscal) {
		this.tipoComprobanteFiscal = tipoComprobanteFiscal;
	}
	public Set<TipoPapelExtendido> getTipoPapelExtendido() {
		return tipoPapelExtendido;
	}
	public void setTipoPapelExtendido(Set<TipoPapelExtendido> tipoPapelExtendido) {
		this.tipoPapelExtendido = tipoPapelExtendido;
	}
	public Set<TintaEspecial> getTintaEspecial() {
		return tintaEspecial;
	}
	public void setTintaEspecial(Set<TintaEspecial> tintaEspecial) {
		this.tintaEspecial = tintaEspecial;
	}
	public Set<TipoBarniz> getTipoBarniz() {
		return tipoBarniz;
	}
	public void setTipoBarniz(Set<TipoBarniz> tipoBarniz) {
		this.tipoBarniz = tipoBarniz;
	}
	public Set<TipoPlaca> getTipoPlaca() {
		return tipoPlaca;
	}
	public void setTipoPlaca(Set<TipoPlaca> tipoPlaca) {
		this.tipoPlaca = tipoPlaca;
	}
	public Set<TabuladorPrecios> getTabuladorPrecios() {
		return tabuladorPrecios;
	}
	public void setTabuladorPrecios(Set<TabuladorPrecios> tabuladorPrecios) {
		this.tabuladorPrecios = tabuladorPrecios;
	}
	public Set<ProcesoExterno> getProcesoExterno() {
		return procesoExterno;
	}
	public void setProcesoExterno(Set<ProcesoExterno> procesoExterno) {
		this.procesoExterno = procesoExterno;
	}
	public Set<ProcesoTransporte> getProcesoTransporte() {
		return procesoTransporte;
	}
	public void setProcesoTransporte(Set<ProcesoTransporte> procesoTransporte) {
		this.procesoTransporte = procesoTransporte;
	}
	public Set<ProcesoDisenio> getProcesoDisenio() {
		return procesoDisenio;
	}
	public void setProcesoDisenio(Set<ProcesoDisenio> procesoDisenio) {
		this.procesoDisenio = procesoDisenio;
	}
	public Set<ProcesoPreprensa> getProcesoPreprensa() {
		return procesoPreprensa;
	}
	public void setProcesoPreprensa(Set<ProcesoPreprensa> procesoPreprensa) {
		this.procesoPreprensa = procesoPreprensa;
	}
	public Set<ParametrosConfig> getParametrosConfig() {
		return parametrosConfig;
	}
	public void setParametrosConfig(Set<ParametrosConfig> parametrosConfig) {
		this.parametrosConfig = parametrosConfig;
	}
	public Set<DescuentoTabuladorPrecios> getDescuentoTabuladorPrecios() {
		return descuentoTabuladorPrecios;
	}
	public void setDescuentoTabuladorPrecios(
			Set<DescuentoTabuladorPrecios> descuentoTabuladorPrecios) {
		this.descuentoTabuladorPrecios = descuentoTabuladorPrecios;
	}
}
