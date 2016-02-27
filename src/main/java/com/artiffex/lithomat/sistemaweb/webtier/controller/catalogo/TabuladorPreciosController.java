package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComplejidadService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTabuladorPrecios;
import com.google.gson.Gson;

@Controller
@RequestMapping("/tabulador_precios")
public class TabuladorPreciosController {

	private static final Logger log = Logger.getLogger(TabuladorPreciosController.class);
	
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TipoComplejidadService tipoComplejidadService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTabuladorPrecios( Locale locale, Model model ) throws IOException {
		log.info("/lista_tabulador_precios");

		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina 			= null;
		
		List<ComboSelect> listaTipoComplejidad = tipoComplejidadService.listaComboSelect();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		listaTipoComplejidad	= null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio 		= null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// parametros de busqueda
		ParametrosBusquedaTabuladorPrecios parametros = new ParametrosBusquedaTabuladorPrecios();
		parametros.setBusquedaPorMaquina(false);
		parametros.setBusquedaPorComplejidad(false);
		parametros.setIdMaquina(0);
		parametros.setIdTipoComplejidad(0);
		
		// numero total de registros // BUSQUEDA DEFAULT
		int numeroTotalRegistros = tabuladorPreciosService.numeroRegistrosPorCriterioBusqueda( parametros );
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TabuladorPreciosDTO> listaTabuladorPrecios = tabuladorPreciosService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		listaTabuladorPrecios 	= null;
		
		parametros = null;
		
		return "catalogo/tabulador_precios";
	}// lista_tabulador_precios
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista_por_pagina_por_parametros", method = RequestMethod.POST)
	@ResponseBody
	public String buscaTabuladorPreciosPorParametros(
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_maquina", 		required = false) boolean busquedaPorMaquina,
			@RequestParam(value = "chkbx_busca_por_complejidad", 	required = false) boolean busquedaPorComplejidad,
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "id_tipo_complejidad", 			required = false) Integer idTipoComplejidad
		) {
		
		ParametrosBusquedaTabuladorPrecios parametros = new ParametrosBusquedaTabuladorPrecios();
		parametros.setBusquedaPorMaquina(busquedaPorMaquina);
		parametros.setBusquedaPorComplejidad(busquedaPorComplejidad);
		parametros.setIdMaquina(idMaquina);
		parametros.setIdTipoComplejidad(idTipoComplejidad);
		
		// numero total de registros // BUSQUEDA DEFAULT
		int numeroTotalRegistros = tabuladorPreciosService.numeroRegistrosPorCriterioBusqueda( parametros );
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TabuladorPreciosDTO> listaTabuladorPrecios = tabuladorPreciosService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);

		StringBuilder sb = new StringBuilder();
		Gson gson = new Gson();
		
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaTabuladorPrecios\":");
		sb.append(gson.toJson(listaTabuladorPrecios));
		sb.append("}");
		
		listaTabuladorPrecios 	= null;
		gson 					= null;
		parametros 				= null;
		
		return sb.toString();
	}
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTabuladorPrecios(
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "nombre_insumo", 					required = false) String nombreInsumo,
			@RequestParam(value = "descripcion", 					required = false) String descripcion,
			@RequestParam(value = "inicio_tabulador", 				required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 					required = false) Integer finTabulador,
			@RequestParam(value = "id_tipo_complejidad", 			required = false) Integer idTipoComplejidad,
			@RequestParam(value = "precio",							required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 				required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_tabulador_precios");

		TabuladorPrecios tabuladorPrecios = new TabuladorPrecios();
			Maquina maquina = new Maquina();
			maquina.setIdMaquina(idMaquina);
		tabuladorPrecios.setMaquina(maquina);
		tabuladorPrecios.setNombreInsumo(nombreInsumo);
		tabuladorPrecios.setDescripcion(descripcion);
		tabuladorPrecios.setInicioTabulador(inicioTabulador);
		tabuladorPrecios.setFinTabulador(finTabulador);
			TipoComplejidad tipoComplejidad = new TipoComplejidad();
			tipoComplejidad.setIdTipoComplejidad(idTipoComplejidad);
		tabuladorPrecios.setTipoComplejidad(tipoComplejidad);
		tabuladorPrecios.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tabuladorPrecios.setTipoPrecio(tipoPrecio);
		tabuladorPrecios.setActivo(true);

		tabuladorPreciosService.creaTabuladorPrecios(tabuladorPrecios);
		
		maquina 				= null;
		tipoComplejidad			= null;
		tipoPrecio 				= null;
		tabuladorPrecios 		= null;
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina 			= null;
		
		List<ComboSelect> listaTipoComplejidad = tipoComplejidadService.listaComboSelect();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		listaTipoComplejidad	= null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio 		= null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// parametros de busqueda
		ParametrosBusquedaTabuladorPrecios parametros = new ParametrosBusquedaTabuladorPrecios();
		parametros.setBusquedaPorMaquina(false);
		parametros.setBusquedaPorComplejidad(false);
		parametros.setIdMaquina(0);
		parametros.setIdTipoComplejidad(0);
		
		// numero total de registros // BUSQUEDA DEFAULT
		int numeroTotalRegistros = tabuladorPreciosService.numeroRegistrosPorCriterioBusqueda( parametros );
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TabuladorPreciosDTO> listaTabuladorPrecios = tabuladorPreciosService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		listaTabuladorPrecios 	= null;
		
		parametros = null;
		
		return "catalogo/tabulador_precios";

	}// alta_tabulador_precios

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	@ResponseBody
	public void modificaTabuladorPrecios(
			@RequestParam(value = "id_tabulador_precios", 			required = false) Integer idTabuladorPrecios,
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "nombre_insumo", 					required = false) String nombreInsumo,
			@RequestParam(value = "descripcion", 					required = false) String descripcion,
			@RequestParam(value = "inicio_tabulador", 				required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 					required = false) Integer finTabulador,
			@RequestParam(value = "id_tipo_complejidad", 			required = false) Integer idTipoComplejidad,
			@RequestParam(value = "precio",							required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 				required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tabulador_precios");
		TabuladorPrecios tabuladorPrecios = tabuladorPreciosService.buscaTabuladorPrecios(idTabuladorPrecios);
		tabuladorPrecios.getMaquina().setIdMaquina(idMaquina);
		tabuladorPrecios.setNombreInsumo(nombreInsumo);
		tabuladorPrecios.setDescripcion(descripcion);
		tabuladorPrecios.setInicioTabulador(inicioTabulador);
		tabuladorPrecios.setFinTabulador(finTabulador);
		tabuladorPrecios.getTipoComplejidad().setIdTipoComplejidad(idTipoComplejidad);
		tabuladorPrecios.setPrecio(precio);
		tabuladorPrecios.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		tabuladorPreciosService.modificaTabuladorPrecios(tabuladorPrecios);
		tabuladorPrecios 		= null;
	}// modifica_tabulador_precios

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	@ResponseBody
	public void eliminaTabuladorPrecios(
			@RequestParam(value = "id_tabulador_precios", required = false) Integer idTabuladorPrecios,
			Model model
		) throws IOException {
		log.info("/elimina_tabulador_precios");
		TabuladorPrecios tabuladorPrecios = tabuladorPreciosService.buscaTabuladorPrecios(idTabuladorPrecios);
		tabuladorPrecios.setActivo(false);
		tabuladorPreciosService.modificaTabuladorPrecios(tabuladorPrecios);
		tabuladorPrecios = null;
	}// elimina_tabulador_precios
	
}
