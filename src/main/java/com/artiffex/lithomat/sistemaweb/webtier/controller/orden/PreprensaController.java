package com.artiffex.lithomat.sistemaweb.webtier.controller.orden;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;

@Controller
@RequestMapping("/preprensa")
public class PreprensaController {
	
	private static final Logger log = Logger.getLogger(PreprensaController.class);
	
	@Resource
	private PreprensaService preprensaService;
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse modificaPreprensa(
			@RequestParam(value = "id_preprensa", 				required = false) Integer idPreprensa,
			@RequestParam(value = "indicacion_tarea_realizar", 	required = false) String indicacionTareaRealizar,
			@RequestParam(value = "materiales_recibe", 			required = false) String materialesRecibe,
			@RequestParam(value = "observaciones", 				required = false) String observaciones
		) {
		log.info("/modifica_preprensa");

		Preprensa preprensa = preprensaService.buscaPreprensa(idPreprensa);
		preprensa.setIndicacionTareaRealizar(indicacionTareaRealizar);
		preprensa.setMaterialesRecibe(materialesRecibe);
		preprensa.setObservaciones(observaciones);

		preprensaService.modificaPreprensa(preprensa);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setIdPreprensa(idPreprensa);

		preprensa 	= null;
		
		return jsonResponse;
	} // modificaPreprensa
	
}
