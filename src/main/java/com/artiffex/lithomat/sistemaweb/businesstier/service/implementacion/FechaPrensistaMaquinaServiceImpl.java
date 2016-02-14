package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.FechaPrensistaMaquinaDAO;

@Service("fechaPrensistaMaquinaService")
public class FechaPrensistaMaquinaServiceImpl implements FechaPrensistaMaquinaService {
	
	@Resource
	private FechaPrensistaMaquinaDAO fechaPrensistaMaquinaDAO;
	
	
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
				fpm.setFrenteKilosTinta( Integer.valueOf( jsonObject2.get("frente_kilos_tinta").toString() ) );
				fpm.setVueltaKilosTinta( Integer.valueOf( jsonObject2.get("vuelta_kilos_tinta").toString() ) );
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

	public List<FechaPrensistaMaquina> listaFechaPrensistaMaquina() {
		return fechaPrensistaMaquinaDAO.lista();
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
			query.append("        AND fpm.id_pliego IS NULL ");
		else
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
		query.append("    p.hojas_requeridas hojasRequeridas ");
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
			query.append("        AND fpm.id_pliego IS NULL ");
		else
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