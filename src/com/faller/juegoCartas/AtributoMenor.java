package com.faller.juegoCartas;

public class AtributoMenor extends Atributo {

	public AtributoMenor(String nombre, double valor, String operacion,
			String unidad) {
		super(nombre, valor, operacion,unidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean compitePorContienda(Atributo atriCarta2) 
	{
				if(getValor()<atriCarta2.getValor()){return true;}
				return false;
	}
		 

}
