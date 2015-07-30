package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Offset;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;

@Controller
@RequestMapping("/partida")
public class PartidaController {
	
	private static final Logger log = Logger.getLogger(PartidaController.class);
	
	@Resource
	private PartidaService partidaService;
	@Resource
	private DisenioService disenioService;
	@Resource
	private PreprensaService preprensaService;
	@Resource
	private TransporteService transporteService;
	@Resource
	private AcabadoService acabadoService;
	@Resource
	private OffsetService offsetService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaPartida( HttpServletRequest request ) {
		log.info("/agrega_partida");
		
		Timestamp fechaGeneracion = new Timestamp(Calendar.getInstance().getTimeInMillis());

		JsonResponse jsonResponse = new JsonResponse();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());
			uploader.setSizeMax(104857600); // 1024 * 1024 * 100 = 100MB
			Partida partida = new Partida();
			try {
				List<FileItem> fileItemsList = uploader.parseRequest(request);
				Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
				while (fileItemsIterator.hasNext()) {
					FileItem item = fileItemsIterator.next();
					if (item.isFormField()) {
						if ("id_orden_produccion".equals(item.getFieldName())) {
							OrdenProduccion ordenProduccion = new OrdenProduccion();
							ordenProduccion.setIdOrdenProduccion(Integer.valueOf(item.getString()));
							partida.setOrdenProduccion(ordenProduccion);
						}
						if ("id_tipo_trabajo".equals(item.getFieldName())) {
							TipoTrabajo tipoTrabajo = new TipoTrabajo();
							tipoTrabajo.setIdTipoTrabajo(Integer.valueOf(item.getString()));
							partida.setTipoTrabajo(tipoTrabajo);
						}
						if ("nombre_partida".equals(item.getFieldName()))
							partida.setNombrePartida(item.getString());
						if ("cantidad".equals(item.getFieldName()))
							partida.setCantidad(Integer.valueOf(item.getString()));
						if ("id_tipo_forma_trabajo".equals(item.getFieldName())) {
							TipoFormaTrabajo tipoFormaTrabajo = new TipoFormaTrabajo();
							tipoFormaTrabajo.setIdTipoFormaTrabajo(Integer.valueOf(item.getString()));
							partida.setTipoFormaTrabajo(tipoFormaTrabajo);
						}
						if ("descripcion_partida".equals(item.getFieldName()))
							partida.setDescripcionPartida(item.getString());
						if ("observaciones_generales".equals(item.getFieldName()))
							partida.setObservacionesGenerales(item.getString());
						if ("observaciones_aprobacion".equals(item.getFieldName()))
							partida.setObservacionesAprobacion(item.getString());
					} else {
						if ("diagrama_formacion".equals(item.getFieldName())) {
							if (item.getSize() > 0)
								partida.setDiagramaFormacion(item.get());
							else
								partida.setDiagramaFormacion(null);
						}
					}
				}
				partida.setFechaGeneracion(fechaGeneracion);
				partida.setActivo(true);

				// insert a la base de datos
				int idPartida = partidaService.creaPartida(partida);
				
				// crea los registros en blanco de: disenio, preprensa, transporte, acabado y offset
				// que más adelante pueden ser modificados.
				partida.setIdPartida(idPartida);
				
				Disenio disenio = new Disenio();
				disenio.setPartida(partida);
				disenio.setFechaGeneracion(fechaGeneracion);
				disenio.setActivo(true);
				int idDisenio = disenioService.creaDisenio(disenio);
				
				Preprensa preprensa = new Preprensa();
				preprensa.setPartida(partida);
				preprensa.setFechaGeneracion(fechaGeneracion);
				preprensa.setActivo(true);
				int idPreprensa = preprensaService.creaPreprensa(preprensa);
				
				Transporte transporte = new Transporte();
				transporte.setPartida(partida);
				transporte.setFechaGeneracion(fechaGeneracion);
				transporte.setActivo(true);
				int idTransporte = transporteService.creaTransporte(transporte);
				
				Acabado acabado = new Acabado();
				acabado.setPartida(partida);
				acabado.setFechaGeneracion(fechaGeneracion);
				acabado.setActivo(true);
				int idAcabado = acabadoService.creaAcabado(acabado);
				
				Offset offset = new Offset();
				offset.setPartida(partida);
				offset.setFechaGeneracion(fechaGeneracion);
				offset.setActivo(true);
				int idOffset = offsetService.creaOffset(offset);

				jsonResponse.setEstatusOperacion(idPartida);
				jsonResponse.setIdPartida(idPartida);
				jsonResponse.setIdDisenio(idDisenio);
				jsonResponse.setIdPreprensa(idPreprensa);
				jsonResponse.setIdTransporte(idTransporte);
				jsonResponse.setIdAcabado(idAcabado);
				jsonResponse.setIdOffset(idOffset);

			} catch (FileUploadException e1) {
				e1.printStackTrace();
				jsonResponse.setEstatusOperacion(0);
			} catch (Exception e2) {
				e2.printStackTrace();
				jsonResponse.setEstatusOperacion(0);
			}
			partida = null;
		} else {
			jsonResponse.setEstatusOperacion(0);
		}

		fechaGeneracion = null;
		
		return jsonResponse;
	} // agregaPartida
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse buscaPartida(
			@RequestParam(value = "id_orden_produccion", required = false) Integer idOrdenProduccion
		) {
		log.info("/busca_partida");
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setTextoHTML(partidaService.buscaHTML(idOrdenProduccion));

		return jsonResponse;
	} // buscaPartida
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaPartida(
			@RequestParam(value = "id_orden_produccion", 		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_partida", 				required = false) Integer idPartida,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "id_tipo_forma_trabajo", 		required = false) Integer idTipoFormaTrabajo,
			@RequestParam(value = "descripcion_partida", 		required = false) String descripcionPartida,
			@RequestParam(value = "observaciones_generales", 	required = false) String observacionesGenerales,
			@RequestParam(value = "observaciones_aprobacion",	required = false) String observacionesAprobacion
		) {
		log.info("/actualiza_partida");
		
		Partida partida = partidaService.buscaPartida(idPartida);
		partida.setCantidad(cantidad);
		partida.getTipoFormaTrabajo().setIdTipoFormaTrabajo(idTipoFormaTrabajo);
		partida.setDescripcionPartida(descripcionPartida);
		partida.setObservacionesGenerales(observacionesGenerales);
		partida.setObservacionesAprobacion(observacionesAprobacion);
		
		partidaService.actualizaPartida(partida); // aqui tmb actualiza hojas_papel_requeridas
		
		partida = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		calificacionService.actualizaPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( (float)calificacionOrdenProduccion.getPrecioNeto() );
		
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaPartida

}
