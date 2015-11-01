package com.faller.juegoCartas;


import java.util.ArrayList;
import java.util.Random;


public class Jugador {
	private String nombre;
	private ArrayList<Carta> cartas;
	private boolean turno;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		cartas = new ArrayList<Carta>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta getCarta(int c) {
		return cartas.get(c);
	}
	public int cantCartas()
	{
	return  cartas.size();
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	public String randomAtributo() {
		int aux = getCarta(0).cantAtributos();
		Random rand = new Random();
		return getCarta(0).getAtributo(rand.nextInt(aux)).getNombre();
		
	}
	
	public void agregarCarta(Carta a)
		{
			cartas.add(a);
		}
	
	public void borrarCarta(Carta a) {
		cartas.remove(a);
	}
	
	public void borrarCartas() {
		cartas.clear();
	}
	
	public boolean tieneCartas() {
		if (cartas.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public Carta obtenerCarta(String nombre) {
		for (Carta c : cartas) {
			if(c.getNombre() == nombre.toLowerCase()) {
				return c;
			}
		}
		return null;
	}
	
	public int totalDcartas() {
		int i = 0;
		for (Carta c : cartas) {
			i++;
			}
		return i;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	
}
