package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cotizacion;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOResultado;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOVariables;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CotizacionExpressService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/cotizacion_express")
public class CotizacionExpressController {

	private static final Logger log = Logger.getLogger(CotizacionExpressController.class);
	
	@Resource
	private TipoClienteService tipoClienteService;
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private CotizacionExpressService cotizacionExpressService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaCotizacion( Locale locale, Model model ) throws IOException {
		log.info("/cotizacion_express");
		
		List<ComboSelect> listaTipoCliente = tipoClienteService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		listaTipoCliente = null;
		
		List<ComboSelect> listaTamanioPublicacion = tamanioPublicacionService.listaComboSelect();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);
		listaTamanioPublicacion = null;
		
		List<ComboSelect> listaTipoPapelExtendido = tipoPapelExtendidoService.listaComboSelect();
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		List<ComboSelect> listaCombinacionTintas = combinacionTintasService.listaComboSelect();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;
		
		List<ComboSelect> listaTipoBarniz = tipoBarnizService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		listaTipoBarniz = null;
		
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		return "produccion/cotizacion/ventana_cotizacion_express";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/calcula", method = RequestMethod.POST)
	@ResponseBody
	public CotizacionExpressDTOResultado calculaCotizacionExpress(
			@RequestParam(value = "id_tipo_cliente", 				required = false) int idTipoCliente,
			@RequestParam(value = "cantidad", 						required = false) int cantidad,
			@RequestParam(value = "id_tipo_trabajo", 				required = false) int idTipoTrabajo,
			@RequestParam(value = "repeticiones_x_pliego", 			required = false) int repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 	required = false) int numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 		required = false) int idTamanioPublicacion,
			@RequestParam(value = "numero_pliegos", 				required = false) float numeroPliegos,
			@RequestParam(value = "incluye_costo_papel", 			required = false) boolean incluyeCostoPapel,
			@RequestParam(value = "id_tipo_papel_extendido", 		required = false) int idTipoPapelExtendido,
			@RequestParam(value = "frente_id_combinacion_tintas", 	required = false) int frenteIdCombinacionTintas,
			@RequestParam(value = "frente_numero_tinta_especial", 	required = false) int frenteNumeroTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 			required = false) int frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 	required = false) int vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_numero_tinta_especial", 	required = false) int vueltaNumeroTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 			required = false) int vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 					required = false) int idMaquina,
			@RequestParam(value = "incluye_costo_placa", 			required = false) boolean incluyeCostoPlaca,
			@RequestParam(value = "id_tipo_placa", 					required = false) int idTipoPlaca,
			@RequestParam(value = "vuelta_mismas_placas", 			required = false) boolean vueltaMismasPlacas,
			@RequestParam(value = "aplica_precio_tabulador", 		required = false) boolean aplicaPrecioTabulador,
			@RequestParam(value = "precio_tabulador", 				required = false) int precioTabulador,
			@RequestParam(value = "costos_extra", 					required = false) float costosExtra
		) {
		log.info("/calcula_cotizacion");
		
		CotizacionExpressDTOVariables cotizacionExpressDTOVariables = new CotizacionExpressDTOVariables();
		cotizacionExpressDTOVariables.setIdTipoCliente(idTipoCliente);
		cotizacionExpressDTOVariables.setCantidad(cantidad);
		cotizacionExpressDTOVariables.setIdTipoTrabajo(idTipoTrabajo);
		cotizacionExpressDTOVariables.setRepeticionesXPliego(repeticionesXPliego);
		cotizacionExpressDTOVariables.setNumeroPaginasPublicacion(numeroPaginasPublicacion);
		cotizacionExpressDTOVariables.setIdTamanioPublicacion(idTamanioPublicacion);
		cotizacionExpressDTOVariables.setNumeroPliegos(numeroPliegos);
		cotizacionExpressDTOVariables.setIncluyeCostoPapel(incluyeCostoPapel);
		cotizacionExpressDTOVariables.setIdTipoPapelExtendido(idTipoPapelExtendido);
		cotizacionExpressDTOVariables.setFrenteIdCombinacionTintas(frenteIdCombinacionTintas);
		cotizacionExpressDTOVariables.setFrenteNumeroTintaEspecial(frenteNumeroTintaEspecial);
		cotizacionExpressDTOVariables.setFrenteIdTipoBarniz(frenteIdTipoBarniz);
		cotizacionExpressDTOVariables.setVueltaIdCombinacionTintas(vueltaIdCombinacionTintas);
		cotizacionExpressDTOVariables.setVueltaNumeroTintaEspecial(vueltaNumeroTintaEspecial);
		cotizacionExpressDTOVariables.setVueltaIdTipoBarniz(vueltaIdTipoBarniz);
		cotizacionExpressDTOVariables.setIdMaquina(idMaquina);
		cotizacionExpressDTOVariables.setIncluyeCostoPlaca(incluyeCostoPlaca);
		cotizacionExpressDTOVariables.setIdTipoPlaca(idTipoPlaca);
		cotizacionExpressDTOVariables.setVueltaMismasPlacas(vueltaMismasPlacas);
		cotizacionExpressDTOVariables.setAplicaPrecioTabulador(aplicaPrecioTabulador);
		cotizacionExpressDTOVariables.setPrecioTabulador(precioTabulador);
		cotizacionExpressDTOVariables.setCostosExtra(costosExtra);
		
		CotizacionExpressDTOResultado cotizadorExpressResultado = cotizacionExpressService.calculaCotizacionExpress(cotizacionExpressDTOVariables);
		
		cotizacionExpressDTOVariables = null;
		return cotizadorExpressResultado;
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/reporte_excel", method = RequestMethod.POST)
	public void impresionCotizacionExpress(
			@RequestParam(value = "id_tipo_cliente", 				required = false) int idTipoCliente,
			@RequestParam(value = "cantidad", 						required = false) int cantidad,
			@RequestParam(value = "id_tipo_trabajo", 				required = false) int idTipoTrabajo,
			@RequestParam(value = "repeticiones_x_pliego", 			required = false) int repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 	required = false) int numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 		required = false) int idTamanioPublicacion,
			@RequestParam(value = "numero_pliegos", 				required = false) float numeroPliegos,
			@RequestParam(value = "incluye_costo_papel", 			required = false) boolean incluyeCostoPapel,
			@RequestParam(value = "id_tipo_papel_extendido", 		required = false) int idTipoPapelExtendido,
			@RequestParam(value = "frente_id_combinacion_tintas", 	required = false) int frenteIdCombinacionTintas,
			@RequestParam(value = "frente_numero_tinta_especial", 	required = false) int frenteNumeroTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 			required = false) int frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 	required = false) int vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_numero_tinta_especial", 	required = false) int vueltaNumeroTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 			required = false) int vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 					required = false) int idMaquina,
			@RequestParam(value = "incluye_costo_placa", 			required = false) boolean incluyeCostoPlaca,
			@RequestParam(value = "id_tipo_placa", 					required = false) int idTipoPlaca,
			@RequestParam(value = "vuelta_mismas_placas", 			required = false) boolean vueltaMismasPlacas,
			@RequestParam(value = "aplica_precio_tabulador", 		required = false) boolean aplicaPrecioTabulador,
			@RequestParam(value = "precio_tabulador", 				required = false) int precioTabulador,
			@RequestParam(value = "costos_extra", 					required = false) float costosExtra,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		CotizacionExpressDTOVariables cotizacionExpressDTOVariables = new CotizacionExpressDTOVariables();
		cotizacionExpressDTOVariables.setIdTipoCliente(idTipoCliente);
		cotizacionExpressDTOVariables.setCantidad(cantidad);
		cotizacionExpressDTOVariables.setIdTipoTrabajo(idTipoTrabajo);
		cotizacionExpressDTOVariables.setRepeticionesXPliego(repeticionesXPliego);
		cotizacionExpressDTOVariables.setNumeroPaginasPublicacion(numeroPaginasPublicacion);
		cotizacionExpressDTOVariables.setIdTamanioPublicacion(idTamanioPublicacion);
		cotizacionExpressDTOVariables.setNumeroPliegos(numeroPliegos);
		cotizacionExpressDTOVariables.setIncluyeCostoPapel(incluyeCostoPapel);
		cotizacionExpressDTOVariables.setIdTipoPapelExtendido(idTipoPapelExtendido);
		cotizacionExpressDTOVariables.setFrenteIdCombinacionTintas(frenteIdCombinacionTintas);
		cotizacionExpressDTOVariables.setFrenteNumeroTintaEspecial(frenteNumeroTintaEspecial);
		cotizacionExpressDTOVariables.setFrenteIdTipoBarniz(frenteIdTipoBarniz);
		cotizacionExpressDTOVariables.setVueltaIdCombinacionTintas(vueltaIdCombinacionTintas);
		cotizacionExpressDTOVariables.setVueltaNumeroTintaEspecial(vueltaNumeroTintaEspecial);
		cotizacionExpressDTOVariables.setVueltaIdTipoBarniz(vueltaIdTipoBarniz);
		cotizacionExpressDTOVariables.setIdMaquina(idMaquina);
		cotizacionExpressDTOVariables.setIncluyeCostoPlaca(incluyeCostoPlaca);
		cotizacionExpressDTOVariables.setIdTipoPlaca(idTipoPlaca);
		cotizacionExpressDTOVariables.setVueltaMismasPlacas(vueltaMismasPlacas);
		cotizacionExpressDTOVariables.setAplicaPrecioTabulador(aplicaPrecioTabulador);
		cotizacionExpressDTOVariables.setPrecioTabulador(precioTabulador);
		cotizacionExpressDTOVariables.setCostosExtra(costosExtra);
		
		byte[] documento = cotizacionExpressService.obtieneExcelCotizacionExpress(cotizacionExpressDTOVariables);
		
		try {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			OutputStream os = response.getOutputStream();
			response.setHeader("Content-Disposition","attachment; filename=cotizacionExpress" + dateFormat.format(date) + ".xls");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength(documento.length);
			os.write(documento);
			os.flush();
		} catch( Exception e ) {
			log.error("Error al enviar el archivo de excel");
			e.printStackTrace();
		} finally {
			cotizacionExpressDTOVariables = null;
			documento = null;
		}
	}
}
