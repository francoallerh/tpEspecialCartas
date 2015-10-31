package com.faller.juegoCartas;

public abstract class PosimaGenerica {
	private String nombre;
	
	public PosimaGenerica(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void calcular(Atributo a);


}
