package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class RemisionPliego implements Serializable {

	private static final long serialVersionUID = 442943849340083801L;
	
	private double pliegoCosteTotal;
	private int hojasRequeridasRedondeo;
	private String papelDescripcion;
	private int papelCantidadTotal;
	private float papelPrecioUnitario;
	private double papelCosteTotal;
	private String placasDescripcion;
	private int placasNumPlacas;
	private float placasPrecioUnitario;
	private double placasCosteTotal;
	private String tintaDescripcion;
	private int tintaNumEntMaq;
	private float tintaPrecioUnitario;
	private double tintaCosteTotal;
	private String tintaEspecialDescripcion;
	private int tintaEspecialNumEntMaq;
	private float tintaEspecialPrecioUnitario;
	private double tintaEspecialCosteTotal;
	private String barnizDescripcion;
	private int frenteBarnizNumEntMaq;
	private float frenteBarnizPrecioUnitario;
	private double frenteBarnizCosteTotal;
	private int vueltaBarnizNumEntMaq;
	private float vueltaBarnizPrecioUnitario;
	private double vueltaBarnizCosteTotal;
	private boolean clienteProporcionaPapel;
	private boolean clienteProporcionaTinta;
	private boolean clienteProporcionaTintaEspecial;
	private boolean clienteProporcionaBarniz;
	private boolean clienteProporcionaPlacas;
	
	
	public double getPliegoCosteTotal() {
		return pliegoCosteTotal;
	}
	public void setPliegoCosteTotal(double pliegoCosteTotal) {
		this.pliegoCosteTotal = pliegoCosteTotal;
	}
	public int getHojasRequeridasRedondeo() {
		return hojasRequeridasRedondeo;
	}
	public void setHojasRequeridasRedondeo(int hojasRequeridasRedondeo) {
		this.hojasRequeridasRedondeo = hojasRequeridasRedondeo;
	}
	public String getPapelDescripcion() {
		return papelDescripcion;
	}
	public void setPapelDescripcion(String papelDescripcion) {
		this.papelDescripcion = papelDescripcion;
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
	public String getPlacasDescripcion() {
		return placasDescripcion;
	}
	public void setPlacasDescripcion(String placasDescripcion) {
		this.placasDescripcion = placasDescripcion;
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
	public String getTintaDescripcion() {
		return tintaDescripcion;
	}
	public void setTintaDescripcion(String tintaDescripcion) {
		this.tintaDescripcion = tintaDescripcion;
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
	public String getTintaEspecialDescripcion() {
		return tintaEspecialDescripcion;
	}
	public void setTintaEspecialDescripcion(String tintaEspecialDescripcion) {
		this.tintaEspecialDescripcion = tintaEspecialDescripcion;
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
	public String getBarnizDescripcion() {
		return barnizDescripcion;
	}
	public void setBarnizDescripcion(String barnizDescripcion) {
		this.barnizDescripcion = barnizDescripcion;
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
}
