package com.faller.juegoCartas;

public class  PosimaValorFijo extends PosimaNoCompuesta {

	public  PosimaValorFijo(String nombre) {
		super(nombre,5.0);
	
	}

	@Override
	public void calcular(Atributo a) {
		 a.setValor(super.getValor());
	}

}
