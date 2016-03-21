package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DescuentoTabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DescuentoTabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DescuentoTabuladorPreciosDAO;

@Service("descuentoTabuladorPreciosService")
public class DescuentoTabuladorPreciosServiceImpl implements DescuentoTabuladorPreciosService {
	
	@Resource
	private DescuentoTabuladorPreciosDAO descuentoTabuladorPreciosDAO;

	public int crea(DescuentoTabuladorPrecios descuentoTabuladorPrecios) {
		return descuentoTabuladorPreciosDAO.crea(descuentoTabuladorPrecios);
	}

	public void modifica(DescuentoTabuladorPrecios descuentoTabuladorPrecios) {
		descuentoTabuladorPreciosDAO.modifica(descuentoTabuladorPrecios);
	}
	
	public DescuentoTabuladorPreciosDTO buscaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		DescuentoTabuladorPreciosDTO dtpDTO = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append("    dtp.id_descuento_tabulador_precios idDescuentoTabuladorPrecios,");
		sb.append("    dtp.id_tipo_trabajo_detalle idTipoTrabajoDetalle,");
		sb.append("    dtp.precio_tabulador precioTabulador,");
		sb.append("    tp.nombre tipoPrecio,");
		sb.append("    dtp.activo");
		sb.append(" FROM");
		sb.append("    descuento_tabulador_precios dtp,");
		sb.append("    tipo_precio tp");
		sb.append(" WHERE");
		sb.append("    tp.id_tipo_precio = dtp.id_tipo_precio");
		sb.append("        AND dtp.id_tipo_trabajo_detalle = ");
		sb.append(idTipoTrabajoDetalle);
		sb.append("        AND dtp.activo = TRUE;");
		
		dtpDTO = descuentoTabuladorPreciosDAO.buscaPorQuery(sb.toString());
		
		sb = null;	
		return dtpDTO;
	}

	public float buscaPrecioPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		
		float precioUnitario = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append("    CAST((dtp.precio_tabulador / tp.factor_divisor)");
		sb.append("        AS DECIMAL (6 , 3 ))");
		sb.append(" FROM");
		sb.append("    descuento_tabulador_precios dtp,");
		sb.append("    tipo_precio tp");
		sb.append(" WHERE");
		sb.append("    tp.id_tipo_precio = dtp.id_tipo_precio");
		sb.append("        AND dtp.id_tipo_trabajo_detalle = ");
		sb.append(idTipoTrabajoDetalle);
		sb.append("        AND dtp.activo = TRUE;");
		
		precioUnitario = descuentoTabuladorPreciosDAO.buscaFloatPorQuery(sb.toString());
		
		sb = null;
		return precioUnitario;
	}

}
