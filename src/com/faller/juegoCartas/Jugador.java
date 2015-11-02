package com.faller.juegoCartas;


import java.util.ArrayList;
import java.util.Random;


public class Jugador {
	private String nombre;
	private MazoPozo pozo;
	private boolean turno;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		pozo = new MazoPozo("nombre");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta getCarta(int c) {
		return pozo.getCarta(c);
	}
	public int cantCartas()
	{
	return  pozo.cantCartas();
	}

	public void setCartas(MazoPozo cartas) {
		this.pozo = cartas;
	}
	public String randomAtributo() {
		int aux = getCarta(0).cantAtributos();
		Random rand = new Random();
		return getCarta(0).getAtributo(rand.nextInt(aux)).getNombre();
		
	}
	
	public void agregarCarta(Carta c)
		{
			pozo.agregarCarta(c);
		}
	
	public void borrarCarta(Carta a) {
		pozo.borrarCarta(a);
	}
	

	
	public boolean tieneCartas() {
		return pozo.tieneCartas();
			
	
	}
	

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	
}
