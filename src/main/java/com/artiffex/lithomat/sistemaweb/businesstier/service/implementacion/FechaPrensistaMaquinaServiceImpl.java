package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.FechaPrensistaMaquinaConcentrado;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaFechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.FechaPrensistaMaquinaDAO;

@Service("fechaPrensistaMaquinaService")
public class FechaPrensistaMaquinaServiceImpl implements FechaPrensistaMaquinaService {
	
	@Resource
	private FechaPrensistaMaquinaDAO fechaPrensistaMaquinaDAO;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	
	
	public int creaFechaPrensistaMaquina(String jsonFechaPrensistaMaquina, String usuario) {
		JSONParser parser = new JSONParser();
		try {
			Object obj 					= parser.parse(jsonFechaPrensistaMaquina);
			JSONObject jsonObject 		= (JSONObject) obj;
			//System.out.println( "jsonObject:" + jsonObject );
			JSONArray arreglo 			= (JSONArray) jsonObject.get("registrosFPM");
			@SuppressWarnings("unchecked")
			Iterator<Object> iterator 	= arreglo.iterator();
			while ( iterator.hasNext() ) {
				JSONObject jsonObject2 = (JSONObject) iterator.next();
				//System.out.println("jsonObject2:" + jsonObject2);
				FechaPrensistaMaquina fpm = new FechaPrensistaMaquina();
					Pliego pliego = new Pliego();
					pliego.setIdPliego( Integer.valueOf( jsonObject2.get("id_pliego").toString() ) );
				fpm.setPliego(pliego);
					Prensista prensista = new Prensista();
					prensista.setIdPrensista( Integer.valueOf( jsonObject2.get("id_prensista").toString() ) );
				fpm.setPrensista(prensista);
					TurnoLaboral turnoLaboral = new TurnoLaboral();
					turnoLaboral.setIdTurnoLaboral( Integer.valueOf( jsonObject2.get("id_turno_laboral").toString() ) );
				fpm.setTurnoLaboral(turnoLaboral);
					Maquina maquina = new Maquina();
					maquina.setIdMaquina( Integer.valueOf( jsonObject2.get("id_turno_laboral").toString() ) );
				fpm.setMaquina(maquina);
				fpm.setFechaImpresion( Timestamp.valueOf(jsonObject2.get("fecha_impresion").toString() + " 00:00:00") );
					Prensista prensistaAyudante = new Prensista();
					prensistaAyudante.setIdPrensista( Integer.valueOf( jsonObject2.get("id_prensista_ayudante").toString() ) );
				fpm.setPrensistaAyudante(prensistaAyudante);
				fpm.setHojasBuenas( Integer.valueOf( jsonObject2.get("hojas_buenas").toString() ) );
				fpm.setHojasMalas( Integer.valueOf( jsonObject2.get("hojas_malas").toString() ) );
				fpm.setHojasLimpias( Integer.valueOf( jsonObject2.get("hojas_limpias").toString() ) );
				fpm.setHojasAdicionales( Integer.valueOf( jsonObject2.get("hojas_adicionales").toString() ) );
				fpm.setCambioPlacas( Integer.valueOf( jsonObject2.get("cambio_placas").toString() ) );
				fpm.setLaminasExtra( Integer.valueOf( jsonObject2.get("laminas_extra").toString() ) );
				fpm.setFrenteKilosTintaCyan( Float.valueOf( jsonObject2.get("frente_kilos_tinta_cyan").toString() ) );
				fpm.setFrenteKilosTintaMagenta( Float.valueOf( jsonObject2.get("frente_kilos_tinta_magenta").toString() ) );
				fpm.setFrenteKilosTintaYellow( Float.valueOf( jsonObject2.get("frente_kilos_tinta_yellow").toString() ) );
				fpm.setFrenteKilosTintaBlack( Float.valueOf( jsonObject2.get("frente_kilos_tinta_black").toString() ) );
				fpm.setVueltaKilosTintaCyan( Float.valueOf( jsonObject2.get("vuelta_kilos_tinta_cyan").toString() ) );
				fpm.setVueltaKilosTintaMagenta( Float.valueOf( jsonObject2.get("vuelta_kilos_tinta_magenta").toString() ) );
				fpm.setVueltaKilosTintaYellow( Float.valueOf( jsonObject2.get("vuelta_kilos_tinta_yellow").toString() ) );
				fpm.setVueltaKilosTintaBlack( Float.valueOf( jsonObject2.get("vuelta_kilos_tinta_black").toString() ) );
				fpm.setUsuario( usuario );
					Timestamp fechaGeneracion = new Timestamp(Calendar.getInstance().getTimeInMillis());
				fpm.setFechaGeneracion( fechaGeneracion );
				fpm.setActivo( true );
				
				fechaPrensistaMaquinaDAO.crea(fpm);
				
				pliego 				= null;
				prensista 			= null;
				turnoLaboral 		= null;
				maquina 			= null;
				prensistaAyudante	= null;
				fechaGeneracion		= null;
				fpm 				= null;
				jsonObject2			= null;
			}
			iterator 	= null;
			arreglo 	= null;
			jsonObject 	= null;
			obj 		= null;
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
		parser = null;
		
		return 1;
	}
	
	public void eliminaFechaPrensistaMaquinaPorNut(String nut) {
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
				List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (Pliego pliego : listaPliego) {
					fechaPrensistaMaquinaDAO.eliminaPorIdPliego(pliego.getIdPliego());
					pliego = null;
				}
				listaPliego = null;
				tipoTrabajoDetalle = null;
			}
			listaTipoTrabajoDetalle = null;
			partida = null;
		}
		listaPartida = null;
		ordenProduccion = null;
	}
	
	public byte[] obtieneExcelReporteConcentrado(String fechaBusquedaInicio, String fechaBusquedaFin) {
		StringBuilder query = new StringBuilder();
		
		query.append(" SELECT ");
		query.append("    fpm.fecha_impresion fechaImpresion,");
		query.append("    CONCAT(p.nombre,");
		query.append("            ' ',");
		query.append("            p.ap_paterno,");
		query.append("            ' ',");
		query.append("            p.ap_materno) prensista,");
		query.append("    CONCAT(p_ayudante.nombre,");
		query.append("            ' ',");
		query.append("            p_ayudante.ap_paterno,");
		query.append("            ' ',");
		query.append("            p_ayudante.ap_materno) prensistaAyudante,");
		query.append("    m.nombre maquina,");
		query.append("    SUM(hojas_buenas) hojasBuenas,");
		query.append("    SUM(cambio_placas) cambioPlacas ");
		query.append(" FROM");
		query.append("    fecha_prensista_maquina fpm,");
		query.append("    prensista p,");
		query.append("    prensista p_ayudante,");
		query.append("    maquina m ");
		query.append(" WHERE");
		query.append("    fpm.id_prensista = p.id_prensista");
		query.append("        AND fpm.id_prensista_ayudante = p_ayudante.id_prensista");
		query.append("        AND fpm.id_maquina = m.id_maquina");
		query.append("        AND fpm.fecha_impresion BETWEEN '");
		query.append(fechaBusquedaInicio);
		query.append("' AND '");
		query.append(fechaBusquedaFin);
		query.append("' ");
		query.append("        AND fpm.activo = TRUE ");
		query.append(" GROUP BY fpm.fecha_impresion , fpm.id_prensista , fpm.id_prensista_ayudante , fpm.id_maquina ");
		query.append(" ORDER BY fpm.fecha_impresion ASC , fpm.id_prensista ASC , fpm.id_prensista_ayudante ASC , fpm.id_maquina ASC;");
		
		// generacion del excel
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			// creacion de la hoja
			HSSFSheet sheet = wb.createSheet("FPM Concentrado");
			// creacion de la fila 1
			HSSFRow row = sheet.createRow(0);
			// creacion de celdas fila 1
				// celda A (0)
			HSSFCell cell_fecha_imprension = row.createCell(0);
			cell_fecha_imprension.setCellValue("FECHA IMPRESION");
				// celda B (1)
			HSSFCell cell_prensista = row.createCell(1);
			cell_prensista.setCellValue("PRENSISTA");
				// celda C (2)
			HSSFCell cell_prensista_ayudante = row.createCell(2);
			cell_prensista_ayudante.setCellValue("PRENSISTA AYUDANTE");
				// celda D (3)
			HSSFCell cell_maquina = row.createCell(3);
			cell_maquina.setCellValue("MAQUINA");
				// celda E (4)
			HSSFCell cell_hojas_buenas = row.createCell(4);
			cell_hojas_buenas.setCellValue("HOJAS BUENAS");
				// celda F (5)
			HSSFCell cell_cambio_placas = row.createCell(5);
			cell_cambio_placas.setCellValue("CAMBIO PLACAS");
			
			// obtencion de los registros
			int cont = 1;
			List<FechaPrensistaMaquinaConcentrado> fpmConcentrado = fechaPrensistaMaquinaDAO.buscaFechaPrensistaMaquinaConcentrado(query.toString());
			for (FechaPrensistaMaquinaConcentrado fechaPrensistaMaquinaConcentrado : fpmConcentrado) {
				row = sheet.createRow(cont);
				row.createCell(0).setCellValue( fechaPrensistaMaquinaConcentrado.getFechaImpresion().toString() );
				row.createCell(1).setCellValue( fechaPrensistaMaquinaConcentrado.getPrensista() );
				row.createCell(2).setCellValue( fechaPrensistaMaquinaConcentrado.getPrensistaAyudante() );
				row.createCell(3).setCellValue( fechaPrensistaMaquinaConcentrado.getMaquina() );
				row.createCell(4).setCellValue( fechaPrensistaMaquinaConcentrado.getHojasBuenas().intValue() );
				row.createCell(5).setCellValue( fechaPrensistaMaquinaConcentrado.getCambioPlacas().intValue() );
				cont++;
				fechaPrensistaMaquinaConcentrado = null;
			}
			fpmConcentrado = null;
			wb.close();
		} catch ( Exception e ) {
			System.out.println("obtieneExcelReporteConcentrado: Error al generar excel");
		}
		query = null;
		
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

	public List<FechaPrensistaMaquinaDTO> listaFechaPrensistaMaquinaPorConsulta(ParametrosBusquedaFechaPrensistaMaquina parametros) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    CONCAT(p.nombre,");
		query.append("            ' ',");
		query.append("            p.ap_paterno,");
		query.append("            ' ',");
		query.append("            p.ap_materno) prensista,");
		query.append("    t.descripcion turnoLaboral,");
		query.append("    m.nombre maquina,");
		query.append("    fpm.fecha_impresion fechaImpresion,");
		query.append("    CONCAT(p_ayudante.nombre,");
		query.append("            ' ',");
		query.append("            p_ayudante.ap_paterno,");
		query.append("            ' ',");
		query.append("            p_ayudante.ap_materno) prensistaAyudante,");
		query.append("    pl.hojas_requeridas hojasRequeridas,");
		query.append("    fpm.hojas_buenas hojasBuenas,");
		query.append("    fpm.hojas_malas hojasMalas,");
		query.append("    fpm.hojas_limpias hojasLimpias,");
		query.append("    fpm.hojas_adicionales hojasAdicionales,");
		query.append("    fpm.cambio_placas cambioPlacas,");
		query.append("    fpm.laminas_extra laminasExtra,");
		query.append("    fpm.frente_kilos_tinta_cyan frenteKilosTintaCyan,");
		query.append("    fpm.frente_kilos_tinta_magenta frenteKilosTintaMagenta,");
		query.append("    fpm.frente_kilos_tinta_yellow frenteKilosTintaYellow,");
		query.append("    fpm.frente_kilos_tinta_black frenteKilosTintaBlack,");
		query.append("    fpm.vuelta_kilos_tinta_cyan vueltaKilosTintaCyan,");
		query.append("    fpm.vuelta_kilos_tinta_magenta vueltaKilosTintaMagenta,");
		query.append("    fpm.vuelta_kilos_tinta_yellow vueltaKilosTintaYellow,");
		query.append("    fpm.vuelta_kilos_tinta_black vueltaKilosTintaBlack ");
		query.append("FROM");
		query.append("    fecha_prensista_maquina fpm,");
		query.append("    pliego pl,");
		query.append("    tipo_trabajo_detalle ttd,");
		query.append("    partida par,");
		query.append("    orden_produccion op,");
		query.append("    prensista p,");
		query.append("    prensista p_ayudante,");
		query.append("    turno_laboral t,");
		query.append("    maquina m ");
		query.append("WHERE");
		
		if ( parametros.isBusquedaPorNut() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("    op.nut LIKE '");
			query.append( parametros.getNut() );
			query.append("' ");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorFecha() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        fpm.fecha_impresion BETWEEN '");
			query.append( parametros.getFechaBusquedaInicio() );
			query.append("' AND '");
			query.append( parametros.getFechaBusquedaFin() );
			query.append("' ");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorPrensista() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        p.id_prensista = ");
			query.append( parametros.getIdPrensista() );
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorMaquina() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        m.id_maquina = ");
			query.append( parametros.getIdMaquina() );
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
		
		query.append("        fpm.id_pliego = pl.id_pliego");
		query.append("        AND ttd.id_tipo_trabajo_detalle = pl.id_tipo_trabajo_detalle");
		query.append("        AND par.id_partida = ttd.id_partida");
		query.append("        AND op.id_orden_produccion = par.id_orden_produccion");
		query.append("        AND fpm.id_prensista = p.id_prensista");
		query.append("        AND fpm.id_prensista_ayudante = p_ayudante.id_prensista");
		query.append("        AND fpm.id_turno_laboral = t.id_turno_laboral");
		query.append("        AND fpm.id_maquina = m.id_maquina ");
		query.append("ORDER BY fpm.fecha_impresion ASC , fpm.id_prensista ASC , fpm.id_prensista_ayudante ASC , fpm.id_maquina ASC;");
		
		List<FechaPrensistaMaquinaDTO> lista = fechaPrensistaMaquinaDAO.buscaFechaPrensistaMaquinaDTO( query.toString() );
		
		query = null;
		
		return lista;
	}

	public int obtieneNumeroFechaPrensistaMaquinaPorParametros(boolean busquedaPorNut, String nut) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("    COUNT(*) ");
		query.append("FROM ");
		query.append("    orden_produccion op_dos, ");
		query.append("    partida par, ");
		query.append("    tipo_trabajo_detalle ttd, ");
		query.append("    pliego p ");
		query.append("        LEFT OUTER JOIN ");
		query.append("    fecha_prensista_maquina fpm ON p.id_pliego = fpm.id_pliego ");
		query.append("WHERE ");
		
		if ( busquedaPorNut ) {
			if ( existeParametro ) {
				query.append("AND ");
			}
			query.append("    op_dos.nut LIKE '");
			query.append(nut);
			query.append("' ");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
			
		query.append("    fpm.id_pliego IS NULL ");
		query.append("        AND ttd.id_tipo_trabajo_detalle = p.id_tipo_trabajo_detalle ");
		query.append("        AND par.id_partida = ttd.id_partida ");
		query.append("        AND op_dos.id_orden_produccion = par.id_orden_produccion ");
		query.append("        AND op_dos.nut IN (SELECT ");
		query.append("            op_uno.nut ");
		query.append("        FROM ");
		query.append("            orden_produccion op_uno, ");
		query.append("            historial_estatus he_dos ");
		query.append("        WHERE ");
		query.append("            (he_dos.id_orden_produccion , he_dos.fecha) IN (SELECT ");
		query.append("                    he_uno.id_orden_produccion, MAX(he_uno.fecha) ");
		query.append("                FROM ");
		query.append("                    historial_estatus he_uno ");
		query.append("                GROUP BY he_uno.id_orden_produccion) ");
		query.append("                AND he_dos.id_estatus_orden >= 7 ");
		query.append("                AND he_dos.id_orden_produccion = op_uno.id_orden_produccion);");
		
		int numRegistros = fechaPrensistaMaquinaDAO.numeroRegistrosFechaPrensistaMaquina( query.toString() );
		
		query = null;
		
		return numRegistros;
	}

	public List<FechaPrensistaMaquinaDTOGrid> listaFechaPrensistaMaquinaPorParametrosEnDTO(boolean busquedaPorNut, String nut, int numeroPagina, int numeroRegistrosPorPagina) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("    op_dos.nut, ");
		query.append("    op_dos.nombre nombreOrdenProduccion, ");
		query.append("    par.nombre_partida nombrePartida, ");
		query.append("    ttd.descripcion descripcionTipoTrabajoDetalle, ");
		query.append("    p.id_pliego idPliego, ");
		query.append("    p.numero_pliego noPliego, ");
		query.append("    p.hojas_requeridas hojasRequeridas, ");
		query.append("    p.hojas_sobrantes hojasSobrantes, ");
		query.append("    p.hojas_totales hojasTotales ");
		query.append("FROM ");
		query.append("    orden_produccion op_dos, ");
		query.append("    partida par, ");
		query.append("    tipo_trabajo_detalle ttd, ");
		query.append("    pliego p ");
		query.append("        LEFT OUTER JOIN ");
		query.append("    fecha_prensista_maquina fpm ON p.id_pliego = fpm.id_pliego ");
		query.append("WHERE ");
		
		if ( busquedaPorNut ) {
			if ( existeParametro ) {
				query.append("AND ");
			}
			query.append("    op_dos.nut LIKE '");
			query.append(nut);
			query.append("' ");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
			
		query.append("    fpm.id_pliego IS NULL ");
		query.append("        AND ttd.id_tipo_trabajo_detalle = p.id_tipo_trabajo_detalle ");
		query.append("        AND par.id_partida = ttd.id_partida ");
		query.append("        AND op_dos.id_orden_produccion = par.id_orden_produccion ");
		query.append("        AND op_dos.nut IN (SELECT ");
		query.append("            op_uno.nut ");
		query.append("        FROM ");
		query.append("            orden_produccion op_uno, ");
		query.append("            historial_estatus he_dos ");
		query.append("        WHERE ");
		query.append("            (he_dos.id_orden_produccion , he_dos.fecha) IN (SELECT ");
		query.append("                    he_uno.id_orden_produccion, MAX(he_uno.fecha) ");
		query.append("                FROM ");
		query.append("                    historial_estatus he_uno ");
		query.append("                GROUP BY he_uno.id_orden_produccion) ");
		query.append("                AND he_dos.id_estatus_orden >= 7 ");
		query.append("                AND he_dos.id_orden_produccion = op_uno.id_orden_produccion) ");
		query.append("ORDER BY op_dos.id_orden_produccion ASC, p.id_pliego ASC ");
		query.append("LIMIT");
		query.append(" ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		List<FechaPrensistaMaquinaDTOGrid> lista = fechaPrensistaMaquinaDAO.listaPorRango( query.toString() );
		
		query = null;
		
		return lista;
	}

	
	
}