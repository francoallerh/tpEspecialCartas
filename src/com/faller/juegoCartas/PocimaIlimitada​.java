package com.faller.juegoCartas;

public class PocimaIlimitada​ extends PocimaDecrementa {
private int decremento=1;
private double segundo_decremento;

	public PocimaIlimitada​(String nombre,double primerDecremento, double segundo_decremento){
		super(nombre,primerDecremento);
		this.segundo_decremento=segundo_decremento;
	}
	
	@Override
	public void calcular(Atributo a) {
		if(decremento==1){
		super.calcular(a);
		decremento=2;
		}else if(decremento==2){
			a.setValor(a.getValor()+((a.getValor()*segundo_decremento/100)));
			decremento=3;
		}

	}
	public PocimaGenerica miCopiar(){
		PocimaGenerica pcopy= new PocimaIlimitada​(super.getNombre(), super.getValor(), this.segundo_decremento);
		return pcopy;
	}
}
