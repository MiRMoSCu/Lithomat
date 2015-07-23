package com.artiffex.lithomat.sistemaweb.ayuda;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion.EstatusOrdenDaoImpl;


public class Ayuda {

	private static final Logger log = Logger.getLogger(Ayuda.class);
	
	public static void main(String args[]) {
		
		try {
			File file = new File("hola");
			System.out.println(file.getAbsolutePath());
			
			Properties props = new Properties();
			props.load(new FileInputStream("WebContent/WEB-INF/config/log4j.properties"));
			PropertyConfigurator.configure(props);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		log.info("esta vivo");
		
		
		
		EstatusOrdenDaoImpl estatusOrdenDao = new EstatusOrdenDaoImpl();
		List<EstatusOrden> listaEstatusOrden = estatusOrdenDao.lista();
		for (EstatusOrden estatusOrden : listaEstatusOrden) {
			System.out.print(estatusOrden.getIdEstatusOrden() + "\t");
			System.out.println(estatusOrden.getNombre() + "\t");
		}
		System.out.println();
		
		/*
		HistorialEstatusDaoImpl historialEstatusDao = new HistorialEstatusDaoImpl();
		List<HistorialEstatus> listaHistorialEstatus = historialEstatusDao.lista(1);
		for (HistorialEstatus historialEstatus : listaHistorialEstatus) {
			System.out.println(historialEstatus.getIdHistorialEstatus());
			System.out.println(historialEstatus.getFecha());
			System.out.println(historialEstatus.getOrdenProduccion().getIdOrdenProduccion());
			System.out.println(historialEstatus.getOrdenProduccion().getNut());
			System.out.println(historialEstatus.getEstatusOrden().getNombre());
			System.out.println();
		}
		*/
		
		
		/*
		OrdenProduccionDaoImpl ordenProduccionDaoImpl = new OrdenProduccionDaoImpl();
		List<OrdenProduccion> listaOP = ordenProduccionDaoImpl.lista();
		for (OrdenProduccion ordenProduccion : listaOP) {
			System.out.print(ordenProduccion.getIdOrdenProduccion() + "\t");
			System.out.print(ordenProduccion.getNut() + "\t");
			System.out.print(ordenProduccion.getNombre() + "\t");
			System.out.print(ordenProduccion.getCliente().getNombreMoral() + "\t");
			System.out.print(ordenProduccion.getCliente().getTipoCliente().getClave() + "\t");
			System.out.println(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getNombre() + "\t");
		}
		System.out.println();
		*/
		
		
		/*
		TipoComprobanteFiscalDaoImpl tipoComprobanteFiscalDao = new TipoComprobanteFiscalDaoImpl();
		List<TipoComprobanteFiscal> listaTipoComprobanteFiscalDao = tipoComprobanteFiscalDao.lista();
		for (TipoComprobanteFiscal tipoComprobanteFiscal : listaTipoComprobanteFiscalDao) {
			System.out.print(tipoComprobanteFiscal.getIdTipoComprobanteFiscal() + "\t");
			System.out.print(tipoComprobanteFiscal.getNombre() + "\t");
			System.out.println(tipoComprobanteFiscal.getTipoPrecio().getDescripcion());
		}
		*/
		
		
		/*
		ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		List<Cliente> listaCliente = clienteDao.lista();
		for (Cliente cliente : listaCliente) {
		System.out.print(cliente.getIdCliente() + "\t");
		System.out.print(cliente.getNombreMoral() + "\t");
		System.out.print(cliente.getTipoCliente().getClave() + "\t");
		System.out.println(cliente.getTipoCliente().getDescripcion() + "\t");
		}
		System.out.println();
		*/
		
		
		
		/*
		TipoClienteDaoImpl tipoClienteDao = new TipoClienteDaoImpl();
		List<TipoCliente> listaTipoCliente = null;
		
		listaTipoCliente = tipoClienteDao.lista();
		for (TipoCliente tipoCliente : listaTipoCliente) {
			System.out.print( tipoCliente.getIdTipoCliente() + "\t" );
			System.out.print( tipoCliente.getClave() + "\t" );
			System.out.print( tipoCliente.getTipoPrecio().getIdTipoPrecio() + "\t" );
			System.out.println( tipoCliente.getTipoPrecio().getNombre() );
		}
		System.out.println();
		TipoCliente tipoCliente = new TipoCliente();
		tipoCliente.setClave("ZZZ");
		tipoCliente.setDescripcion("zzzz");
		tipoCliente.setPrecio(81);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(2);
		tipoCliente.setTipoPrecio(tipoPrecio);
		tipoCliente.setActivo(true);

		int resultado = tipoClienteDao.crea(tipoCliente);
		System.out.println("tipo cliente creado" + resultado);
		System.out.println();
		
		listaTipoCliente = tipoClienteDao.lista();
		for (TipoCliente tipoCliente2 : listaTipoCliente) {
			System.out.print( tipoCliente2.getIdTipoCliente() + "\t" );
			System.out.print( tipoCliente2.getClave() + "\t" );
			System.out.print( tipoCliente2.getTipoPrecio().getIdTipoPrecio() + "\t" );
			System.out.println( tipoCliente2.getTipoPrecio().getNombre() );
		}
		System.out.println();
		*/

		
		
		
		
		
		/*
		// ***************************************************************************
		// EXCEL
		
		try {
			System.out.println("entro al try de generacion de excel");
			
			HSSFWorkbook wb = new HSSFWorkbook();
			
	       
			// Create a row and put some cells in it. Rows are 0 based.
	        //HSSFRow row = sheet.createRow(0);
	        // Create a cell and put a value in it.
	        //HSSFCell cell = row.createCell(0);
	        //cell.setCellValue(1);

	        // Or do it on one line.
	        //row.createCell(1).setCellValue(1.2);
	        //row.createCell(2).setCellValue("This is a string");
	        //row.createCell(3).setCellValue(true);
		
			
			// ESTILO ALINEACION CENTRO
			HSSFCellStyle cellStyle_centro = wb.createCellStyle();
			cellStyle_centro.setAlignment((short)HSSFCellStyle.ALIGN_CENTER);
	        
	        // ESTILO QUITAR PROTECCION
			//HSSFCellStyle cellStyle_protegida = wb.createCellStyle();
			//cellStyle_protegida.setLocked(false);
	        
			// CREACION DE HOJA
			HSSFSheet sheet = wb.createSheet("Papel");
			
			// PROTEGE LA HOJA
			//sheet.protectSheet("password");
			
			// CREACION DE FILA	
			HSSFRow row = sheet.createRow(0);
			
			// CREACION DE CELDAS
			HSSFCell cell_id = row.createCell(0);
			cell_id.setCellValue("ID");
	        cell_id.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_proveedor = row.createCell(1);
	        cell_proveedor.setCellValue("PROVEEDOR");
	        cell_proveedor.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_nombre = row.createCell(2);
	        cell_nombre.setCellValue("NOMBRE");
	        cell_nombre.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_gramaje = row.createCell(3);
	        cell_gramaje.setCellValue("GRAMAJE");
	        cell_gramaje.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_kilogramos = row.createCell(4);
	        cell_kilogramos.setCellValue("KILOGRAMOS");
	        cell_kilogramos.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_ancho = row.createCell(5);
	        cell_ancho.setCellValue("ANCHO");
	        cell_ancho.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_alto = row.createCell(6);
	        cell_alto.setCellValue("ALTO");
	        cell_alto.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_precio = row.createCell(7);
	        cell_precio.setCellValue("PRECIO");
	        cell_precio.setCellStyle(cellStyle_centro);
	        
	        HSSFCell cell_unidad = row.createCell(8);
	        cell_unidad.setCellValue("UNIDAD");
	        cell_unidad.setCellStyle(cellStyle_centro);
	        
			//row.createCell(0).setCellValue("ID");
			//row.createCell(1).setCellValue("PROVEEDOR");
			//row.createCell(2).setCellValue("NOMBRE");
			//row.createCell(3).setCellValue("GRAMAJE");
			//row.createCell(4).setCellValue("KILOGRAMOS");
			//row.createCell(5).setCellValue("ANCHO");
			//row.createCell(6).setCellValue("ALTO");
			//row.createCell(7).setCellValue("PRECIO");
			//row.createCell(8).setCellValue("UNIDAD");
			
			
			
			
			
			
			FileOutputStream fileOut = new FileOutputStream("/Users/Gera/Desktop/workbook.xls");
			
			wb.write(fileOut);
			wb.close();
			fileOut.close();
			System.out.println("termino");
		} catch( Exception e ) {
			e.printStackTrace();
			System.out.println("entro al catch");
		}
		
		*/

		// ***************************************************************************/
		// USO DE GSON

		//CalificacionOrdenProduccion cop = new CalificacionOrdenProduccion();

		//Gson gson = new Gson();
		//String json1 = gson.toJson(cop);

		//System.out.println(json1);
		//System.out.println();

		//CalificacionTrabajoDetalle ctd = new CalificacionTrabajoDetalle();
		//ctd.setId_calificacion_trabajo_detalle(1);
		//ctd.setId_tipo_trabajo_detalle(1);
		//ctd.setId_maquina(1);
		//ctd.setCantidad_original(1000);
		//ctd.setCantidad_redondeada(1000);
		//ctd.setPrecio_unitario_tabulador(10.5f);

		//ArrayList<CalificacionTrabajoDetalle> lista = new ArrayList<CalificacionTrabajoDetalle>();
		//lista.add(ctd);
		//lista.add(ctd);

		//String json2 = gson.toJson(lista);

		//System.out.println(json2);

		// ***************************************************************************/

		// REDONDEO

		// int cantidad_original = 53100; //185; //53350;
		// int num_millares_redondeado = 0;

		// int cociente = cantidad_original / 1000;
		// double cociente_double = (double)cantidad_original / 1000;
		// int residuo = cantidad_original % 1000;

		// System.out.println("cantidad: " + cantidad_original);
		// System.out.println("cociente: " + cociente);
		// System.out.println("cociente_double: " + cociente_double);
		// System.out.println("residuo: " + residuo);
		// System.out.println();
		// System.out.println("calculando millares redondeado");

		// if( cantidad_original <= 300 )
		// num_millares_redondeado = 1 * 1000;
		// if( residuo > 300 )
		// num_millares_redondeado = ((cantidad_original / 1000) + 1) * 1000;
		// else
		// num_millares_redondeado = (cantidad_original / 1000) * 1000;

		// System.out.println("num_millares_redondeado: " +
		// num_millares_redondeado);

		// ***************************************************************************/
		// IDENTIFICACION DE CARACTERES DE CADENAS

		// String tintaFrente = "CMY";
		// String tintaVuelta = "C";

		// System.out.println("tinta_frente:" + tintaFrente);
		// System.out.println("tinta_vuelta:" + tintaVuelta);

		// StringBuilder cadenaFinal = new StringBuilder();

		// se copia toda la cadena uno
		// for( int i=0; i<tintaFrente.length(); i++ ) {
		// try {
		// System.out.println( tintaFrente.charAt( i ) );
		// cadenaFinal.append( tintaFrente.charAt( i ) );
		// } catch( Exception e ) {
		// e.printStackTrace();
		// }
		// }
		// System.out.println();
		// for( int i=0; i<tintaVuelta.length(); i++ ) {
		// try {
		// System.out.println( tintaVuelta.charAt( i ) );
		// if( cadenaFinal.toString().indexOf( tintaVuelta.charAt( i ) ) == -1 )
		// // no existe esa tinta
		// cadenaFinal.append( tintaVuelta.charAt( i ) );
		// } catch( Exception e ) {
		// e.printStackTrace();
		// }
		// }

		// System.out.println("cadena final = " + cadenaFinal.toString());
		// System.out.println("cadena length = " + cadenaFinal.length());

		// ***************************************************************************/
		// LECTURA DE ARCHIVO DE CONFIGURACION

		// Properties propiedades = new Properties();
		// try {
		// File f = new File("ruta.txt"); // Creamos un objeto file
		// System.out.println(f.getAbsolutePath()); // Llamamos al m�todo que
		// devuelve la ruta absoluta
		// propiedades.load( new
		// FileInputStream("public_html/WEB-INF/conf_parametros.properties") );
		// String numero_filas =
		// propiedades.getProperty("database.max_registros_pagina");
		// System.out.println("numero_filas: " + numero_filas);
		// } catch( Exception e ) {
		// e.printStackTrace();
		// }

		// ***************************************************************************/
		// JSON MANUAL NO BORRAR

		// JSONParser parser = new JSONParser();

		// try {
		// String json =
		// "{\"arreglo\":[{\"name\":\"Gerardo\",\"calle\":\"azucenas\",\"numero\":25},{\"name\":\"Sarah\",\"calle\":\"rue de prevoyants\",\"numero\":25},{\"name\":\"Lucia\",\"calle\":\"camarones\",\"numero\":109}]}";
		// Object obj = parser.parse( json );
		// JSONObject jsonObject = (JSONObject) obj;
		// JSONArray arreglo = (JSONArray) jsonObject.get("arreglo");
		// Iterator iterator = arreglo.iterator();

		// while( iterator.hasNext() ) {
		// System.out.println( iterator.next() );
		// JSONObject jsonObject_2 = (JSONObject) iterator.next();
		// System.out.println("name: " + jsonObject_2.get("name") );
		// System.out.println("calle: " + jsonObject_2.get("calle"));
		// System.out.println("numero: " + jsonObject_2.get("numero"));
		// System.out.println();
		// }
		// } catch( Exception e ) {
		// e.printStackTrace();
		// }

		// System.out.println("<table width=\"100%\"></table>");

		// String cadena = "cadenita";
		// StringBuilder html = new StringBuilder();

		// html.append("<table width=\"100%\" align=\"left\" border=\"0\"" +
		// cadena + ">");
		// html.append("<a href=\"javascript:descargarDocumento('documentoAyuda',"
		// + cadena + ")\">");
		// System.out.println( html.toString() );
		// ***************************************************************************/

	}

}
