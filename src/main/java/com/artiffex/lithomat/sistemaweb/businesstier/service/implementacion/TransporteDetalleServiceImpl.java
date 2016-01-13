package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TransporteDetalleDAO;

@Service("transporteDetalleService")
public class TransporteDetalleServiceImpl implements TransporteDetalleService {
	
	@Resource
	private TransporteDetalleDAO transporteDetalleDAO;
	
	@Resource
	private TransporteService transporteService;

	public int creaTransporteDetalle(TransporteDetalle transporteDetalle) {
		return transporteDetalleDAO.crea(transporteDetalle);
	}
	
	public TransporteDetalle buscaTransporteDetalle(int idTransporteDetalle) {
		return transporteDetalleDAO.busca(idTransporteDetalle);
	}

	public void modificaTransporteDetalle(TransporteDetalle transporteDetalle) {
		transporteDetalleDAO.modifica(transporteDetalle);
	}

	public List<TransporteDetalle> listaTransporteDetalle() {
		return transporteDetalleDAO.lista();
	}
	
	public List<TransporteDetalle> listaTransporteDetallePorTransporte(int idTransporte) {
		return transporteDetalleDAO.listaPorTransporte(idTransporte);
	}
	
	public List<TransporteDetalleDTO> listaTransporteDetallePorTransporteEnDTO(int idTransporte) {
		List<TransporteDetalleDTO> listaTransporteDetalleDTO = new ArrayList<TransporteDetalleDTO>();
		List<TransporteDetalle> listaTransporteDetalle = transporteDetalleDAO.listaPorTransporte(idTransporte);
		for (TransporteDetalle transporteDetalle : listaTransporteDetalle) {
			TransporteDetalleDTO transporteDetalleDTO = new TransporteDetalleDTO();
			transporteDetalleDTO.setNombreProcesoTransporte(transporteDetalle.getProcesoTransporte().getNombreProceso());
			transporteDetalleDTO.setCantidad(transporteDetalle.getCantidad());
			transporteDetalleDTO.setEspecificaciones(transporteDetalle.getEspecificaciones());
			listaTransporteDetalleDTO.add(transporteDetalleDTO);
			transporteDetalleDTO 	= null;
			transporteDetalle 		= null;
		}
		listaTransporteDetalle = null;
		return listaTransporteDetalleDTO;
	}

	public String listaHTML(int idTransporte) {
		DecimalFormat formato = new DecimalFormat("#,###");
		List<TransporteDetalle> listaTransporteDetalle = transporteDetalleDAO.listaPorTransporte(idTransporte);

		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaTransporteDetalle.size() > 0) {
			for (TransporteDetalle transporteDetalle : listaTransporteDetalle) {

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
				html.append(transporteDetalle.getProcesoTransporte().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(formato.format(transporteDetalle.getCantidad()));
				html.append("</td>");

				html.append("<td>");
				html.append(transporteDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				transporteDetalle = null;
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

		listaTransporteDetalle = null;
		formato = null;
		
		return html.toString();
	}
	
	public String listaHTMLModificacionPorTransporte(int idTransporte) {
		DecimalFormat formato = new DecimalFormat("#,###");
		List<TransporteDetalle> listaTransporteDetalle = transporteDetalleDAO.listaPorTransporte(idTransporte);

		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_transporte_detalle\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaTransporteDetalle.size() > 0) {
			for (TransporteDetalle transporteDetalle : listaTransporteDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\' ");
				html.append("onclick=\'setCamposTransporteDetalle("
						+ "&#39;" + transporteDetalle.getIdTransporteDetalle() + "&#39;,"
						+ "&#39;" + transporteDetalle.getProcesoTransporte().getNombreProceso() + "&#39;,"
						+ "&#39;" + transporteDetalle.getCantidad() + "&#39;,"
						+ "&#39;" + transporteDetalle.getEspecificaciones() + "&#39;,"
						+ "&#39;" + transporteDetalle.getPrecioTotalPesos() + "&#39;"
						+ ");\'");
				html.append(">");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(transporteDetalle.getProcesoTransporte().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(formato.format(transporteDetalle.getCantidad()));
				html.append("</td>");

				html.append("<td>");
				html.append(transporteDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				transporteDetalle = null;
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

		listaTransporteDetalle = null;
		formato = null;
		
		return html.toString();
	}
	
	public String listaHTMLProcesosYPrecio(int idPartida) {
		
		Transporte transporte = transporteService.buscaTransportePorPartida(idPartida);
		List<TransporteDetalle> listaTransporteDetalle = transporteDetalleDAO.listaPorTransporte(transporte.getIdTransporte());
		transporte = null;
		
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
		if (listaTransporteDetalle.size() > 0) {
			for (TransporteDetalle transporteDetalle : listaTransporteDetalle) {

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
				html.append(transporteDetalle.getProcesoTransporte().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(transporteDetalle.getPrecioTotalPesos()) );
				html.append("</td>");

				html.append("<td>");
				html.append(transporteDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				transporteDetalle = null;
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

		listaTransporteDetalle = null;
		numFormat = null;
		
		return html.toString();
	}

	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idPartida, float porcentajeCliente) {
		Transporte transporte = transporteService.buscaTransportePorPartida(idPartida);
		List<TransporteDetalle> listaTransporteDetalle = transporteDetalleDAO.listaPorTransporte(transporte.getIdTransporte());
		transporte = null;
		
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
		if (listaTransporteDetalle.size() > 0) {
			for (TransporteDetalle transporteDetalle : listaTransporteDetalle) {

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
				html.append(transporteDetalle.getProcesoTransporte().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(transporteDetalle.getPrecioTotalPesos() * (1 + porcentajeCliente)) );
				html.append("</td>");

				html.append("<td>");
				html.append(transporteDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				transporteDetalle = null;
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

		listaTransporteDetalle = null;
		numFormat = null;
		
		return html.toString();
	}
}
