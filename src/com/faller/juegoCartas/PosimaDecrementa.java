package com.faller.juegoCartas;

public class PosimaDecrementa extends PosimaNoCompuesta {
	
public PosimaDecrementa(String nombre, double valor){
	super(nombre, valor);
}
	
	@Override
	public void calcular(Atributo a) {
	a.setValor(a.getValor()+((a.getValor()*super.getValor()/100)));
	}

}
