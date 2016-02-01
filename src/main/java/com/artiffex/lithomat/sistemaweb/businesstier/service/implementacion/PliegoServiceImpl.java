package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPliegoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PliegoDAO;

@Service("pliegoService")
public class PliegoServiceImpl implements PliegoService {

	private static final int TIPO_TRABAJO_FLYER 	= 1;
	private static final int TIPO_TRABAJO_REVISTA 	= 2;
	private static final int TIPO_TRABAJO_OTRO 		= 3;

	@Resource
	private PliegoDAO pliegoDAO;
	@Resource
	private CalificacionPliegoDAO calificacionPliegoDAO;
	
	@Resource
	private PapelSobranteService papelSobranteService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	

	public List<Pliego> calculaListaPliegos(int idTipoTrabajoDetalle) {

		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);

		List<Pliego> listaPliego = new ArrayList<Pliego>();
		
		// variables para calculo de informacion
		PapelSobrante papelSobrante = new PapelSobrante();
		int cantidad				= tipoTrabajoDetalle.getPartida().getCantidad();
		int frenteNumTinta			= tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas();
		int vueltaNumTinta			= tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas();
		int frenteNumTintaEspecial	= tipoTrabajoDetalle.getFrenteNumTintaEspecial();
		int vueltaNumTintaEspecial	= tipoTrabajoDetalle.getVueltaNumTintaEspecial();
		int hojasRequeridas 		= 0;
		int hojasSobrantes 			= 0;
		int hojasTotales 			= 0;
		
		// busca el tipo de trabajo para saber como proceder al calculo de pliegos.
		switch (tipoTrabajoDetalle.getPartida().getTipoTrabajo().getIdTipoTrabajo()) {
			case TIPO_TRABAJO_FLYER:
				
				// cantidad de hojas = cantidad total de flyers / flyers que caben
				// en un pliego.
				// System.out.println("datosAyudaPliego.getCantidad = " + tipoTrabajoDetalle.getPartida().getCantidad());
				// System.out.println("datosAyudaPliego.getRepeticiones_x_pliego = " + tipoTrabajoDetalle.getRepeticionesXPliego());
				// System.out.println("datosAyudaPliego.getCantidad / datosAyudaPliego.getRepeticiones_x_pliego = " + tipoTrabajoDetalle.getPartida().getCantidad() / tipoTrabajoDetalle.getRepeticionesXPliego());
				// System.out.println("1) ceil( division ) = " + Math.ceil((double) tipoTrabajoDetalle.getPartida().getCantidad() / (double) (tipoTrabajoDetalle.getRepeticionesXPliego() * 1.0)));
				// System.out.println("2) ceil( division ) = " + Math.ceil( (double) tipoTrabajoDetalle.getPartida().getCantidad() / (double) tipoTrabajoDetalle.getRepeticionesXPliego() ) );
	
				int repeticionesXPliego = tipoTrabajoDetalle.getRepeticionesXPliego();
				hojasRequeridas = (int) Math.ceil( (double) cantidad / (double) repeticionesXPliego );
					papelSobrante.setInicioTabulador(hojasRequeridas + 1);
					papelSobrante.setFinTabulador(hojasRequeridas - 1);
					papelSobrante.setFrenteNumTinta(frenteNumTinta);
					papelSobrante.setVueltaNumTinta(vueltaNumTinta);
					papelSobrante.setTintaEspecial( frenteNumTintaEspecial > 0 || vueltaNumTintaEspecial > 0 ? true : false);
				hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
				hojasTotales = hojasRequeridas + hojasSobrantes;
					
				// objeto que se envia de regreso para pintar table correspondiente.
				Pliego pliegoFlyer = new Pliego();
				
				pliegoFlyer.setNumeroDecimal(1);
				pliegoFlyer.setHojasRequeridas(hojasRequeridas);
				pliegoFlyer.setHojasSobrantes(hojasSobrantes);
				pliegoFlyer.setHojasTotales(hojasTotales);
				pliegoFlyer.setObservaciones("Ninguna");
				pliegoFlyer.setVueltaMismasPlacas(false);
					TipoVuelta tipoVueltaFlyer = new TipoVuelta();
					tipoVueltaFlyer.setIdTipoVuelta(1);
					tipoVueltaFlyer.setNombre("No aplica");
				pliegoFlyer.setTipoVuelta(tipoVueltaFlyer);
				
				listaPliego.add(pliegoFlyer);
	
				papelSobrante 	= null;
				tipoVueltaFlyer = null;
				pliegoFlyer 	= null;
				
				break;
	
			case TIPO_TRABAJO_REVISTA:
	
				List<TamanioPublicacion> listaTamanio = tamanioPublicacionService.listaDecimales();
				// cantidad de pliegos = ( cantidad de paginas de publicacion / hojas tamanio revista )
				// double cantidad_pliegos = (double) 56 / 32;
				double cantidadPliegos = (double) tipoTrabajoDetalle.getNumeroPaginasPublicacion() / tipoTrabajoDetalle.getTamanioPublicacion().getNumeroPaginas();
				int contadorPaginas = 0;
				for (TamanioPublicacion tamanio : listaTamanio) {
					do {
						if (cantidadPliegos >= tamanio.getNumeroDecimal()) {
							float numeroDecimal = tamanio.getNumeroDecimal();
							hojasRequeridas = (int) Math.ceil(numeroDecimal * cantidad);
								papelSobrante.setInicioTabulador(hojasRequeridas + 1);
								papelSobrante.setFinTabulador(hojasRequeridas - 1);
								papelSobrante.setFrenteNumTinta(frenteNumTinta);
								papelSobrante.setVueltaNumTinta(vueltaNumTinta);
								papelSobrante.setTintaEspecial(frenteNumTintaEspecial > 0 || vueltaNumTintaEspecial > 0 ? true : false);
							hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
							hojasTotales = hojasRequeridas + hojasSobrantes;
							
							Pliego pliegoRevista = new Pliego();
							pliegoRevista.setNumeroDecimal(numeroDecimal);
							pliegoRevista.setHojasRequeridas(hojasRequeridas);
							pliegoRevista.setHojasSobrantes(hojasSobrantes);
							pliegoRevista.setHojasTotales(hojasTotales);
								StringBuilder observaciones = new StringBuilder();
								observaciones.append("Pag: ");
									contadorPaginas = contadorPaginas + 1;
								observaciones.append(contadorPaginas);
								observaciones.append(" - ");
									float paginasCalculadas = tipoTrabajoDetalle.getTamanioPublicacion().getNumeroPaginas() * tamanio.getNumeroDecimal();
									contadorPaginas = (contadorPaginas + (int) paginasCalculadas - 1);
								observaciones.append(contadorPaginas);
								observaciones.append(".");
							pliegoRevista.setObservaciones(observaciones.toString());
								TipoVuelta tipoVueltaRevista = new TipoVuelta();
								if (tamanio.getNumeroDecimal() >= 1) {
									pliegoRevista.setVueltaMismasPlacas(false);
										tipoVueltaRevista.setIdTipoVuelta(1);
										tipoVueltaRevista.setNombre("No aplica");
									pliegoRevista.setTipoVuelta(tipoVueltaRevista);
								} else {
									pliegoRevista.setVueltaMismasPlacas(true);
										tipoVueltaRevista.setIdTipoVuelta(2);
										tipoVueltaRevista.setNombre("Normal");
									pliegoRevista.setTipoVuelta(tipoVueltaRevista);
								}
							listaPliego.add(pliegoRevista);
	
							cantidadPliegos -= numeroDecimal;
	
							observaciones 		= null;
							tipoVueltaRevista	= null;
							pliegoRevista 		= null;
							hojasRequeridas 	= 0;
							hojasSobrantes 		= 0;
							hojasTotales 		= 0;
						} else {
							break;
						}// if
					} while (cantidadPliegos > 0);
				}// for
				papelSobrante = null;
				break;
	
			case TIPO_TRABAJO_OTRO:
				break;
	
			default:
				break;
		}// switch
		tipoTrabajoDetalle = null;
		
		return listaPliego;
	}
	
	public int creaPliego(Pliego pliego, String json) {
		JSONParser parser = new JSONParser();
		try {
			Object obj 					= parser.parse(json);
			JSONObject jsonObject 		= (JSONObject) obj;
			System.out.println("jsonObject: " + jsonObject);
			JSONArray arreglo 			= (JSONArray) jsonObject.get("pliegos");
			@SuppressWarnings("unchecked")
			Iterator<Object> iterator 	= arreglo.iterator();
			int contadorNumeroPliego	= 0;

			while (iterator.hasNext()) {

				JSONObject jsonObject_2 = (JSONObject) iterator.next();
				
				// System.out.println(
				// jsonObject_2.get("hojas_requeridas").toString() ); //
				// System.out.println(
				// jsonObject_2.get("hojas_sobrantes").toString() ); //
				// System.out.println(
				// jsonObject_2.get("hojas_totales").toString() ); //
				// System.out.println(
				// jsonObject_2.get("observaciones").toString() );
				
				TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(pliego.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());

				Pliego pliegoInsert = new Pliego();
				pliegoInsert.setTipoTrabajoDetalle(tipoTrabajoDetalle);
				pliegoInsert.setNumeroPliego(++contadorNumeroPliego);
				pliegoInsert.setRebaseEnMilimetros(pliego.getRebaseEnMilimetros());
				pliegoInsert.setMedianilesEnMilimetros(pliego.getMedianilesEnMilimetros());
				pliegoInsert.setPinzasEnMilimetros(pliego.getPinzasEnMilimetros());

				pliegoInsert.setObservaciones(jsonObject_2.get("observaciones").toString());
				pliegoInsert.setHojasRequeridas(Integer.parseInt(jsonObject_2.get("hojas_requeridas").toString()));
				pliegoInsert.setHojasSobrantes(Integer.parseInt(jsonObject_2.get("hojas_sobrantes").toString()));
				pliegoInsert.setHojasTotales(Integer.parseInt(jsonObject_2.get("hojas_totales").toString()));

				// pregunta si son mismas placas
				if (Boolean.parseBoolean(jsonObject_2.get("vuelta_mismas_placas").toString())) {
					// SI son mismas placas: tratamiento especial; entonces 1 placa != 1 tinta
					// conocer los colores que van a pasar por rodillo tanto
					// frente como vuelta y que no sean repetidos
					String descripcionTintaFrente = tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion();
					String descripcionTintaVuelta = tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion();
					
					StringBuilder cadenaFinal = new StringBuilder();
					if ( tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas() > 0 ) 
						for ( int i = 0; i < descripcionTintaFrente.length(); i++ ) { 
							try {
								cadenaFinal.append(descripcionTintaFrente.charAt(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					
					if ( tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas() > 0 ) 
						for ( int i = 0; i < descripcionTintaVuelta.length(); i++ ) { 
							try {
								if ( cadenaFinal.toString().indexOf(descripcionTintaVuelta.charAt(i)) == -1 )
									cadenaFinal.append(descripcionTintaVuelta.charAt(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					
					//System.out.println( cadenaFinal );
					
					// FRENTE
					int fteVtaNumEntMaqTinta 			= cadenaFinal.length();
					int fteVtaNumEntMaqTintaEspecial	= (tipoTrabajoDetalle.getFrenteNumTintaEspecial() + tipoTrabajoDetalle.getVueltaNumTintaEspecial());
					int fteVtaNumPlacasBarniz			= 0;
					if( tipoTrabajoDetalle.getFrenteTipoBarniz().getNumPlacas() > 0 || tipoTrabajoDetalle.getVueltaTipoBarniz().getNumPlacas() > 0 )
						fteVtaNumPlacasBarniz 			= 1;
					int fteVtaNumPlacas 				= fteVtaNumEntMaqTinta + fteVtaNumEntMaqTintaEspecial + fteVtaNumPlacasBarniz;

					pliegoInsert.setFrenteNumEntradasMaquinaTinta(cadenaFinal.length());
					pliegoInsert.setFrenteNumEntradasMaquinaTintaEspecial(fteVtaNumEntMaqTintaEspecial);
					pliegoInsert.setFrenteNumEntradasMaquinaBarniz(tipoTrabajoDetalle.getFrenteTipoBarniz().getNumEntradasMaquina());
					pliegoInsert.setFrenteNumTotalPlacas(fteVtaNumPlacas);

					// VUELTA
					pliegoInsert.setVueltaNumEntradasMaquinaTinta(cadenaFinal.length());
					pliegoInsert.setVueltaNumEntradasMaquinaTintaEspecial(fteVtaNumEntMaqTintaEspecial);
					pliegoInsert.setVueltaNumEntradasMaquinaBarniz(tipoTrabajoDetalle.getVueltaTipoBarniz().getNumEntradasMaquina());
					pliegoInsert.setVueltaMismasPlacas(true);
					pliegoInsert.setVueltaNumTotalPlacas(0);
					
					// limpia memoria
					cadenaFinal 					= null;
					fteVtaNumEntMaqTinta 			= 0;
					fteVtaNumEntMaqTintaEspecial 	= 0;
					fteVtaNumPlacasBarniz 			= 0;
					fteVtaNumPlacas 				= 0;
				} else {
					// NO son mismas placas, entonces 1 placa = 1 tinta; cada
					// placa es un color diferente
					
					// frente
					int fteNumEntMaqTinta 			= tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas();
					int fteNumEntMaqTintaEspecial 	= tipoTrabajoDetalle.getFrenteNumTintaEspecial();
					int fteNumEntMaqBarniz			= tipoTrabajoDetalle.getFrenteTipoBarniz().getNumEntradasMaquina();
					int fteNumPlacasBarniz			= tipoTrabajoDetalle.getFrenteTipoBarniz().getNumPlacas();
					
					pliegoInsert.setFrenteNumEntradasMaquinaTinta(fteNumEntMaqTinta);
					pliegoInsert.setFrenteNumEntradasMaquinaTintaEspecial(fteNumEntMaqTintaEspecial);
					pliegoInsert.setFrenteNumEntradasMaquinaBarniz(fteNumEntMaqBarniz);
					pliegoInsert.setFrenteNumTotalPlacas(fteNumEntMaqTinta + fteNumEntMaqTintaEspecial + fteNumPlacasBarniz);
					
					// vuelta
					int vtaNumEntMaqTinta			= tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas();
					int vtaNumEntMaqTintaEspecial	= tipoTrabajoDetalle.getVueltaNumTintaEspecial();
					int vtaNumEntMaqBarniz			= tipoTrabajoDetalle.getVueltaTipoBarniz().getNumEntradasMaquina();
					int vtaNumPlacasBarniz			= tipoTrabajoDetalle.getVueltaTipoBarniz().getNumPlacas();
					
					pliegoInsert.setVueltaNumEntradasMaquinaTinta(vtaNumEntMaqTinta);
					pliegoInsert.setVueltaNumEntradasMaquinaTintaEspecial(vtaNumEntMaqTintaEspecial);
					pliegoInsert.setVueltaNumEntradasMaquinaBarniz(vtaNumEntMaqBarniz);
					pliegoInsert.setVueltaMismasPlacas(false);
					pliegoInsert.setVueltaNumTotalPlacas(vtaNumEntMaqTinta + vtaNumEntMaqTintaEspecial + vtaNumPlacasBarniz);
					
				}
				
					TipoVuelta tipoVuelta = new TipoVuelta();
					tipoVuelta.setIdTipoVuelta(Integer.parseInt(jsonObject_2.get("id_tipo_vuelta").toString()));
				pliegoInsert.setTipoVuelta(tipoVuelta);
				pliegoInsert.setNumeroDecimal(Float.parseFloat(jsonObject_2.get("numero_decimal").toString()));
				pliegoInsert.setActivo(true);
				
				pliegoDAO.crea(pliegoInsert);

				tipoTrabajoDetalle 	= null;
				pliegoInsert 		= null;
				jsonObject_2 		= null;
			}
			iterator = null;
			arreglo = null;
			jsonObject = null;
			obj = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		parser = null;
		
		return 1;
	}
	
	public Pliego buscaPliego(int idPliego) {
		return pliegoDAO.busca(idPliego);
	}

	public void modificaPliego(Pliego pliego) {
		pliegoDAO.modifica(pliego);
	}

	public List<Pliego> listaPliego() {
		return pliegoDAO.lista();
	}
	
	public List<Pliego> listaPliegoPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		return pliegoDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	}
	
	public String buscaHTML(int idTipoTrabajoDetalle) {
		// lista de pliegos
		DecimalFormat formato = new DecimalFormat("#,###");
		List<Pliego> lista = pliegoDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);

		StringBuilder html = new StringBuilder();
		html.append("<table id=\'tabla_lista_pliegos\'>");

		html.append("<tr>");
		html.append("<th>No. Pgo</th>");
		html.append("<th>Rebase (mm.)</th>");
		html.append("<th>Medianiles (mm.)</th>");
		html.append("<th>Pinzas (mm.)</th>");
		html.append("<th>H. Requeridas</th>");
		html.append("<th>H. Sobrantes</th>");
		html.append("<th>H. Totales</th>");
		html.append("<th width=\'20%\'>Observaciones</th>");
		html.append("<th>Frente Ent. M&aacute;quina</th>");
		html.append("<th>Frente No. Placas</th>");
		html.append("<th>Vuelta Ent. M&aacute;quina</th>");
		html.append("<th>Vuelta No. Placas</th>");
		html.append("</tr>");

		int cont 					= 0;
		int totalHojasRequeridas 	= 0;
		int totalHojasSobrantes 	= 0;
		int totalHojasTotales 		= 0;
		int totalEntradasFrente 	= 0;
		int totalEntradasVuelta 	= 0;
		int totalPlacasFrente 		= 0;
		int totalPlacasVuelta 		= 0;

		if (lista.size() > 0) {
			for (Pliego pliego : lista) {
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
				html.append(pliego.getRebaseEnMilimetros());
				html.append("</td>");

				html.append("<td>");
				html.append(pliego.getMedianilesEnMilimetros());
				html.append("</td>");

				html.append("<td>");
				html.append(pliego.getPinzasEnMilimetros());
				html.append("</td>");

				html.append("<td>");
				html.append(formato.format(pliego.getHojasRequeridas()));
				html.append("</td>");

				totalHojasRequeridas += pliego.getHojasRequeridas();

				html.append("<td>");
				html.append(formato.format(pliego.getHojasSobrantes()));
				html.append("</td>");

				totalHojasSobrantes += pliego.getHojasSobrantes();

				html.append("<td>");
				html.append(formato.format(pliego.getHojasTotales()));
				html.append("</td>");

				totalHojasTotales += pliego.getHojasTotales();

				html.append("<td>");
				html.append(pliego.getObservaciones());
				html.append("</td>");

				html.append("<td>");
				html.append(pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getFrenteNumEntradasMaquinaBarniz());
				html.append("</td>");

				totalEntradasFrente += pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getFrenteNumEntradasMaquinaBarniz();

				html.append("<td>");
				html.append(pliego.getFrenteNumTotalPlacas());
				html.append("</td>");

				totalPlacasFrente += pliego.getFrenteNumTotalPlacas();

				html.append("<td>");
				html.append(pliego.getVueltaNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaBarniz());
				html.append("</td>");

				totalEntradasVuelta += pliego.getVueltaNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaBarniz();

				html.append("<td>");
				html.append(pliego.getVueltaNumTotalPlacas());
				html.append("</td>");

				totalPlacasVuelta += pliego.getVueltaNumTotalPlacas();

				html.append("</tr>");

				cont++;
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

		html.append("<tr>");
		html.append("<td><i>TOTAL</i></td>");
		html.append("<td></td>");
		html.append("<td></td>");
		html.append("<td></td>");
		html.append("<td><i>");
		html.append(formato.format(totalHojasRequeridas));
		html.append("</i></td>");
		html.append("<td><i>");
		html.append(formato.format(totalHojasSobrantes));
		html.append("</i></td>");
		html.append("<td><i>");
		html.append(formato.format(totalHojasTotales));
		html.append("</i></td>");
		html.append("<td></td>");
		html.append("<td><i>");
		html.append(formato.format(totalEntradasFrente));
		html.append("</i></td>");
		html.append("<td><i>");
		html.append(formato.format(totalPlacasFrente));
		html.append("</i></td>");
		html.append("<td><i>");
		html.append(formato.format(totalEntradasVuelta));
		html.append("</i></td>");
		html.append("<td><i>");
		html.append(formato.format(totalPlacasVuelta));
		html.append("</i></td>");
		html.append("</tr>");
		html.append("</table>");

		lista = null;
		formato = null;
		
		return html.toString();
	}
	
	public String listaHTMLModificacion(int idTipoTrabajoDetalle) {
		// lista de pliegos
				DecimalFormat formato = new DecimalFormat("#,###");
				List<Pliego> lista = pliegoDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);

				StringBuilder html = new StringBuilder();
				html.append("<table id=\'tabla_lista_pliegos\'>");

				html.append("<tr>");
				html.append("<th>No. Pgo</th>");
				html.append("<th>Rebase (mm.)</th>");
				html.append("<th>Medianiles (mm.)</th>");
				html.append("<th>Pinzas (mm.)</th>");
				html.append("<th>H. Requeridas</th>");
				html.append("<th>H. Sobrantes</th>");
				html.append("<th>H. Totales</th>");
				html.append("<th width=\'20%\'>Observaciones</th>");
				html.append("<th>Frente Ent. M&aacute;quina</th>");
				html.append("<th>Frente No. Placas</th>");
				html.append("<th>Vuelta Ent. M&aacute;quina</th>");
				html.append("<th>Vuelta No. Placas</th>");
				html.append("</tr>");

				int cont 					= 0;
				int totalHojasRequeridas 	= 0;
				int totalHojasSobrantes 	= 0;
				int totalHojasTotales 		= 0;
				int totalEntradasFrente 	= 0;
				int totalEntradasVuelta 	= 0;
				int totalPlacasFrente 		= 0;
				int totalPlacasVuelta 		= 0;

				if (lista.size() > 0) {
					for (Pliego pliego : lista) {
						html.append("<tr class=\'");
						if (cont % 2 == 0)
							html.append("l1");
						else
							html.append("l2");
						html.append("\' ");
						html.append("onclick=\'setCamposPliego("
								+ "&#39;" + pliego.getIdPliego() + "&#39;,"
								+ "&#39;" + (cont + 1) + "&#39;,"
								+ "&#39;" + pliego.getRebaseEnMilimetros() + "&#39;,"
								+ "&#39;" + pliego.getMedianilesEnMilimetros() + "&#39;,"
								+ "&#39;" + pliego.getPinzasEnMilimetros() + "&#39;,"
								+ "&#39;" + pliego.getHojasSobrantes() + "&#39;,"
								+ "&#39;" + pliego.getObservaciones() + "&#39;"
								+ ")\'");
						html.append(">");

						html.append("<td>");
						html.append(cont + 1);
						html.append("</td>");

						html.append("<td>");
						html.append(pliego.getRebaseEnMilimetros());
						html.append("</td>");

						html.append("<td>");
						html.append(pliego.getMedianilesEnMilimetros());
						html.append("</td>");

						html.append("<td>");
						html.append(pliego.getPinzasEnMilimetros());
						html.append("</td>");

						html.append("<td>");
						html.append(formato.format(pliego.getHojasRequeridas()));
						html.append("</td>");

						totalHojasRequeridas += pliego.getHojasRequeridas();

						html.append("<td>");
						html.append(formato.format(pliego.getHojasSobrantes()));
						html.append("</td>");

						totalHojasSobrantes += pliego.getHojasSobrantes();

						html.append("<td>");
						html.append(formato.format(pliego.getHojasTotales()));
						html.append("</td>");

						totalHojasTotales += pliego.getHojasTotales();

						html.append("<td>");
						html.append(pliego.getObservaciones());
						html.append("</td>");

						html.append("<td>");
						html.append(pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getFrenteNumEntradasMaquinaBarniz());
						html.append("</td>");

						totalEntradasFrente += pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getFrenteNumEntradasMaquinaBarniz();

						html.append("<td>");
						html.append(pliego.getFrenteNumTotalPlacas());
						html.append("</td>");

						totalPlacasFrente += pliego.getFrenteNumTotalPlacas();

						html.append("<td>");
						html.append(pliego.getVueltaNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaBarniz());
						html.append("</td>");

						totalEntradasVuelta += pliego.getVueltaNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaBarniz();

						html.append("<td>");
						html.append(pliego.getVueltaNumTotalPlacas());
						html.append("</td>");

						totalPlacasVuelta += pliego.getVueltaNumTotalPlacas();

						html.append("</tr>");

						cont++;
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

				html.append("<tr>");
				html.append("<td><i>TOTAL</i></td>");
				html.append("<td></td>");
				html.append("<td></td>");
				html.append("<td></td>");
				html.append("<td><i>");
				html.append(formato.format(totalHojasRequeridas));
				html.append("</i></td>");
				html.append("<td><i>");
				html.append(formato.format(totalHojasSobrantes));
				html.append("</i></td>");
				html.append("<td><i>");
				html.append(formato.format(totalHojasTotales));
				html.append("</i></td>");
				html.append("<td></td>");
				html.append("<td><i>");
				html.append(formato.format(totalEntradasFrente));
				html.append("</i></td>");
				html.append("<td><i>");
				html.append(formato.format(totalPlacasFrente));
				html.append("</i></td>");
				html.append("<td><i>");
				html.append(formato.format(totalEntradasVuelta));
				html.append("</i></td>");
				html.append("<td><i>");
				html.append(formato.format(totalPlacasVuelta));
				html.append("</i></td>");
				html.append("</tr>");
				html.append("</table>");

				lista = null;
				formato = null;
				
				return html.toString();
	}

	public List<Integer> eliminaPliegoPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		List<Integer> listaIdPliegoEliminado = new ArrayList<Integer>();
		List<Pliego> listaPliego = pliegoDAO.listaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		for (Pliego pliego : listaPliego) {
			listaIdPliegoEliminado.add(pliego.getIdPliego());
			// eliminacion logica del pliego
			pliego.setActivo(false);
			pliegoDAO.modifica(pliego);
			// eliminacion logica de calificacion_pliego
			CalificacionPliego calificacionPliego = calificacionPliegoDAO.buscaPorPliego(pliego.getIdPliego());
			calificacionPliego.setActivo(false);
			calificacionPliegoDAO.modifica(calificacionPliego);
			calificacionPliego 	= null;
			pliego 				= null;
		}
		listaPliego = null;
		return listaIdPliegoEliminado;
	}

	public void activaPliego(int idPliego) {
		// activa pliego
		Pliego pliego = pliegoDAO.busca(idPliego);
		pliego.setActivo(true);
		pliegoDAO.modifica(pliego);
		pliego = null;
		// activa calificacion_pliego
		CalificacionPliego calificacionPliego = calificacionPliegoDAO.buscaPorPliego(idPliego);
		calificacionPliego.setActivo(true);
		calificacionPliegoDAO.modifica(calificacionPliego);
		calificacionPliego = null;
	}

	public int cuentaPliegosPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		return pliegoDAO.numeroPliegosPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	}

}
