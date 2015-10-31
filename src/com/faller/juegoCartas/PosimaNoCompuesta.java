package com.faller.juegoCartas;

public class PosimaNoCompuesta extends PosionGenerica {
private double valor;

public PosimaNoCompuesta(String nombre,Double valor){
	super(nombre);
	this.valor=valor;
	
}


public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}


@Override
public void calcular(Atributo a) {
	a.setValor(a.getValor());
}




}
