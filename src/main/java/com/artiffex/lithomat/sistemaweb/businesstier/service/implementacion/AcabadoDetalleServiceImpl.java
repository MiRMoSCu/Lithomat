package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.AcabadoDetalleDAO;

@Service("acabadoDetalleService")
public class AcabadoDetalleServiceImpl implements AcabadoDetalleService {

	@Resource
	private AcabadoDetalleDAO acabadoDetalleDAO;
	
	@Resource
	private AcabadoService acabadoService;

	public int creaAcabadoDetalle(AcabadoDetalle acabadoDetalle) {
		return acabadoDetalleDAO.crea(acabadoDetalle);
	}
	
	public AcabadoDetalle buscaAcabadoDetalle(int idAcabadoDetalle) {
		return acabadoDetalleDAO.busca(idAcabadoDetalle);
	}

	public void modificaAcabadoDetalle(AcabadoDetalle acabadoDetalle) {
		acabadoDetalleDAO.modifica(acabadoDetalle);
	}

	public List<AcabadoDetalle> listaAcabadoDetalle() {
		return acabadoDetalleDAO.lista();
	}
	
	public List<AcabadoDetalle> listaAcabadoDetallePorAcabado(int idAcabado) {
		return acabadoDetalleDAO.listaPorAcabado(idAcabado);
	}
	
	public List<AcabadoDetalleDTO> listaAcabadoDetallePorAcabadoEnDTO(int idAcabado) {
		List<AcabadoDetalleDTO> listaAcabadoDetalleDTO = new ArrayList<AcabadoDetalleDTO>();
		List<AcabadoDetalle> listaAcabadoDetalle = acabadoDetalleDAO.listaPorAcabado(idAcabado);
		for (AcabadoDetalle acabadoDetalle : listaAcabadoDetalle) {
			AcabadoDetalleDTO acabadoDetalleDTO = new AcabadoDetalleDTO();
			acabadoDetalleDTO.setNombreProcesoAcabado(acabadoDetalle.getProcesoExterno().getNombreProceso());
			acabadoDetalleDTO.setNombreProveedor(acabadoDetalle.getProcesoExterno().getProveedorExterno().getRazonSocial());
			acabadoDetalleDTO.setCantidad(acabadoDetalle.getCantidadProcesoExterno());
			acabadoDetalleDTO.setEspecificaciones(acabadoDetalle.getEspecificaciones());
			listaAcabadoDetalleDTO.add(acabadoDetalleDTO);
			acabadoDetalleDTO 	= null;
			acabadoDetalle 		= null;
		}
		listaAcabadoDetalle = null;
		return listaAcabadoDetalleDTO;
	}

	public String listaHTML(int idAcabado) {
		List<AcabadoDetalle> listaAcabadoDetalle = acabadoDetalleDAO.listaPorAcabado(idAcabado);

		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaAcabadoDetalle.size() > 0) {
			for (AcabadoDetalle acabadoDetalle : listaAcabadoDetalle) {

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
				html.append(acabadoDetalle.getProcesoExterno().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getCantidadProcesoExterno());
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				acabadoDetalle = null;
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

		listaAcabadoDetalle = null;
		
		return html.toString();
	}
	
	public String listaHTMLModificacionPorAcabado(int idAcabado) {
		
		List<AcabadoDetalle> listaAcabadoDetalle = acabadoDetalleDAO.listaPorAcabado(idAcabado);

		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_acabado_detalle\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaAcabadoDetalle.size() > 0) {
			for (AcabadoDetalle acabadoDetalle : listaAcabadoDetalle) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\' ");
				html.append("onclick=\'setCamposAcabadoDetalle("
						+ "&#39;" + acabadoDetalle.getIdAcabadoDetalle() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getProcesoExterno().getNombreProceso() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getAncho() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getAlto() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getCantidadProcesoExterno() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getEspecificaciones() + "&#39;,"
						+ "&#39;" + acabadoDetalle.getPrecioTotalPesos() + "&#39;"
						+ ");\'");
				html.append(">");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getProcesoExterno().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getCantidadProcesoExterno());
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				acabadoDetalle = null;
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

		listaAcabadoDetalle = null;
		
		return html.toString();
	}
	
	public String listaHTMLProcesosYPrecio(int idPartida) {
		
		Acabado acabado = acabadoService.buscaAcabadoPorPartida(idPartida);
		List<AcabadoDetalle> listaAcabadoDetalle = acabadoDetalleDAO.listaPorAcabado(acabado.getIdAcabado());
		acabado = null;
		
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
		if (listaAcabadoDetalle.size() > 0) {
			for (AcabadoDetalle acabadoDetalle : listaAcabadoDetalle) {

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
				html.append(acabadoDetalle.getProcesoExterno().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(acabadoDetalle.getPrecioTotalPesos()) );
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				acabadoDetalle = null;
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

		listaAcabadoDetalle = null;
		return html.toString();
	}

	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idPartida, float porcentajeCliente) {
		Acabado acabado = acabadoService.buscaAcabadoPorPartida(idPartida);
		List<AcabadoDetalle> listaAcabadoDetalle = acabadoDetalleDAO.listaPorAcabado(acabado.getIdAcabado());
		acabado = null;
		
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
		if (listaAcabadoDetalle.size() > 0) {
			for (AcabadoDetalle acabadoDetalle : listaAcabadoDetalle) {

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
				html.append(acabadoDetalle.getProcesoExterno().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(acabadoDetalle.getPrecioTotalPesos() * (1 + porcentajeCliente)) );
				html.append("</td>");

				html.append("<td>");
				html.append(acabadoDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				acabadoDetalle = null;
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

		listaAcabadoDetalle = null;
		return html.toString();
	}
}
