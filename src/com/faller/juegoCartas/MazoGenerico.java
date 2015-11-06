package com.faller.juegoCartas;

import java.util.ArrayList;
import java.util.Collections;

public abstract class  MazoGenerico  {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	
	public MazoGenerico(String nombre2) {
		this.nombre=nombre;
		cartas = new ArrayList<Carta>();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void borrarCarta(Carta a) {
		cartas.remove(a);
	}
	public void borrarCartas() {
		for(int i=0;i<cantCartas();i++){cartas.remove(i);}
	
	}

	public int cantCartas() {
		return cartas.size();
	}
	public Carta getCarta(int c) {
		return cartas.get(c);
	}
	
	public boolean mazoCorrecto() {
		for (Carta car : cartas)
				{
					if(!(cartas.get(0).equals(car)))
						{
							return false;
						}
					}return true;

	}
	public void mezclarMazo() {
		Collections.shuffle(cartas);
	}
	

private boolean existeCarta(Carta x)
	{
		for(int i=0;i<cantCartas();i++)
			{
				if(getCarta(i).equals(x))
					{
					 return true;
					}
			}
		return false;
	}
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void agregarCarta(Carta a)
		{		
			cartas.add(a);

		}
	
	public void intercambiaCaras(Jugador jugadorQueRecive, Jugador jugadorQueCede)
	{
		jugadorQueRecive.agregarCarta(jugadorQueCede.getCarta(0));
		jugadorQueCede.borrarCarta(jugadorQueCede.getCarta(0));
		
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


	@Override
	public String toString() {
		return "MazoGenerico [nombre=" + nombre + ", cartas=" + cartas
				+ ", getNombre()=" + getNombre() + ", cantCartas()="
				+ cantCartas() + ", mazoCorrecto()=" + mazoCorrecto()
				+ ", tieneCartas()=" + tieneCartas() + ", totalDcartas()="
				+ totalDcartas() + "]";
	}

	

}
