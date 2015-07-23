package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PapelSobranteDAO;

@Service("papelSobranteService")
public class PapelSobranteServiceImpl implements PapelSobranteService {

	@Resource
	private PapelSobranteDAO papelSobranteDAO;

	public void creaPapelSobrante(PapelSobrante papelSobrante) {
		papelSobranteDAO.crea(papelSobrante);
	}
	
	public PapelSobrante buscaPapelSobrante(int idPapelSobrante) {
		return papelSobranteDAO.busca(idPapelSobrante);
	}

	public void modificaPapelSobrante(PapelSobrante papelSobrante) {
		papelSobranteDAO.modifica(papelSobrante);
	}

	public List<PapelSobrante> listaPapelSobrante() {
		return papelSobranteDAO.lista();
	}

	public int buscaHojasSobrante(PapelSobrante papelSobrante) {
		
		// se adapta numero de tintas frente y vuelta a los parametros default registrados en BD: 1x0, 1x1, 4x0, 4x4
		if (papelSobrante.getFrenteNumTinta() == 0)
			papelSobrante.setFrenteNumTinta(1);
		if (papelSobrante.getFrenteNumTinta() == 1)
			papelSobrante.setFrenteNumTinta(1);
		if (papelSobrante.getFrenteNumTinta() == 2)
			papelSobrante.setFrenteNumTinta(1);
		if (papelSobrante.getFrenteNumTinta() == 3)
			papelSobrante.setFrenteNumTinta(4);
		if (papelSobrante.getFrenteNumTinta() == 4 || papelSobrante.getFrenteNumTinta() > 4)
			papelSobrante.setFrenteNumTinta(4);
		switch (papelSobrante.getFrenteNumTinta()) {
			case 1:
				if (papelSobrante.getVueltaNumTinta() == 0)
					papelSobrante.setVueltaNumTinta(0);
				if (papelSobrante.getVueltaNumTinta() == 1)
					papelSobrante.setVueltaNumTinta(1);
				if (papelSobrante.getVueltaNumTinta() == 2)
					papelSobrante.setVueltaNumTinta(1);
				if (papelSobrante.getVueltaNumTinta() == 3)
					papelSobrante.setVueltaNumTinta(1);
				if (papelSobrante.getVueltaNumTinta() == 4 || papelSobrante.getVueltaNumTinta() > 4)
					papelSobrante.setVueltaNumTinta(1);
				break;
			case 4:
				if (papelSobrante.getVueltaNumTinta() == 0)
					papelSobrante.setVueltaNumTinta(0);
				if (papelSobrante.getVueltaNumTinta() == 1)
					papelSobrante.setVueltaNumTinta(4);
				if (papelSobrante.getVueltaNumTinta() == 2)
					papelSobrante.setVueltaNumTinta(4);
				if (papelSobrante.getVueltaNumTinta() == 3)
					papelSobrante.setVueltaNumTinta(4);
				if (papelSobrante.getVueltaNumTinta() == 4 || papelSobrante.getVueltaNumTinta() > 4)
					papelSobrante.setVueltaNumTinta(4);
				break;
			default:
				break;
		}
		return papelSobranteDAO.buscaHojasSobrante(papelSobrante);
	}

}
