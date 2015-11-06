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


public class Mazo extends MazoGenerico{
	private static final int RANDOM_POSIMA =1;
	private static final int FIN_RANDOM_POSIMAS =3;
	private static final int INICIO_RANDOM_POSIMAS=1;
	
   	private ArrayList<Carta> cartasEnJuego;
	private ArrayList<PocimaGenerica> pocimas;
   	
public Mazo(String nombre) {
	super(nombre);
		cartasEnJuego=new ArrayList<Carta>();
		pocimas=new ArrayList<PocimaGenerica>();
	}





	public void repartirMazo(Jugador p1, Jugador p2) {
		int i=0;
		while(i<cantCartas())
			{
			Carta cartaArepartir = getCarta(i);
			if((pocimas.size()!=0)){
				if((enteroRandom(INICIO_RANDOM_POSIMAS,FIN_RANDOM_POSIMAS)==RANDOM_POSIMA)){
					cartaArepartir.SetPosima(pocimas.get(0));
					pocimas.remove(0);
				}
			}
			
			if((i%2==0)){p1.agregarCarta(cartaArepartir); }
			else{p2.agregarCarta(cartaArepartir);}
			i++;
			}
		this.borrarCartas();
	}
	
	public void agregarPocion(PocimaGenerica p){
		pocimas.add(p);
	}
	public  int enteroRandom(int min, int max) {
		Random rand = new Random();
		return (rand.nextInt((max - min) + 1) + min);
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

	public void intercambiaCaras(Jugador jugadorQueRecive, Jugador jugadorQueCede)
	{
		jugadorQueRecive.agregarCarta(jugadorQueCede.getCarta(0));
		jugadorQueCede.borrarCarta(jugadorQueCede.getCarta(0));
		
	}





	@Override
	public String toString() {
		return "Mazo [cartasEnJuego=" + cartasEnJuego + ", getNombre()=" + getNombre() + ", cantCartas()="
				+ cantCartas() + ", mazoCorrecto()=" + super.toString()+	 "]";
	}









	


}

