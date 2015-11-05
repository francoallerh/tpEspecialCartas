package com.faller.juegoCartas;

public abstract class Atributo implements Comparable<Atributo> {
	private String nombre;
	private double valor;
	private String unidad;
	private String contienda;

	public Atributo(String nombre, double valor,String contienda, String unidad) {
		this.nombre = nombre.toLowerCase();
		this.valor = valor;
		this.unidad = unidad.toLowerCase();
		this.contienda=contienda;

	}
	
	public abstract Atributo copiar(); 

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public double getValor() {
		
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getContienda() {
		return contienda;
	}

	public void setContienda(String contienda) {
		this.contienda = contienda;
	}

	@Override
	public int compareTo(Atributo atr) {
		return nombre.compareTo(atr.nombre);
	}

	@Override
	public String toString() {
		return "Atributo [nombre=" + nombre + ", valor=" + valor
				+ ", operacion=" + contienda + ", unidad=" + unidad + "]";
	}

	public abstract int compara(Atributo atriCarta2);

}
