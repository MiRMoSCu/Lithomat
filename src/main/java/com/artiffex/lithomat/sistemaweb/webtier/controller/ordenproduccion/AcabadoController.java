package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;

@Controller
@RequestMapping("/acabado")
public class AcabadoController {
	
	private static final Logger log = Logger.getLogger(AcabadoController.class);
	
	@Resource
	private AcabadoService acabadoService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse modificaAcabado(
			@RequestParam(value = "id_acabado", 				required = false) Integer idAcabado,
			@RequestParam(value = "indicacion_tarea_realizar", 	required = false) String indicacionTareaRealizar,
			@RequestParam(value = "materiales_recibe", 			required = false) String materialesRecibe,
			@RequestParam(value = "observaciones", 				required = false) String observaciones
		) {
		log.info("/modifica_acabado");

		Acabado acabado = acabadoService.buscaAcabado(idAcabado);
		acabado.setIndicacionTareaRealizar(indicacionTareaRealizar);
		acabado.setMaterialesRecibe(materialesRecibe);
		acabado.setObservaciones(observaciones);

		acabadoService.modificaAcabado(acabado);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setIdAcabado(idAcabado);

		acabado = null;
		
		return jsonResponse;
	} // modificaAcabado
	
}
