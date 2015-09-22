package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.PartidaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PartidaDAO;

@Service("partidaService")
public class PartidaServiceImpl implements PartidaService {
	
	private static final int TIPO_TRABAJO_FLYER 	= 1;
	private static final int TIPO_TRABAJO_REVISTA 	= 2;
	private static final int TIPO_TRABAJO_OTRO 		= 3;
	
	@Resource
	private PartidaDAO partidaDAO;
	
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private PapelSobranteService papelSobranteService;
	@Resource 
	private DisenioService disenioService;
	@Resource
	private DisenioDetalleService disenioDetalleService;
	@Resource
	private PreprensaService preprensaService;
	@Resource
	private PreprensaDetalleService preprensaDetalleService;
	@Resource
	private TransporteService transporteService;
	@Resource
	private TransporteDetalleService transporteDetalleService;
	@Resource
	private AcabadoService acabadoService;
	@Resource
	private AcabadoDetalleService acabadoDetalleService;
	@Resource
	private CostoExtraDetalleService costoExtraDetalleService;
	
	
	public int creaPartida(Partida partida) {
		return partidaDAO.crea(partida);
	}
	
	public Partida buscaPartida(int idPartida) {
		return partidaDAO.busca(idPartida);
	}
	
	public PartidaDTO buscaPartidaEnDTO(int idPartida) {
		Partida partida = partidaDAO.busca(idPartida);
		PartidaDTO partidaDTO = new PartidaDTO();
		partidaDTO.setIdPartida(partida.getIdPartida());
		partidaDTO.setIdTipoTrabajo(partida.getTipoTrabajo().getIdTipoTrabajo());
		partidaDTO.setNombrePartida(partida.getNombrePartida());
		partidaDTO.setCantidad(partida.getCantidad());
		partidaDTO.setNombreTipoFormaTrabajo(partida.getTipoFormaTrabajo().getNombre());
		partidaDTO.setDescripcionPartida(partida.getDescripcionPartida());
		partidaDTO.setObservacionesGenerales(partida.getObservacionesGenerales());
		partidaDTO.setObservacionesAprobacion(partida.getObservacionesAprobacion());
		partida = null;
		return partidaDTO;
	}

	public void modificaPartida(Partida partida) {
		partidaDAO.modifica(partida); 
	}

	public List<Partida> listaPartida() {
		return partidaDAO.lista();
	}
	
	public List<Partida> listaPartidaPorOrdenProduccion(int idOrdenProduccion) {
		return partidaDAO.listaPorOrdenProduccion(idOrdenProduccion);
	}
	
	public float obtieneDisenioCosteTotal(int idPartida) {
		float costeTotal = 0f;
		Disenio disenio = disenioService.buscaDisenioPorPartida(idPartida);
		List<DisenioDetalle> lista = disenioDetalleService.listaDisenioDetallePorDisenio(disenio.getIdDisenio());
		for (DisenioDetalle disenioDetalle : lista) {
			costeTotal += disenioDetalle.getPrecioTotalPesos();
			disenioDetalle = null;
		}
		lista 	= null;
		disenio = null;
		return costeTotal;
	}

	public float obtienePreprensaCosteTotal(int idPartida) {
		float costeTotal = 0f;
		Preprensa preprensa = preprensaService.buscaPreprensaPorPartida(idPartida);
		List<PreprensaDetalle> lista = preprensaDetalleService.listaPreprensaDetallePorPreprensa(preprensa.getIdPreprensa());
		for (PreprensaDetalle preprensaDetalle : lista) {
			costeTotal += preprensaDetalle.getPrecioTotalPesos();
			preprensaDetalle = null;
		}
		lista		= null;
		preprensa 	= null;
		return costeTotal;
	}

	public float obtieneTransporteCosteTotal(int idPartida) {
		float costeTotal = 0f;
		Transporte transporte = transporteService.buscaTransportePorPartida(idPartida);
		List<TransporteDetalle> lista = transporteDetalleService.listaTransporteDetallePorTransporte(transporte.getIdTransporte());
		for (TransporteDetalle transporteDetalle : lista) {
			costeTotal += transporteDetalle.getPrecioTotalPesos();
			transporteDetalle = null;
		}
		lista		= null;
		transporte 	= null;
		return costeTotal;
	}

	public float obtieneAcabadoCosteTotal(int idPartida) {
		float costeTotal = 0f;
		Acabado acabado = acabadoService.buscaAcabadoPorPartida(idPartida);
		List<AcabadoDetalle> lista = acabadoDetalleService.listaAcabadoDetallePorAcabado(acabado.getIdAcabado());
		for (AcabadoDetalle acabadoDetalle : lista) {
			costeTotal += acabadoDetalle.getPrecioTotalPesos();
			acabadoDetalle = null;
		}
		lista 	= null;
		acabado = null;
		return costeTotal;
	}

	public float obtieneCostoExtraCosteTotal(int idPartida) {
		float costeTotal = 0f;
		List<CostoExtraDetalle> lista = costoExtraDetalleService.listaCostoExtraDetallePorPartida(idPartida);
		for (CostoExtraDetalle costosExtrasDetalle : lista) {
			costeTotal += costosExtrasDetalle.getPrecioTotalPesos();
			costosExtrasDetalle = null;
		}
		lista = null;
		return costeTotal;
	}
	
	public String buscaHTML(int idOrdenProduccion) {
		List<Partida> listaPartida = partidaDAO.listaPorOrdenProduccion(idOrdenProduccion);
		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_partidas\'>");

		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Tipo trabajo</th>");
		html.append("<th>Nombre</th>");
		html.append("<th>Cantidad</th>");
		html.append("<th>Descripci&oacute;n</th>");

		int cont = 0;
		if (listaPartida.size() > 0) {
			for (Partida partida : listaPartida) {
				html.append("<tr class=\'");
				if (cont % 2 == 0)
					html.append("l1");
				else
					html.append("l2");
				html.append("\'>");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(partida.getTipoTrabajo().getNombre());
				html.append("</td>");

				html.append("<td>");
				html.append(partida.getNombrePartida());
				html.append("</td>");

				html.append("<td>");
				html.append(partida.getCantidad());
				html.append("</td>");

				html.append("<td>");
				html.append(partida.getDescripcionPartida());
				html.append("</td>");

				html.append("</tr>");
				cont++;
				
				partida = null;
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

			html.append("</tr>");
		}

		html.append("</table>");
		
		listaPartida = null;

		return html.toString();
	}
	
	public void actualizaPartida(Partida partida) {
		
		// actualiza tabla PARTIDA
		partidaDAO.modifica(partida);
		
		// al actualizar la CANTIDAD de la PARTIDA significa que 
		// se debe ACTUALIZAR la cantidad de papel en la tabla PLIEGO.
		// Para ello, es necesario conocer que tipo de trabajo es: flyer o revista,
		// para saber cuantos registros hay insertados en la tabla PLIEGO.
		// Despues se debe hacer el calculo de hojas y actualizar los registros.
		
		PapelSobrante papelSobrante = new PapelSobrante();
		int idPartida				= partida.getIdPartida();
		int cantidad 				= partida.getCantidad();
		int hojasRequeridas 		= 0;
		int hojasSobrantes 			= 0;
		int hojasTotales 			= 0;
		
		List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = null;
		
		switch( partida.getTipoTrabajo().getIdTipoTrabajo() ) {
			
			case TIPO_TRABAJO_FLYER:

				listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(idPartida);
				for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
					int repeticionesXPliego 	= tipoTrabajoDetalle.getRepeticionesXPliego();
					List<Pliego> listaPliego	= pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
					for (Pliego pliego : listaPliego) {
						hojasRequeridas = (int) Math.ceil( (double) cantidad / (double) repeticionesXPliego );
							papelSobrante.setInicioTabulador(hojasRequeridas + 1);
							papelSobrante.setFinTabulador(hojasRequeridas - 1);
							papelSobrante.setFrenteNumTinta(tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas());
							papelSobrante.setVueltaNumTinta(tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas());
							papelSobrante.setTintaEspecial(tipoTrabajoDetalle.getFrenteNumTintaEspecial() > 0 || tipoTrabajoDetalle.getVueltaNumTintaEspecial() > 0 ? true : false);
						hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
						hojasTotales = hojasRequeridas + hojasSobrantes;

						pliego.setHojasRequeridas(hojasRequeridas);
						pliego.setHojasSobrantes(hojasSobrantes);
						pliego.setHojasTotales(hojasTotales);
						
						pliegoService.modificaPliego(pliego);
					}
				}
				papelSobrante = null;
				break;
				
			case TIPO_TRABAJO_REVISTA:
				
				listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(idPartida);
				for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
					
					List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
					for (Pliego pliego : listaPliego) {
					
						System.out.println("cantidad:" + cantidad);
						
						float numeroDecimal = pliego.getNumeroDecimal();
						hojasRequeridas = (int) Math.ceil(numeroDecimal * cantidad);
						System.out.println("hojasRequeridas:" + hojasRequeridas);
							papelSobrante.setInicioTabulador(hojasRequeridas + 1);
							papelSobrante.setFinTabulador(hojasRequeridas - 1);
							papelSobrante.setFrenteNumTinta(tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas());
							papelSobrante.setVueltaNumTinta(tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas());
							papelSobrante.setTintaEspecial(tipoTrabajoDetalle.getFrenteNumTintaEspecial() > 0 || tipoTrabajoDetalle.getVueltaNumTintaEspecial() > 0 ? true : false);
						hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
						System.out.println("hojasSobrantes:" + hojasSobrantes);
						hojasTotales = hojasRequeridas + hojasSobrantes;
					
						pliego.setHojasRequeridas(hojasRequeridas);
						pliego.setHojasSobrantes(hojasSobrantes);
						pliego.setHojasTotales(hojasTotales);
						
						pliegoService.modificaPliego(pliego);
					}
				}
				papelSobrante = null;
				break;
				
			case TIPO_TRABAJO_OTRO:
				break;
		}
		
		listaTipoTrabajoDetalle = null;
	}
	
}
