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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
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
			sb.append(tipoPapelExtendido.getAncho());
			sb.append("x");
			sb.append(tipoPapelExtendido.getAlto());
			sb.append("  cm. (");
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
				// celda A
			HSSFCell cell_id = row.createCell(0);
			cell_id.setCellValue("ID");
	        cell_id.setCellStyle(cellStyle_centro);
	        	// celda B
	        HSSFCell cell_proveedor = row.createCell(1);
	        cell_proveedor.setCellValue("PROVEEDOR");
	        cell_proveedor.setCellStyle(cellStyle_centro);
	        	// celda C
	        HSSFCell cell_nombre = row.createCell(2);
	        cell_nombre.setCellValue("NOMBRE");
	        cell_nombre.setCellStyle(cellStyle_centro);
	        	// celda D
	        HSSFCell cell_gramaje = row.createCell(3);
	        cell_gramaje.setCellValue("GRAMAJE");
	        cell_gramaje.setCellStyle(cellStyle_centro);
	        	// celda E
	        HSSFCell cell_kilogramos = row.createCell(4);
	        cell_kilogramos.setCellValue("KILOGRAMOS");
	        cell_kilogramos.setCellStyle(cellStyle_centro);
	        	// celda F
	        HSSFCell cell_ancho = row.createCell(5);
	        cell_ancho.setCellValue("ANCHO");
	        cell_ancho.setCellStyle(cellStyle_centro);
	        	// celda G
	        HSSFCell cell_alto = row.createCell(6);
	        cell_alto.setCellValue("ALTO");
	        cell_alto.setCellStyle(cellStyle_centro);
	        	// celda H
	        HSSFCell cell_precio = row.createCell(7);
	        cell_precio.setCellValue("PRECIO");
	        cell_precio.setCellStyle(cellStyle_centro);
	        	// celda I
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
				row.createCell(5).setCellValue( tipoPapelExtendido.getAncho() );
				row.createCell(6).setCellValue( tipoPapelExtendido.getAlto() );
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
