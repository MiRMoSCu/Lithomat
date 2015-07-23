package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PreprensaDetalleDAO;

@Service("preprensaDetalleService")
public class PreprensaDetalleServiceImpl implements PreprensaDetalleService {

	@Resource
	private PreprensaDetalleDAO preprensaDetalleDAO;
	
	@Resource
	private PreprensaService preprensaService;

	public int creaPreprensaDetalle(PreprensaDetalle preprensaDetalle) {
		return preprensaDetalleDAO.crea(preprensaDetalle);
	}
	
	public PreprensaDetalle buscaPreprensaDetalle(int idPreprensaDetalle) {
		return preprensaDetalleDAO.busca(idPreprensaDetalle);
	}

	public void modificaPreprensaDetalle(PreprensaDetalle preprensaDetalle) {
		preprensaDetalleDAO.modifica(preprensaDetalle);
	}
	
	public List<PreprensaDetalle> listaPreprensaDetalle() {
		return preprensaDetalleDAO.lista();
	}
	
	public List<PreprensaDetalle> listaPreprensaDetallePorPreprensa(int idPreprensa) {
		return preprensaDetalleDAO.listaPorPreprensa(idPreprensa);
	}
	
	public String listaHTML(int idPreprensa) {
		List<PreprensaDetalle> listaPreprensaDetalle = preprensaDetalleDAO.listaPorPreprensa(idPreprensa);

		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaPreprensaDetalle.size() > 0) {
			for (PreprensaDetalle preprensaDetalle : listaPreprensaDetalle) {
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
				html.append(preprensaDetalle.getProcesoPreprensa().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getCantidad());
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				preprensaDetalle = null;
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

		listaPreprensaDetalle = null;
		
		return html.toString();
	}
	
	public String listaHTMLModificacionPorPreprensa(int idPreprensa) {
		
		List<PreprensaDetalle> listaPreprensaDetalle = preprensaDetalleDAO.listaPorPreprensa(idPreprensa);

		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_preprensa_detalle\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaPreprensaDetalle.size() > 0) {
			for (PreprensaDetalle preprensaDetalle : listaPreprensaDetalle) {
				
				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\' ");
				html.append("onclick=\'setCamposPreprensaDetalle("
						+ "&#39;" + preprensaDetalle.getIdPreprensaDetalle() + "&#39;,"
						+ "&#39;" + preprensaDetalle.getProcesoPreprensa().getNombreProceso() + "&#39;,"
						+ "&#39;" + preprensaDetalle.getCantidad() + "&#39;,"
						+ "&#39;" + preprensaDetalle.getEspecificaciones() + "&#39;,"
						+ "&#39;" + preprensaDetalle.getPrecioTotalPesos() + "&#39;"
						+ ");\'");
				html.append(">");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getProcesoPreprensa().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getCantidad());
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				preprensaDetalle = null;
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

		listaPreprensaDetalle = null;
		
		return html.toString();
	}
	
	public String listaHTMLProcesosYPrecio(int idPartida) {
		
		Preprensa preprensa = preprensaService.buscaPreprensaPorPartida(idPartida);
		List<PreprensaDetalle> listaPreprensaDetalle = preprensaDetalleDAO.listaPorPreprensa(preprensa.getIdPreprensa());
		preprensa = null;

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
		if (listaPreprensaDetalle.size() > 0) {
			for (PreprensaDetalle preprensaDetalle : listaPreprensaDetalle) {
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
				html.append(preprensaDetalle.getProcesoPreprensa().getNombreProceso());
				html.append("</td>");

				html.append("<td>");
				html.append( numFormat.format(preprensaDetalle.getPrecioTotalPesos()) );
				html.append("</td>");

				html.append("<td>");
				html.append(preprensaDetalle.getEspecificaciones());
				html.append("</td>");

				cont++;
				
				preprensaDetalle = null;
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

		listaPreprensaDetalle = null;
		
		return html.toString();
	}	

}
