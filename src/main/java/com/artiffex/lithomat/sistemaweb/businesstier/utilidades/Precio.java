package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

public class Precio {
	
	private static final int TIPO_PRECIO_NO_APLICA 				= 1;
	private static final int TIPO_PRECIO_UNIDAD 				= 2;
	private static final int TIPO_PRECIO_CIENTO 				= 3;
	private static final int TIPO_PRECIO_MILLAR 				= 4;
	private static final int TIPO_PRECIO_HORA 					= 5;
	private static final int TIPO_PRECIO_PORCENTAJE 			= 6;
	private static final int TIPO_PRECIO_CENTIMETRO_CUADRADO 	= 7;
	
	public static float calculaPrecioRespectoTipoPrecio(float precioBase, int idTipoPrecio, float cantidadTipoPrecio ) {
		
		float precioFinal = 0f;
		
		switch (idTipoPrecio) {
			case TIPO_PRECIO_NO_APLICA:
				precioFinal = precioBase * 0;
				break;
				
			case TIPO_PRECIO_UNIDAD:
				precioFinal = cantidadTipoPrecio;
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
				precioFinal = precioBase + (precioBase * (cantidadTipoPrecio / 100));
				break;
				
			case TIPO_PRECIO_CENTIMETRO_CUADRADO:
				break;
				
			default:
				break;
		}
		return precioFinal;
	}
	
	public static long cortaADosDecimales( double d ) {
		return (long) ((long) (d * 1e2) / 1e2);
	}
}
