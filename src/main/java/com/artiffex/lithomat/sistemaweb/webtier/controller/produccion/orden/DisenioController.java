package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.orden;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;

@Controller
@RequestMapping("/disenio")
public class DisenioController {
	
	private static final Logger log = Logger.getLogger(DisenioController.class);
	
	@Resource
	private DisenioService disenioService;
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse modificaDisenio(
			@RequestParam(value = "id_disenio", 				required = false) Integer idDisenio,
			@RequestParam(value = "indicacion_tarea_realizar", 	required = false) String indicacionTareaRealizar,
			@RequestParam(value = "materiales_recibe", 			required = false) String materialesRecibe,
			@RequestParam(value = "observaciones", 				required = false) String observaciones
		) {
		log.info("/modifica_disenio");
		
		Disenio disenio = disenioService.buscaDisenio(idDisenio);
		disenio.setIndicacionTareaRealizar(indicacionTareaRealizar);
		disenio.setMaterialesRecibe(materialesRecibe);
		disenio.setObservaciones(observaciones);
		
		disenioService.modificaDisenio(disenio);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setIdDisenio(idDisenio);

		disenio = null;
		
		return jsonResponse;
	} // modificaDisenio
	
}
