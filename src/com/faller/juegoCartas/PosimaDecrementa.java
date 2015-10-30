package com.faller.juegoCartas;

public class PosimaDecrementa extends Posima {
	
public PosimaDecrementa(String nombre, double valor){
	super(nombre, valor);
}
	
	@Override
	public double calcular(Atributo a, double suma) {
		return suma=a.getValor()-(a.getValor()*super.getValor()/100);
	}

}
