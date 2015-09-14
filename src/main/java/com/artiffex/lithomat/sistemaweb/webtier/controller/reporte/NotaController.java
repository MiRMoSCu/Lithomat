package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.Remision;

@Controller
@RequestMapping("/nota")
public class NotaController {
	
	private static final Logger log = Logger.getLogger(NotaController.class);
	
	// cuando se corre en una aplicacion java
	//public static final String DIRECTORIO_ORIGEN = "WebContent/resources/jasper/"; 
	
	// cuando se corre en una aplicacion dentro de un servidor
	private static final String DIRECTORIO_ORIGEN = "/resources/jasper/";
	
	@Autowired
	ServletContext context; // sirve para obtener el getContextPath()
	@Resource
	private CalificacionService calificacionService;
	@Resource
	private ClienteService clienteService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/condiciones_produccion", method = RequestMethod.GET)
	public String condicionesProduccion(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.info("/condiciones_produccion");
		
		List<ComboSelect> listaReporte = ordenProduccionService.listaReportePorNut(nut);
		
		model.addAttribute("listaReporte",listaReporte);
		model.addAttribute("condicionesProduccion", calificacionService.obtieneCondicionesProduccion(nut));
		
		listaReporte = null;
		
		return "visualizador/condiciones_produccion";
	} // condicionesProduccion
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/cotizacion", method = RequestMethod.POST)
	public void exportaReportePDF(
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "condiciones_produccion", required = false) String condicionesProduccion,
			@RequestParam(value = "id_tipo_formato",		required = false) Integer idTipoFormato,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_reporte");
		
		//System.out.println("nut:" + nut);
		//System.out.println("condiciones_produccion:" + condicionesProduccion);
		
		// guarda condiciones en la base de datos
		calificacionService.guardaCondicionesProduccion(nut, condicionesProduccion);

		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		Cliente cliente = clienteService.buscaCliente(ordenProduccion.getCliente().getIdCliente());

		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		// logo
		parameterMap.put("path_logo", context.getResource("/resources/image/logo.png").getPath());
		// nut
		parameterMap.put("nut", nut);
		// fecha
		SimpleDateFormat sdf = new SimpleDateFormat("'México D.F. a' dd 'de' MMMM 'de' yyyy", new Locale("es","MX"));
		parameterMap.put("fecha", sdf.format( new Date( Calendar.getInstance().getTimeInMillis() ) ));
		// nombre_representante
		parameterMap.put("nombre_representante", cliente.getNombreRepresentante());
		// puesto
		if( cliente.getPuesto() == null ) {
			parameterMap.put("puesto", "");
		} else {
			parameterMap.put("puesto", cliente.getPuesto());
		}
		// nombre_moral
		parameterMap.put("nombre_moral", cliente.getNombreMoral());
		// direccion
		StringBuilder sb = new StringBuilder();
		if( cliente.getCalle() != null && !"".equals(cliente.getCalle()) ) {
			sb.append(cliente.getCalle());
			sb.append(" ");
			sb.append(cliente.getNumExterior());
		}
		if( cliente.getNumInterior() != null && !"".equals(cliente.getNumInterior().toString().trim()) ) {
			sb.append(", int. ");
			sb.append(cliente.getNumInterior());
		}
		if( cliente.getColonia() != null && !"".equals(cliente.getColonia().trim()) ) {
			sb.append(". Col. ");
			sb.append(cliente.getColonia());
			sb.append(". ");
		}
		if( cliente.getDelegacionMunicipio() != null && !"".equals(cliente.getDelegacionMunicipio().trim()) ) {
			sb.append(cliente.getDelegacionMunicipio());
			sb.append(". ");
			sb.append(cliente.getEstado());
		}
		if( cliente.getTelefonoParticular() != null && !"".equals(cliente.getTelefonoParticular().toString().trim()) ) {
			sb.append(". Tel. ");
			sb.append(cliente.getTelefonoParticular());
			sb.append(".");
		}
		parameterMap.put("direccion", sb.toString());
		// condiciones_produccion
		parameterMap.put("condiciones_produccion", condicionesProduccion);
		
		// lista de partida
		List<ReporteCotizacionDTO> listaPartida = calificacionService.obtieneListaPrecioCotizacionPartida(nut);

		try {
			OutputStream outputStream 				= response.getOutputStream();
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "ReporteCotizacion.jasper");
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaPartida);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormato ) {
				case 1:	// PDF
					response.setHeader("Content-Disposition", "attachment; filename=Cotizacion" + nut + ".pdf");
					response.setContentType("application/pdf");
					//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); // funciona
					JRPdfExporter pdfExporter = new JRPdfExporter();
					pdfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					pdfExporter.setExporterOutput( new SimpleOutputStreamExporterOutput(outputStream) );
					pdfExporter.exportReport();
					break;
				case 2: // RTF
					response.setHeader("Content-Disposition", "attachment; filename=Cotizacion" + nut + ".doc");
					response.setContentType("application/rtf");
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					rtfExporter.setExporterOutput( new SimpleHtmlExporterOutput(outputStream) );
					rtfExporter.exportReport();
					break;
				case 3: // EXCEL // NO ESTA CONFIGURADO, QUIZA NO FUNCIONE
					response.setHeader("Content-Disposition", "attachment; filename=Cotizacion" + nut + ".xls");
					response.setContentType("application/vnd.ms-excel");
					//JRXlsExporter xlsExporter = new JRXlsExporter();
					//xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
					//xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
					//SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
					//configuration.setOnePagePerSheet(true);
					//configuration.setDetectCellType(true);
					//configuration.setCollapseRowSpan(false);
					//xlsExporter.setConfiguration(configuration);
					break;
				default: // en pantalla
					response.setContentType("application/pdf");
					try {
						JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
			}

			outputStream.flush();
			outputStream.close();
			
			ordenProduccion = null;
			cliente			= null;
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
	} // exportaReportePDF
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/remision", method = RequestMethod.POST)
	public void exportaReporteRemision(
			@RequestParam(value = "nut", 				required = false) String nut,
			@RequestParam(value = "id_tipo_formato",	required = false) Integer idTipoFormato,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_reporte_remision");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion cop = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		String path = request.getSession().getServletContext().getRealPath("/");
		// PARAMETROS
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		
		parameterMap.put("SUBREPORT_DIR",path + DIRECTORIO_ORIGEN + "RemisionChild.jasper");
		parameterMap.put("nut",nut);
		parameterMap.put("nombreCliente",ordenProduccion.getCliente().getNombreMoral());
		parameterMap.put("nombreOrdenProduccion",ordenProduccion.getNombre());
		parameterMap.put("precioCliente",cop.getPrecioCliente());
		
		cop				= null;
		ordenProduccion = null;

		// INFORMACION DEL DATA SOURCE
		List<Remision> listaRemision = calificacionService.obtieneRemisionPorNut(nut);
		
		try {
			OutputStream outputStream 				= response.getOutputStream();
			
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "RemisionMaster.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaRemision);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormato ) {
				case 1:	// PDF
					response.setHeader("Content-Disposition", "attachment; filename=Remision" + nut + ".pdf");
					response.setContentType("application/pdf");
					//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); // funciona
					JRPdfExporter pdfExporter = new JRPdfExporter();
					pdfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					pdfExporter.setExporterOutput( new SimpleOutputStreamExporterOutput(outputStream) );
					pdfExporter.exportReport();
					break;
				case 2: // RTF
					response.setHeader("Content-Disposition", "attachment; filename=Remision" + nut + ".doc");
					response.setContentType("application/rtf");
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					rtfExporter.setExporterOutput( new SimpleHtmlExporterOutput(outputStream) );
					rtfExporter.exportReport();
					break;
				case 3: // EXCEL // NO ESTA CONFIGURADO, QUIZA NO FUNCIONE
					response.setHeader("Content-Disposition", "attachment; filename=Remision" + nut + ".xls");
					response.setContentType("application/vnd.ms-excel");
					//JRXlsExporter xlsExporter = new JRXlsExporter();
					//xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
					//xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
					//SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
					//configuration.setOnePagePerSheet(true);
					//configuration.setDetectCellType(true);
					//configuration.setCollapseRowSpan(false);
					//xlsExporter.setConfiguration(configuration);
					break;
				default: // en pantalla
					response.setContentType("application/pdf");
					try {
						JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
		listaRemision = null;
	}

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/factura", method = RequestMethod.POST)
	public void exportaReporteFactura(
			@RequestParam(value = "nut", 				required = false) String nut,
			@RequestParam(value = "id_tipo_formato",	required = false) Integer idTipoFormato,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_reporte_factura");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion cop = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		String path = request.getSession().getServletContext().getRealPath("/");
		// PARAMETROS
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_DIR",path + DIRECTORIO_ORIGEN + "RemisionChild.jasper");
		parameterMap.put("nut",nut);
		parameterMap.put("nombreCliente",ordenProduccion.getCliente().getNombreMoral());
		parameterMap.put("nombreOrdenProduccion",ordenProduccion.getNombre());
		parameterMap.put("precioCliente",cop.getPrecioCliente());
		parameterMap.put("precioNeto",cop.getPrecioNeto());
		
		cop				= null;
		ordenProduccion = null;

		// INFORMACION DEL DATA SOURCE
		List<Remision> listaRemision = calificacionService.obtieneRemisionPorNut(nut);
		
		try {
			OutputStream outputStream 				= response.getOutputStream();
			
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "FacturaMaster.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaRemision);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormato ) {
				case 1:	// PDF
					response.setHeader("Content-Disposition", "attachment; filename=Factura" + nut + ".pdf");
					response.setContentType("application/pdf");
					//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); // funciona
					JRPdfExporter pdfExporter = new JRPdfExporter();
					pdfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					pdfExporter.setExporterOutput( new SimpleOutputStreamExporterOutput(outputStream) );
					pdfExporter.exportReport();
					break;
				case 2: // RTF
					response.setHeader("Content-Disposition", "attachment; filename=Factura" + nut + ".doc");
					response.setContentType("application/rtf");
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					rtfExporter.setExporterOutput( new SimpleHtmlExporterOutput(outputStream) );
					rtfExporter.exportReport();
					break;
				case 3: // EXCEL // NO ESTA CONFIGURADO, QUIZA NO FUNCIONE
					response.setHeader("Content-Disposition", "attachment; filename=Factura" + nut + ".xls");
					response.setContentType("application/vnd.ms-excel");
					//JRXlsExporter xlsExporter = new JRXlsExporter();
					//xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
					//xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
					//SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
					//configuration.setOnePagePerSheet(true);
					//configuration.setDetectCellType(true);
					//configuration.setCollapseRowSpan(false);
					//xlsExporter.setConfiguration(configuration);
					break;
				default: // en pantalla
					response.setContentType("application/pdf");
					try {
						JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
		listaRemision = null;
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/orden_trabajo", method = RequestMethod.POST)
	public void exportaOrdenTrabajo(
				@RequestParam(value = "nut", 				required = false) String nut,
				@RequestParam(value = "id_tipo_formato",	required = false) Integer idTipoFormato,
				HttpServletRequest request,
				HttpServletResponse response
			) throws IOException {
		log.info("/exporta_orden_trabajo");
		
		// INFORMACION DEL DATASOURCE
		List<OrdenTrabajo> listaOrdenTrabajo = calificacionService.obtieneOrdenTrabajo(nut);
		
		// PARAMETROS
		String path = request.getSession().getServletContext().getRealPath("/");
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_PARTIDA",path + DIRECTORIO_ORIGEN + "OrdenTrabajoPartida.jasper");
		parameterMap.put("SUBREPORT_TIPO_TRABAJO_DETALLE",path + DIRECTORIO_ORIGEN + "OrdenTrabajoTipoTrabajoDetalle.jasper");
		parameterMap.put("SUBREPORT_PLIEGO",path + DIRECTORIO_ORIGEN + "OrdenTrabajoPliego.jasper");
		
		try {
			OutputStream outputStream 				= response.getOutputStream();
			
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "OrdenTrabajoMaster.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaOrdenTrabajo);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormato ) {
				case 1:	// PDF
					response.setHeader("Content-Disposition", "attachment; filename=OT" + nut + ".pdf");
					response.setContentType("application/pdf");
					//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); // funciona
					JRPdfExporter pdfExporter = new JRPdfExporter();
					pdfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					pdfExporter.setExporterOutput( new SimpleOutputStreamExporterOutput(outputStream) );
					pdfExporter.exportReport();
					break;
				case 2: // RTF
					response.setHeader("Content-Disposition", "attachment; filename=OT" + nut + ".doc");
					response.setContentType("application/rtf");
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					rtfExporter.setExporterOutput( new SimpleHtmlExporterOutput(outputStream) );
					rtfExporter.exportReport();
					break;
				case 3: // EXCEL // NO ESTA CONFIGURADO, QUIZA NO FUNCIONE
					response.setHeader("Content-Disposition", "attachment; filename=OT" + nut + ".xls");
					response.setContentType("application/vnd.ms-excel");
					//JRXlsExporter xlsExporter = new JRXlsExporter();
					//xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
					//xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
					//SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
					//configuration.setOnePagePerSheet(true);
					//configuration.setDetectCellType(true);
					//configuration.setCollapseRowSpan(false);
					//xlsExporter.setConfiguration(configuration);
					break;
				default: // en pantalla
					response.setContentType("application/pdf");
					try {
						JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
		
		listaOrdenTrabajo = null;
		
	}

}
