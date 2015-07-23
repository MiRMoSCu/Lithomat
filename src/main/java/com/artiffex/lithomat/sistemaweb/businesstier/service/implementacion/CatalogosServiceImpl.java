package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CatalogosService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CatalogosDAO;

@Service("catalogosService")
public class CatalogosServiceImpl implements CatalogosService {
	
	@Resource
	private CatalogosDAO catalogosDao;

	public int creaCatalogos() {
		return catalogosDao.creaCatalogos();
	}
}
