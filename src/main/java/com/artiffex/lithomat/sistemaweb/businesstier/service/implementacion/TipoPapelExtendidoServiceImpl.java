package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoPapelExtendidoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPapelExtendidoDAO;

@Service("tipoPapelExtendidoService")
public class TipoPapelExtendidoServiceImpl implements TipoPapelExtendidoService {
	
	@Resource
	private TipoPapelExtendidoDAO tipoPapelExtendidoDAO;

	public void creaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido) {
		tipoPapelExtendidoDAO.crea(tipoPapelExtendido);
	}
	
	public TipoPapelExtendido buscaTipoPapelExtendido(int idTipoPapelExtendido) {
		return tipoPapelExtendidoDAO.busca(idTipoPapelExtendido);
	}

	public void modificaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido) {
		tipoPapelExtendidoDAO.modifica(tipoPapelExtendido);
	}

	public List<TipoPapelExtendido> listaTipoPapelExtendido() {
		return tipoPapelExtendidoDAO.lista();
	}
	
	public int obtieneNumeroTipoPapelExtendidoPorParematros(
			boolean busquedaPorNombre, 
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos, 
			boolean busquedaPorAncho,
			boolean busquedaPorAlto, 
			boolean busquedaPorProveedor,
			String nombre, 
			Integer gramaje, 
			Float kilogramos, 
			Float ancho,
			Float alto, 
			Integer idProveedorPapel ) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT COUNT(*)");
		query.append(" ");
		query.append("FROM tipo_papel_extendido tpe");
		query.append(" ");
		query.append("WHERE");
		query.append(" ");
		
		if( busquedaPorNombre ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.nombre LIKE '%");
			query.append(nombre);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorGramaje ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.gramaje = ");
			query.append(gramaje);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorKilogramos ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.kilogramos = ");
			query.append(kilogramos);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorAncho ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.ancho = ");
			query.append(ancho);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorAlto ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.alto = ");
			query.append(alto);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorProveedor ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("id_proveedor_papel = ");
			query.append(idProveedorPapel);
			query.append(" ");
			existeParametro = true;
		}
		
		if( existeParametro )
			query.append("AND tpe.activo = TRUE; ");
		else
			query.append("tpe.activo = TRUE; ");
		
		int numRegistros = tipoPapelExtendidoDAO.numeroTipoPapelExtendido( query.toString() );
		
		query = null;
		
		return numRegistros;
	}
	
	public List<TipoPapelExtendido> listaTipoPapelExtendidoPorParametrosPorNumeroPagina(
			boolean busquedaPorNombre, 
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos, 
			boolean busquedaPorAncho,
			boolean busquedaPorAlto, 
			boolean busquedaPorProveedor,
			String nombre, 
			Integer gramaje, 
			Float kilogramos, 
			Float ancho,
			Float alto, 
			Integer idProveedorPapel, 
			int numeroPagina,
			int numeroRegistrosPorPagina ) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT *");
		query.append(" ");
		query.append("FROM tipo_papel_extendido tpe");
		query.append(" ");
		query.append("WHERE");
		query.append(" ");
		
		if( busquedaPorNombre ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.nombre LIKE '%");
			query.append(nombre);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorGramaje ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.gramaje = ");
			query.append(gramaje);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorKilogramos ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.kilogramos = ");
			query.append(kilogramos);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorAncho ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.ancho = ");
			query.append(ancho);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorAlto ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("tpe.alto = ");
			query.append(alto);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorProveedor ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("id_proveedor_papel = ");
			query.append(idProveedorPapel);
			query.append(" ");
			existeParametro = true;
		}
		
		if( existeParametro )
			query.append("AND tpe.activo = TRUE");
		else
			query.append("tpe.activo = TRUE");
		
		query.append(" ");
		query.append("ORDER BY id_tipo_papel_extendido ASC");
		query.append(" ");
		query.append("LIMIT");
		query.append(" ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		System.out.println(query.toString());
		
		List<TipoPapelExtendido> lista = tipoPapelExtendidoDAO.listaPorRango( query.toString() );
		
		query = null;
		
		return lista;
	}
	
	public List<TipoPapelExtendidoDTO> listaTipoPapelExtendidoPorParametrosPorNumeroPaginaEnDTO(
			boolean busquedaPorNombre, 
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos, 
			boolean busquedaPorAncho,
			boolean busquedaPorAlto, 
			boolean busquedaPorProveedor,
			String nombre, 
			Integer gramaje, 
			Float kilogramos, 
			Float ancho,
			Float alto, 
			Integer idProveedorPapel, 
			int numeroPagina,
			int numeroRegistrosPorPagina ) {
		
		List<TipoPapelExtendido> listaTipoPapelExtendido = listaTipoPapelExtendidoPorParametrosPorNumeroPagina(busquedaPorNombre, busquedaPorGramaje, busquedaPorKilogramos, busquedaPorAncho, busquedaPorAlto, busquedaPorProveedor, nombre, gramaje, kilogramos, ancho, alto, idProveedorPapel, numeroPagina, numeroRegistrosPorPagina);
		
		List<TipoPapelExtendidoDTO> listaClienteDTO = new ArrayList<TipoPapelExtendidoDTO>();
		for (TipoPapelExtendido tipoPapelExtendido : listaTipoPapelExtendido) {
			TipoPapelExtendidoDTO tpeDTO = new TipoPapelExtendidoDTO();
			tpeDTO.setIdTipoPapelExtendido( tipoPapelExtendido.getIdTipoPapelExtendido() );
			tpeDTO.setRazonSocial( tipoPapelExtendido.getProveedorPapel().getRazonSocial() );
			tpeDTO.setNombre( tipoPapelExtendido.getNombre() );
			tpeDTO.setGramaje( tipoPapelExtendido.getGramaje() );
			tpeDTO.setKilogramos( tipoPapelExtendido.getKilogramos() );
			tpeDTO.setAlto( tipoPapelExtendido.getAlto() );
			tpeDTO.setAncho( tipoPapelExtendido.getAncho() );
			tpeDTO.setDescripcion( tipoPapelExtendido.getDescripcion()==null?"":tipoPapelExtendido.getDescripcion() );
			tpeDTO.setPrecio( tipoPapelExtendido.getPrecio() );
			tpeDTO.setNombrePrecio( tipoPapelExtendido.getTipoPrecio().getNombre() );
			listaClienteDTO.add(tpeDTO);
			tpeDTO 				= null;
			tipoPapelExtendido 	= null;
		}
		listaTipoPapelExtendido = null;
		
		return listaClienteDTO;
	}
	
	public String listaHTMLTipoPapelExtendidoPorConsulta(ParametrosBusquedaTipoPapelExtendido parametros) {
		
		StringBuilder query = new StringBuilder();
		query.append("from TipoPapelExtendido tpe ");
		query.append("where tpe.activo = true ");
		if( parametros.isBusquedaPorNombre() )
			query.append("and tpe.nombre like concat('%', :nombrePapel ,'%') ");
		if( parametros.isBusquedaPorAncho() )
			query.append("and tpe.ancho = :ancho ");
		if( parametros.isBusquedaPorAlto() )
			query.append("and tpe.alto = :alto ");
		if( parametros.isBusquedaPorGramaje() )
			query.append("and tpe.gramaje = :gramaje ");
		if( parametros.isBusquedaPorKilogramos() )
			query.append("and tpe.kilogramos = :kilogramos ");
		if( parametros.isBusquedaPorProveedor() )
			query.append("and tpe.proveedorPapel.idProveedorPapel = :idProveedorPapel ");
		query.append("order by tpe.proveedorPapel.idProveedorPapel asc, tpe.nombre asc, tpe.gramaje asc, tpe.kilogramos asc");
		
		List<TipoPapelExtendido> lista = tipoPapelExtendidoDAO.listaPorQuery(query.toString(), parametros);
		
		query = null;
		StringBuilder html = new StringBuilder();
		
		html.append("<table id=\"tabla_tipo_papel_extendido\">");
		html.append("<tr>");
		html.append("<th>Id.</th>");
		html.append("<th>Proveedor</th>");
		html.append("<th>Nombre</th>");
		html.append("<th>Gramaje</th>");
		html.append("<th>Kilogramos</th>");
		html.append("<th>Alto</th>");
		html.append("<th>Ancho</th>");
		html.append("<th>Precio</th>");
		html.append("<th>Unidad</th>");
		html.append("</tr>");
		
		int cont = 0;
		if( lista.size() > 0 ) {
			for (TipoPapelExtendido tipoPapelExtendido : lista) {
				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("' ");
				html.append("onclick='setCamposTipoPapelExtendido("
						+ "&#39;" + tipoPapelExtendido.getIdTipoPapelExtendido() + "&#39;,"
						+ "&#39;" + tipoPapelExtendido.getProveedorPapel().getRazonSocial() + "&#39;,"
						+ "&#39;" + tipoPapelExtendido.getNombre() + "&#39;,"
						+ "&#39;" + tipoPapelExtendido.getGramaje() + "&#39;,"
						+ "&#39;" + tipoPapelExtendido.getKilogramos() + "&#39;,"
						+ "&#39;" + (int)tipoPapelExtendido.getAlto() + "&#39;,"
						+ "&#39;" + (int)tipoPapelExtendido.getAncho() + "&#39;,"
						+ "&#39;" + tipoPapelExtendido.getPrecio() + "&#39;"
						+ ");'");
				html.append("ondblclick=\"this.click(); window.parent.Shadowbox.close();\"");
				html.append(">");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getIdTipoPapelExtendido());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getProveedorPapel().getRazonSocial());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getNombre());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getGramaje());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getKilogramos());
				html.append("</td>");
				
				html.append("<td>");
				html.append((int)tipoPapelExtendido.getAlto());
				html.append("</td>");
				
				html.append("<td>");
				html.append((int)tipoPapelExtendido.getAncho());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getPrecio());
				html.append("</td>");
				
				html.append("<td>");
				html.append(tipoPapelExtendido.getTipoPrecio().getNombre());
				html.append("</td>");
				
				cont++;
				tipoPapelExtendido = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");
			// id
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// proveedor
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// nombre
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// gramaje
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// kilogramos
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// alto
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// ancho
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// precio
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
			// unidad
			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}
		html.append("</table");
		
		return html.toString();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoPapelExtendido> listaTipoPapelExtendido = tipoPapelExtendidoDAO.lista();
		for (TipoPapelExtendido tipoPapelExtendido : listaTipoPapelExtendido) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoPapelExtendido.getIdTipoPapelExtendido());
			StringBuffer sb = new StringBuffer();
			sb.append(tipoPapelExtendido.getNombre());
			sb.append(" ");
			sb.append(tipoPapelExtendido.getGramaje());
			sb.append(" gr. ");
			sb.append((int)tipoPapelExtendido.getAlto());
			sb.append(" x ");
			sb.append((int)tipoPapelExtendido.getAncho());
			sb.append(" cm. (");
			sb.append(tipoPapelExtendido.getKilogramos());
			sb.append(" kg.) ($");
			sb.append(tipoPapelExtendido.getPrecio());
			sb.append(") [");
			sb.append(tipoPapelExtendido.getProveedorPapel().getRazonSocial());
			sb.append("]");
			comboSelect.setText(sb.toString());
			listaComboSelect.add(comboSelect);
			sb = null;
			comboSelect = null;
			tipoPapelExtendido = null;
		}
		listaTipoPapelExtendido = null;
		return listaComboSelect;
	}

	public byte[] obtieneExcelListaTipoPapelExtendido() {
		// generacion del excel
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			// estilos
				// alineacion centro
			HSSFCellStyle cellStyle_centro = wb.createCellStyle();
			cellStyle_centro.setAlignment((short)HSSFCellStyle.ALIGN_CENTER);
			
			// crecion de la hoja
			HSSFSheet sheet = wb.createSheet("Papel");
			// creacion de fila 1
			HSSFRow row = sheet.createRow(0);
			// creacion de celdas fila 1
				// celda A (0)
			HSSFCell cell_id = row.createCell(0);
			cell_id.setCellValue("ID");
	        cell_id.setCellStyle(cellStyle_centro);
	        	// celda B (1)
	        HSSFCell cell_proveedor = row.createCell(1);
	        cell_proveedor.setCellValue("PROVEEDOR");
	        cell_proveedor.setCellStyle(cellStyle_centro);
	        	// celda C (2)
	        HSSFCell cell_nombre = row.createCell(2);
	        cell_nombre.setCellValue("NOMBRE");
	        cell_nombre.setCellStyle(cellStyle_centro);
	        	// celda D (3)
	        HSSFCell cell_gramaje = row.createCell(3);
	        cell_gramaje.setCellValue("GRAMAJE");
	        cell_gramaje.setCellStyle(cellStyle_centro);
	        	// celda E (4)
	        HSSFCell cell_kilogramos = row.createCell(4);
	        cell_kilogramos.setCellValue("KILOGRAMOS");
	        cell_kilogramos.setCellStyle(cellStyle_centro);
	    		// celda G (5)
	        HSSFCell cell_alto = row.createCell(5);
	        cell_alto.setCellValue("ALTO");
	        cell_alto.setCellStyle(cellStyle_centro);
	        	// celda F (6)
	        HSSFCell cell_ancho = row.createCell(6);
	        cell_ancho.setCellValue("ANCHO");
	        cell_ancho.setCellStyle(cellStyle_centro);
	        	// celda H (7)
	        HSSFCell cell_precio = row.createCell(7);
	        cell_precio.setCellValue("PRECIO");
	        cell_precio.setCellStyle(cellStyle_centro);
	        	// celda I (8)
	        HSSFCell cell_unidad = row.createCell(8);
	        cell_unidad.setCellValue("UNIDAD");
	        cell_unidad.setCellStyle(cellStyle_centro);
	        
	        // obtencion de la lista
	        int cont = 1;
			List<TipoPapelExtendido> listaPapelExcel = tipoPapelExtendidoDAO.lista();
			for (TipoPapelExtendido tipoPapelExtendido : listaPapelExcel) {
				// creacion de fila
				row = sheet.createRow(cont);
				row.createCell(0).setCellValue( tipoPapelExtendido.getIdTipoPapelExtendido() );
				row.createCell(1).setCellValue( tipoPapelExtendido.getProveedorPapel().getRazonSocial() );
				row.createCell(2).setCellValue( tipoPapelExtendido.getNombre() );
				row.createCell(3).setCellValue( tipoPapelExtendido.getGramaje() );
				row.createCell(4).setCellValue( tipoPapelExtendido.getKilogramos() );
				row.createCell(5).setCellValue( tipoPapelExtendido.getAlto() );
				row.createCell(6).setCellValue( tipoPapelExtendido.getAncho() );
				row.createCell(7).setCellValue( tipoPapelExtendido.getPrecio() );
				row.createCell(8).setCellValue( tipoPapelExtendido.getTipoPrecio().getNombre() );
				cont++;
			}
			
			wb.close();
		} catch( Exception e ) {
			System.out.println("obtieneExcelListaTipoPapelExtendido:Error al generar el archivo de excel");
		}
		
		// creacion del stream
		ByteArrayOutputStream os;
		try {
			os = new ByteArrayOutputStream();
			wb.write(os);
			return os.toByteArray();
		} catch( Exception e ) {
			System.out.println("obtieneExcelListaTipoPapelExtendido:Error al convertir a stream");
			e.printStackTrace();
			return null;
		}
	}

	public void cargaExcel(String path) {
		if( path.equals("") ) {
			System.out.println("No existe archivo que leer");
			//return 0;
		}
		else {
			// lee archivo con POI
			//System.out.println( "path:" + path );
			try {
				FileInputStream fis = new FileInputStream( new File(path) );
				// Get the workbook instance for XLS file 
	            HSSFWorkbook workbook = new HSSFWorkbook(fis);
	            // Get first sheet from the workbook
	            HSSFSheet sheet = workbook.getSheetAt(0);
	            // Iterate through each rows from first sheet
	            Iterator<Row> rowIterator = sheet.iterator();
	            while(rowIterator.hasNext()) {
	            	Row row = rowIterator.next();
	            	/*
	                //For each row, iterate through each columns, NO BORRAR
	                Iterator<Cell> cellIterator = row.cellIterator();
	                while(cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
	                    switch(cell.getCellType()) {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.print(cell.getBooleanCellValue() + "\t\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "\t\t");
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            System.out.print(cell.getStringCellValue() + "\t\t");
	                            break;
	                    }
	                }
	                System.out.println();
	                */
	                
	            	if( row.getRowNum() == 0 ) // primer linea es encabezado
	            		continue;
	            	
	                Cell cell = row.getCell(0);
	                int idTipoPapelExtendido = (int)cell.getNumericCellValue();
	                
	                cell = row.getCell(7);
	                float precio = (float)cell.getNumericCellValue();
	                
	                TipoPapelExtendido tipoPapelExtendido = tipoPapelExtendidoDAO.busca(idTipoPapelExtendido);
	                tipoPapelExtendido.setPrecio(precio);
	                
	                tipoPapelExtendidoDAO.modifica(tipoPapelExtendido);
	                
	                tipoPapelExtendido = null;
	            }
	            workbook.close();
	            fis.close();
	            
	            // FileOutputStream out = new FileOutputStream(new File("C:\\test.xls"));
	            // workbook.write(out);
	            // out.close();
	            //return 1;
			} catch( Exception e ) {
				e.printStackTrace();
				//return -1;
			}
		}
	}

}
