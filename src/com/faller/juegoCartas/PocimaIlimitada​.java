package com.faller.juegoCartas;

public class PocimaIlimitada​ extends PocionGenerica {
private int decremento=2;
private static final int PRIMER_DECREMENTO=20;
private static final int SEGUNDO_DECREMENTO=10;

	public PocimaIlimitada​(String nombre){
		super(nombre);
	}
	
	@Override
	public void calcular(Atributo a) {
		if(decremento==2){
			decremento=1;
			a.setValor(a.getValor()+((a.getValor()*PRIMER_DECREMENTO/100)));
		}else if(decremento==1){
			a.setValor(a.getValor()+((a.getValor()*SEGUNDO_DECREMENTO/100)));
		}

	}

}
