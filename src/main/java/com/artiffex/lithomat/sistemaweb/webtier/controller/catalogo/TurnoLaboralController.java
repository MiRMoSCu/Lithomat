package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TurnoLaboralService;

@Controller
@RequestMapping("/turno_laboral")
public class TurnoLaboralController {
	
	private static final Logger log = Logger.getLogger(TipoVueltaController.class);
	
	@Resource
	private TurnoLaboralService turnoLaboralService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTurnoLaboral( Locale locale, Model model ) throws IOException {
		log.info("/lista_turno_laboral");

		List<TurnoLaboral> listaTurnoLaboral = turnoLaboralService.listaTurnoLaboral();
		model.addAttribute("listaTurnoLaboral", listaTurnoLaboral);

		listaTurnoLaboral = null;
		
		return "catalogo/turno_laboral";
	}// lista_turno_laboral

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTurnoLaboral(
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "hora_inicio", 	required = false) String horaInicio,
			@RequestParam(value = "hora_fin", 		required = false) String horaFin,
			Model model
		) throws IOException {
		log.info("/alta_turno_laboral");

		String horaTimestampInicio = "1970-01-01 " + horaInicio;
		String horaTimestampFin = "1970-01-01 " + horaFin;

		TurnoLaboral turnoLaboral = new TurnoLaboral();
		turnoLaboral.setDescripcion(descripcion);
		turnoLaboral.setHoraInicio( new Time( Timestamp.valueOf(horaTimestampInicio).getTime() ) );
		turnoLaboral.setHoraFin( new Time( Timestamp.valueOf(horaTimestampFin).getTime() ) );
		turnoLaboral.setActivo(true);

		turnoLaboralService.creaTurnoLaboral(turnoLaboral);

		List<TurnoLaboral> listaTurnoLaboral = turnoLaboralService.listaTurnoLaboral();
		model.addAttribute("listaTurnoLaboral", listaTurnoLaboral);

		turnoLaboral = null;
		listaTurnoLaboral = null;
		
		return "catalogo/turno_laboral";
	}// alta_turno_laboral

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTurnoLaboral(
			@RequestParam(value = "id_turno_laboral", 	required = false) Integer idTurnoLaboral,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "hora_inicio", 		required = false) String horaInicio,
			@RequestParam(value = "hora_fin", 			required = false) String horaFin,
			Model model
		) throws IOException {
		log.info("/modifica_turno_laboral");

		String horaTimestampInicio = "1970-01-01 " + horaInicio;
		String horaTimestampFin = "1970-01-01 " + horaFin;

		TurnoLaboral turnoLaboral = turnoLaboralService.busca(idTurnoLaboral);
		turnoLaboral.setDescripcion(descripcion);
		turnoLaboral.setHoraInicio( new Time( Timestamp.valueOf(horaTimestampInicio).getTime() ) );
		turnoLaboral.setHoraFin( new Time( Timestamp.valueOf(horaTimestampFin).getTime() ) );

		turnoLaboralService.modificaTurnoLaboral(turnoLaboral);

		List<TurnoLaboral> listaTurnoLaboral = turnoLaboralService.listaTurnoLaboral();
		model.addAttribute("listaTurnoLaboral", listaTurnoLaboral);

		turnoLaboral = null;
		listaTurnoLaboral = null;
		
		return "catalogo/turno_laboral";
	}// modifica_turno_laboral

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTurnoLaboral(
			@RequestParam(value = "id_turno_laboral", required = false) Integer idTurnoLaboral,
			Model model
		) throws IOException {
		log.info("/elimina_turno_laboral");
		
		TurnoLaboral turnoLaboral = turnoLaboralService.busca(idTurnoLaboral);
		turnoLaboral.setActivo(false);

		turnoLaboralService.modificaTurnoLaboral(turnoLaboral);

		List<TurnoLaboral> listaTurnoLaboral = turnoLaboralService.listaTurnoLaboral();
		model.addAttribute("listaTurnoLaboral", listaTurnoLaboral);

		listaTurnoLaboral = null;
		
		return "catalogo/turno_laboral";
	}// elimina_turno_laboral
	
}