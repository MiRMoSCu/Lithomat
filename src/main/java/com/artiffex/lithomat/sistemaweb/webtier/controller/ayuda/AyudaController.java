package com.artiffex.lithomat.sistemaweb.webtier.controller.ayuda;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AyudaController {

	// PRUEBAS

	@RequestMapping(value = "/tabla", method = RequestMethod.GET)
	public String tabla() {
		return "_ayuda/tabla";
	}

	@RequestMapping(value = "/pagina_muestra", method = RequestMethod.GET)
	public String prueba() {
		return "_ayuda/pagina_muestra";
	}

	@RequestMapping(value = "upload_file_example", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request,HttpServletResponse response) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			ServletFileUpload uploader = new ServletFileUpload(
					new DiskFileItemFactory());
			uploader.setSizeMax(104857600); // 1024 * 1024 * 100
			try {
				List<FileItem> fileItemsList = uploader.parseRequest(request);
				Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
				while (fileItemsIterator.hasNext()) {
					FileItem item = fileItemsIterator.next();
					if (item.isFormField()) {
						System.out.println("FieldName = " + item.getFieldName());
						System.out.println("Value = " + item.getString());
					} else {
						System.out.println("FieldName = " + item.getFieldName());
						System.out.println("FileName = " + item.getName());
						System.out.println("ContentType = " + item.getContentType());
						System.out.println("Size in bytes = " + item.getSize());
						System.out.println();
					}
				}
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return String.valueOf(HttpServletResponse.SC_OK);
		/*
		 * if( !file.isEmpty() ) { try { byte[] bytes = file.getBytes();
		 * System.out.println( bytes.toString() ); } catch( IOException e ) {
		 * e.printStackTrace(); } return "ok"; } else { return "failure"; }
		 */

	}// uploadFIle

	@RequestMapping(value = "reenvio_pagina_prueba", method = RequestMethod.GET)
	// es GET porque Shadowbox no abre paginas con metodo POST
	public String prueba(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("entro a reenvio_pagina_prueba()");
		return "cotizador/untitled1";
	}// prueba

	@RequestMapping(value = "prueba_actualizacion", method = RequestMethod.POST)
	public void pruebaActualizacion(
						@RequestParam(value = "texto", required = false) String texto,
						HttpServletRequest request, HttpServletResponse response
					) {
		System.out.println();
		System.out.println("entro a prueba_actualizacion()");
		System.out.println("texto: " + texto);
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>Hola, esto es del servidor</h1>");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// pruebaAcrualizacion

	public String regresaJesonString() {
		// ES POSIBLE REGRESAR UNA CADENA CON FORMATO JSON AL CLIENTE, SU FORMA
		// DEBE SER:

		// String stringJson =
		// "{\"nombre\":\"gerardo nieto lopez\", \"edad\":\"29\", \"nacionalidad\":\"mexicana\"}";
		// String stringJson = "{"estatusOperacion":"1"}";
		return "{\"estatusOperacion\":\"1\"}";
	}// regresaJesonString
	
	@RequestMapping(value = "/modificar_tabla_boton", method = RequestMethod.GET)
	public String modificarTablaBoton() {
		return "_ayuda/modificar_tabla_con_boton";
	}

} // AyudaController
