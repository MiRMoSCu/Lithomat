package com.artiffex.lithomat.sistemaweb.ayuda;

import java.util.List;

public class Persona {
	private String nombrePersona;
	private List<Telefono> listaTelefono;
	
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public List<Telefono> getListaTelefono() {
		return listaTelefono;
	}
	public void setListaTelefono(List<Telefono> listaTelefono) {
		this.listaTelefono = listaTelefono;
	}
}
