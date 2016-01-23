package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ReporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionOrdenProduccion;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	private static final Logger log = Logger.getLogger(ReporteController.class);
	
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
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private EstatusOrdenService estatusOrdenService;
	@Resource
	private ReporteService reporteService;
	
	
	
	// MENUS
	//******************************************************************************************
	
	private List<ComboSelect> getListaReportes() {
		List<ComboSelect> lista = new ArrayList<ComboSelect>();
		ComboSelect c1 = new ComboSelect();
		c1.setValue(0);
		c1.setText("Orden Producción");
		lista.add(c1);
		c1 = null;
		ComboSelect c2 = new ComboSelect();
		c2.setValue(1);
		c2.setText("Cotización");
		lista.add(c2);
		c2 = null;
		ComboSelect c3 = new ComboSelect();
		c3.setValue(2);
		c3.setText("Nota Remisión / Factura");
		lista.add(c3);
		c3 = null;
		return lista;
	}
	
	private List<ComboSelect> getListaTipoFormatoImpresion() {
		List<ComboSelect> lista = new ArrayList<ComboSelect>();
		ComboSelect c1 = new ComboSelect();
		c1.setValue(0);
		c1.setText("En pantalla");
		lista.add(c1);
		c1 = null;
		ComboSelect c2 = new ComboSelect();
		c2.setValue(1);
		c2.setText("PDF");
		lista.add(c2);
		c2 = null;
		ComboSelect c3 = new ComboSelect();
		c3.setValue(2);
		c3.setText("RTF");
		lista.add(c3);
		c3 = null;
		ComboSelect c4 = new ComboSelect();
		c4.setValue(3);
		c4.setText("EXCEL");
		lista.add(c4);
		c4 = null;
		return lista;
	}
	
	// GENERACION DE REPORTES
	//******************************************************************************************
	
	private void ordenProduccion( String nut, int idTipoFormatoImpresion, HttpServletRequest request, HttpServletResponse response ) throws IOException {
		// INFORMACION DEL DATASOURCE
		List<OrdenTrabajo> listaOrdenTrabajo = calificacionService.obtieneOrdenTrabajo(nut);
		// PARAMETROS
		String path = request.getSession().getServletContext().getRealPath("/");
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_PARTIDA",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoPartida.jasper");
		parameterMap.put("SUBREPORT_DISENIO",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoDisenio.jasper");
		parameterMap.put("SUBREPORT_DISENIO_DETALLE",		path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoDisenioDetalle.jasper");
		parameterMap.put("SUBREPORT_PREPRENSA",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoPreprensa.jasper");
		parameterMap.put("SUBREPORT_PREPRENSA_DETALLE",		path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoPreprensaDetalle.jasper");
		parameterMap.put("SUBREPORT_TRANSPORTE",			path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoTransporte.jasper");
		parameterMap.put("SUBREPORT_TRANSPORTE_DETALLE",	path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoTransporteDetalle.jasper");
		parameterMap.put("SUBREPORT_ACABADO",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoAcabado.jasper");
		parameterMap.put("SUBREPORT_ACABADO_DETALLE",		path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoAcabadoDetalle.jasper");
		parameterMap.put("SUBREPORT_OFFSET",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoOffset.jasper");
		parameterMap.put("SUBREPORT_MATERIAL_AYUDA",		path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoMaterialAyuda.jasper");
		parameterMap.put("SUBREPORT_TIPO_TRABAJO_DETALLE",	path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoTipoTrabajoDetalle.jasper");
		parameterMap.put("SUBREPORT_PLIEGO",				path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoPliego.jasper");
		parameterMap.put("SUBREPORT_PLIEGO_RESUMEN",		path + DIRECTORIO_ORIGEN + "04_OrdenTrabajoPliegoResumen.jasper");
		try {
			OutputStream outputStream 				= response.getOutputStream();
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "04_OrdenTrabajoMaster.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaOrdenTrabajo);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormatoImpresion ) {
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
		} finally {
			parameterMap		= null;
			listaOrdenTrabajo 	= null;
		}
	}
	
	
	private void cotizacion( String nut, String condicionesProduccion, int idTipoFormatoImpresion, HttpServletRequest request, HttpServletResponse response ) throws IOException {
		// guarda condiciones en la base de datos
		calificacionService.guardaCondicionesProduccion(nut, condicionesProduccion);
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		Cliente cliente = clienteService.buscaCliente(ordenProduccion.getCliente().getIdCliente());
		CalificacionOrdenProduccion calificacion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
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
		// PRECIOS
		parameterMap.put("precio_cliente", calificacion.getPrecioCliente());
		parameterMap.put("porcentaje_descuento", calificacion.getPorcentajeDescuento());
		parameterMap.put("precio_cliente_con_descuento", calificacion.getPrecioClienteConDescuento());
		// lista de partida
		List<ReporteCotizacionDTO> listaPartida = calificacionService.obtieneListaPrecioCotizacionPartida(nut);
		try {
			OutputStream outputStream 				= response.getOutputStream();
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "01_ReporteCotizacion.jasper");
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaPartida);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormatoImpresion ) {
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
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		} finally {
			listaPartida	= null;
			parameterMap	= null;
			calificacion	= null;
			cliente			= null;
			ordenProduccion = null;
		}
	}
	
	
	private void notaRemision( String nut, int idTipoFormatoImpresion, HttpServletRequest request, HttpServletResponse response ) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/");
		// PARAMETROS
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_PARTIDA",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaPartida.jasper");
		parameterMap.put("SUBREPORT_TIPO_TRABAJO_DETALLE",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaTipoTrabajoDetalle.jasper");
		parameterMap.put("SUBREPORT_PLIEGO",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaPliego.jasper");
		parameterMap.put("IMPRIME_IVA",false);
		// INFORMACION DEL DATA SOURCE
		List<RemisionOrdenProduccion> listaRemision = calificacionService.obtieneRemisionPorNut(nut);
		try {
			OutputStream outputStream 				= response.getOutputStream();
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "02_RemisionFacturaOrdenProduccion.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaRemision);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormatoImpresion ) {
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
		} finally {
			listaRemision = null;
			parameterMap	= null;
		}
	}
	
	
	private void notaFactura( String nut, int idTipoFormatoImpresion, HttpServletRequest request, HttpServletResponse response ) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/");
		// PARAMETROS
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("SUBREPORT_PARTIDA",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaPartida.jasper");
		parameterMap.put("SUBREPORT_TIPO_TRABAJO_DETALLE",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaTipoTrabajoDetalle.jasper");
		parameterMap.put("SUBREPORT_PLIEGO",path + DIRECTORIO_ORIGEN + "02_RemisionFacturaPliego.jasper");
		parameterMap.put("IMPRIME_IVA",true);
		// INFORMACION DEL DATA SOURCE
		List<RemisionOrdenProduccion> listaRemision = calificacionService.obtieneRemisionPorNut(nut);
		try {
			OutputStream outputStream 				= response.getOutputStream();
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "02_RemisionFacturaOrdenProduccion.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaRemision);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, parameterMap, dataSource );
			//System.out.println("tipo_formato:" + tipo_formato);
			switch( idTipoFormatoImpresion ) {
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
		} finally {
			listaRemision = null;
			parameterMap	= null;
		}
	}
	
	
	private void colaImpresion( int idEstatusOrden, HttpServletRequest request, HttpServletResponse response ) {
		// enviar un archivo al cliente
		byte[] documento = reporteService.obtieneExcelListaColaImpresion( idEstatusOrden );
		try {
			OutputStream os = response.getOutputStream();
			response.setHeader("Content-Disposition","attachment; filename=reporteColaImpresion.xls");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength( documento.length );
			os.write( documento );
			os.flush();
		} catch( Exception e ) {
			log.error("Error al enviar el archivo de excel");
			e.printStackTrace();
		} finally {
			documento = null;
		}
	}
	
	// URL de JSP's
	//******************************************************************************************
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/existe_nut", method = RequestMethod.POST)
	@ResponseBody
	public boolean existeNut( @RequestParam(value = "nut", required = false) String nut ) {
		log.info("/existe_nut");
		return ordenProduccionService.existeOrdenProduccionPorNut(nut);
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca_condiciones_produccion", method = RequestMethod.POST)
	@ResponseBody
	public String condicionesProduccion( @RequestParam(value = "nut", required = false) String nut ) {
		log.info("/busca_condiciones_produccion");
		boolean existeRegistro 			= ordenProduccionService.existeOrdenProduccionPorNut(nut);
		String condicionesProduccion 	= "";
		if( existeRegistro ) {
			condicionesProduccion = calificacionService.obtieneCondicionesProduccion(nut);
		}
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"existeRegistro\":");
		json.append(existeRegistro);
		json.append(",");
		json.append("\"condicionesProduccion\":");
		json.append("\"");
		json.append(condicionesProduccion);
		json.append("\"");
		json.append("}");
		
		return json.toString();
	}
	
	
	// UTILIZADO EN VISUALIZADOR -> DETALLE_PRECIO -> CONDICIONES_PRODUCCION
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/selecciona_reporte", method = RequestMethod.POST)
	public void seleccionaReporte( 
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_reporte", 			required = false) Integer idTipoReporte,
			@RequestParam(value = "condiciones_produccion", 	required = false) String condicionesProduccion,
			@RequestParam(value = "id_tipo_formato_impresion", 	required = false) Integer idTipoFormatoImpresion,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/nota_remision_factura");
		switch( idTipoReporte ) {
			case 0: // ORDEN PRODUCCION
				ordenProduccion(nut, idTipoFormatoImpresion, request, response);
				break;
			case 1: // COTIZACION
				cotizacion(nut, condicionesProduccion, idTipoFormatoImpresion, request, response);
				break;
			case 2:	// NOTA REMISION / FACTURA
				OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
				int idTipoComprobanteFiscal = ordenProduccion.getTipoComprobanteFiscal().getIdTipoComprobanteFiscal();
				ordenProduccion = null;
				switch( idTipoComprobanteFiscal ) {
					case 1: // NOTA REMISION
						notaRemision(nut, idTipoFormatoImpresion, request, response);
						break;
					case 2:	// NOTA FACTURA
						notaFactura(nut, idTipoFormatoImpresion, request, response);
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/orden_produccion", method = RequestMethod.POST)
	public void reporteOrdenTrabajo(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_formato_impresion",	required = false) Integer idTipoFormatoImpresion,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_orden_trabajo");
		ordenProduccion(nut, idTipoFormatoImpresion, request, response);
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/cotizacion", method = RequestMethod.POST)
	public void reporteCotizacion(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "condiciones_produccion", 	required = false) String condicionesProduccion,
			@RequestParam(value = "id_tipo_formato_impresion",	required = false) Integer idTipoFormatoImpresion,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_reporte");
		cotizacion(nut, condicionesProduccion, idTipoFormatoImpresion, request, response);
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/nota_remision_factura", method = RequestMethod.POST)
	public void notaRemisionFactura(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_formato_impresion",	required = false) Integer idTipoFormatoImpresion,
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		log.info("/nota_remision_factura");
		// obtiene tipo comprobante fiscal
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		int idTipoComprobanteFiscal = ordenProduccion.getTipoComprobanteFiscal().getIdTipoComprobanteFiscal();
		ordenProduccion = null;
		switch( idTipoComprobanteFiscal ) {
			case 1: // NOTA REMISION
				notaRemision(nut, idTipoFormatoImpresion, request, response);
				break;
			case 2:	// NOTA FACTURA
				notaFactura(nut, idTipoFormatoImpresion, request, response);
				break;
			default:
				break;
		}
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/cola_impresion", method = RequestMethod.POST)
	public void colaImpresionPorMaquinaEstatusOrden(
			@RequestParam(value = "id_estatus_orden", 	required = false) Integer idEstatusOrden,
			HttpServletRequest request,
			HttpServletResponse response
		) {
		log.info("/cola_impresion");
		colaImpresion(idEstatusOrden, request, response);
	}
	
	
	// URL de ventanas
	//******************************************************************************************
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana_condiciones_produccion", method = RequestMethod.GET)
	public String ventanaCondicionesProduccion(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.info("/ventana_condiciones_produccion");
		
		model.addAttribute("nut", nut);
		List<ComboSelect> listaReporte = getListaReportes();
		model.addAttribute("listaReporte",listaReporte);
		listaReporte = null;
		List<ComboSelect> listaTipoFormatoImpresion = getListaTipoFormatoImpresion();
		model.addAttribute("listaTipoFormatoImpresion", listaTipoFormatoImpresion);
		listaTipoFormatoImpresion = null;
		model.addAttribute("condicionesProduccion", calificacionService.obtieneCondicionesProduccion(nut));
		return "produccion/visualizador/condiciones_produccion";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana_orden_produccion", method = RequestMethod.GET)
	public String ventanaOrdenProduccion( Model model) {
		log.info("/ventana_orden_produccion");
		
		List<ComboSelect> listaTipoFormatoImpresion = getListaTipoFormatoImpresion();
		model.addAttribute("listaTipoFormatoImpresion", listaTipoFormatoImpresion);
		listaTipoFormatoImpresion = null;
		return "reporte/ventana_orden_produccion";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana_cotizacion", method = RequestMethod.GET)
	public String ventanaCotizacion( Model model ) {
		log.info("/ventana_cotizacion");
		
		List<ComboSelect> listaTipoFormatoImpresion = getListaTipoFormatoImpresion();
		model.addAttribute("listaTipoFormatoImpresion", listaTipoFormatoImpresion);
		listaTipoFormatoImpresion = null;
		return "reporte/ventana_cotizacion";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana_nota_remision_factura", method = RequestMethod.GET)
	public String ventanaNotaRemision( Model model ) {
		log.info("/ventana_nota_remision_factura");
		
		List<ComboSelect> listaTipoFormatoImpresion = getListaTipoFormatoImpresion();
		model.addAttribute("listaTipoFormatoImpresion", listaTipoFormatoImpresion);
		listaTipoFormatoImpresion = null;
		return "reporte/ventana_nota_remision_factura";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/ventana_cola_impresion", method = RequestMethod.GET)
	public String ventanaColaImpresion( Model model ){
		log.info("/ventana_cola_impresion");
		
		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelect();
		model.addAttribute("listaEstatusOrden",listaEstatusOrden);
		listaEstatusOrden = null;
		return "reporte/ventana_cola_impresion";
	}

}
