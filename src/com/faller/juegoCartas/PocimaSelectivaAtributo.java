package com.faller.juegoCartas;

public class PocimaSelectivaAtributo extends PocimaNoCompuesta {

	public PocimaSelectivaAtributo(String nombre, Double valor) {
		super(nombre, valor);
	}

	@Override
	public void calcular(Atributo a) {
		if(a.getNombre().equals(super.getNombre())){
			a.setValor(a.getValor()-((a.getValor()*super.getValor()/100)));
		}
		
		
	}

}
