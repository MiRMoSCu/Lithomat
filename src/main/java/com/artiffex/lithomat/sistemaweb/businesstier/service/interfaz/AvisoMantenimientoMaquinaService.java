package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AvisoMantenimientoMaquina;

public interface AvisoMantenimientoMaquinaService {
	
	public int creaAvisoMantenimientoMaquina(AvisoMantenimientoMaquina avisoMantenimientoMaquina);
	
	public AvisoMantenimientoMaquina buscaAvisoMantenimientoMaquina(int idAvisoMantenimientoMaquina);
	
	public void modificaAvisoMantenimientoMaquina(AvisoMantenimientoMaquina avisoMantenimientoMaquina);
	
	public List<AvisoMantenimientoMaquina> listaAvisoMantenimientoMaquina();
	
}