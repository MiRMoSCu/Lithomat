package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DescuentoTabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DescuentoTabuladorPreciosDAO;

@Service("descuentoTabuladorPreciosService")
public class DescuentoTabuladorPreciosServiceImpl implements DescuentoTabuladorPreciosService {
	
	@Resource
	private DescuentoTabuladorPreciosDAO descuentoTabuladorPreciosDAO;
	

}
