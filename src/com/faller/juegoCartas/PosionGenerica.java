package com.faller.juegoCartas;

public abstract class PosionGenerica {
	private String nombre;
	
	public PosionGenerica(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void calcular(Atributo a);
	@Override
	public String toString() {
		return "PosionGenerica [nombre=" + nombre + "]";
	}



}
