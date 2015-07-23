package com.artiffex.lithomat.sistemaweb.businesstier.utilidades;

import java.io.Serializable;

public class ComboSelect implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6891558172805233689L;
	
	private int value;
	private String text;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
