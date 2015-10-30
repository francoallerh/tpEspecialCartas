package com.faller.juegoCartas;

public class  PosimaValorFijo extends Posima {

	public  PosimaValorFijo(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcular(Atributo a, double suma) {
		
		return 5;
	}

}
