package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostosExtrasDetalleDAO;

@Service("costosExtrasDetalleService")
public class CostosExtrasDetalleServiceImpl implements CostosExtrasDetalleService {
	
	@Resource
	private CostosExtrasDetalleDAO costosExtrasDetalleDAO;
	@Resource
	private CostosExtrasService costosExtrasService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private CalificacionService calificacionService;

	
	public void creaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle) {
		// calculo de campo faltante: precio_total_pesos
		int idCostosExtras = costosExtrasDetalle.getCostosExtras().getIdCostosExtras();
		float precioTotalPesos = 0;
		CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(idCostosExtras);
		switch( costosExtras.getTipoPrecio().getIdTipoPrecio() ) {
			case 1: // NO APLICA
				precioTotalPesos = 0;
				break;
			case 2: // UNIDAD
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 3: // CIENTO
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 4: // MILLAR
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 5: // HORA
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 6: // PORCENTAJE
				// la cantidad de costos extras en porcentaje siempre es 1
				costosExtrasDetalle.setCantidad(1);
				// debe buscar el tabulador de impresión y la cantidad de hojas de impresion.
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionService.buscaCalificacionTrabajoDetalle(costosExtrasDetalle.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());
				int cantidadRedondeada 			= calificacionTrabajoDetalle.getCantidadRedondeada();
				int numEntradasMaquina 			= calificacionTrabajoDetalle.getTintaNumEntMaq();
				float precioUnitarioTabulador 	= calificacionTrabajoDetalle.getPrecioUnitarioTabulador();
				precioTotalPesos = cantidadRedondeada * numEntradasMaquina * precioUnitarioTabulador * (1 + ( costosExtras.getPrecio() / costosExtras.getTipoPrecio().getFactorDivisor() ));
				calificacionTrabajoDetalle = null;
				break;
			case 7: // CENTIMETRO CUADRADO
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			default:
				break;
		}
		costosExtras = null;
		costosExtrasDetalle.setPrecioTotalPesos(precioTotalPesos);
		costosExtrasDetalleDAO.crea(costosExtrasDetalle);
	}
	
	public CostosExtrasDetalle buscaCostosExtrasDetalle(int idCostosExtrasDetalle) {
		return costosExtrasDetalleDAO.busca(idCostosExtrasDetalle);
	}

	public void modificaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle) {
		// calculo de campo faltante: precio_total_pesos
		int idCostosExtras = costosExtrasDetalle.getCostosExtras().getIdCostosExtras();
		float precioTotalPesos = 0;
		CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(idCostosExtras);
		switch( costosExtras.getTipoPrecio().getIdTipoPrecio() ) {
			case 1: // NO APLICA
				precioTotalPesos = 0;
				break;
			case 2: // UNIDAD
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 3: // CIENTO
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 4: // MILLAR
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 5: // HORA
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			case 6: // PORCENTAJE
				// la cantidad de costos extras en porcentaje siempre es 1
				costosExtrasDetalle.setCantidad(1);
				// debe buscar el tabulador de impresión y la cantidad de hojas de impresion.
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionService.buscaCalificacionTrabajoDetalle(costosExtrasDetalle.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());
				int cantidadRedondeada 			= calificacionTrabajoDetalle.getCantidadRedondeada();
				int numEntradasMaquina 			= calificacionTrabajoDetalle.getTintaNumEntMaq();
				float precioUnitarioTabulador 	= calificacionTrabajoDetalle.getPrecioUnitarioTabulador();
				precioTotalPesos = cantidadRedondeada * numEntradasMaquina * precioUnitarioTabulador * (1 + ( costosExtras.getPrecio() / costosExtras.getTipoPrecio().getFactorDivisor() ));
				calificacionTrabajoDetalle = null;
				break;
			case 7: // CENTIMETRO CUADRADO
				precioTotalPesos = costosExtrasDetalle.getCantidad() * costosExtras.getPrecio();
				break;
			default:
				break;
		}
		costosExtras = null;
		costosExtrasDetalle.setPrecioTotalPesos(precioTotalPesos);
		costosExtrasDetalleDAO.modifica(costosExtrasDetalle);
	}

	public List<CostosExtrasDetalle> listaCostosExtrasDetalle() {
		return costosExtrasDetalleDAO.lista();
	}

	public List<CostosExtrasDetalle> listaCostosExtrasDetallePorNut(String nut) {
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = new ArrayList<CostosExtrasDetalle>();
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalleService = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalleService) {
				List<CostosExtrasDetalle> listaTemporal = costosExtrasDetalleDAO.listaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (CostosExtrasDetalle costosExtrasDetalle : listaTemporal) {
					listaCostosExtrasDetalle.add(costosExtrasDetalle);
					costosExtrasDetalle = null;
				}
				listaTemporal = null;
				tipoTrabajoDetalle = null;
			}
			listaTipoTrabajoDetalleService = null;
			partida = null;
		}
		listaPartida = null;
		ordenProduccion = null;
		return listaCostosExtrasDetalle;
	}

	public List<CostosExtrasDetalle> listaCostosExtrasDetallePorPartida(int idPartida) {
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = new ArrayList<CostosExtrasDetalle>();
		List<TipoTrabajoDetalle> listaTipoTrabajoDetalleService = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(idPartida);
		for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalleService) {
			List<CostosExtrasDetalle> listaTemporal = costosExtrasDetalleDAO.listaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
			for (CostosExtrasDetalle costosExtrasDetalle : listaTemporal) {
				listaCostosExtrasDetalle.add(costosExtrasDetalle);
				costosExtrasDetalle = null;
			}
			listaTemporal = null;
			tipoTrabajoDetalle = null;
		}
		listaTipoTrabajoDetalleService = null;
		return listaCostosExtrasDetalle;
	}
}