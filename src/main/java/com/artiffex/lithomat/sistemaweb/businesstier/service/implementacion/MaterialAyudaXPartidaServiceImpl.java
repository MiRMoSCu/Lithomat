package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.MaterialAyudaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyudaXPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaXPartidaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaterialAyudaXPartidaDAO;

@Service("materialAyudaXPartidaService")
public class MaterialAyudaXPartidaServiceImpl implements MaterialAyudaXPartidaService {
	
	@Resource
	private MaterialAyudaXPartidaDAO materialAyudaXPartidaDAO;

	public int creaMaterialAyudaXPartida(MaterialAyudaXPartida materialAyudaXPartida) {
		return materialAyudaXPartidaDAO.crea(materialAyudaXPartida);
	}
	
	public MaterialAyudaXPartida buscaMaterialAyudaXPartida(int idMaterialAyudaXPartida) {
		return materialAyudaXPartidaDAO.busca(idMaterialAyudaXPartida);
	}

	public void modificaMaterialAyudaXPartida(MaterialAyudaXPartida materialAyudaXPartida) {
		materialAyudaXPartidaDAO.modifica(materialAyudaXPartida);
	}

	public List<MaterialAyudaXPartida> listaMaterialAyudaXPartida() {
		return materialAyudaXPartidaDAO.lista();
	}
	
	public String listaHTML(int idPartida) {
		List<MaterialAyudaXPartida> listaMaterialAyudaXPartida = materialAyudaXPartidaDAO.lista(idPartida);

		StringBuilder html = new StringBuilder();
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Material</th>");
		html.append("<th>Responsable</th>");
		html.append("<th>Observaciones</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaMaterialAyudaXPartida.size() > 0) {
			for (MaterialAyudaXPartida materialAcabadoXPartida : listaMaterialAyudaXPartida) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\'>");

				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getMaterialAyuda().getNombre());
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getResponsableInsumo().getNombre());
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getObservaciones());
				html.append("</td>");

				cont++;
				
				materialAcabadoXPartida = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}

		html.append("</table>");

		listaMaterialAyudaXPartida = null;
		
		return html.toString();
	}

	public String listaHTMLModificacion(int idPartida) {
		
		List<MaterialAyudaXPartida> listaMaterialAyudaXPartida = materialAyudaXPartidaDAO.lista(idPartida);

		StringBuilder html = new StringBuilder();
		html.append("<table  id=\'tabla_lista_material_ayuda\'>");
		html.append("<tr>");
		html.append("<th>No.</th>");
		html.append("<th>Material</th>");
		html.append("<th>Responsable</th>");
		html.append("<th>Observaciones</th>");
		html.append("</tr>");

		int cont = 0;
		if (listaMaterialAyudaXPartida.size() > 0) {
			for (MaterialAyudaXPartida materialAcabadoXPartida : listaMaterialAyudaXPartida) {

				html.append("<tr class=\'");
				if (cont % 2 == 0) {
					html.append("l1");
				} else {
					html.append("l2");
				}
				html.append("\' ");
				html.append("onclick=\'setCamposMaterialAyuda("
						+ "&#39;" + materialAcabadoXPartida.getIdMaterialAyudaXPartida() + "&#39;,"
						+ "&#39;" + materialAcabadoXPartida.getMaterialAyuda().getIdMaterialAyuda() + "&#39;,"
						+ "&#39;" + materialAcabadoXPartida.getMaterialAyuda().getNombre() + "&#39;,"
						+ "&#39;" + materialAcabadoXPartida.getResponsableInsumo().getIdResponsableInsumo() + "&#39;,"
						+ "&#39;" + materialAcabadoXPartida.getObservaciones() + "&#39;"
						+ ");\'");
				html.append(">");
				
				html.append("<td>");
				html.append(cont + 1);
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getMaterialAyuda().getNombre());
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getResponsableInsumo().getNombre());
				html.append("</td>");

				html.append("<td>");
				html.append(materialAcabadoXPartida.getObservaciones());
				html.append("</td>");

				cont++;
				
				materialAcabadoXPartida = null;
			}
		} else {
			html.append("<tr class=\'");
			html.append("l1");
			html.append("\'>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");

			html.append("<td>");
			html.append("&nbsp;");
			html.append("</td>");
		}

		html.append("</table>");

		listaMaterialAyudaXPartida = null;
		
		return html.toString();
	}

	public List<MaterialAyudaDTO> buscaListaMaterialAyudaPorPartidaEnDTO(int idPartida) {
		List<MaterialAyudaDTO> listaMaterialAyudaXPartidaEnDTO = new ArrayList<MaterialAyudaDTO>();
		List<MaterialAyudaXPartida> listaMaterialAyudaxPartida = materialAyudaXPartidaDAO.lista(idPartida);
		for (MaterialAyudaXPartida materialAyudaXPartida : listaMaterialAyudaxPartida) {
			MaterialAyudaDTO materialAyudaDTO = new MaterialAyudaDTO();
			materialAyudaDTO.setIdMaterialAyudaXPartida(materialAyudaXPartida.getIdMaterialAyudaXPartida());
			materialAyudaDTO.setNombreMaterialAyuda(materialAyudaXPartida.getMaterialAyuda().getNombre());
			materialAyudaDTO.setNombreResponsableInsumo(materialAyudaXPartida.getResponsableInsumo().getNombre());
			materialAyudaDTO.setObservaciones(materialAyudaXPartida.getObservaciones());
			listaMaterialAyudaXPartidaEnDTO.add(materialAyudaDTO);
			materialAyudaDTO 		= null;
			materialAyudaXPartida 	= null;
		}
		listaMaterialAyudaxPartida = null;
		return listaMaterialAyudaXPartidaEnDTO;
	}

}
