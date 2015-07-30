package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Offset;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;

@Controller
@RequestMapping("/offset")
public class OffsetController {
	
	private static final Logger log = Logger.getLogger(OffsetController.class);
	
	@Resource
	private OffsetService offsetService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse modificaOffset(
			@RequestParam(value = "id_offset", 					required = false) Integer idOffset,
			@RequestParam(value = "indicacion_tarea_realizar", 	required = false) String indicacionTareaRealizar,
			@RequestParam(value = "materiales_recibe", 			required = false) String materialesRecibe,
			@RequestParam(value = "observaciones", 				required = false) String observaciones
		) {
		log.info("/modifica_offset");

		Offset offset = offsetService.buscaOffset(idOffset);
		offset.setIndicacionTareaRealizar(indicacionTareaRealizar);
		offset.setMaterialesRecibe(materialesRecibe);
		offset.setObservaciones(observaciones);

		offsetService.modificaOffset(offset);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);

		offset 	= null;
		
		return jsonResponse;
	} // modificaOffset
	
}
