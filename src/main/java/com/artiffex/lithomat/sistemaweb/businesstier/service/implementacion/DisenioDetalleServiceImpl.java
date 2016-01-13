package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DisenioDetalleDAO;

@Service("disenioDetalleService")
public class DisenioDetalleServiceImpl implements DisenioDetalleService {

	@Resource
	private DisenioDetalleDAO disenioDetalleDAO;
	
	@Resource
	private DisenioService disenioService;

	public int creaDisenioDetalle(DisenioDetalle disenioDetalle) {
		return disenioDetalleDAO.crea(disenioDetalle);
	}
	
	public DisenioDetalle buscaDisenioDetalle(int idDisenioDetalle) {
		return disenioDetalleDAO.busca(idDisenioDetalle);
	}

	public void modificaDisenioDetalle(DisenioDetalle disenioDetalle) {
		disenioDetalleDAO.modifica(disenioDetalle);
	}
	
	public List<DisenioDetalle> listaDisenioDetalle() {
		return disenioDetalleDAO.lista();
	}
	
	public List<DisenioDetalle> listaDisenioDetallePorDisenio(int idDisenio) {
		return disenioDetalleDAO.listaPorDisenio(idDisenio);
	}
	
	public List<DisenioDetalleDTO> listaDisenioDetallePorDisenioEnDTO(int idDisenio) {
		List<DisenioDetalleDTO> listaDisenioDetalleDTO = new ArrayList<DisenioDetalleDTO>();
		List<DisenioDetalle> listaTemporal = disenioDetalleDAO.listaPorDisenio(idDisenio);
		for (DisenioDetalle disenioDetalle : listaTemporal) {
			DisenioDetalleDTO disenioDetalleDTO = new DisenioDetalleDTO();
			disenioDetalleDTO.setNombreProcesoDisenio(disenioDetalle.getProcesoDisenio().getNombreProceso());
			disenioDetalleDTO.setCantidad(disenioDetalle.getCantidad());
			disenioDetalleDTO.setEspecificaciones(disenioDetalle.getEspecificaciones());
			listaDisenioDetalleDTO.add(disenioDetalleDTO);
			disenioDetalleDTO 	= null;
			disenioDetalle 		= null;
		}
		listaTemporal = null;
		return listaDisenioDetalleDTO;
	}
	
	public String listaHTML(int idDisenio) {
		DecimalFormat formato = new DecimalFormat("#,###");
		List<DisenioDetalle> listaDisenioDetalle = disenioDetalleDAO.listaPorDisenio(idDisenio);

		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaDisenioDetalle.size() > 0) {
			for (DisenioDetalle disenioDetalle : listaDisenioDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\'>");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getProcesoDisenio().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(formato.format(disenioDetalle.getCantidad()));
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				disenioDetalle = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table>");

		listaDisenioDetalle = null;
		formato	= null;

		return html.toString();
	}
	
	public String listaHTMLModificacionPorDisenio(int idDisenio) {
		DecimalFormat formato = new DecimalFormat("#,###");
		List<DisenioDetalle> listaDisenioDetalle = disenioDetalleDAO.listaPorDisenio(idDisenio);
		
		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_disenio_detalle\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaDisenioDetalle.size() > 0) {
			for (DisenioDetalle disenioDetalle : listaDisenioDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\' ");
				html.append("onclick=\'setCamposDisenioDetalle("
						+ "&#39;" + disenioDetalle.getIdDisenioDetalle() + "&#39;,"
						+ "&#39;" + disenioDetalle.getProcesoDisenio().getNombreProceso() + "&#39;,"
						+ "&#39;" + disenioDetalle.getCantidad() + "&#39;,"
						+ "&#39;" + disenioDetalle.getEspecificaciones() + "&#39;,"
						+ "&#39;" + disenioDetalle.getPrecioTotalPesos() + "&#39;"
						+ ");\'");
				html.append(">");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getProcesoDisenio().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(formato.format(disenioDetalle.getCantidad()));
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				disenioDetalle = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table>");

		listaDisenioDetalle = null;
		formato	= null;

		return html.toString();
		
	}
		
	public String listaHTMLProcesosYPrecio(int idPartida) {
		
		Disenio disenio = disenioService.buscaDisenioPorPartida(idPartida);
		List<DisenioDetalle> listaDisenioDetalle = disenioDetalleDAO.listaPorDisenio(disenio.getIdDisenio());
		disenio = null;
		
		DecimalFormat numFormat = new DecimalFormat("'$ '#,##0.00");
		
		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Precio</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaDisenioDetalle.size() > 0) {
			for (DisenioDetalle disenioDetalle : listaDisenioDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\'>");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getProcesoDisenio().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(disenioDetalle.getPrecioTotalPesos()) );
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				disenioDetalle = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table>");

		listaDisenioDetalle = null;
		numFormat = null;

		return html.toString();
	}

	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idPartida, float porcentajeCliente) {
		
		Disenio disenio = disenioService.buscaDisenioPorPartida(idPartida);
		List<DisenioDetalle> listaDisenioDetalle = disenioDetalleDAO.listaPorDisenio(disenio.getIdDisenio());
		disenio = null;
		
		DecimalFormat numFormat = new DecimalFormat("'$ '#,##0.00");
		
		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Precio</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaDisenioDetalle.size() > 0) {
			for (DisenioDetalle disenioDetalle : listaDisenioDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\'>");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getProcesoDisenio().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(disenioDetalle.getPrecioTotalPesos() * (1 + porcentajeCliente)) );
				html.append("</td>");

				html.append("<td>");
				html.append(disenioDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				disenioDetalle = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table>");

		listaDisenioDetalle = null;
		numFormat = null;

		return html.toString();
	}

}
