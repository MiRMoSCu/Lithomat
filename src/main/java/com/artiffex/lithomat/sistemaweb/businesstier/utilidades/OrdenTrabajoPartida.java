package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.OffsetDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDTO;

public class OrdenTrabajoPartida implements Serializable {

	private static final long serialVersionUID = -7391707563318274113L;
	
	private String tipoTrabajo;
	private Integer cantidad;
	private String nombrePartida;
	private String descripcionPartida;
	private String observacionesGenerales;
	private String observacionesAprobacion;
	private List<DisenioDTO> listaDisenioDTO;
	private List<PreprensaDTO> listaPreprensaDTO;
	private List<TransporteDTO> listaTransporteDTO;
	private List<AcabadoDTO> listaAcabadoDTO;
	private List<OffsetDTO> listaOffsetDTO;
	private List<OrdenTrabajoTipoTrabajoDetalle> listaOrdenTrabajoTipoTrabajoDetalle;
	
	
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombrePartida() {
		return nombrePartida;
	}
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	public String getDescripcionPartida() {
		return descripcionPartida;
	}
	public void setDescripcionPartida(String descripcionPartida) {
		this.descripcionPartida = descripcionPartida;
	}
	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}
	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}
	public String getObservacionesAprobacion() {
		return observacionesAprobacion;
	}
	public void setObservacionesAprobacion(String observacionesAprobacion) {
		this.observacionesAprobacion = observacionesAprobacion;
	}
	public List<DisenioDTO> getListaDisenioDTO() {
		return listaDisenioDTO;
	}
	public void setListaDisenioDTO(List<DisenioDTO> listaDisenioDTO) {
		this.listaDisenioDTO = listaDisenioDTO;
	}
	public List<PreprensaDTO> getListaPreprensaDTO() {
		return listaPreprensaDTO;
	}
	public void setListaPreprensaDTO(List<PreprensaDTO> listaPreprensaDTO) {
		this.listaPreprensaDTO = listaPreprensaDTO;
	}
	public List<TransporteDTO> getListaTransporteDTO() {
		return listaTransporteDTO;
	}
	public void setListaTransporteDTO(List<TransporteDTO> listaTransporteDTO) {
		this.listaTransporteDTO = listaTransporteDTO;
	}
	public List<AcabadoDTO> getListaAcabadoDTO() {
		return listaAcabadoDTO;
	}
	public void setListaAcabadoDTO(List<AcabadoDTO> listaAcabadoDTO) {
		this.listaAcabadoDTO = listaAcabadoDTO;
	}
	public List<OffsetDTO> getListaOffsetDTO() {
		return listaOffsetDTO;
	}
	public void setListaOffsetDTO(List<OffsetDTO> listaOffsetDTO) {
		this.listaOffsetDTO = listaOffsetDTO;
	}
	public List<OrdenTrabajoTipoTrabajoDetalle> getListaOrdenTrabajoTipoTrabajoDetalle() {
		return listaOrdenTrabajoTipoTrabajoDetalle;
	}
	public void setListaOrdenTrabajoTipoTrabajoDetalle(
			List<OrdenTrabajoTipoTrabajoDetalle> listaOrdenTrabajoTipoTrabajoDetalle) {
		this.listaOrdenTrabajoTipoTrabajoDetalle = listaOrdenTrabajoTipoTrabajoDetalle;
	}
}
