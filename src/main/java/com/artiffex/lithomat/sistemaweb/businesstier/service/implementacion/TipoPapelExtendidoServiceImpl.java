package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaTipoPapelExtendido parametros) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append(" SELECT COUNT(*) ");
		query.append(" FROM tipo_papel_extendido tpe ");
		query.append(" WHERE ");
		
		if( parametros.isBusquedaPorNombre() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("tpe.nombre LIKE '%");
			query.append(parametros.getNombrePapel());
			query.append("%'");
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorGramaje() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("tpe.gramaje = ");
			query.append(parametros.getGramaje());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorKilogramos() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("tpe.kilogramos = ");
			query.append(parametros.getKilogramos());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorAncho() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("tpe.ancho = ");
			query.append(parametros.getAncho());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorAlto() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("tpe.alto = ");
			query.append(parametros.getAlto());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorProveedor() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("id_proveedor_papel = ");
			query.append(parametros.getIdProveedorPapel());
			existeParametro = true;
		}
		
		if( existeParametro )
			query.append(" AND ");
			
		query.append(" tpe.activo = TRUE; ");
		int numRegistros = tipoPapelExtendidoDAO.numeroRegistros(query.toString());
		
		query = null;
		
		return numRegistros;
	}
	
	public List<TipoPapelExtendidoDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaTipoPapelExtendido parametros, int numeroPagina, int numeroRegistrosPorPagina ) {
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    tpe.id_tipo_papel_extendido idTipoPapelExtendido,");
		query.append("    pp.razon_social razonSocial,");
		query.append("    tpe.nombre,");
		query.append("    tpe.gramaje,");
		query.append("    tpe.kilogramos,");
		query.append("    tpe.alto,");
		query.append("    tpe.ancho,");
		query.append("    tpe.descripcion,");
		query.append("    tpe.precio,");
		query.append("    tp.nombre nombrePrecio");
		query.append(" FROM");
		query.append("    tipo_papel_extendido tpe,");
		query.append("    proveedor_papel pp,");
		query.append("    tipo_precio tp");
		query.append(" WHERE");
		
		if( parametros.isBusquedaPorNombre() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("    tpe.nombre LIKE '%");
			query.append(parametros.getNombrePapel());
			query.append("%'");
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorGramaje() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("        tpe.gramaje = ");
			query.append(parametros.getGramaje());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorKilogramos() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("        tpe.kilogramos = ");
			query.append(parametros.getKilogramos());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorAncho() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("        tpe.ancho = ");
			query.append(parametros.getAncho());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorAlto() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("        tpe.alto = ");
			query.append(parametros.getAlto());
			existeParametro = true;
		}
		
		if( parametros.isBusquedaPorProveedor() ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("        tpe.id_proveedor_papel = ");
			query.append(parametros.getIdProveedorPapel());
			existeParametro = true;
		}
		
		if( existeParametro )
			query.append(" AND ");
		
		query.append("        tpe.activo = TRUE");
		query.append("        AND pp.id_proveedor_papel = tpe.id_proveedor_papel");
		query.append("        AND tp.id_tipo_precio = tpe.id_tipo_precio");
		query.append(" ORDER BY id_tipo_papel_extendido ASC");
		query.append(" LIMIT ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		//System.out.println(query.toString());
		
		List<TipoPapelExtendidoDTO> lista = tipoPapelExtendidoDAO.listaPorCriteriosBusqueda( query.toString() );
		
		query = null;
		
		return lista;
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
		
		DecimalFormat formato = new DecimalFormat("#,##0.00");
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
				html.append(formato.format(tipoPapelExtendido.getPrecio()));
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
		
		formato = null;
		
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
		SXSSFWorkbook wb = new SXSSFWorkbook();
		try {
			// estilos
				// alineacion centro
			CellStyle cellStyle_centro = wb.createCellStyle();
			cellStyle_centro.setAlignment((short)CellStyle.ALIGN_CENTER);
			
			// crecion de la hoja
			Sheet sheet = wb.createSheet("Papel");
			// creacion de fila 1
			Row row = sheet.createRow(0);
			// creacion de celdas fila 1
				// celda A (0)
			Cell cell_id = row.createCell(0);
			cell_id.setCellValue("ID");
	        cell_id.setCellStyle(cellStyle_centro);
	        	// celda B (1)
	        Cell cell_proveedor = row.createCell(1);
	        cell_proveedor.setCellValue("PROVEEDOR");
	        cell_proveedor.setCellStyle(cellStyle_centro);
	        	// celda C (2)
	        Cell cell_nombre = row.createCell(2);
	        cell_nombre.setCellValue("NOMBRE");
	        cell_nombre.setCellStyle(cellStyle_centro);
	        	// celda D (3)
	        Cell cell_gramaje = row.createCell(3);
	        cell_gramaje.setCellValue("GRAMAJE");
	        cell_gramaje.setCellStyle(cellStyle_centro);
	        	// celda E (4)
	        Cell cell_kilogramos = row.createCell(4);
	        cell_kilogramos.setCellValue("KILOGRAMOS");
	        cell_kilogramos.setCellStyle(cellStyle_centro);
	    		// celda G (5)
	        Cell cell_alto = row.createCell(5);
	        cell_alto.setCellValue("ALTO");
	        cell_alto.setCellStyle(cellStyle_centro);
	        	// celda F (6)
	        Cell cell_ancho = row.createCell(6);
	        cell_ancho.setCellValue("ANCHO");
	        cell_ancho.setCellStyle(cellStyle_centro);
	        	// celda H (7)
	        Cell cell_precio = row.createCell(7);
	        cell_precio.setCellValue("PRECIO");
	        cell_precio.setCellStyle(cellStyle_centro);
	        	// celda I (8)
	        Cell cell_unidad = row.createCell(8);
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
				tipoPapelExtendido = null;
			}
			listaPapelExcel = null;
			//wb.close();
		} catch( Exception e ) {
			System.out.println("obtieneExcelListaTipoPapelExtendido:Error al generar el archivo de excel");
		}
		
		// creacion del stream
		ByteArrayOutputStream os;
		try {
			os = new ByteArrayOutputStream();
			wb.write(os);
			wb.dispose();
			wb.close();
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
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            // Get first sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
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

	public void borradoLogicoPorProveedorPapel(int idProveedorPapel) {
		StringBuilder query = new StringBuilder();
		query.append(" UPDATE tipo_papel_extendido tpe ");
		query.append(" SET ");
		query.append("    tpe.activo = FALSE");
		query.append(" WHERE");
		query.append("    tpe.id_proveedor_papel = ");
		query.append(idProveedorPapel);
		query.append(";");
		tipoPapelExtendidoDAO.borradoLogico(query.toString());
		query = null;
	}

}
