package com.faller.juegoCartas;

public class PosimaIncrementa extends PosimaNoCompuesta {

	public PosimaIncrementa(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcular(Atributo a) {
		return (a.getValor()*super.getValor()/100);

	}

}
