package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostoExtraDetalleDAO;

@Service("costoExtraDetalleServiceImpl")
public class CostoExtraDetalleServiceImpl implements CostoExtraDetalleService {
	
	@Resource
	private CostoExtraDetalleDAO costoExtraDetalleDAO;
	@Resource
	private CostoExtraService costoExtraService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private CalificacionService calificacionService;

	
	public int creaCostoExtraDetalle(CostoExtraDetalle costoExtraDetalle) {
		if( costoExtraDetalle.getResponsableInsumo().getIdResponsableInsumo() == 2 ) { // LITHOMAT
			costoExtraDetalle.setPrecioTotalPesos(0);
		} else {
			// calculo de campo faltante: precio_total_pesos
			int idCostoExtra = costoExtraDetalle.getCostoExtra().getIdCostoExtra();
			float precioTotalPesos = 0;
			CostoExtra costoExtra = costoExtraService.buscaCostoExtra(idCostoExtra);
			switch( costoExtra.getTipoPrecio().getIdTipoPrecio() ) {
				case 1: // NO APLICA
					precioTotalPesos = 0;
					break;
				case 2: // UNIDAD
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 3: // CIENTO
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 4: // MILLAR
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 5: // HORA
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 6: // PORCENTAJE
					// la cantidad de costo extra en porcentaje siempre es 1
					costoExtraDetalle.setCantidad(1);
					// encuentra cantidad, entradas a maquina y precio unitario tabulador, IGUAL que en calificacionServiceImpl
					TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(costoExtraDetalle.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());
						// CANTIDAD REDONDEADA
					int cantidadOriginal = tipoTrabajoDetalle.getPartida().getCantidad();
					int cantidadRedondeada = 0;
					if (cantidadOriginal <= 1000)
						cantidadRedondeada = 1000;
					else if ((cantidadOriginal % 1000) > 300)
						cantidadRedondeada = ((cantidadOriginal / 1000) + 1) * 1000;
					else
						cantidadRedondeada = (cantidadOriginal / 1000) * 1000;
						// *** precio tabulador
					float precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador(
								tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad(), 
								tipoTrabajoDetalle.getMaquina().getIdMaquina(), 
								cantidadRedondeada
							);
						// *** entradas a maquina
					HashMap<String, Object> sumatorias = tipoTrabajoDetalleService.obtieneSumatorias(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
					int numEntradasMaquina = (Integer)sumatorias.get("tintaNumEntMaq") + (Integer)sumatorias.get("tintaEspecialNumEntMaq") + (Integer)sumatorias.get("frenteBarnizNumEntMaq") + (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
					sumatorias = null;
					tipoTrabajoDetalle = null;
						// *** calculo precio total
					precioTotalPesos = cantidadRedondeada * numEntradasMaquina * precioUnitarioTabulador * (1 + ( costoExtra.getPrecio() / costoExtra.getTipoPrecio().getFactorDivisor() ));
					break;
				case 7: // CENTIMETRO CUADRADO
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				default:
					break;
			}
			costoExtra = null;
			costoExtraDetalle.setPrecioTotalPesos(precioTotalPesos);
		}
		return costoExtraDetalleDAO.crea(costoExtraDetalle);
	}
	
	public CostoExtraDetalle buscaCostoExtraDetalle(int idCostoExtraDetalle) {
		return costoExtraDetalleDAO.busca(idCostoExtraDetalle);
	}

	public void modificaCostoExtraDetalle(CostoExtraDetalle costoExtraDetalle) {
		// calculo de campo faltante: precio_total_pesos
		if( costoExtraDetalle.getResponsableInsumo().getIdResponsableInsumo() == 2 ) { // LITHOMAT
			costoExtraDetalle.setPrecioTotalPesos(0);
		} else {
			int idCostoExtra = costoExtraDetalle.getCostoExtra().getIdCostoExtra();
			float precioTotalPesos = 0;
			CostoExtra costoExtra = costoExtraService.buscaCostoExtra(idCostoExtra);
			switch( costoExtra.getTipoPrecio().getIdTipoPrecio() ) {
				case 1: // NO APLICA
					precioTotalPesos = 0;
					break;
				case 2: // UNIDAD
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 3: // CIENTO
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 4: // MILLAR
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 5: // HORA
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				case 6: // PORCENTAJE
					// la cantidad de costo extra en porcentaje siempre es 1
					costoExtraDetalle.setCantidad(1);
					// encuentra cantidad, entradas a maquina y precio unitario tabulador, IGUAL que en calificacionServiceImpl
					TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(costoExtraDetalle.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());
						// CANTIDAD REDONDEADA
					int cantidadOriginal = tipoTrabajoDetalle.getPartida().getCantidad();
					int cantidadRedondeada = 0;
					if (cantidadOriginal <= 1000)
						cantidadRedondeada = 1000;
					else if ((cantidadOriginal % 1000) > 300)
						cantidadRedondeada = ((cantidadOriginal / 1000) + 1) * 1000;
					else
						cantidadRedondeada = (cantidadOriginal / 1000) * 1000;
						// *** precio tabulador
					float precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador(
								tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad(), 
								tipoTrabajoDetalle.getMaquina().getIdMaquina(), 
								cantidadRedondeada
							);
						// *** entradas a maquina
					HashMap<String, Object> sumatorias = tipoTrabajoDetalleService.obtieneSumatorias(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
					int numEntradasMaquina = (Integer)sumatorias.get("tintaNumEntMaq") + (Integer)sumatorias.get("tintaEspecialNumEntMaq") + (Integer)sumatorias.get("frenteBarnizNumEntMaq") + (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
					sumatorias = null;
					tipoTrabajoDetalle = null;
						// *** calculo precio total
					precioTotalPesos = cantidadRedondeada * numEntradasMaquina * precioUnitarioTabulador * (1 + ( costoExtra.getPrecio() / costoExtra.getTipoPrecio().getFactorDivisor() ));
					break;
				case 7: // CENTIMETRO CUADRADO
					precioTotalPesos = costoExtraDetalle.getCantidad() * costoExtra.getPrecio();
					break;
				default:
					break;
			}
			costoExtra = null;
			costoExtraDetalle.setPrecioTotalPesos(precioTotalPesos);
		}
		costoExtraDetalleDAO.modifica(costoExtraDetalle);
	}

	public List<CostoExtraDetalle> listaCostoExtraDetalle() {
		return costoExtraDetalleDAO.lista();
	}

	public List<CostoExtraDetalle> listaCostoExtraDetallePorNut(String nut) {
		List<CostoExtraDetalle> listaCostoExtraDetalle = new ArrayList<CostoExtraDetalle>();
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalleService = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalleService) {
				List<CostoExtraDetalle> listaTemporal = costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (CostoExtraDetalle costoExtraDetalle : listaTemporal) {
					listaCostoExtraDetalle.add(costoExtraDetalle);
					costoExtraDetalle = null;
				}
				listaTemporal = null;
				tipoTrabajoDetalle = null;
			}
			listaTipoTrabajoDetalleService = null;
			partida = null;
		}
		listaPartida = null;
		ordenProduccion = null;
		return listaCostoExtraDetalle;
	}

	public List<CostoExtraDetalle> listaCostoExtraDetallePorPartida(int idPartida) {
		List<CostoExtraDetalle> listaCostoExtraDetalle = new ArrayList<CostoExtraDetalle>();
		List<TipoTrabajoDetalle> listaTipoTrabajoDetalleService = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(idPartida);
		for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalleService) {
			List<CostoExtraDetalle> listaTemporal = costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
			for (CostoExtraDetalle costoExtraDetalle : listaTemporal) {
				listaCostoExtraDetalle.add(costoExtraDetalle);
				costoExtraDetalle = null;
			}
			listaTemporal = null;
			tipoTrabajoDetalle = null;
		}
		listaTipoTrabajoDetalleService = null;
		return listaCostoExtraDetalle;
	}
	
	public List<CostoExtraDetalle> listaCostoExtraDetallePorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		return costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	}

	public String buscaHTML(int idTipoTrabajoDetalle) {
		List<CostoExtraDetalle> lista = costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_costo_extra_tipo_trabajo\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Costo Extra</th>");
		html.append("<th>Responsable</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");
		
		int cont = 0;
		if( lista.size() > 0 ) {
			for (CostoExtraDetalle costoExtraDetalle : lista) {
				html.append("<tr class=\'");
				if (cont % 2 == 0)
					html.append("l1");
				else
					html.append("l2");
				html.append("\'>");
				// No
				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");
				// costo extra
				html.append("<td>");
				html.append(costoExtraDetalle.getCostoExtra().getNombre());
				html.append("</td>");
				// responsable
				html.append("<td>");
				html.append(costoExtraDetalle.getResponsableInsumo().getNombre());
				html.append("</td>");
				// cantidad
				html.append("<td>");
				html.append(costoExtraDetalle.getCantidad());
				html.append("</td>");
				// especificacion
				html.append("<td>");
				html.append(costoExtraDetalle.getEspecificacion());
				html.append("</td>");
				
				html.append("</tr>");
				cont++;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");
			// 1
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 2
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 3
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 4
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 5
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			
			html.append("</tr>");
		}
		html.append("</table>");
		lista = null;
		
		return html.toString();
	}
	
	public String listaHTMLModificacion(int idTipoTrabajoDetalle) {
		List<CostoExtraDetalle> lista = costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_costo_extra_tipo_trabajo\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Costo Extra</th>");
		html.append("<th>Responsable</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");
		
		int cont = 0;
		if( lista.size() > 0 ) {
			for (CostoExtraDetalle costoExtraDetalle : lista) {
				html.append("<tr class=\'");
				if (cont % 2 == 0)
					html.append("l1");
				else
					html.append("l2");
				html.append("\' ");
				html.append("onclick=\'setCamposCostoExtraDetalle("
						+ "&#39;" + costoExtraDetalle.getIdCostoExtraDetalle() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getResponsableInsumo().getIdResponsableInsumo() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getCostoExtra().getIdCostoExtra() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getCostoExtra().getNombre() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getResponsableInsumo().getNombre() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getCantidad() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getEspecificacion() + "&#39;,"
						+ "&#39;" + costoExtraDetalle.getCostoExtra().getTipoPrecio().getNombre() + "&#39;"
						+ ");\'");
				html.append(">");
				
				// No
				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");
				// costo extra
				html.append("<td>");
				html.append(costoExtraDetalle.getCostoExtra().getNombre());
				html.append("</td>");
				// responsable
				html.append("<td>");
				html.append(costoExtraDetalle.getResponsableInsumo().getNombre());
				html.append("</td>");
				// cantidad
				html.append("<td>");
				html.append(costoExtraDetalle.getCantidad());
				html.append("</td>");
				// especificacion
				html.append("<td>");
				html.append(costoExtraDetalle.getEspecificacion());
				html.append("</td>");
				
				html.append("</tr>");
				cont++;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");
			// 1
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 2
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 3
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 4
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 5
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			
			html.append("</tr>");
		}
		html.append("</table>");
		lista = null;
		
		return html.toString();
	}

	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idTipoTrabajoDetalle, float porcentajeCliente) {
		int cont = 0;
		DecimalFormat numFormat = new DecimalFormat("'$ '#,##0.00");
		StringBuilder html = new StringBuilder();
		
		html.append("<table id=\'tabla_lista_costo_extra_tipo_trabajo\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Costo Extra</th>");
		html.append("<th>Responsable</th>");
		html.append("<th>Precio</th>");
		html.append("<th>Especificaci&oacute;n</th>");
		html.append("</tr>");
		
		List<CostoExtraDetalle> listaCostoExtraDetalle = costoExtraDetalleDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		if( listaCostoExtraDetalle.size() > 0 ) {
			for (CostoExtraDetalle costoExtraDetalle : listaCostoExtraDetalle) {
				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\'>");
				// No.
				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");
				// Costo Extra
				html.append("<td>");
				html.append(costoExtraDetalle.getCostoExtra().getNombre());
				html.append("</td>");
				// Responsable
				html.append("<td>");
				html.append(costoExtraDetalle.getResponsableInsumo().getNombre());
				html.append("</td>");
				// Precio
				html.append("<td>");
				html.append(numFormat.format(costoExtraDetalle.getPrecioTotalPesos() * (1 + porcentajeCliente)));
				html.append("</td>");
				// Especificacion
				html.append("<td>");
				html.append(costoExtraDetalle.getEspecificacion());
				html.append("</td>");
				
				cont++;
				costoExtraDetalle = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");
			// 1
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 2
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 3
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 4
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// 5
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table>");
		
		listaCostoExtraDetalle = null;
		
		return html.toString();
	}

	
}