package com.faller.juegoCartas;

public class PosimaSelectivaAtributo extends PosimaNoCompuesta {

	public PosimaSelectivaAtributo(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcular(Atributo a) {
		if(a.getNombre().equals(super.getNombre())){
			a.setValor(a.getValor()-((a.getValor()*super.getValor()/100)));
		}
		
		
	}

}
