package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class TipoTrabajoDetalle implements Serializable {

	private static final long serialVersionUID = -3776964822001944608L;

	private int idTipoTrabajoDetalle;
	private Partida partida;
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
	private TipoPapelExtendido tipoPapelExtendido;
	private int repeticionesXPliego;
	private int numeroPaginasPublicacion;
	private TamanioPublicacion tamanioPublicacion;
	private CombinacionTintas frenteCombinacionTintas;
	private int frenteNumTintaEspecial;
	private String frenteDescripcionTintaEspecial;
	private TipoBarniz frenteTipoBarniz;
	private CombinacionTintas vueltaCombinacionTintas;
	private int vueltaNumTintaEspecial;
	private String vueltaDescripcionTintaEspecial;
	private TipoBarniz vueltaTipoBarniz;
	private Maquina maquina;
	private TipoPlaca tipoPlaca;
	private TipoComplejidad tipoComplejidad;
	private String observaciones;
	private Timestamp fechaGeneracion;
	private boolean activo;
	// esta clase esta relacionada [uno a muchos] con las tablas:
	private Set<Pliego> pliego = new HashSet<Pliego>();
	private Set<CostoExtraDetalle> costoExtraDetalle = new HashSet<CostoExtraDetalle>();
	private Set<CalificacionTrabajoDetalle> calificacionTrabajoDetalle = new HashSet<CalificacionTrabajoDetalle>();
	
	
	public int getIdTipoTrabajoDetalle() {
		return idTipoTrabajoDetalle;
	}
	public void setIdTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		this.idTipoTrabajoDetalle = idTipoTrabajoDetalle;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
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
	public TipoPapelExtendido getTipoPapelExtendido() {
		return tipoPapelExtendido;
	}
	public void setTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido) {
		this.tipoPapelExtendido = tipoPapelExtendido;
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
	public TamanioPublicacion getTamanioPublicacion() {
		return tamanioPublicacion;
	}
	public void setTamanioPublicacion(TamanioPublicacion tamanioPublicacion) {
		this.tamanioPublicacion = tamanioPublicacion;
	}
	public CombinacionTintas getFrenteCombinacionTintas() {
		return frenteCombinacionTintas;
	}
	public void setFrenteCombinacionTintas(CombinacionTintas frenteCombinacionTintas) {
		this.frenteCombinacionTintas = frenteCombinacionTintas;
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
	public TipoBarniz getFrenteTipoBarniz() {
		return frenteTipoBarniz;
	}
	public void setFrenteTipoBarniz(TipoBarniz frenteTipoBarniz) {
		this.frenteTipoBarniz = frenteTipoBarniz;
	}
	public CombinacionTintas getVueltaCombinacionTintas() {
		return vueltaCombinacionTintas;
	}
	public void setVueltaCombinacionTintas(CombinacionTintas vueltaCombinacionTintas) {
		this.vueltaCombinacionTintas = vueltaCombinacionTintas;
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
	public TipoBarniz getVueltaTipoBarniz() {
		return vueltaTipoBarniz;
	}
	public void setVueltaTipoBarniz(TipoBarniz vueltaTipoBarniz) {
		this.vueltaTipoBarniz = vueltaTipoBarniz;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public TipoPlaca getTipoPlaca() {
		return tipoPlaca;
	}
	public void setTipoPlaca(TipoPlaca tipoPlaca) {
		this.tipoPlaca = tipoPlaca;
	}
	public TipoComplejidad getTipoComplejidad() {
		return tipoComplejidad;
	}
	public void setTipoComplejidad(TipoComplejidad tipoComplejidad) {
		this.tipoComplejidad = tipoComplejidad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Timestamp getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Timestamp fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Set<Pliego> getPliego() {
		return pliego;
	}
	public void setPliego(Set<Pliego> pliego) {
		this.pliego = pliego;
	}
	public Set<CostoExtraDetalle> getCostoExtraDetalle() {
		return costoExtraDetalle;
	}
	public void setCostoExtraDetalle(Set<CostoExtraDetalle> costoExtraDetalle) {
		this.costoExtraDetalle = costoExtraDetalle;
	}
	public Set<CalificacionTrabajoDetalle> getCalificacionTrabajoDetalle() {
		return calificacionTrabajoDetalle;
	}
	public void setCalificacionTrabajoDetalle(
			Set<CalificacionTrabajoDetalle> calificacionTrabajoDetalle) {
		this.calificacionTrabajoDetalle = calificacionTrabajoDetalle;
	}
}
