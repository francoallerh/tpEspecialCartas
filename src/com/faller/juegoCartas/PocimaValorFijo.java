package com.faller.juegoCartas;

public class  PocimaValorFijo extends PocimaNoCompuesta {

	public  PocimaValorFijo(String nombre) {
		super(nombre,5.0);
	
	}

	@Override
	public void calcular(Atributo a) {
		 a.setValor(super.getValor());
	}
	public PocimaGenerica miCopiar(){
		PocimaGenerica pcopy= new PocimaValorFijo(this.getNombre());
		return pcopy;
	}
}
