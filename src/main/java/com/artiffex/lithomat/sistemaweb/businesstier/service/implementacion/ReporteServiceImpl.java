package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ReporteService;

@Service("reporteService")
public class ReporteServiceImpl implements ReporteService {
	
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private EstatusOrdenService estatusOrdenService;
	
	
	

	public byte[] obtieneExcelListaColaImpresion(Timestamp fechaImpresion, int idMaquina, int idEstatusOrden) {
		
		Maquina maquina = maquinaService.buscaMaquina(idMaquina);
		EstatusOrden estatusOrden = estatusOrdenService.buscaEstatusOrden(idEstatusOrden);
		
		
		// generacion del excel
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			// estilos
			
				// alineacion izquierda
			HSSFCellStyle cellStyle_izquierda = wb.createCellStyle();
			cellStyle_izquierda.setAlignment((short)HSSFCellStyle.ALIGN_LEFT);
				// alineacion centro
			HSSFCellStyle cellStyle_centro = wb.createCellStyle();
			cellStyle_centro.setAlignment((short)HSSFCellStyle.ALIGN_CENTER);
			
				
			
			// crecion de la hoja
			HSSFSheet sheet = wb.createSheet("Cola Impresion");
			
			
			// CREACION FILA 0
			HSSFRow row_0 = sheet.createRow(0);
			// CREACION DE COLUMNAS
			HSSFCell cell_fechs = row_0.createCell(0);
			cell_fechs.setCellValue("FECHA:");
			cell_fechs.setCellStyle(cellStyle_izquierda);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			row_0.createCell(1).setCellValue( dateFormat.format( new Date( fechaImpresion.getTime() ) ) );
			dateFormat = null;

			
			// CREACION FILA 1
			HSSFRow row_1 = sheet.createRow(1);
			// CREACION DE COLUMNAS
			HSSFCell cell_maquina = row_1.createCell(0);
			cell_maquina.setCellValue("MAQUINA:");
			cell_maquina.setCellStyle(cellStyle_izquierda);
			
			row_1.createCell(1).setCellValue( maquina.getNombre() );
			
			
			// CREACION FILA 2
			HSSFRow row_2 = sheet.createRow(2);
			// CREACION DE COLUMNAS
			HSSFCell cell_estatus = row_2.createCell(0);
			cell_estatus.setCellValue("ESTATUS:");
			cell_estatus.setCellStyle(cellStyle_izquierda);
			
			row_2.createCell(1).setCellValue( estatusOrden.getNombre() );
			
			
			// CREACION DE FILA 3
			HSSFRow row_3 = sheet.createRow(3);
			// creacion de celdas fila 1
				// celda A (0)
			HSSFCell cell_nut = row_3.createCell(0);
			cell_nut.setCellValue("NUT");
			cell_nut.setCellStyle(cellStyle_centro);
				// celda B (1)
			HSSFCell cell_cliente = row_3.createCell(1);
			cell_cliente.setCellValue("CLIENTE");
			cell_cliente.setCellStyle(cellStyle_centro);
	        	// celda C (2)
	        HSSFCell cell_descripcion = row_3.createCell(2);
	        cell_descripcion.setCellValue("DESCRIPCION");
	        cell_descripcion.setCellStyle(cellStyle_centro);
	        	// celda D (3)
	        HSSFCell cell_papel = row_3.createCell(3);
	        cell_papel.setCellValue("PAPEL");
	        cell_papel.setCellStyle(cellStyle_centro);
	        	// celda E (4)
	        HSSFCell cell_medida = row_3.createCell(4);
	        cell_medida.setCellValue("MEDIDA");
	        cell_medida.setCellStyle(cellStyle_centro);
	        	// celda F (5)
	        HSSFCell cell_tiro = row_3.createCell(5);
	        cell_tiro.setCellValue("TIRO");
	        cell_tiro.setCellStyle(cellStyle_centro);
	        	// celda G (6)
	        HSSFCell cell_tintas = row_3.createCell(6);
	        cell_tintas.setCellValue("TINTAS");
	        cell_tintas.setCellStyle(cellStyle_centro);
	        	// celda H (7)
	        HSSFCell cell_colores_fte = row_3.createCell(7);
	        cell_colores_fte.setCellValue("COLORES FTE");
	        cell_colores_fte.setCellStyle(cellStyle_centro);
	        	// celda I (8)
	        HSSFCell cell_colores_vta = row_3.createCell(8);
	        cell_colores_vta.setCellValue("COLORES VTA");
	        cell_colores_vta.setCellStyle(cellStyle_centro);
	        	// celda J (9)
	        HSSFCell cell_placas = row_3.createCell(9);
	        cell_placas.setCellValue("PLACAS");
	        cell_placas.setCellStyle(cellStyle_centro);
	    		// celda K (10)
	        HSSFCell cell_tiempo_estimado = row_3.createCell(10);
	        cell_tiempo_estimado.setCellValue("T/EST");
	        cell_tiempo_estimado.setCellStyle(cellStyle_centro);
	    		// celda L (11)
	        HSSFCell cell_observaciones = row_3.createCell(11);
	        cell_observaciones.setCellValue("OBSERVACIONES");
	        cell_observaciones.setCellStyle(cellStyle_centro);
	        
	        // obtencion de la lista
	        //int cont = 1;
	        /*
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
			*/
			
			wb.close();
		} catch( Exception e ) {
			System.out.println("obtieneExcelListaTipoPapelExtendido:Error al generar el archivo de excel");
		}
		
		maquina 		= null;
		estatusOrden	= null;
		
		
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

}
