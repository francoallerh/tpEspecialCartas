package com.faller.juegoCartas;

public abstract class Formula {
private String nombre;
private Double valor;

public Formula(String nombre,Double valor){
	this.nombre=nombre;
	this.valor=valor;
}
public abstract double calcular(Atributo a, double suma);

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}




}
