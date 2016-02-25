package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoPapelExtendidoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorPapel;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorPapelService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTipoPapelExtendido;
import com.google.gson.Gson;

@Controller
@RequestMapping("/tipo_papel_extendido")
public class TipoPapelExtendidoController {
	
	private static final Logger log = Logger.getLogger(TipoPapelExtendidoController.class);
	
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	@Resource
	private ProveedorPapelService proveedorPapelService;
	@Resource
	private TipoPrecioService tipoPrecioService;
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana/lista", method = RequestMethod.GET)
	public String ventanaBusquedaPapelExtendido( Model model )  throws IOException {
		log.info("/ventana_busqueda_tipo_papel_extendido");
		
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		listaProveedorPapel = null;
		
		return "catalogo/tipo_papel_extendido_busqueda";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana/busca", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse buscaTipoPapelExtendido(
			@RequestParam(value = "chkbx_busca_por_nombre",		required = false) boolean busquedaPorNombre,
			@RequestParam(value = "chkbx_busca_por_ancho",		required = false) boolean busquedaPorAncho,
			@RequestParam(value = "chkbx_busca_por_alto", 		required = false) boolean busquedaPorAlto,
			@RequestParam(value = "chkbx_busca_por_gramaje", 	required = false) boolean busquedaPorGramaje,
			@RequestParam(value = "chkbx_busca_por_kilogramos",	required = false) boolean busquedaPorKilogramos,
			@RequestParam(value = "chkbx_busca_por_proveedor", 	required = false) boolean busquedaPorProveedor,
			@RequestParam(value = "nombre", 					required = false) String nombrePapel,
			@RequestParam(value = "ancho", 						required = false) Float ancho,
			@RequestParam(value = "alto", 						required = false) Float alto,
			@RequestParam(value = "gramaje", 					required = false) Integer gramaje,
			@RequestParam(value = "kilogramos", 				required = false) Float kilogramos,
			@RequestParam(value = "id_proveedor_papel", 		required = false) Integer idProveedorPapel
		) {
		log.info("entraste a ventana/busca");
		
		ParametrosBusquedaTipoPapelExtendido parametros = new ParametrosBusquedaTipoPapelExtendido();
		parametros.setBusquedaPorNombre(busquedaPorNombre);
		parametros.setBusquedaPorAncho(busquedaPorAncho);
		parametros.setBusquedaPorAlto(busquedaPorAlto);
		parametros.setBusquedaPorGramaje(busquedaPorGramaje);
		parametros.setBusquedaPorKilogramos(busquedaPorKilogramos);
		parametros.setBusquedaPorProveedor(busquedaPorProveedor);
		parametros.setNombrePapel(nombrePapel);
		parametros.setAncho(ancho);
		parametros.setAlto(alto);
		parametros.setGramaje(gramaje);
		parametros.setKilogramos(kilogramos);
		parametros.setIdProveedorPapel(idProveedorPapel);
		
		String html = tipoPapelExtendidoService.listaHTMLTipoPapelExtendidoPorConsulta(parametros);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setTextoHTML(html);
				
		parametros 	= null;
		html 		= null;
		
		return jsonResponse;
	}
	
	
	/* funciones utilizadas para el CATALOGO */
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoPapelExtendido( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_papel_extendido");
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		listaProveedorPapel = null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// numero total de registros
		int numeroTotalRegistros = tipoPapelExtendidoService.obtieneNumeroTipoPapelExtendidoPorParametros(false, false, false, false, false, false, null, null, null, null, null, null);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TipoPapelExtendido> listaTipoPapelExtendido = tipoPapelExtendidoService.listaTipoPapelExtendidoPorParametrosPorNumeroPagina(false, false, false, false, false, false, null, null, null, null, null, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		return "catalogo/tipo_papel_extendido";
	}// lista_tipo_papel_extendido
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/lista_por_pagina_por_parametros", method = RequestMethod.POST)
	@ResponseBody
	public String buscaTipoPapelExtendidoPorParametros(
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_nombre", 		required = false) boolean busquedaPorNombre,
			@RequestParam(value = "chkbx_busca_por_gramaje", 		required = false) boolean busquedaPorGramaje,
			@RequestParam(value = "chkbx_busca_por_kilogramos",		required = false) boolean busquedaPorKilogramos,
			@RequestParam(value = "chkbx_busca_por_ancho", 			required = false) boolean busquedaPorAncho,
			@RequestParam(value = "chkbx_busca_por_alto", 			required = false) boolean busquedaPorAlto,
			@RequestParam(value = "chkbx_busca_por_proveedor", 		required = false) boolean busquedaPorProveedor,
			@RequestParam(value = "nombre", 						required = false) String nombre,
			@RequestParam(value = "gramaje", 						required = false) Integer gramaje,
			@RequestParam(value = "kilogramos", 					required = false) Float kilogramos,
			@RequestParam(value = "ancho", 							required = false) Float ancho,
			@RequestParam(value = "alto", 							required = false) Float alto,
			@RequestParam(value = "id_proveedor_papel", 			required = false) Integer idProveedorPapel
		) {
		log.info("/catalogo/lista_por_pagina");
		
		StringBuilder sb = new StringBuilder();
		Gson gson = new Gson();
		
		int numeroTotalRegistros = tipoPapelExtendidoService.obtieneNumeroTipoPapelExtendidoPorParametros(
				busquedaPorNombre, 
				busquedaPorGramaje, 
				busquedaPorKilogramos, 
				busquedaPorAncho, 
				busquedaPorAlto, 
				busquedaPorProveedor, 
				nombre, 
				gramaje, 
				kilogramos, 
				ancho, 
				alto, 
				idProveedorPapel );
		
		List<TipoPapelExtendidoDTO> listaTipoPapelExtendido = tipoPapelExtendidoService.listaTipoPapelExtendidoPorParametrosPorNumeroPaginaEnDTO(busquedaPorNombre, busquedaPorGramaje, busquedaPorKilogramos, busquedaPorAncho, busquedaPorAlto, busquedaPorProveedor, nombre, gramaje, kilogramos, ancho, alto, idProveedorPapel, numeroPagina, numeroRegistrosPorPagina);
		
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaTipoPapelExtendido\":");
		sb.append(gson.toJson(listaTipoPapelExtendido));
		sb.append("}");
		
		//System.out.println(sb.toString());

		listaTipoPapelExtendido	= null;
		gson 					= null;
		
		return sb.toString();
	}
	
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoPapelExtendido(
			@RequestParam(value = "id_proveedor_papel", required = false) Integer idProveedorPapel,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "gramaje", 			required = false) Integer gramaje,
			@RequestParam(value = "kilogramos", 		required = false) float kilogramos,
			@RequestParam(value = "alto", 				required = false) float alto,
			@RequestParam(value = "ancho", 				required = false) float ancho,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_tipo_papel_extendido");

		TipoPapelExtendido tipoPapelExtendido = new TipoPapelExtendido();
			ProveedorPapel proveedorPapel = new ProveedorPapel();
			proveedorPapel.setIdProveedorPapel(idProveedorPapel);
		tipoPapelExtendido.setProveedorPapel(proveedorPapel);
		tipoPapelExtendido.setNombre(nombre);
		tipoPapelExtendido.setGramaje(gramaje);
		tipoPapelExtendido.setKilogramos(kilogramos);
		tipoPapelExtendido.setAlto(alto);
		tipoPapelExtendido.setAncho(ancho);
		tipoPapelExtendido.setDescripcion(descripcion);
		tipoPapelExtendido.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tipoPapelExtendido.setTipoPrecio(tipoPrecio);
		tipoPapelExtendido.setActivo(true);

		tipoPapelExtendidoService.creaTipoPapelExtendido(tipoPapelExtendido);
		
		proveedorPapel		= null;
		tipoPrecio 			= null;
		tipoPapelExtendido 	= null;
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		listaProveedorPapel = null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// numero total de registros
		int numeroTotalRegistros = tipoPapelExtendidoService.obtieneNumeroTipoPapelExtendidoPorParametros(false, false, false, false, false, false, null, null, null, null, null, null);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TipoPapelExtendido> listaTipoPapelExtendido = tipoPapelExtendidoService.listaTipoPapelExtendidoPorParametrosPorNumeroPagina(false, false, false, false, false, false, null, null, null, null, null, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		return "catalogo/tipo_papel_extendido";
	}// alta_tipo_papel_extendido

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoPapelExtendido(
			@RequestParam(value = "id_tipo_papel_extendido", 	required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "id_proveedor_papel", 		required = false) Integer idProveedorPapel,
			@RequestParam(value = "nombre", 					required = false) String nombre,
			@RequestParam(value = "gramaje", 					required = false) Integer gramaje,
			@RequestParam(value = "kilogramos", 				required = false) float kilogramos,
			@RequestParam(value = "alto", 						required = false) float alto,
			@RequestParam(value = "ancho", 						required = false) float ancho,
			@RequestParam(value = "descripcion", 				required = false) String descripcion,
			@RequestParam(value = "precio", 					required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 			required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_papel_extendido");

		TipoPapelExtendido tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(idTipoPapelExtendido);
		tipoPapelExtendido.getProveedorPapel().setIdProveedorPapel(idProveedorPapel);
		tipoPapelExtendido.setNombre(nombre);
		tipoPapelExtendido.setGramaje(gramaje);
		tipoPapelExtendido.setKilogramos(kilogramos);
		tipoPapelExtendido.setAlto(alto);
		tipoPapelExtendido.setAncho(ancho);
		tipoPapelExtendido.setDescripcion(descripcion);
		tipoPapelExtendido.setPrecio(precio);
		tipoPapelExtendido.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		
		tipoPapelExtendidoService.modificaTipoPapelExtendido(tipoPapelExtendido);

		tipoPapelExtendido 	= null;
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		listaProveedorPapel = null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// numero total de registros
		int numeroTotalRegistros = tipoPapelExtendidoService.obtieneNumeroTipoPapelExtendidoPorParametros(false, false, false, false, false, false, null, null, null, null, null, null);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TipoPapelExtendido> listaTipoPapelExtendido = tipoPapelExtendidoService.listaTipoPapelExtendidoPorParametrosPorNumeroPagina(false, false, false, false, false, false, null, null, null, null, null, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		return "catalogo/tipo_papel_extendido";
	}// modifica_tipo_papel_extendido

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoPapelExtendido(
			@RequestParam(value = "id_tipo_papel_extendido", required = false) Integer idTipoPapelExtendido,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_papel_extendido");
		
		TipoPapelExtendido tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(idTipoPapelExtendido);
		tipoPapelExtendido.setActivo(false);

		tipoPapelExtendidoService.modificaTipoPapelExtendido(tipoPapelExtendido);

		tipoPapelExtendido 	= null;
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		listaProveedorPapel = null;
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		listaTipoPrecio = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// numero total de registros
		int numeroTotalRegistros = tipoPapelExtendidoService.obtieneNumeroTipoPapelExtendidoPorParametros(false, false, false, false, false, false, null, null, null, null, null, null);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// lista de registros // BUSQUEDA DEFAULT
		List<TipoPapelExtendido> listaTipoPapelExtendido = tipoPapelExtendidoService.listaTipoPapelExtendidoPorParametrosPorNumeroPagina(false, false, false, false, false, false, null, null, null, null, null, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		return "catalogo/tipo_papel_extendido";
	}// elimina_tipo_papel_extendido
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/exporta", method = RequestMethod.GET)
	public void exportaTipoPapelExtendido( HttpServletResponse response ) {
		log.info("/exporta_tipo_papel_extendido");
		// enviar un archivo al cliente
		byte[] documento = tipoPapelExtendidoService.obtieneExcelListaTipoPapelExtendido();
		try {
			OutputStream os = response.getOutputStream();
			response.setHeader("Content-Disposition","attachment; filename=tipo_papel_extendido.xls");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength( documento.length );
			os.write( documento );
			os.flush();
		} catch( Exception e ) {
			log.error("Error al enviar el archivo de excel");
			e.printStackTrace();
		}
		documento = null;
	} // exporta_tipo_papel_extendido
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/ventana", method = RequestMethod.GET )
	public String ventanaModalSubirArchivoPapel() {
		log.info("/ventana_modal_subir_archivo_papel");
		return "catalogo/tipo_papel_extendido_sube_archivo";
	} // ventanaModalSubirArchivoPapel
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/importa", method = RequestMethod.POST)
	public String importaTipoPapelExtendido( HttpServletRequest request, Model model ) {
		log.info("/importa_tipo_papel_extendido");
		
		// recibir un archivo del cliente
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if( isMultipart ) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = request.getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// Parse the request
			try {
				List<FileItem> items = upload.parseRequest(request);
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = iter.next();

				    if (item.isFormField()) {
				    	String name	 = item.getFieldName();
				        String value = item.getString();
				        System.out.println("name:" + name);
				        System.out.println("value:" + value);
				    } else {
				    	String fieldName 	= item.getFieldName();
				        String fileName 	= item.getName();
				        String contentType 	= item.getContentType();
				        boolean isInMemory 	= item.isInMemory();
				        long sizeInBytes 	= item.getSize();
				        System.out.println("fieldName:" 	+ fieldName);
				        System.out.println("fileName:" 		+ fileName);
				        System.out.println("contentType:" 	+ contentType);
				        System.out.println("isInMemory:" 	+ isInMemory);
				        System.out.println("sizeInBytes:" 	+ sizeInBytes);
				        
				        if( contentType.equals("application/vnd.ms-excel") ) {
				        	boolean writeToFile = true;
					        // Process a file upload
				        	StringBuilder path 	= null;
				        	File file 			= null;
					        if (writeToFile) {
					        	
					        	// EJEMPLO DE MANEJO DE RUTAS DEL ARCHIVO: no borrar
					        	// ServletContext app_context = request.getServletContext();
						        // app_context.getRealPath("/");
					        	// System.out.println("getContextPath:" + request.getContextPath()); // contexto de la aplicacion : relativa
						        // System.out.println("realPath:" + request.getSession().getServletContext().getRealPath("/")); // contexto de la aplicacion : absoluta
						        // System.out.println("Path:" + new File("/").getAbsolutePath()); // de todo el sistema : absoluta
					        	
					        	Date date = new Date( Calendar.getInstance().getTimeInMillis() );
					        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
					        	
					        	path = new StringBuilder();
					        	path.append( request.getSession().getServletContext().getRealPath("/") );
					        	path.append("/resources/temporal/");
					        	path.append( dateFormat.format(date) );
					        	path.append(".xls");
					        	
					        	file = new File( path.toString() );
					        	item.write(file);
					        	
					        } else {
					            //FileInputStream fis = new FileInputStream(fileName);
					        	//InputStream uploadedStream = item.getInputStream();
					            //...
					            //uploadedStream.close();
					        }
					        tipoPapelExtendidoService.cargaExcel(path.toString());
					        
					        // delete file
					        if( file.delete() ) {
					        	System.out.println("archivo eliminado");
					        } else {
					        	System.out.println("archivo NO eliminado");
					        }
				        } else {
				        	System.out.println("No es un archivo excel");
				        }
				    }
				}
			} catch( Exception e ) {
				log.error("Error al cargar el archivo de excel");
				e.printStackTrace();
			}
		}
		
		List<TipoPapelExtendido> listaTipoPapelExtendido 	= tipoPapelExtendidoService.listaTipoPapelExtendido();
		List<ComboSelect> listaProveedorPapel = proveedorPapelService.listaComboSelect();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPapelExtendido = null;
		listaProveedorPapel 	= null;
		listaTipoPrecio 		= null;
		
		return "catalogo/tipo_papel_extendido";
	} // importaTipoPapelExtendido
	
}
