package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AvisoMantenimientoMaquina;

public interface AvisoMantenimientoMaquinaDAO {
	
	public int crea(AvisoMantenimientoMaquina avisoMantenimientoMaquina);
	
	public AvisoMantenimientoMaquina busca(int idAvisoMantenimientoMaquina);

	public void modifica(AvisoMantenimientoMaquina avisoMantenimientoMaquina);

	public List<AvisoMantenimientoMaquina> lista();
	
}
