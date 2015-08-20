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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tabulador_precios")
public class TabuladorPreciosController {

	private static final Logger log = Logger.getLogger(TabuladorPreciosController.class);
	
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTabuladorPrecios( Locale locale, Model model ) throws IOException {
		log.info("/lista_tabulador_precios");

		List<TabuladorPrecios> listaTabuladorPrecios = tabuladorPreciosService.listaTabuladorPrecios();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTabuladorPrecios = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tabulador_precios";
	}// lista_tabulador_precios

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTabuladorPrecios(
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "nombre_insumo", 					required = false) String nombreInsumo,
			@RequestParam(value = "descripcion", 					required = false) String descripcion,
			@RequestParam(value = "inicio_tabulador", 				required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 					required = false) Integer finTabulador,
			@RequestParam(value = "precio_complejidad_sencilla",	required = false) float precioComplejidadSencilla,
			@RequestParam(value = "precio_complejidad_regular",		required = false) float precioComplejidadRegular,
			@RequestParam(value = "precio_complejidad_dificil",		required = false) float precioComplejidadDificil,
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
		tabuladorPrecios.setPrecioComplejidadSencilla(precioComplejidadSencilla);
		tabuladorPrecios.setPrecioComplejidadRegular(precioComplejidadRegular);
		tabuladorPrecios.setPrecioComplejidadDificil(precioComplejidadDificil);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tabuladorPrecios.setTipoPrecio(tipoPrecio);
		tabuladorPrecios.setActivo(true);

		tabuladorPreciosService.creaTabuladorPrecios(tabuladorPrecios);

		List<TabuladorPrecios> listaTabuladorPrecios = tabuladorPreciosService.listaTabuladorPrecios();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tabuladorPrecios = null;
		maquina = null;
		tipoPrecio = null;
		listaTabuladorPrecios = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tabulador_precios";
	}// alta_tabulador_precios

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTabuladorPrecios(
			@RequestParam(value = "id_tabulador_precios", 			required = false) Integer idTabuladorPrecios,
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "nombre_insumo", 					required = false) String nombreInsumo,
			@RequestParam(value = "descripcion", 					required = false) String descripcion,
			@RequestParam(value = "inicio_tabulador", 				required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 					required = false) Integer finTabulador,
			@RequestParam(value = "precio_complejidad_sencilla",	required = false) float precioComplejidadSencilla,
			@RequestParam(value = "precio_complejidad_regular",		required = false) float precioComplejidadRegular,
			@RequestParam(value = "precio_complejidad_dificil",		required = false) float precioComplejidadDificil,
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
		tabuladorPrecios.setPrecioComplejidadSencilla(precioComplejidadSencilla);
		tabuladorPrecios.setPrecioComplejidadRegular(precioComplejidadRegular);
		tabuladorPrecios.setPrecioComplejidadDificil(precioComplejidadDificil);
		tabuladorPrecios.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		
		tabuladorPreciosService.modificaTabuladorPrecios(tabuladorPrecios);

		List<TabuladorPrecios> listaTabuladorPrecios = tabuladorPreciosService.listaTabuladorPrecios();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tabuladorPrecios = null;
		listaTabuladorPrecios = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tabulador_precios";
	}// modifica_tabulador_precios

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTabuladorPrecios(
			@RequestParam(value = "id_tabulador_precios", required = false) Integer idTabuladorPrecios,
			Model model
		) throws IOException {
		log.info("/elimina_tabulador_precios");
		
		TabuladorPrecios tabuladorPrecios = tabuladorPreciosService.buscaTabuladorPrecios(idTabuladorPrecios);
		tabuladorPrecios.setActivo(false);

		tabuladorPreciosService.modificaTabuladorPrecios(tabuladorPrecios);

		List<TabuladorPrecios> listaTabuladorPrecios = tabuladorPreciosService.listaTabuladorPrecios();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTabuladorPrecios", listaTabuladorPrecios);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTabuladorPrecios = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tabulador_precios";
	}// elimina_tabulador_precios
	
}
