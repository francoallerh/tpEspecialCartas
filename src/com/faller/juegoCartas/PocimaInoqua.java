package com.faller.juegoCartas;

public class PocimaInoqua extends PocimaGenerica{



	public PocimaInoqua() {
		super("inoqua");
	}

	public void calcular(Atributo a) {
		
	}
	public PocimaGenerica miCopiar(){
		PocimaGenerica pcopy= new PocimaInoqua();
		return pcopy;
	}
}
