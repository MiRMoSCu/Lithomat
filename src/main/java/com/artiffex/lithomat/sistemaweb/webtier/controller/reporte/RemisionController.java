package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

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
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionTrabajoDetalle;

@Controller
@RequestMapping("/remision")
public class RemisionController {
	
	private static final Logger log = Logger.getLogger(CotizacionController.class);
	
	private static final String DIRECTORIO_ORIGEN = "/resources/jasper/";
	
	@Autowired
	ServletContext context; // sirve para obtener el getContextPath()
	@Resource
	private CalificacionService calificacionService;

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/exporta_reporte", method = RequestMethod.GET)
	public void exportaReporteRemision(
			@RequestParam(value = "nut", required = false) String nut,
			HttpServletResponse response
		) throws IOException {
		log.info("/exporta_reporte_remision");
		
		List<_CalificacionTrabajoDetalle> listaCalificacionTrabajoDetalle = calificacionService.obtieneListaCalificacionTrabajoDetallePorNut(nut);
		
		try {
			OutputStream outputStream 				= response.getOutputStream();
			
			InputStream reportStream 				= context.getResourceAsStream(DIRECTORIO_ORIGEN + "Remision.jasper");			
			JRBeanCollectionDataSource dataSource 	= new JRBeanCollectionDataSource(listaCalificacionTrabajoDetalle);
			JasperPrint jasperPrint 				= JasperFillManager.fillReport( reportStream, null, dataSource );
			
			int tipoFormato = 0;
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
			
			listaCalificacionTrabajoDetalle = null;

			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
		
		
	}

}
