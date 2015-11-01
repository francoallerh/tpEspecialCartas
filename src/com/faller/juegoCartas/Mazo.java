package com.faller.juegoCartas;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Mazo {
	private String nombre;
	private int cantidad;
	private ArrayList<Carta> cartas;
   	private ArrayList<Carta> cartasEnJuego;

public Mazo(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		cartas = new ArrayList<Carta>(cantidad);
		cartasEnJuego=new ArrayList<Carta>();
		
		
	}



  
public Mazo(String nombre) {
	this.nombre = nombre;
	cartas = new ArrayList<Carta>();
    this.cartasEnJuego=new ArrayList<Carta>();

}

	@Override
	public String toString() {
		return "Mazo [nombre=" + nombre + ", cantidad=" + cantidad
				+ ", cartas=" + cartas + ", getNombre()=" + getNombre()
				+ ", getCantidad()=" + getCantidad() + ", getCartas()="
				+ cantCartas() + ", mazoCorrecto()=" + mazoCorrecto() + "]";
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int cantCartas() {
		return cartas.size();
	}
	public Carta getCarta(int c) {
		return cartas.get(c);
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
	
	
	public void borrarCarta(Carta a) {
		cartas.remove(a);
	}
	
	public void borrarCartas() {
		for(int i=0;i<cantCartas();i++){cartas.remove(i);}
	
	}
	public Carta obtenerCarta(String nombre) {
		for (Carta c : cartas) {
			if(c.getNombre() == nombre.toLowerCase()) {
				return c;
			}
		}
		return null;
	}
	
	public boolean mazoCorrecto() {
			if(cantCartas()==getCantidad())
				{
					for (Carta car : cartas)
					{
						if(!(cartas.get(0).equals(car)))
							{
								return false;
							}
					}return true;
				}return false;
		}
		

	public void mezclarMazo() {
		Collections.shuffle(cartas);
	}
	
	public void intercambiaCaras(Jugador jugadorQueRecive, Jugador jugadorQueCede)
	{
		jugadorQueRecive.agregarCarta(jugadorQueCede.getCarta(0));
		jugadorQueCede.borrarCarta(jugadorQueCede.getCarta(0));
		
	}

	public void repartirMazo(Jugador p1, Jugador p2) {
		int i=1;
		for(Carta c: cartas)
			{
			if((i%2==0)){p1.agregarCarta(c); }
			else{p2.agregarCarta(c);}
			i++;
			}
		this.borrarCartas();
	}
	public Carta getCartaEnJuego(int c) {
		return cartasEnJuego.get(c);
	}

	public void setCartasEnJuego(ArrayList<Carta> cartasEnJuego) {
		this.cartasEnJuego = cartasEnJuego;
	}
	public void borrarCartasEnJuego(Carta c) {
		cartasEnJuego.remove(c);
	}
	
	public void agregarCartaEnJuego(Carta a) {
		cartasEnJuego.add(a);
	}
	
	public boolean cartasEnJuegoTieneCartas() {
		if (cartasEnJuego.isEmpty()) {
			return false;
		}
		return true;
	}

public int catCartasEnJuego()
	{
       return cartasEnJuego.size();
	}

private void eliminarCartasEnJuego()
	{
		for(int i=0;i<catCartasEnJuego();i++){
			cartasEnJuego.remove(i);
		}
	}

public void transfiereCartasAlGanador(Jugador jugadorReceptor) 
	{
		for(int i=0;i<catCartasEnJuego();i++){jugadorReceptor.agregarCarta(getCartaEnJuego(i));}
			eliminarCartasEnJuego();
	}


}

