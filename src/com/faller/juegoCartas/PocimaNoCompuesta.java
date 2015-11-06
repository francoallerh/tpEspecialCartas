package com.faller.juegoCartas;

public abstract class PocimaNoCompuesta extends PocimaGenerica {
private double valor;

public PocimaNoCompuesta(String nombre,Double valor){
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
public abstract void calcular(Atributo a);



}





