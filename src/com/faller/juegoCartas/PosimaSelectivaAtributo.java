package com.faller.juegoCartas;

public class PosimaSelectivaAtributo extends PosimaNoCompuesta {

	public PosimaSelectivaAtributo(String nombre, Double valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcular(Atributo a) {
		if(a.getNombre().equals(super.getNombre())){
			return (a.getValor()*super.getValor()/100);
		}
		return 0;
		
	}

}
