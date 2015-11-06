package com.faller.juegoCartas;

public class AtributoMayor extends Atributo {

	public AtributoMayor(String nombre, double valor, String contienda,
			String unidad) {
		super(nombre, valor, contienda, unidad);
		// TODO Auto-generated constructor stub
	}

	public Atributo copiar(){
		Atributo a=new AtributoMayor(this.getNombre(),this.getValor(),this.getContienda(), this.getUnidad());
		return a;
	}
	
	@Override
	public int compite(Atributo atriCarta2) {

		System.out.println("Atributo por el cual se compite: " + getNombre()
				+ "\n" + "Contienda1: " + getContienda() + "\n" );
		if (getValor() > atriCarta2.getValor()) {
			return 1;
		} else if (getValor() == atriCarta2.getValor()) {
			return 0;
		}
		 else if 	(getValor() <atriCarta2.getValor()) {
			 return 2;
		 }
		 return 222;
	}

}
