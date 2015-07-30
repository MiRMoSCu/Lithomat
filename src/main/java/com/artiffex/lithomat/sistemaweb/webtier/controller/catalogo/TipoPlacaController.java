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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPlacaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tipo_placa")
public class TipoPlacaController {
	
	private static final Logger log = Logger.getLogger(TipoPlacaController.class);
	
	@Resource
	private TipoPlacaService tipoPlacaService;
	@Resource
	private TipoPrecioService tipoPrecioService;
	@Resource
	private MaquinaService maquinaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoPlaca( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_placa");

		List<TipoPlaca> listaTipoPlaca = tipoPlacaService.listaTipoPlaca();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPlaca", listaTipoPlaca);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPlaca = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_placa";
	}// lista_tipo_placa

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoPlaca(
			@RequestParam(value = "id_maquina", 	required = false) Integer idMaquina,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/lista_tipo_placa");

		TipoPlaca tipoPlaca = new TipoPlaca();
			Maquina maquina = new Maquina();
			maquina.setIdMaquina(idMaquina);
		tipoPlaca.setMaquina(maquina);
		tipoPlaca.setDescripcion(descripcion);
		tipoPlaca.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tipoPlaca.setTipoPrecio(tipoPrecio);
		tipoPlaca.setActivo(true);

		tipoPlacaService.creaTipoPlaca(tipoPlaca);

		List<TipoPlaca> listaTipoPlaca = tipoPlacaService.listaTipoPlaca();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPlaca", listaTipoPlaca);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPlaca = null;
		maquina = null;
		tipoPrecio = null;
		listaTipoPlaca = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_placa";
	}// alta_tipo_placa

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoPlaca(
			@RequestParam(value = "id_tipo_placa", 	required = false) Integer idTipoPlaca,
			@RequestParam(value = "id_maquina", 	required = false) Integer idMaquina,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/lista_tipo_placa");

		TipoPlaca tipoPlaca = tipoPlacaService.buscaTipoPlaca(idTipoPlaca);
		tipoPlaca.getMaquina().setIdMaquina(idMaquina);
		tipoPlaca.setDescripcion(descripcion);
		tipoPlaca.setPrecio(precio);
		tipoPlaca.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		
		tipoPlacaService.modificaTipoPlaca(tipoPlaca);

		List<TipoPlaca> listaTipoPlaca = tipoPlacaService.listaTipoPlaca();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPlaca", listaTipoPlaca);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPlaca = null;
		listaTipoPlaca = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_placa";
	}// modifica_tipo_placa

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoPlaca(
			@RequestParam(value = "id_tipo_placa", required = false) Integer idTipoPlaca,
			Model model
		) throws IOException {
		log.info("/lista_tipo_placa");
		
		TipoPlaca tipoPlaca = tipoPlacaService.buscaTipoPlaca(idTipoPlaca);
		tipoPlaca.setActivo(false);

		tipoPlacaService.modificaTipoPlaca(tipoPlaca);

		List<TipoPlaca> listaTipoPlaca = tipoPlacaService.listaTipoPlaca();
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPlaca", listaTipoPlaca);
		model.addAttribute("listaMaquina", listaMaquina);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPlaca = null;
		listaTipoPlaca = null;
		listaMaquina = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_placa";
	}// elimina_tipo_placa
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse buscaTipoPlaca(
			@RequestParam(value = "id_maquina", required = false) Integer idMaquina
		) {
		log.info("/busca_tipo_placa");
		
		// aqui se busca el tipo de placa que corresponde con la maquina
		// seleccionada en formato JSON.
		// "[{\"id_tipo_placa\":1, \"descripcion\":\"ABC\"},{\"id_tipo_placa\":2, \"descripcion\":\"DEF\"}, {...}]"
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setTextoJson(tipoPlacaService.jsonListaTipoPlaca(idMaquina));
		
		return jsonResponse;
	} // buscaTipoPlaca
	
}
