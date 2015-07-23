package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyudaXPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaXPartidaService;

@Controller
@RequestMapping("/material_ayuda_x_partida")
public class MaterialAyudaXPartidaController {
	
	private static final Logger log = Logger.getLogger(MaterialAyudaXPartidaController.class);

	@Resource
	private MaterialAyudaXPartidaService materialAyudaXPartidaService;
	

	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaMaterialAyuda(
			@RequestParam(value = "id_partida", 			required = false) Integer idPartida,
			@RequestParam(value = "id_material_ayuda", 		required = false) Integer idMaterialAyuda,
			@RequestParam(value = "id_responsable_insumo", 	required = false) Integer idResponsableInsumo,
			@RequestParam(value = "observaciones", 			required = false) String observaciones
		) {
		log.info("/agrega_material_ayuda");

		MaterialAyudaXPartida materialAyudaXPartida = new MaterialAyudaXPartida();
			Partida partida = new Partida();
			partida.setIdPartida(idPartida);
		materialAyudaXPartida.setPartida(partida);
			MaterialAyuda materialAyuda = new MaterialAyuda();
			materialAyuda.setIdMaterialAyuda(idMaterialAyuda);
		materialAyudaXPartida.setMaterialAyuda(materialAyuda);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		materialAyudaXPartida.setResponsableInsumo(responsableInsumo);
		materialAyudaXPartida.setObservaciones(observaciones);
		materialAyudaXPartida.setActivo(true);

		int idMaterialAyudaXPartida = materialAyudaXPartidaService.creaMaterialAyudaXPartida(materialAyudaXPartida);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idMaterialAyudaXPartida);
		jsonResponse.setTextoHTML(materialAyudaXPartidaService.listaHTML(idPartida));

		materialAyudaXPartida = null;
		
		return jsonResponse;
	} // agregaMaterialAyuda
	
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaMaterialAyudaXPartidaOlvidado(
			@RequestParam(value = "id_partida", 				required = false) Integer idPartida,
			@RequestParam(value = "id_material_ayuda", 			required = false) Integer idMaterialAyuda,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "observaciones",				required = false) String observaciones
		) {
		log.info("/agrega_material_ayuda_x_partida_olvidado");
		
		System.out.println("\nentro a agregaMaterialAyudaOlvidado");
		
		MaterialAyudaXPartida materialAyudaXPartida = new MaterialAyudaXPartida();
			Partida partida = new Partida();
			partida.setIdPartida(idPartida);
		materialAyudaXPartida.setPartida(partida);
			MaterialAyuda materialAyuda = new MaterialAyuda();
			materialAyuda.setIdMaterialAyuda(idMaterialAyuda);
		materialAyudaXPartida.setMaterialAyuda(materialAyuda);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		materialAyudaXPartida.setResponsableInsumo(responsableInsumo);
		materialAyudaXPartida.setObservaciones(observaciones);
		materialAyudaXPartida.setActivo(true);
		
		int resultado = materialAyudaXPartidaService.creaMaterialAyudaXPartida(materialAyudaXPartida);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML(materialAyudaXPartidaService.listaHTMLModificacion(idPartida));
		}
		
		partida = null;
		materialAyuda = null;
		responsableInsumo = null;
		materialAyudaXPartida = null;
		
		return jsonResponse;
	} // agregaMaterialAyudaXPartidaOlvidado
	
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaMaterialAyudaXPartida(
			@RequestParam(value = "id_material_ayuda_x_partida",	required = false) Integer idMaterialAyudaXPartida,
			@RequestParam(value = "id_partida", 					required = false) Integer idPartida,
			@RequestParam(value = "id_material_ayuda", 				required = false) Integer idMaterialAyuda,
			@RequestParam(value = "id_responsable_insumo", 			required = false) Integer idResponsableInsumo,
			@RequestParam(value = "observaciones",					required = false) String observaciones
		) {
		log.info("/actualiza_material_ayuda_x_partida");
		
		MaterialAyudaXPartida materialAyudaXPartida = materialAyudaXPartidaService.buscaMaterialAyudaXPartida(idMaterialAyudaXPartida);
		materialAyudaXPartida.getMaterialAyuda().setIdMaterialAyuda(idMaterialAyuda);
		materialAyudaXPartida.getResponsableInsumo().setIdResponsableInsumo(idResponsableInsumo);
		materialAyudaXPartida.setObservaciones(observaciones);
		materialAyudaXPartidaService.modificaMaterialAyudaXPartida(materialAyudaXPartida);
		materialAyudaXPartida = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(materialAyudaXPartidaService.listaHTMLModificacion(idPartida));
		
		return jsonResponse;
	} // actualizaMaterialAyudaXPartida
	
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaMaterialAyudaXPartida(
			@RequestParam(value = "id_material_ayuda_x_partida",	required = false) Integer idMaterialAyudaXPartida,
			@RequestParam(value = "id_partida",						required = false) Integer idPartida
		) {
		log.info("/elimina_material_ayuda_x_partida");
		
		MaterialAyudaXPartida materialAyudaXPartida = materialAyudaXPartidaService.buscaMaterialAyudaXPartida(idMaterialAyudaXPartida);
		materialAyudaXPartida.setActivo(false);
		materialAyudaXPartidaService.modificaMaterialAyudaXPartida(materialAyudaXPartida);
		materialAyudaXPartida = null;

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(materialAyudaXPartidaService.listaHTMLModificacion(idPartida));
			
		return jsonResponse;
	} // eliminaMaterialAyudaXPartida
	
}
