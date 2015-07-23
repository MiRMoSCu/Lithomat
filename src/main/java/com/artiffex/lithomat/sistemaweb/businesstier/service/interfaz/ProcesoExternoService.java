package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProcesoExternoService {
    
    public void creaProcesoExterno(ProcesoExterno procesoExterno);
    
    public ProcesoExterno buscaProcesoExterno(int idProcesoExterno);
    
    public void modificaProcesoExterno(ProcesoExterno procesoExterno);
    
    public List<ProcesoExterno> listaProcesoExterno();
    
    public List<ComboSelect> listaComboSelect();
}