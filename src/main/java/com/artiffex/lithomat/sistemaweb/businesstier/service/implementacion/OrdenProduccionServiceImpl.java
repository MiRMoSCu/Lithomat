package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.Util;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.OrdenProduccionDAO;

@Service("ordenProduccionService")
public class OrdenProduccionServiceImpl implements OrdenProduccionService {

	private static final int ESTATUS_COTIZACION = 1;
	//private static final int ESTATUS_EN_ESPERA = 2;
	//private static final int ESTATUS_CANCELADO = 3;
	//private static final int ESTATUS_DISENIO = 4;
	//private static final int ESTATUS_PREPRENSA = 5;
	//private static final int ESTATUS_TRANSPORTE = 6;
	//private static final int ESTATUS_OFFSET = 7;
	//private static final int ESTATUS_ACABADO = 8;
	//private static final int ESTATUS_PROCESO_EXTERNO = 9;
	//private static final int ESTATUS_FINALIZADO = 10;

	@Resource
	private OrdenProduccionDAO ordenProduccionDAO;
	
	@Resource
	private HistorialEstatusService historialEstatusService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	

	@SuppressWarnings("static-access")
	public String generaNut(Timestamp fechaGeneracion) {

		/*
		 * NUT = Numero Unico de Transaccion. 
		 * NUT = 201400100019 = 2014 001 0001 9 
		 * 2014 : anio 
		 * 001 : día correspondiente al año, 001 - 365 
		 * 0001 : contador de numero de registros insertados por fecha 
		 * 9 : digito verificador
		 */

		Calendar calendario = Calendar.getInstance();
		calendario.setTimeInMillis(fechaGeneracion.getTime());

		String anio = new Integer(calendario.get(calendario.YEAR)).toString();

		DecimalFormat decimalFormat = new DecimalFormat("000");
		String diaAnio = decimalFormat.format(calendario.get(calendario.DAY_OF_YEAR));

		/*
		 * EJEMPLO de MessageFormat: 
		 * MessageFormat mf = new MessageFormat("{0,number,#.##}, {0,number,#.#}"); 
		 * Object[] objs = {new Double(3.1415)}; 
		 * String result = mf.format( objs ); // result now equals "3.14, 3.1"
		 */

		MessageFormat messageFormat = new MessageFormat("{0,number,0000}");
		Object[] obj = { new Integer(ordenProduccionDAO.contador(fechaGeneracion)) };
		String contador = messageFormat.format(obj);
		
		String digitoVerificador = new Util().getDigitoVerificador(anio + diaAnio, contador);

		StringBuilder nut = new StringBuilder();
		nut.append(anio);
		nut.append(diaAnio);
		nut.append(contador);
		nut.append(digitoVerificador);

		return nut.toString(); //nut.substring(2).toString();
	}

	public int creaOrdenProduccion(OrdenProduccion ordenProduccion) {
		int idOrdenProduccion = ordenProduccionDAO.crea(ordenProduccion);
		
		HistorialEstatus historialEstatus = new HistorialEstatus();
		historialEstatus.setOrdenProduccion(ordenProduccion);
			EstatusOrden estatusOrden = new EstatusOrden();
			estatusOrden.setIdEstatusOrden(ESTATUS_COTIZACION);
		historialEstatus.setEstatusOrden(estatusOrden);
		historialEstatus.setFecha(ordenProduccion.getFechaGeneracion());
		historialEstatus.setActivo(true);
		historialEstatusService.creaHistorialEstatus(historialEstatus);
		
		return idOrdenProduccion;
	}
	
	public OrdenProduccion buscaOrdenProduccion(int idOrdenProduccion) {
		return ordenProduccionDAO.busca(idOrdenProduccion);
	}
	
	public OrdenProduccion buscaOrdenProduccionPorNut(String nut) {
		return ordenProduccionDAO.buscaPorNut(nut);
	}

	public void modificaOrdenProduccion(OrdenProduccion ordenProduccion) {
		ordenProduccionDAO.modifica(ordenProduccion);
	}

	public List<OrdenProduccion> listaOrdenProduccion() {
		return ordenProduccionDAO.lista();
	}
	
	public int buscaEstatusOrdenProduccionPorNut(String nut) {
		return ordenProduccionDAO.buscaIdEstatusOrden(nut);
	}

	public String generaJsonArbolOrdenProduccion(int idOrdenProduccion) {
		
		// json debe tener la siguiente estructura:
		// [{   
		//      "id":"1",
		//      "text":"Orden Produccion",
		//      "state":{"opened":true},
		//      "children":[
		//          {   
		//              "id":"1.2",
		//              "text":"Partida 1",
		//				"state":{"opened":true},
		//              "children":[
		//                  {   
		//                      "id":"1.2.1",
		//                      "text":"Subpartida 1"
		//                  },{ 
		//                      "id":"1.2.2",
		//                      "text":"Subpartida 2"
		//                  }
		//              ]
		//          },{
		//              "id":"1.3",
		//              "text":"Partida 2"
		//          },{
		//              "id":"1.4",
		//              "text":"Partida 3"
		//          }
		//          
		//      ]
		// }]
		
		OrdenProduccion ordenProduccion = ordenProduccionDAO.busca(idOrdenProduccion);
		
		StringBuilder sb = new StringBuilder();
		sb.append("[{");
		sb.append("\"id\":\"IdOrdProd:" + ordenProduccion.getIdOrdenProduccion() + "\",");
		sb.append("\"text\":\"" + ordenProduccion.getNut() + "\",");
		sb.append("\"state\":{\"opened\":true},");
		sb.append("\"children\":[");
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for( int i=0; i<listaPartida.size(); i++ ) {
			Partida partida = (Partida)listaPartida.get(i);
			sb.append("{");
			sb.append("\"id\":\"IdPartida:" + partida.getIdPartida() + "\",");
			sb.append("\"text\":\"" + partida.getNombrePartida() + "\",");
			sb.append("\"state\":{\"opened\":true},");
			sb.append("\"children\":[");
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for( int j=0; j<listaTipoTrabajoDetalle.size(); j++ ) {
				TipoTrabajoDetalle tipoTrabajoDetalle = listaTipoTrabajoDetalle.get(j);
				sb.append("{");
				sb.append("\"id\":\"IdSubpartida:" + tipoTrabajoDetalle.getIdTipoTrabajoDetalle() + "\",");
				sb.append("\"text\":\"" + tipoTrabajoDetalle.getDescripcion() + "\"");
				sb.append("}");
				if( j+1 < listaTipoTrabajoDetalle.size() )
					sb.append(",");
				else {
					sb.append(",{");
					sb.append("\"id\":\"IdProcExt:" + partida.getIdPartida() + "\",");
					sb.append("\"text\":\"Procesos\"");
					sb.append("}");
				}
				tipoTrabajoDetalle = null;
			}
			partida					= null;
			listaTipoTrabajoDetalle = null;
			sb.append("]");
			sb.append("}");
			if( i+1 < listaPartida.size() )
				sb.append(",");
		}
		listaPartida = null;
		sb.append("]");
		//sb.append("\"id\":\"value\",");
		sb.append("}]");
		
		ordenProduccion = null;
		
		return sb.toString();
	}

	public boolean existeOrdenProduccionPorNut(String nut) {
		boolean existeRegistro = false;
		OrdenProduccion ordenProduccion = ordenProduccionDAO.buscaPorNut(nut);
		if( ordenProduccion != null )
			existeRegistro = true;
		ordenProduccion = null;
		return existeRegistro;
	}

}
