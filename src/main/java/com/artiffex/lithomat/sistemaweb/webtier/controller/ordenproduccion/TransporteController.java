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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;

@Controller
@RequestMapping("/transporte")
public class TransporteController {
	
	private static final Logger log = Logger.getLogger(TransporteController.class);
	
	@Resource
	private TransporteService transporteService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse modificaTransporte(
			@RequestParam(value = "id_transporte", 				required = false) Integer idTransporte,
			@RequestParam(value = "indicacion_tarea_realizar", 	required = false) String indicacionTareaRealizar,
			@RequestParam(value = "materiales_recibe", 			required = false) String materialesRecibe,
			@RequestParam(value = "observaciones", 				required = false) String observaciones
		) {
		log.info("/modifica_transporte");

		Transporte transporte = transporteService.buscaTransporte(idTransporte);
		transporte.setIndicacionTareaRealizar(indicacionTareaRealizar);
		transporte.setMaterialesRecibe(materialesRecibe);
		transporte.setObservaciones(observaciones);

		transporteService.modificaTransporte(transporte);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setIdTransporte(idTransporte);

		transporte 	= null;
		
		return jsonResponse;
	} // modificaTransporte

}
