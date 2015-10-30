package com.faller.juegoCartas;

public class PosimaSelectivaAtributo extends Posima {

	public PosimaSelectivaAtributo(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcular(Atributo a, double suma) {
		if(a.getNombre().equals(super.getNombre())){
			return suma=a.getValor()+(a.getValor()*super.getValor()/100);
		}
		return suma=0;
	}

}
