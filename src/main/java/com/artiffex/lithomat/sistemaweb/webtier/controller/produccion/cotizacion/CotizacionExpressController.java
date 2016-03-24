package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cotizacion;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizadorExpressDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPlacaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/cotizacion_express")
public class CotizacionExpressController {

	private static final Logger log = Logger.getLogger(CotizacionExpressController.class);
	
	@Resource
	private TipoClienteService tipoClienteService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private TintaEspecialService tintaEspecialService;
	@Resource
	private TipoPlacaService tipoPlacaService;
	
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaCotizacion( Locale locale, Model model ) throws IOException {
		log.info("/cotizacion_express");
		
		List<ComboSelect> listaTipoCliente = tipoClienteService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		listaTipoCliente = null;
		
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		List<ComboSelect> listaCombinacionTintas = combinacionTintasService.listaComboSelect();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;
		
		List<ComboSelect> listaTipoBarniz = tipoBarnizService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		listaTipoBarniz = null;
		
		return "produccion/cotizacion/ventana_cotizacion_express";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/calcula", method = RequestMethod.POST)
	@ResponseBody
	public CotizadorExpressDTO calculaCotizacionExpress(
			@RequestParam(value = "id_tipo_cliente", 				required = false) Integer idTipoCliente,
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "cantidad", 						required = false) Integer cantidad,
			@RequestParam(value = "numero_pliegos", 				required = false) float numeroPliegos,
			@RequestParam(value = "frente_id_combinacion_tintas", 	required = false) Integer frenteIdCombinacionTintas,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 	required = false) Integer vueltaIdCombinacionTintas,
			@RequestParam(value = "frente_numero_tinta_especial", 	required = false) Integer frenteNumeroTintaEspecial,
			@RequestParam(value = "vuelta_numero_tinta_especial", 	required = false) Integer vueltaNumeroTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 			required = false) Integer frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_tipo_barniz", 			required = false) Integer vueltaIdTipoBarniz,
			@RequestParam(value = "id_tipo_placa", 					required = false) Integer idTipoPlaca,
			@RequestParam(value = "vuelta_mismas_placas", 			required = false) boolean vueltaMismasPlacas
		) {
		log.info("/calcula_cotizacion");
		
		float cotizacionCosteTotal = 0;
		
		// CANTIDAD
		int cantidadRedondeada = 0;
		if ( cantidad <= 100 )
			cantidadRedondeada = 1000;
		else if ( (cantidad % 1000 ) > 300 )
			cantidadRedondeada = ( ( cantidad / 1000 ) + 1 ) * 1000;
		else 
			cantidadRedondeada = cantidad;
		
		// PRECIO TABULADOR
		float precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, idMaquina, cantidadRedondeada );
		
		// PLACAS inicio
		int numeroPlacas = 0;
		
		// TINTA
		CombinacionTintas frenteCombinacionTintas = combinacionTintasService.buscaCombinacionTintas(frenteIdCombinacionTintas);
		int frenteTintaEntradasMaquina = frenteCombinacionTintas.getNumTintas();
		numeroPlacas += frenteTintaEntradasMaquina;
		frenteCombinacionTintas = null;
		
		CombinacionTintas vueltaCombinacionTintas = combinacionTintasService.buscaCombinacionTintas(vueltaIdCombinacionTintas);
		int vueltaTintaEntradasMaquina = vueltaCombinacionTintas.getNumTintas();
		if ( !vueltaMismasPlacas )
			numeroPlacas += vueltaTintaEntradasMaquina;
		vueltaCombinacionTintas = null;
		
		int tintaNumEntMaq = frenteTintaEntradasMaquina + vueltaTintaEntradasMaquina;
		float tintaPrecioUnitario = precioUnitarioTabulador;
		float tintaCosteTotal = numeroPliegos * cantidadRedondeada * tintaNumEntMaq * tintaPrecioUnitario;
		
		cotizacionCosteTotal += tintaCosteTotal;
		
		// TINTA ESPECIAL
		HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
		int tintaEspecialNumEntMaq = frenteNumeroTintaEspecial + vueltaNumeroTintaEspecial;
		numeroPlacas += frenteNumeroTintaEspecial;
		if ( !vueltaMismasPlacas )
			numeroPlacas += vueltaNumeroTintaEspecial;
		float tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
		float tintaEspecialCosteTotal = numeroPliegos * cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
		
		cotizacionCosteTotal += tintaEspecialCosteTotal;
		
		// BARNIZ
		TipoBarniz frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(frenteIdTipoBarniz);
		int frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
		numeroPlacas += frenteTipoBarniz.getNumPlacas();
		float frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
		float frenteBarnizCosteTotal = numeroPliegos * cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
		frenteTipoBarniz = null;
		
		cotizacionCosteTotal += frenteBarnizCosteTotal;
		
		TipoBarniz vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(vueltaIdTipoBarniz);
		int vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
		if ( !vueltaMismasPlacas )
			numeroPlacas += vueltaTipoBarniz.getNumPlacas();
		float vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
		float vueltaBarnizCosteTotal = numeroPliegos * cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
		vueltaTipoBarniz = null;
		
		cotizacionCosteTotal += vueltaBarnizCosteTotal;
		
		// PLACAS
		TipoPlaca tipoPlaca = tipoPlacaService.buscaTipoPlaca(idTipoPlaca);
		float placasPrecioUnitario 	= tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor();
		float placasCosteTotal = numeroPlacas * placasPrecioUnitario;
		tipoPlaca = null;
		
		cotizacionCosteTotal += placasCosteTotal;
		
		CotizadorExpressDTO cotizadorExpress = new CotizadorExpressDTO();
		cotizadorExpress.setTintaDescripcion(tintaNumEntMaq + " [" + String.format("%.3f", tintaPrecioUnitario) + "]");
		cotizadorExpress.setTintaEspecialDescripcion(tintaEspecialNumEntMaq + " [" + String.format("%.3f", tintaEspecialPrecioUnitario) + "]" );
		cotizadorExpress.setBarnizDescripcion("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
		cotizadorExpress.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]" );
		cotizadorExpress.setTintaCosteTotal(tintaCosteTotal);
		cotizadorExpress.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
		cotizadorExpress.setBarnizCosteTotal(frenteBarnizCosteTotal + vueltaBarnizCosteTotal);
		cotizadorExpress.setPlacasCosteTotal(placasCosteTotal);
		cotizadorExpress.setCotizacionCosteTotal(cotizacionCosteTotal);
		
		return cotizadorExpress;
	}
	
}
