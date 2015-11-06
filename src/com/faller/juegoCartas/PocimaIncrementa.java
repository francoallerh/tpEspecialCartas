package com.faller.juegoCartas;

public class PocimaIncrementa extends PocimaNoCompuesta {

	public PocimaIncrementa(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcular(Atributo a) {
		a.setValor(a.getValor()+((a.getValor()*super.getValor()/100)));

	}
	public PocimaGenerica miCopiar(){
		PocimaGenerica pcopy= new PocimaIncrementa(super.getNombre(), super.getValor());
		return pcopy;
	}
}



