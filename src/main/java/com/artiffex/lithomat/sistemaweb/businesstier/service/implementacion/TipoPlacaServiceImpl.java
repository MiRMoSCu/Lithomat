package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPlacaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPlacaDAO;

@Service("tipoPlacaService")
public class TipoPlacaServiceImpl implements TipoPlacaService {
	
	@Resource
	private TipoPlacaDAO tipoPlacaDAO;

	public void creaTipoPlaca(TipoPlaca tipoPlaca) {
		tipoPlacaDAO.crea(tipoPlaca);
	}
	
	public TipoPlaca buscaTipoPlaca(int idTipoPlaca) {
		return tipoPlacaDAO.busca(idTipoPlaca);
	}

	public void modificaTipoPlaca(TipoPlaca tipoPlaca) {
		tipoPlacaDAO.modifica(tipoPlaca);
	}

	public List<TipoPlaca> listaTipoPlaca() {
		return tipoPlacaDAO.lista();
	}

	public String jsonListaTipoPlaca(int idMaquina) {

		List<TipoPlaca> listaTipoPlaca = tipoPlacaDAO.lista(idMaquina);

		StringBuffer str = new StringBuffer();
		str.append("[");
		for (int i = 0; i < listaTipoPlaca.size(); i++) {
			// "[{\"id_tipo_placa\":1, \"descripcion\":\"ABC\"},{\"id_tipo_placa\":2, \"descripcion\":\"DEF\"}, {...}]"
			TipoPlaca tipoPlaca = new TipoPlaca();
			tipoPlaca = listaTipoPlaca.get(i);
			str.append("{");
			str.append("\"id_tipo_placa\":");
			str.append(tipoPlaca.getIdTipoPlaca());
			str.append(",");
			str.append("\"descripcion\":");
			str.append("\"");
			str.append(tipoPlaca.getDescripcion());
			str.append("\"");
			str.append("}");
			tipoPlaca = null;
			if (i != (listaTipoPlaca.size() - 1))
				str.append(",");
		}
		str.append("]");
		return str.toString();
	}

}
