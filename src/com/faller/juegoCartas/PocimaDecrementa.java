package com.faller.juegoCartas;

public class PocimaDecrementa extends PocimaNoCompuesta {
	
public PocimaDecrementa(String nombre, double valor){
	super(nombre, valor);
}
	
	@Override
	public void calcular(Atributo a) {
	a.setValor(a.getValor()-((a.getValor()*super.getValor()/100)));
	}
	public PocimaGenerica miCopiar(){
		PocimaGenerica pcopy= new PocimaDecrementa(super.getNombre(), super.getValor());
		return pcopy;
	}

}
