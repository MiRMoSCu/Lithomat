package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoTrabajoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoTrabajoDetalleDAO;

@Service("tipoTrabajoDetalleService")
public class TipoTrabajoDetalleServiceImpl implements TipoTrabajoDetalleService {
	
	@Resource
	private TipoTrabajoDetalleDAO tipoTrabajoDetalleDAO;
	
	@Resource
	private PliegoService pliegoService;
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	

	public int creaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		return tipoTrabajoDetalleDAO.crea(tipoTrabajoDetalle);
	}
	
	public TipoTrabajoDetalle buscaTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		return tipoTrabajoDetalleDAO.busca(idTipoTrabajoDetalle);
	}
	
	public TipoTrabajoDetalleDTO buscaTipoTrabajoDetalleEnDTO(int idTipoTrabajoDetalle) {
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleDAO.busca(idTipoTrabajoDetalle);
		TipoTrabajoDetalleDTO tipoTrabajoDetalleDTO = new TipoTrabajoDetalleDTO();
		tipoTrabajoDetalleDTO.setIdTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
		tipoTrabajoDetalleDTO.setDescripcion(tipoTrabajoDetalle.getDescripcion());
		tipoTrabajoDetalleDTO.setAltoFinal(tipoTrabajoDetalle.getAltoFinal());
		tipoTrabajoDetalleDTO.setAnchoFinal(tipoTrabajoDetalle.getAnchoFinal());
		tipoTrabajoDetalleDTO.setAltoExtendido(tipoTrabajoDetalle.getAltoExtendido());
		tipoTrabajoDetalleDTO.setAnchoExtendido(tipoTrabajoDetalle.getAnchoExtendido());
		tipoTrabajoDetalleDTO.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
		tipoTrabajoDetalleDTO.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
		tipoTrabajoDetalleDTO.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
		tipoTrabajoDetalleDTO.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
		tipoTrabajoDetalleDTO.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
			StringBuilder sb = new StringBuilder();
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getNombre());
			sb.append(" ");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getGramaje());
			sb.append(" gr. ");
			sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAlto());
			sb.append(" x ");
			sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAncho());
			sb.append(" cm. (");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getKilogramos());
			sb.append(" kg.) ($");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio());
			sb.append(") [");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getProveedorPapel().getRazonSocial());
			sb.append("]");
		tipoTrabajoDetalleDTO.setDescripcionTipoPapelExtendido(sb.toString());
			sb = null;
		tipoTrabajoDetalleDTO.setRepeticionesXPliego(tipoTrabajoDetalle.getRepeticionesXPliego());
		tipoTrabajoDetalleDTO.setNumeroPaginasPublicacion(tipoTrabajoDetalle.getNumeroPaginasPublicacion());
		tipoTrabajoDetalleDTO.setDescripcionTamanioPublicacion(tipoTrabajoDetalle.getTamanioPublicacion().getNombre());
		tipoTrabajoDetalleDTO.setFrenteDescripcionNumTintas(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
		tipoTrabajoDetalleDTO.setFrenteNumTintaEspecial(tipoTrabajoDetalle.getFrenteNumTintaEspecial());
		tipoTrabajoDetalleDTO.setFrenteDescripcionTintaEspecial(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
		tipoTrabajoDetalleDTO.setFrenteDescripcionTipoBarniz(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
		tipoTrabajoDetalleDTO.setVueltaDescripcionNumTintas(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
		tipoTrabajoDetalleDTO.setVueltaNumTintaEspecial(tipoTrabajoDetalle.getVueltaNumTintaEspecial());
		tipoTrabajoDetalleDTO.setVueltaDescripcionTintaEspecial(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
		tipoTrabajoDetalleDTO.setVueltaDescripcionTipoBarniz(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
		tipoTrabajoDetalleDTO.setNombreMaquina(tipoTrabajoDetalle.getMaquina().getNombre());
		tipoTrabajoDetalleDTO.setDescripcionPlaca(tipoTrabajoDetalle.getTipoPlaca().getDescripcion());
		tipoTrabajoDetalleDTO.setDescripcionComplejidad(tipoTrabajoDetalle.getTipoComplejidad().getNombre());
		
		tipoTrabajoDetalle = null;
		return tipoTrabajoDetalleDTO;
	}

	public void modificaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle) {
		tipoTrabajoDetalleDAO.modifica(tipoTrabajoDetalle);
	}

	public List<TipoTrabajoDetalle> listaTipoTrabajoDetalle() {
		return tipoTrabajoDetalleDAO.lista();
	}
	
	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorPartida(int idPartida) {
		return tipoTrabajoDetalleDAO.listaPorPartida(idPartida);
	}
	
	public HashMap<String, Object> obtieneSumatorias(int idTipoTrabajoDetalle) {
		
		int papelCantidadTotal 		= 0;
		int placasNumPlacas 		= 0;
		int tintaNumEntMaq 			= 0;
		int tintaEspecialNumEntMaq 	= 0;
		int frenteBarnizNumEntMaq 	= 0;
		int vueltaBarnizNumEntMaq 	= 0;
		
		List<Pliego> lista = pliegoService.listaPliegoPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		for (Pliego pliego : lista) {
			papelCantidadTotal 		+= pliego.getHojasTotales();
			placasNumPlacas			+= pliego.getFrenteNumTotalPlacas() + pliego.getVueltaNumTotalPlacas();
			tintaNumEntMaq			+= pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTinta();
			tintaEspecialNumEntMaq	+= pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaTintaEspecial(); 
			frenteBarnizNumEntMaq	+= pliego.getFrenteNumEntradasMaquinaBarniz();
			vueltaBarnizNumEntMaq	+= pliego.getVueltaNumEntradasMaquinaBarniz();
			pliego = null;
		}
		lista = null;
		
		HashMap<String, Object> sumatorias = new HashMap<String, Object>();
		sumatorias.put("papelCantidadTotal", papelCantidadTotal);
		sumatorias.put("placasNumPlacas", placasNumPlacas);
		sumatorias.put("tintaNumEntMaq", tintaNumEntMaq);
		sumatorias.put("tintaEspecialNumEntMaq", tintaEspecialNumEntMaq);
		sumatorias.put("frenteBarnizNumEntMaq", frenteBarnizNumEntMaq);
		sumatorias.put("vueltaBarnizNumEntMaq", vueltaBarnizNumEntMaq);
		
		return sumatorias;
	}
	
	public String buscaHTML(int idPartida) {
		
		List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleDAO.listaPorPartida(idPartida);
		
		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_tipo_trabajo_detalle\'>");

		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Descripci&oacute;n</th>");
		html.append("<th>Repeticiones pliego</th>");
		html.append("<th>No. p&aacute;ginas</th>");
		html.append("<th>Tama&ntilde;o publicaci&oacute;n</th>");
		html.append("<th>M&aacute;quina</th>");

		int cont = 0;
		if (listaTipoTrabajoDetalle.size() > 0) {
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
				html.append("<tr class=\'");
				if (cont % 2 == 0)
					html.append("l1");
				else
					html.append("l2");
				html.append("\' ");
				html.append("onclick=\'buscaTrabajoDetalle("
						+ tipoTrabajoDetalle.getIdTipoTrabajoDetalle()
						+ ")\'");
				html.append(">");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td id=\'td_" + tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "_descripcion\'>");
				html.append(tipoTrabajoDetalle.getDescripcion());
				html.append("</td>");

				html.append("<td id=\'td_" + tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "_repeticiones_x_pliego\'>");
				html.append(tipoTrabajoDetalle.getRepeticionesXPliego());
				html.append("</td>");

				html.append("<td id=\'td_" + tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "_numero_paginas_publicacion\'>");
				html.append(tipoTrabajoDetalle.getNumeroPaginasPublicacion());
				html.append("</td>");

				html.append("<td id=\'td_"+ tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "_tamanio_publicacion\'>");
				html.append(tipoTrabajoDetalle.getTamanioPublicacion().getNombre());
				html.append("</td>");

				html.append("<td id=\'td_"+ tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "_nombre_maquina\'>");
				html.append(tipoTrabajoDetalle.getMaquina().getNombre());
				html.append("</td>");

				html.append("</tr>");
				cont++;
				
				tipoTrabajoDetalle = null;
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

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("</tr>");
		}

		html.append("</table>");
		
		listaTipoTrabajoDetalle = null;

		return html.toString();
	}

	public String obtienePapelDescripcionBasica(int idTipoTrabajoDetalle) {
		StringBuffer papelDescripcion = new StringBuffer();
		TipoTrabajoDetalle ttd = tipoTrabajoDetalleDAO.busca(idTipoTrabajoDetalle);
		papelDescripcion.append(ttd.getTipoPapelExtendido().getNombre());
		papelDescripcion.append(" ");
		papelDescripcion.append((int)ttd.getTipoPapelExtendido().getAlto());
		papelDescripcion.append("x");
		papelDescripcion.append((int)ttd.getTipoPapelExtendido().getAncho());
		papelDescripcion.append(" ");
		papelDescripcion.append(ttd.getTipoPapelExtendido().getGramaje());
		papelDescripcion.append("g.");
		ttd = null;
		return papelDescripcion.toString();
	}

	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorEstatusOrden(int idEstatusOrden) {
		return tipoTrabajoDetalleDAO.listaPorEstatusOrden(idEstatusOrden);
	}

}
