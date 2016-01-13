package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.RegistroColaImpresionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ReporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;

@Service("reporteService")
public class ReporteServiceImpl implements ReporteService {
	
	private static int CELDA_NUT 				= 0;
	private static int CELDA_CLIENTE 			= 1;
	private static int CELDA_DESCRIPCION 		= 2;
	private static int CELDA_PAPEL 				= 3;
	private static int CELDA_MEDIDA 			= 4;
	private static int CELDA_TIRO 				= 5;
	private static int CELDA_TINTAS 			= 6;
	private static int CELDA_COLORES_FTE 		= 7;
	private static int CELDA_COLORES_VTA 		= 8;
	private static int CELDA_PLACAS 			= 9;
	private static int CELDA_MAQUINA 			= 10;
	private static int CELDA_TIEMPO_ESTIMADO 	= 11;
	private static int CELDA_OBSERVACIONES 		= 12;
	
	
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private EstatusOrdenService estatusOrdenService;
	
	
	private List<RegistroColaImpresionDTO> listaRegistrosColaImpresion( int idEstatusOrden ) {
		List<RegistroColaImpresionDTO> listaColaImpresion = new ArrayList<RegistroColaImpresionDTO>();
		List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorEstatusOrden(idEstatusOrden);
		for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
			List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle( tipoTrabajoDetalle.getIdTipoTrabajoDetalle() );
			for (Pliego pliego : listaPliego) {
				RegistroColaImpresionDTO registro = new RegistroColaImpresionDTO();
				registro.setNut( tipoTrabajoDetalle.getPartida().getOrdenProduccion().getNut() );
				registro.setNombreCliente( tipoTrabajoDetalle.getPartida().getOrdenProduccion().getCliente().getNombreMoral() );
				registro.setDecripcion( tipoTrabajoDetalle.getDescripcion() );
				registro.setPapel( tipoTrabajoDetalle.getTipoPapelExtendido().getNombre() + " " + (int)tipoTrabajoDetalle.getTipoPapelExtendido().getAlto() + "x" + (int)tipoTrabajoDetalle.getTipoPapelExtendido().getAncho() + " " + tipoTrabajoDetalle.getTipoPapelExtendido().getGramaje() + " grs." );
				registro.setMedida( (int)tipoTrabajoDetalle.getAlto() + " x " + (int)tipoTrabajoDetalle.getAncho() );
				registro.setTiro( pliego.getHojasTotales() );
				registro.setTintas( pliego.getFrenteNumTotalPlacas() + " x " + pliego.getVueltaNumTotalPlacas() );
					StringBuilder descripcionTintas = new StringBuilder();
					if( pliego.getFrenteNumTotalPlacas() > 0 ) {
						descripcionTintas.append( tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion() );
						descripcionTintas.append( tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial() != null && !"".equals(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial()) ? " + " + tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial() : ""  );
						descripcionTintas.append( tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion() != null && !"".equals(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion()) ? " + " + tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion() : "");
					}
				registro.setColoresFrente( descripcionTintas.toString() );
					descripcionTintas.delete(0, descripcionTintas.length());
					if( pliego.getVueltaNumTotalPlacas() > 0 ) {
						descripcionTintas.append( tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion() );
						descripcionTintas.append( tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial() != null && !"".equals(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial()) ? " + " + tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial() : "" );
						descripcionTintas.append( tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion() != null && !"".equals(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion()) ? " + " + tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion() : "" );
					}
				registro.setColoresVuelta( descripcionTintas.toString() );
					descripcionTintas = null;
				registro.setPlacas( pliego.getFrenteNumTotalPlacas() + " + " + pliego.getVueltaNumTotalPlacas() );
				registro.setMaquina( tipoTrabajoDetalle.getMaquina().getNombre() );
				listaColaImpresion.add( registro );
				registro = null;
			}
			listaPliego 		= null;
			tipoTrabajoDetalle 	= null;
		}
		listaTipoTrabajoDetalle = null;
		return listaColaImpresion;
	}
	
	
	public byte[] obtieneExcelListaColaImpresion( int idEstatusOrden ) {
		
		//Maquina maquina = maquinaService.buscaMaquina(idMaquina);
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
			row_0.createCell(1).setCellValue( dateFormat.format( new Date( Calendar.getInstance().getTimeInMillis() ) ) );
			dateFormat = null;
			
			
			// CREACION FILA 1
			HSSFRow row_1 = sheet.createRow(1);
			// CREACION DE COLUMNAS
			HSSFCell cell_estatus = row_1.createCell(0);
			cell_estatus.setCellValue("ESTATUS:");
			cell_estatus.setCellStyle(cellStyle_izquierda);
			
			row_1.createCell(1).setCellValue( estatusOrden.getNombre() );
			
			
			// CREACION DE FILA 2
			HSSFRow row_2 = sheet.createRow(2);
			// creacion de celdas fila 1
				// celda A (0)
			HSSFCell cell_nut = row_2.createCell(CELDA_NUT);
			cell_nut.setCellValue("NUT");
			cell_nut.setCellStyle(cellStyle_centro);
				// celda B (1)
			HSSFCell cell_cliente = row_2.createCell(CELDA_CLIENTE);
			cell_cliente.setCellValue("CLIENTE");
			cell_cliente.setCellStyle(cellStyle_centro);
	        	// celda C (2)
	        HSSFCell cell_descripcion = row_2.createCell(CELDA_DESCRIPCION);
	        cell_descripcion.setCellValue("DESCRIPCION");
	        cell_descripcion.setCellStyle(cellStyle_centro);
	        	// celda D (3)
	        HSSFCell cell_papel = row_2.createCell(CELDA_PAPEL);
	        cell_papel.setCellValue("PAPEL");
	        cell_papel.setCellStyle(cellStyle_centro);
	        	// celda E (4)
	        HSSFCell cell_medida = row_2.createCell(CELDA_MEDIDA);
	        cell_medida.setCellValue("MEDIDA");
	        cell_medida.setCellStyle(cellStyle_centro);
	        	// celda F (5)
	        HSSFCell cell_tiro = row_2.createCell(CELDA_TIRO);
	        cell_tiro.setCellValue("TIRO");
	        cell_tiro.setCellStyle(cellStyle_centro);
	        	// celda G (6)
	        HSSFCell cell_tintas = row_2.createCell(CELDA_TINTAS);
	        cell_tintas.setCellValue("TINTAS");
	        cell_tintas.setCellStyle(cellStyle_centro);
	        	// celda H (7)
	        HSSFCell cell_colores_fte = row_2.createCell(CELDA_COLORES_FTE);
	        cell_colores_fte.setCellValue("COLORES FTE");
	        cell_colores_fte.setCellStyle(cellStyle_centro);
	        	// celda I (8)
	        HSSFCell cell_colores_vta = row_2.createCell(CELDA_COLORES_VTA);
	        cell_colores_vta.setCellValue("COLORES VTA");
	        cell_colores_vta.setCellStyle(cellStyle_centro);
	        	// celda J (9)
	        HSSFCell cell_placas = row_2.createCell(CELDA_PLACAS);
	        cell_placas.setCellValue("PLACAS");
	        cell_placas.setCellStyle(cellStyle_centro);
	    		// celda K (10)
	        HSSFCell cell_maquina = row_2.createCell(CELDA_MAQUINA);
	        cell_maquina.setCellValue("MAQUINA");
	        cell_maquina.setCellStyle(cellStyle_centro);
	    		// celda L (11)
	        HSSFCell cell_tiempo_estimado = row_2.createCell(CELDA_TIEMPO_ESTIMADO);
	        cell_tiempo_estimado.setCellValue("T/EST");
	        cell_tiempo_estimado.setCellStyle(cellStyle_centro);
	        	// celda M (12)
	        HSSFCell cell_observaciones = row_2.createCell(CELDA_OBSERVACIONES);
	        cell_observaciones.setCellValue("OBSERVACIONES");
	        cell_observaciones.setCellStyle(cellStyle_centro);
	        
	        
	        // CREACION DE FILA 3 en adelante
	        // obtencion de la lista
	        int cont = 3;
	        List<RegistroColaImpresionDTO> listaRegistroColaImpresion = listaRegistrosColaImpresion( idEstatusOrden );
	        for (RegistroColaImpresionDTO registroColaImpresionDTO : listaRegistroColaImpresion) {
	        	HSSFRow row = sheet.createRow(cont);
	        	row.createCell(CELDA_NUT).setCellValue( registroColaImpresionDTO.getNut() );
	        	row.createCell(CELDA_CLIENTE).setCellValue( registroColaImpresionDTO.getNombreCliente() );
	        	row.createCell(CELDA_DESCRIPCION).setCellValue( registroColaImpresionDTO.getDecripcion() );
	        	row.createCell(CELDA_PAPEL).setCellValue( registroColaImpresionDTO.getPapel() );
	        	row.createCell(CELDA_MEDIDA).setCellValue( registroColaImpresionDTO.getMedida() );
	        	row.createCell(CELDA_TIRO).setCellValue( registroColaImpresionDTO.getTiro() );
	        	row.createCell(CELDA_TINTAS).setCellValue( registroColaImpresionDTO.getTintas() );
	        	row.createCell(CELDA_COLORES_FTE).setCellValue( registroColaImpresionDTO.getColoresFrente() );
	        	row.createCell(CELDA_COLORES_VTA).setCellValue( registroColaImpresionDTO.getColoresVuelta() );
	        	row.createCell(CELDA_PLACAS).setCellValue( registroColaImpresionDTO.getPlacas() );
	        	row.createCell(CELDA_MAQUINA).setCellValue( registroColaImpresionDTO.getMaquina() );
	        	cont++;
			}
	        listaRegistroColaImpresion = null;
			
			wb.close();
		} catch( Exception e ) {
			System.out.println("obtieneExcelListaTipoPapelExtendido:Error al generar el archivo de excel");
		}
		
		//maquina 		= null;
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
