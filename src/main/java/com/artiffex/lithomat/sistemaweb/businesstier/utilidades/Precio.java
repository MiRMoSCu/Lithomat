package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;


public class Precio {
	
	private static final int TIPO_PRECIO_NO_APLICA 				= 1;
	private static final int TIPO_PRECIO_UNIDAD 				= 2;
	private static final int TIPO_PRECIO_CIENTO 				= 3;
	private static final int TIPO_PRECIO_MILLAR 				= 4;
	private static final int TIPO_PRECIO_HORA 					= 5;
	private static final int TIPO_PRECIO_PORCENTAJE 			= 6;
	private static final int TIPO_PRECIO_CENTIMETRO_CUADRADO 	= 7;
	
	
	public static float conversionRespectoTipoPrecio( float cantidadTipoPrecio, int idTipoPrecio ) {
		float precioFinal = 0;
		switch( idTipoPrecio ) {
			case TIPO_PRECIO_NO_APLICA:
				precioFinal = cantidadTipoPrecio * 0;
				break;
			case TIPO_PRECIO_UNIDAD:
				precioFinal = cantidadTipoPrecio / 1;
				break;
			case TIPO_PRECIO_CIENTO:
				precioFinal = cantidadTipoPrecio / 100;
				break;
			case TIPO_PRECIO_MILLAR:
				precioFinal = cantidadTipoPrecio / 1000;
				break;
			case TIPO_PRECIO_HORA:
				precioFinal = cantidadTipoPrecio / 60;
				break;
			case TIPO_PRECIO_PORCENTAJE:
				precioFinal = cantidadTipoPrecio / 100;
				break;
			case TIPO_PRECIO_CENTIMETRO_CUADRADO:
				precioFinal = cantidadTipoPrecio / 1;
				break;
			default:
				break;
		}
		return precioFinal;
	}
	
}
