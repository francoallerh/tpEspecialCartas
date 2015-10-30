package com.faller.juegoCartas;

public class AtributoMenor extends Atributo {

	public AtributoMenor(String nombre, double valor, String operacion,
			String unidad) {
		super(nombre, valor, operacion,unidad);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int competencia(Atributo atriCarta2) {

		System.out.println("Atributo por el cual se compite: " + getNombre()
				+ "\n" + "Contienda: " + getOperacion() + "\n");

		if (getValor() < atriCarta2.getValor()) {
			return 1;
		} else if (getValor() == atriCarta2.getValor()) {
			return 0;
		}

		return 2;
	}	 

}
