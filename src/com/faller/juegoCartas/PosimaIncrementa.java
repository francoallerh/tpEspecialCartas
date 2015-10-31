package com.faller.juegoCartas;

public class PosimaIncrementa extends PosimaNoCompuesta {

	public PosimaIncrementa(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcular(Atributo a) {
		a.setValor(a.getValor()+((a.getValor()*super.getValor()/100)));

	}

}
