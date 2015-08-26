package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.Persona;
import com.artiffex.lithomat.sistemaweb.ayuda.Telefono;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;

@Controller
public class PruebasJasperController {
	
	// cuando se corre en una aplicacion java
		//public static final String DIRECTORIO_ORIGEN = "WebContent/resources/jasper/"; 
		
		// cuando se corre en una aplicacion dentro de un servidor
		public static final String DIRECTORIO_ORIGEN = "/resources/jasper/";
		
		@Autowired
		ServletContext context; // sirve para obtener el getContextPath()
		@Resource
		private CalificacionService calificacionService;
		

	@RequestMapping(value = "/reporte_prueba_uno", method = RequestMethod.GET)
	public void reportePruebaUno(
			HttpServletResponse response
		) throws IOException {

		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("parametro_uno", "la pantera rosa");

		Collection<Map<String, ?>> reportRows = new ArrayList<Map<String, ?>>();

		HashMap<String, Object> row1Map = new HashMap<String, Object>();
		row1Map.put("campo_uno", "AAAAAA");
		row1Map.put("campo_dos", "AAAAAA");
		row1Map.put("campo_tres", "AAAAAA");
		reportRows.add(row1Map);

		HashMap<String, Object> row2Map = new HashMap<String, Object>();
		row2Map.put("campo_uno", "BBBBBB");
		row2Map.put("campo_dos", "BBBBBB");
		row2Map.put("campo_tres", "BBBBBB");
		reportRows.add(row2Map);

		HashMap<String, Object> row3Map = new HashMap<String, Object>();
		row3Map.put("campo_uno", "CCCCCC");
		row3Map.put("campo_dos", "CCCCCC");
		row3Map.put("campo_tres", "CCCCCC");
		reportRows.add(row3Map);

		HashMap<String, Object> row4Map = new HashMap<String, Object>();
		row4Map.put("campo_uno", "DDDDDD");
		row4Map.put("campo_dos", "DDDDDD");
		row4Map.put("campo_tres", "DDDDDD");
		reportRows.add(row4Map);
		
		HashMap<String, Object> row5Map = new HashMap<String, Object>();
		row5Map.put("campo_uno", "EEEEEE");
		row5Map.put("campo_dos", "EEEEEE");
		row5Map.put("campo_tres", "EEEEEE");
		reportRows.add(row5Map);

		try {
			
			InputStream reportStream 	= context.getResourceAsStream( DIRECTORIO_ORIGEN + "Prueba_1.jasper");
			OutputStream outputStream 	= response.getOutputStream();

			// JREmptyDataSource dataSource = new JREmptyDataSource();
			JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(reportRows);

			JasperRunManager.runReportToPdfStream( reportStream, outputStream, parameterMap, dataSource );

			response.setContentType("application/pdf");
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter 	= new StringWriter();
			PrintWriter printWriter 	= new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
	} // reportePruebaUno
	
	
	@RequestMapping(value = "/reporte_prueba_uno_b", method = RequestMethod.GET)
	public void reportePruebaUnoB(
			HttpServletResponse response
		) throws IOException {

		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("parametro_uno", "la pantera rosa");

		Collection<Map<String, ?>> reportRows = new ArrayList<Map<String, ?>>();

		HashMap<String, Object> row1Map = new HashMap<String, Object>();
		row1Map.put("campo_uno", "AAAAAA");
		row1Map.put("campo_dos", "AAAAAA");
		row1Map.put("campo_tres", "AAAAAA");
		reportRows.add(row1Map);

		HashMap<String, Object> row2Map = new HashMap<String, Object>();
		row2Map.put("campo_uno", "BBBBBB");
		row2Map.put("campo_dos", "BBBBBB");
		row2Map.put("campo_tres", "BBBBBB");
		reportRows.add(row2Map);

		HashMap<String, Object> row3Map = new HashMap<String, Object>();
		row3Map.put("campo_uno", "CCCCCC");
		row3Map.put("campo_dos", "CCCCCC");
		row3Map.put("campo_tres", "CCCCCC");
		reportRows.add(row3Map);

		try {
			
			response.setHeader("Content-Disposition", "attachment; filename=reporte_prueba_uno_b.pdf");
			response.setContentType("application/pdf");
			
			OutputStream outputStream 	= response.getOutputStream();

			// JREmptyDataSource dataSource = new JREmptyDataSource();
			JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(reportRows);
			
			System.out.println("uno: cargando reporte..."); 
			JasperReport report = JasperCompileManager.compileReport( context.getResourceAsStream("/resources/jrxml/Prueba_1.jrxml") );
			System.out.println("dos: llenando reporte..."); 
			JasperPrint print = JasperFillManager.fillReport( report, parameterMap, dataSource ); // ( report, new HashMap<String,Object>(), dataSource );
			System.out.println("tres: enviando reporte...");
			JasperExportManager.exportReportToPdfStream( print, outputStream );
			
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter 	= new StringWriter();
			PrintWriter printWriter 	= new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
	} // reportePruebaUnoB
	
	
	@RequestMapping(value = "/reporte_prueba_dos", method = RequestMethod.GET)
	public void reportePruebaDos(
			HttpServletResponse response
		) throws IOException {
		List<OrdenProduccionDTOAyuda> lista = calificacionService.obtieneVOPruebaJasper(1);
		try {
			
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("parametro_uno", "la pantera rosa");

			InputStream reportStream 	= context.getResourceAsStream(DIRECTORIO_ORIGEN + "Prueba_2.jasper");
			OutputStream outputStream 	= response.getOutputStream();
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			
            // parameter lleno
			JasperRunManager.runReportToPdfStream( reportStream, outputStream, parameterMap, dataSource );
			//JasperRunManager.runReportToPdfStream( reportStream, outputStream, new HashMap<String, Object>(), dataSource );
			
			response.setContentType("application/pdf");
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
	} // reportePruebaDos
	
	
	@RequestMapping(value = "/reporte_prueba_tres", method = RequestMethod.GET)
	public void reportePruebaTres(
			HttpServletResponse response
		) throws IOException {
		
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		// fecha
		SimpleDateFormat sdf = new SimpleDateFormat("'México D.F. a' dd 'de' MMMM 'de' yyyy", new Locale("es","MX"));
		parameterMap.put("parametro_uno", sdf.format( new Date( Calendar.getInstance().getTimeInMillis() ) ));
		// logo
		parameterMap.put("path_logo", context.getResource("/resources/image/logo_2.png").getPath());
		
		List<CalificacionTrabajoDetalleDTOAyuda> lista = calificacionService.obtieneEjemploVOPapel();

		try {
			// IMPORTANTE:
			// Recuerda que el codigo del servidor es diferente al codigo del proyecto. El modificar el jrxml fuente, 
			// no implica que el codigo del servidor haya cambiado. Por tanto, limpia el servidor cada ocasion 
			// que modifiques un jrxml.
			
			OutputStream outputStream 	= response.getOutputStream();
			//InputStream reportStream 	= context.getResourceAsStream( DIRECTORIO_ORIGEN + "Prueba_3.jasper" );

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			
			System.out.println("uno: cargando reporte..."); 
			JasperReport report = JasperCompileManager.compileReport( context.getResourceAsStream("/resources/jrxml/Prueba_3.jrxml") );
			System.out.println("dos: llenando reporte..."); 
			JasperPrint print = JasperFillManager.fillReport( report, parameterMap, dataSource ); // ( report, new HashMap<String,Object>(), dataSource );
			System.out.println("tres: enviando reporte...");
			JasperExportManager.exportReportToPdfStream( print, outputStream );
			
			//JasperRunManager.runReportToPdfStream( reportStream, outputStream, parameterMap, dataSource );
			
			response.setHeader("Content-Disposition", "attachment; filename=reporte_prueba_tres.pdf");
			response.setContentType("application/pdf");
			outputStream.flush();
			outputStream.close();
		} catch (JRException jre) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			jre.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		} catch( Exception e ) {
			e.printStackTrace();
		}
	} // reportePruebaTres
	
	
	@RequestMapping(value = "/reporte_frio", method = RequestMethod.GET)
	public void reporteFrio(
			HttpServletResponse response
		) throws IOException {
		
		HashMap<String, Object> parameterMap = new HashMap<String, Object>();
		// fecha
		SimpleDateFormat sdf = new SimpleDateFormat("'México D.F. a' dd 'de' MMMM 'de' yyyy", new Locale("es","MX"));
		parameterMap.put("fecha", sdf.format( new Date( Calendar.getInstance().getTimeInMillis() ) ));
		// logo
		parameterMap.put("path_logo", context.getResource("/resources/image/logo.png").getPath());
		// beans
		//List<CalificacionTrabajoDetalle> lista = calificacionService.obtieneEjemploVOPapel();

		try {
			//response.setHeader("Content-Disposition", "attachment; filename=reporte_frio.pdf");
			response.setContentType("application/pdf");
			
			OutputStream outputStream 	= response.getOutputStream();
			//InputStream reportStream 	= context.getResourceAsStream( DIRECTORIO_ORIGEN + "Prueba_3.jasper" );

			//JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			
			System.out.println("uno: cargando reporte..."); 
			JasperReport report = JasperCompileManager.compileReport( context.getResourceAsStream("/resources/jrxml/CotizacionFrio.jrxml") );
			System.out.println("dos: llenando reporte..."); 
			JasperPrint print = JasperFillManager.fillReport( report, parameterMap, new JREmptyDataSource() ); // ( report, new HashMap<String,Object>(), dataSource );
			System.out.println("tres: enviando reporte...");
			JasperExportManager.exportReportToPdfStream( print, outputStream );
			
			//JasperRunManager.runReportToPdfStream( reportStream, outputStream, parameterMap, dataSource );
			
			outputStream.flush();
			outputStream.close();
		} catch (JRException jre) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			jre.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		} catch( Exception e ) {
			e.printStackTrace();
		}
	} // reporteFrio
	
	
	@RequestMapping(value = "/subreporte", method = RequestMethod.GET)
	public void subreporte(
			HttpServletRequest request,
			HttpServletResponse response
		) throws IOException {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
	
		List<Telefono> listaTelefono1 = new ArrayList<Telefono>();
		
		Telefono telefono1 = new Telefono();
		telefono1.setTelefono("57704580");
		listaTelefono1.add(telefono1);
		
		Telefono telefono2 = new Telefono();
		telefono2.setTelefono("0445537274635");
		listaTelefono1.add(telefono2);
		
		Persona persona1 = new Persona();
		persona1.setNombrePersona("Gerardo Nieto López");
		persona1.setListaTelefono(listaTelefono1);
		
		listaPersona.add(persona1);
		
		//*****/
		List<Telefono> listaTelefono2 = new ArrayList<Telefono>();
		
		Telefono telefono3 = new Telefono();
		telefono3.setTelefono("99990909");
		listaTelefono2.add(telefono3);
		
		Telefono telefono4 = new Telefono();
		telefono4.setTelefono("45454888454");
		listaTelefono2.add(telefono4);
		
		Persona persona2 = new Persona();
		persona2.setNombrePersona("Eduardo Nieto López");
		persona2.setListaTelefono(listaTelefono2);
		
		listaPersona.add(persona2);
		
		for (Persona persona : listaPersona) {
			System.out.println( persona.getNombrePersona() );
			for (Telefono telefono : persona.getListaTelefono()) {
				System.out.println( telefono.getTelefono() );
			}
			
		}
		
		String path = request.getSession().getServletContext().getRealPath("/");
		
		try {
			
			InputStream reportStream 	= context.getResourceAsStream( DIRECTORIO_ORIGEN + "ejemploReportePadre.jasper");
			OutputStream outputStream 	= response.getOutputStream();
			
			HashMap<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("SUBREPORT_DIR", path + DIRECTORIO_ORIGEN + "ejemploReporteHijo.jasper" );

			// JREmptyDataSource dataSource = new JREmptyDataSource();
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaPersona);
			JasperRunManager.runReportToPdfStream( reportStream, outputStream, parameterMap, dataSource );

			response.setContentType("application/pdf");
			outputStream.flush();
			outputStream.close();
			
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter 	= new StringWriter();
			PrintWriter printWriter 	= new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}
	}
}
