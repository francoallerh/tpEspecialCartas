package com.faller.juegoCartas;



public abstract class Atributo implements Comparable<Atributo> {
	private String nombre;
	private double valor;
	private String contienda;
	private String unidad;


	public Atributo(String nombre, double valor, String operacion, String unidad) {
		this.nombre = nombre.toLowerCase();
		this.valor = valor;
		this.contienda = operacion;
		this.unidad = unidad.toLowerCase();

		
	}
	
	abstract public  boolean compitePorContienda(Atributo atriCarta2);

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getOperacion() {
		return contienda;
	}
	public void setOperacion(String operacion) {
		this.contienda = operacion;
	}

	@Override
	public int compareTo(Atributo atr) {
		return nombre.compareTo(atr.nombre);
	}

	@Override
	public String toString() {
		return "Atributo [nombre=" + nombre + ", valor=" + valor
				+ ", operacion=" + contienda + ", unidad=" + unidad + "]";
	}
	

public int competencia(Atributo atriCarta2) 
	{

		System.out.println("Atributo por el cual se compite: "+getNombre() +"\n"+"Contienda: "+getOperacion()+"\n");
	

			if(compitePorContienda(atriCarta2))
				{
					return 1;
				}else if(getValor()==atriCarta2.getValor())
					{
						return 0;
					}
						
		return 2;

	}

	
}
