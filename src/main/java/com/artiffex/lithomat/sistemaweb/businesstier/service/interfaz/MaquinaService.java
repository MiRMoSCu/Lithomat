package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface MaquinaService {

	public void creaMaquina(Maquina maquina);
	
	public Maquina buscaMaquina(int idMaquina);

	public void modificaMaquina(Maquina maquina);

	public List<Maquina> listaMaquina();

	public List<ComboSelect> listaComboSelect();
}