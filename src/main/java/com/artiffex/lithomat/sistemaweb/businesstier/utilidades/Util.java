package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

public class Util {

	public String getDigitoVerificador(String fecha, String contador) {
		int potencia = 0;
		long sumaPotencia = 0;
		// 6 -->2015012 (anio + diaAnio: 2015167)
		for (int i = 0; i <= 6; i++) {
			potencia = Integer.parseInt(fecha.substring(i, i + 1));
			sumaPotencia = sumaPotencia + (potencia * potencia);
		}
		// 2 --> 0023 (contador)
		for (int i = 0; i <= 3; i++) {
			potencia = Integer.parseInt(contador.substring(i, i + 1));
			sumaPotencia = sumaPotencia + (potencia * potencia);
		}
		sumaPotencia = sumaPotencia % 9;
		return String.valueOf(sumaPotencia);
	}

}
