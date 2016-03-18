package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.orden;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoDisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoPreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoTransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComplejidadService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComprobanteFiscalService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoFormaTrabajoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.google.gson.Gson;

@Controller
@RequestMapping("/orden_produccion")
public class OrdenProduccionController {
	
	private static final Logger log = Logger.getLogger(OrdenProduccionController.class);
	
	
	@Resource
	private UsuarioService usuarioService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private TipoComprobanteFiscalService tipoComprobanteFiscalService;
	@Resource
	private TipoFormaTrabajoService tipoFormaTrabajoService;
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TipoComplejidadService tipoComplejidadService;
	@Resource
	private CostoExtraService costoExtraService;
	@Resource
	private ProcesoDisenioService procesoDisenioService;
	@Resource
	private ProcesoPreprensaService procesoPreprensaService;
	@Resource
	private ProcesoTransporteService procesoTransporteService;
	@Resource
	private ProcesoExternoService procesoExternoService;
	@Resource
	private MaterialAyudaService materialAyudaService;
	@Resource
	private ResponsableInsumoService responsableInsumoService;
	@Resource
	private CalificacionService calificacionService;
	@Resource
	private EstatusOrdenService estatusOrdenService;
	@Resource
	private HistorialEstatusService historialEstatusService;
	@Resource
	private TipoPrecioService tipoPrecioService;
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String ordenProduccion(Locale locale, Model model) {
		log.info("/orden_produccion");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String strUsuario = principal.toString();
		if ( principal instanceof UserDetails ) {
			strUsuario = ((UserDetails)principal).getUsername();
		}
		principal = null;
		
		Usuario user = usuarioService.buscaUsuario(strUsuario);
		model.addAttribute("idUsuario",user.getIdUsuario());
		user = null;
		principal = null;

		List<ComboSelect> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		listaTipoComprobanteFiscal = null;

		List<ComboSelect> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaComboSelect();
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);
		listaTipoFormaTrabajo = null;

		List<ComboSelect> listaTamanioPublicacion = tamanioPublicacionService.listaComboSelect();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);
		listaTamanioPublicacion = null;

		List<ComboSelect> listaCombinacionTintas = combinacionTintasService.listaComboSelect();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;

		List<ComboSelect> listaTipoBarniz = tipoBarnizService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		listaTipoBarniz = null;

		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		List<ComboSelect> listaTipoComplejidad = tipoComplejidadService.listaComboSelect();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		listaTipoComplejidad = null;
		
		Gson gson = new Gson();
		
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		model.addAttribute("listaCostoExtra",listaCostoExtra);
		if( listaCostoExtra.size() > 0 ) {
			ComboSelect cs = listaCostoExtra.get(0);
			CostoExtra costoExtra = costoExtraService.buscaCostoExtra(cs.getValue());
			model.addAttribute("nombre_unidad_medida",costoExtra.getTipoPrecio().getNombre());
			costoExtra 	= null;
			cs 				= null;
		}
		String jsonListaCostosExtra = gson.toJson(listaCostoExtra);
		model.addAttribute("jsonListaCostosExtra", jsonListaCostosExtra);
		listaCostoExtra = null;
		
		int[] arregloTipoPrecio = {4};
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect(arregloTipoPrecio);
		model.addAttribute("listaTipoPrecio",listaTipoPrecio);
		listaTipoPrecio = null;

		List<ComboSelect> listaProcesoDisenio = procesoDisenioService.listaComboSelect();
		model.addAttribute("listaProcesoDisenio", listaProcesoDisenio);
		String jsonListaProcesoDisenio = gson.toJson(listaProcesoDisenio);
		model.addAttribute("jsonListaProcesoDisenio",jsonListaProcesoDisenio);
		listaProcesoDisenio = null;

		List<ComboSelect> listaProcesoPreprensa = procesoPreprensaService.listaComboSelect();
		model.addAttribute("listaProcesoPreprensa", listaProcesoPreprensa);
		String jsonListaProcesoPreprensa = gson.toJson(listaProcesoPreprensa);
		model.addAttribute("jsonListaProcesoPreprensa",jsonListaProcesoPreprensa);
		listaProcesoPreprensa = null;

		List<ComboSelect> listaProcesoTransporte = procesoTransporteService.listaComboSelect();
		model.addAttribute("listaProcesoTransporte", listaProcesoTransporte);
		String jsonListaProcesoTransporte = gson.toJson(listaProcesoTransporte);
		model.addAttribute("jsonListaProcesoTransporte",jsonListaProcesoTransporte);
		listaProcesoTransporte = null;

		List<ComboSelect> listaProcesoExterno = procesoExternoService.listaComboSelect();
		model.addAttribute("listaProcesoExterno", listaProcesoExterno);
		String jsonListaProcesoExterno = gson.toJson(listaProcesoExterno);
		model.addAttribute("jsonListaProcesoExterno",jsonListaProcesoExterno);
		listaProcesoExterno = null;

		List<ComboSelect> listaMaterialAyuda = materialAyudaService.listaComboSelect();
		model.addAttribute("listaMaterialAyuda", listaMaterialAyuda);
		String jsonListaMaterialAyuda = gson.toJson(listaMaterialAyuda);
		model.addAttribute("jsonListaMaterialAyuda",jsonListaMaterialAyuda);
		listaMaterialAyuda = null;

		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);
		listaResponsableInsumo = null;

		gson = null;

		return "produccion/orden/orden_produccion";
	} // ordenProduccion
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaOrdenProduccion(
			@RequestParam(value = "id_usuario", 				required = false) Integer idUsuario,
			@RequestParam(value = "id_cliente", 				required = false) Integer idCliente,
			@RequestParam(value = "id_tipo_comprobante_fiscal", required = false) Integer idTipoComprobanteFiscal,
			@RequestParam(value = "nombre", 					required = false) String nombre,
			@RequestParam(value = "descripcion", 				required = false) String descripcion,
			@RequestParam(value = "fecha_prometida_entrega", 	required = false) String fechaPrometidaEntrega
		) {
		log.info("/agrega_orden_produccion");
		
		Timestamp fechaGeneracion = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		OrdenProduccion ordenProduccion = new OrdenProduccion();
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(idUsuario);
		ordenProduccion.setUsuario(usuario);
			Cliente cliente = new Cliente();
			cliente.setIdCliente(idCliente);
		ordenProduccion.setCliente(cliente);
			TipoComprobanteFiscal tipoComprobanteFiscal = new TipoComprobanteFiscal();
			tipoComprobanteFiscal.setIdTipoComprobanteFiscal(idTipoComprobanteFiscal);
		ordenProduccion.setTipoComprobanteFiscal(tipoComprobanteFiscal);
		ordenProduccion.setNut(ordenProduccionService.generaNut(fechaGeneracion));
		ordenProduccion.setNombre(nombre);
		ordenProduccion.setDescripcion(descripcion);
		ordenProduccion.setFechaCotizacion(fechaGeneracion);
		ordenProduccion.setFechaPrometidaEntrega(Timestamp.valueOf(fechaPrometidaEntrega + " 00:00:00"));
		ordenProduccion.setFechaGeneracion(fechaGeneracion);
		ordenProduccion.setActivo(false);

		int idOrdenProduccion = ordenProduccionService.creaOrdenProduccion(ordenProduccion);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idOrdenProduccion);
		jsonResponse.setIdOrdenProduccion(idOrdenProduccion);

		fechaGeneracion = null;
		usuario = null;
		cliente = null;
		ordenProduccion = null;
		
		return jsonResponse;
	} // agregaOrdenProduccion()
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaOrdenProduccion(
			@RequestParam(value = "id_orden_produccion",		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "nombre", 					required = false) String nombre,
			@RequestParam(value = "descripcion", 				required = false) String descripcion,
			@RequestParam(value = "id_tipo_comprobante_fiscal", required = false) Integer idTipoComprobanteFiscal
		) {
		log.info("/actualiza_orden_produccion");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		ordenProduccion.setNombre(nombre);
		ordenProduccion.setDescripcion(descripcion);
		ordenProduccion.getTipoComprobanteFiscal().setIdTipoComprobanteFiscal(idTipoComprobanteFiscal);
		ordenProduccionService.modificaOrdenProduccion(ordenProduccion);
		ordenProduccion = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		//actualilza el precio
		calificacionService.actualizaOrdenProduccion(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( (float)calificacionOrdenProduccion.getPrecioNeto() );
		
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaOrdenProduccion
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/cambia_estatus", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse cambiaEstatusOrdenProduccion(
			@RequestParam(value = "id_orden_produccion",	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_estatus_orden", 		required = false) Integer idEstatusOrden
		){
		log.info("/cambia_estatus_orden_produccion");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = principal.toString();
		if ( principal instanceof UserDetails ) {
			usuario = ((UserDetails)principal).getUsername();
		}
		
		HistorialEstatus historialEstatus = new HistorialEstatus();
			OrdenProduccion ordenProduccion = new OrdenProduccion();
			ordenProduccion.setIdOrdenProduccion(idOrdenProduccion);
		historialEstatus.setOrdenProduccion(ordenProduccion);
			EstatusOrden estatusOrden = new EstatusOrden();
			estatusOrden.setIdEstatusOrden(idEstatusOrden);
		historialEstatus.setEstatusOrden(estatusOrden);
		historialEstatus.setFecha(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		historialEstatus.setUsuario(usuario);
		historialEstatus.setObservaciones("");
		historialEstatus.setActivo(true);
		
		int resultado = historialEstatusService.creaHistorialEstatus(historialEstatus);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelectEstatusPosiblePorNut(ordenProduccion.getNut());
		jsonResponse.setTextoJson(new Gson().toJson(listaEstatusOrden));
		
		ordenProduccion 	= null;
		estatusOrden		= null;
		historialEstatus 	= null;
		listaEstatusOrden	= null;
		principal 			= null;
		
		return jsonResponse;
	} // cambiaEstatusOrdenProduccion
	
}
