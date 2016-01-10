package com.artiffex.lithomat.sistemaweb.businesstier.entity;

import java.io.Serializable;

public class CalificacionPliego implements Serializable {
	
	private static final long serialVersionUID = 7836551649389085837L;
	
	private int idCalificacionPliego;
	private Pliego pliego;
	private double pliegoCosteTotal;
	private int hojasRequeridasOriginal;
	private int hojasRequeridasRedondeo;
	private float precioUnitarioTabulador;
	private int papelCantidadTotal;
	private float papelPrecioUnitario;
	private double papelCosteTotal;
	private int placasNumPlacas;
	private float placasPrecioUnitario;
	private double placasCosteTotal;
	private int tintaNumEntMaq;
	private float tintaPrecioUnitario;
	private double tintaCosteTotal;
	private int tintaEspecialNumEntMaq;
	private float tintaEspecialPrecioUnitario;
	private double tintaEspecialCosteTotal;
	private int frenteBarnizNumEntMaq;
	private float frenteBarnizPrecioUnitario;
	private double frenteBarnizCosteTotal;
	private int vueltaBarnizNumEntMaq;
	private float vueltaBarnizPrecioUnitario;
	private double vueltaBarnizCosteTotal;
	private boolean activo;
	
	
	public int getIdCalificacionPliego() {
		return idCalificacionPliego;
	}
	public void setIdCalificacionPliego(int idCalificacionPliego) {
		this.idCalificacionPliego = idCalificacionPliego;
	}
	public Pliego getPliego() {
		return pliego;
	}
	public void setPliego(Pliego pliego) {
		this.pliego = pliego;
	}
	public double getPliegoCosteTotal() {
		return pliegoCosteTotal;
	}
	public void setPliegoCosteTotal(double pliegoCosteTotal) {
		this.pliegoCosteTotal = pliegoCosteTotal;
	}
	public int getHojasRequeridasOriginal() {
		return hojasRequeridasOriginal;
	}
	public void setHojasRequeridasOriginal(int hojasRequeridasOriginal) {
		this.hojasRequeridasOriginal = hojasRequeridasOriginal;
	}
	public int getHojasRequeridasRedondeo() {
		return hojasRequeridasRedondeo;
	}
	public void setHojasRequeridasRedondeo(int hojasRequeridasRedondeo) {
		this.hojasRequeridasRedondeo = hojasRequeridasRedondeo;
	}
	public float getPrecioUnitarioTabulador() {
		return precioUnitarioTabulador;
	}
	public void setPrecioUnitarioTabulador(float precioUnitarioTabulador) {
		this.precioUnitarioTabulador = precioUnitarioTabulador;
	}
	public int getPapelCantidadTotal() {
		return papelCantidadTotal;
	}
	public void setPapelCantidadTotal(int papelCantidadTotal) {
		this.papelCantidadTotal = papelCantidadTotal;
	}
	public float getPapelPrecioUnitario() {
		return papelPrecioUnitario;
	}
	public void setPapelPrecioUnitario(float papelPrecioUnitario) {
		this.papelPrecioUnitario = papelPrecioUnitario;
	}
	public double getPapelCosteTotal() {
		return papelCosteTotal;
	}
	public void setPapelCosteTotal(double papelCosteTotal) {
		this.papelCosteTotal = papelCosteTotal;
	}
	public int getPlacasNumPlacas() {
		return placasNumPlacas;
	}
	public void setPlacasNumPlacas(int placasNumPlacas) {
		this.placasNumPlacas = placasNumPlacas;
	}
	public float getPlacasPrecioUnitario() {
		return placasPrecioUnitario;
	}
	public void setPlacasPrecioUnitario(float placasPrecioUnitario) {
		this.placasPrecioUnitario = placasPrecioUnitario;
	}
	public double getPlacasCosteTotal() {
		return placasCosteTotal;
	}
	public void setPlacasCosteTotal(double placasCosteTotal) {
		this.placasCosteTotal = placasCosteTotal;
	}
	public int getTintaNumEntMaq() {
		return tintaNumEntMaq;
	}
	public void setTintaNumEntMaq(int tintaNumEntMaq) {
		this.tintaNumEntMaq = tintaNumEntMaq;
	}
	public float getTintaPrecioUnitario() {
		return tintaPrecioUnitario;
	}
	public void setTintaPrecioUnitario(float tintaPrecioUnitario) {
		this.tintaPrecioUnitario = tintaPrecioUnitario;
	}
	public double getTintaCosteTotal() {
		return tintaCosteTotal;
	}
	public void setTintaCosteTotal(double tintaCosteTotal) {
		this.tintaCosteTotal = tintaCosteTotal;
	}
	public int getTintaEspecialNumEntMaq() {
		return tintaEspecialNumEntMaq;
	}
	public void setTintaEspecialNumEntMaq(int tintaEspecialNumEntMaq) {
		this.tintaEspecialNumEntMaq = tintaEspecialNumEntMaq;
	}
	public float getTintaEspecialPrecioUnitario() {
		return tintaEspecialPrecioUnitario;
	}
	public void setTintaEspecialPrecioUnitario(float tintaEspecialPrecioUnitario) {
		this.tintaEspecialPrecioUnitario = tintaEspecialPrecioUnitario;
	}
	public double getTintaEspecialCosteTotal() {
		return tintaEspecialCosteTotal;
	}
	public void setTintaEspecialCosteTotal(double tintaEspecialCosteTotal) {
		this.tintaEspecialCosteTotal = tintaEspecialCosteTotal;
	}
	public int getFrenteBarnizNumEntMaq() {
		return frenteBarnizNumEntMaq;
	}
	public void setFrenteBarnizNumEntMaq(int frenteBarnizNumEntMaq) {
		this.frenteBarnizNumEntMaq = frenteBarnizNumEntMaq;
	}
	public float getFrenteBarnizPrecioUnitario() {
		return frenteBarnizPrecioUnitario;
	}
	public void setFrenteBarnizPrecioUnitario(float frenteBarnizPrecioUnitario) {
		this.frenteBarnizPrecioUnitario = frenteBarnizPrecioUnitario;
	}
	public double getFrenteBarnizCosteTotal() {
		return frenteBarnizCosteTotal;
	}
	public void setFrenteBarnizCosteTotal(double frenteBarnizCosteTotal) {
		this.frenteBarnizCosteTotal = frenteBarnizCosteTotal;
	}
	public int getVueltaBarnizNumEntMaq() {
		return vueltaBarnizNumEntMaq;
	}
	public void setVueltaBarnizNumEntMaq(int vueltaBarnizNumEntMaq) {
		this.vueltaBarnizNumEntMaq = vueltaBarnizNumEntMaq;
	}
	public float getVueltaBarnizPrecioUnitario() {
		return vueltaBarnizPrecioUnitario;
	}
	public void setVueltaBarnizPrecioUnitario(float vueltaBarnizPrecioUnitario) {
		this.vueltaBarnizPrecioUnitario = vueltaBarnizPrecioUnitario;
	}
	public double getVueltaBarnizCosteTotal() {
		return vueltaBarnizCosteTotal;
	}
	public void setVueltaBarnizCosteTotal(double vueltaBarnizCosteTotal) {
		this.vueltaBarnizCosteTotal = vueltaBarnizCosteTotal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
