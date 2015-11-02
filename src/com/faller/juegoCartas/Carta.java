package com.faller.juegoCartas;


import java.util.*;

public class Carta {

	private static final int CANT_ATRIBUTOS_MINIMOS=4;
	private static final int  CANT_ATRIBUTOS_MAXIMOS=7;
	
	private String nombre;
	private int cantidadAtributos;
	private ArrayList<Atributo> atributos;
	private PocionGenerica posion=new PocimaInoqua();
	
	public Carta(String nombre,int cantidadAtributos) {
		this.nombre = nombre.toUpperCase();
		this.cantidadAtributos=cantidadAtributos;
		atributos = new ArrayList<Atributo>();
		
	}

	public Carta(String nombre) {
		this.nombre = nombre.toUpperCase();
		atributos = new ArrayList<Atributo>(); 
	}

	
	public String getNombre() {
		return nombre;
	}
public void SetPosima(PocionGenerica p){
	this.posion=p;
}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	
	public Atributo getAtributo(int c) {
		return atributos.get(c);
	}
	
	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public void agregarAtributo(Atributo a) {
			atributos.add(a);
		//if(!atributos.contains(a)){atributos.add(a);}
	}
	
	public Atributo obtieneAtributo(String nombre) {
		for (Atributo a : atributos) {
			if(a.getNombre().equals(nombre)) {
				Atributo atributoConPosima=a.copiar();
				posion.calcular(atributoConPosima);
				return atributoConPosima;
			}
		}
		return null;
	}
	
	public void borraAtributo(String nombre) {
		for (Atributo a : atributos) {
			if(a.getNombre() == nombre.toLowerCase()) {
				atributos.remove(a);
			}
		}
	}
	
	public int cantAtributos() {
		
		return atributos.size();
	}	
	

	public boolean equals(Object o) {
		if (o instanceof Carta) {
			Carta aux = (Carta)o;
			
			if((this.cantAtributos()>=CANT_ATRIBUTOS_MINIMOS) && (this.cantAtributos()<=CANT_ATRIBUTOS_MAXIMOS)) 
				{
							if ((this.atributos.size() == aux.cantAtributos())) 
								{
									for (Atributo a : this.atributos)//compara que los atributos de un carta 
																	//esten en orden y que se llamen igual
										{
										for (Atributo b : aux.atributos)
											{
												if(a.getNombre().equals(b.getNombre()))
													{
														
														if(!(a.getContienda().equals(b.getContienda()))){return false;}
													}												

											}
										}
								return true;
								}System.out.print("todas las cartas no tienen la misma cantidad de atributos o no son del mismo tipo."+"\n");
							return false;
				
					
					}else{System.out.print("La cantidad de atributos no esta dentro del rango."+"\n");
						return false;
						}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", cantidadAtributos="
				+ cantidadAtributos + ", atributos=" + atributos + ", posion="
				+ posion + "]";
	}

	public int getCantidadAtributos() {
		return cantidadAtributos;
	}
	public void setCantidadAtributos(int cantidadAtributos) {
		this.cantidadAtributos = cantidadAtributos;
	}

	


}