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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;

@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {
	
		private static final Logger log = Logger.getLogger(CotizacionController.class);
	
		// cuando se corre en una aplicacion java
		//public static final String DIRECTORIO_ORIGEN = "WebContent/resources/jasper/"; 
		
		// cuando se corre en una aplicacion dentro de un servidor
		public static final String DIRECTORIO_ORIGEN = "/resources/jasper/";
		
		@Autowired
		ServletContext context; // sirve para obtener el getContextPath()
		@Resource
		private CalificacionService calificacionService;
		@Resource
		private ClienteService clienteService;
		@Resource
		private OrdenProduccionService ordenProduccionService;

	@RequestMapping(value = "/condiciones_produccion", method = RequestMethod.GET)
	public String condicionesProduccion(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.trace("/condiciones_produccion");
		
		model.addAttribute("condiciones_produccion", calificacionService.obtieneCondicionesProduccion(nut));
		return "visualizador/condiciones_produccion";
	} // condicionesProduccion
	
	@RequestMapping(value = "/exporta_reporte", method = RequestMethod.POST)
	public void exportaReportePDF(
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "condiciones_produccion", required = false) String condicionesProduccion,
			@RequestParam(value = "tipo_formato",			required = false) int tipoFormato,
			HttpServletResponse response
		) throws IOException {
		log.trace("/exporta_reporte");
		
		//System.out.println("nut:" + nut);
		//System.out.println("condiciones_produccion:" + condiciones_produccion);
		
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
			switch( tipoFormato ) {
				case 1:	// PDF
					response.setHeader("Content-Disposition", "attachment; filename=" + nut + ".pdf");
					response.setContentType("application/pdf");
					//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream); // funciona
					JRPdfExporter pdfExporter = new JRPdfExporter();
					pdfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					pdfExporter.setExporterOutput( new SimpleOutputStreamExporterOutput(outputStream) );
					pdfExporter.exportReport();
					break;
				case 2: // RTF
					response.setHeader("Content-Disposition", "attachment; filename=" + nut + ".doc");
					response.setContentType("application/rtf");
					JRRtfExporter rtfExporter = new JRRtfExporter();
					rtfExporter.setExporterInput( new SimpleExporterInput(jasperPrint) );
					rtfExporter.setExporterOutput( new SimpleHtmlExporterOutput(outputStream) );
					rtfExporter.exportReport();
					break;
				case 3: // EXCEL // NO ESTA CONFIGURADO, QUIZA NO FUNCIONE
					response.setHeader("Content-Disposition", "attachment; filename=" + nut + ".xls");
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
	
}
