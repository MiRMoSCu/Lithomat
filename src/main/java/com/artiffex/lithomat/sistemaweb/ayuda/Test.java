package com.artiffex.lithomat.sistemaweb.ayuda;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion.TipoTrabajoDetalleDaoImpl;

public class Test {
	
	public static void main( String[] args ) {
		TipoTrabajoDetalleDaoImpl test = new TipoTrabajoDetalleDaoImpl();
		List<TipoTrabajoDetalle> lista = test.listaPorEstatusOrden(1);
		for (TipoTrabajoDetalle tipoTrabajoDetalle : lista) {
			System.out.println( tipoTrabajoDetalle.getIdTipoTrabajoDetalle() );
		}
		
		/*
		PliegoDaoImpl pliego = new PliegoDaoImpl();
		System.out.println( pliego.numeroTotalHojasTotalPliegosPorTipoTrabajoDetalle(2) );
		*/
		System.out.println("_$");
	}

}
