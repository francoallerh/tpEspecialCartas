package com.faller.juegoCartas;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Juego {
	public static final int GANA_PRIMERA = 1;
	public static final int GANA_SEGUNDA = 2;
	public static final int EMPATE = 0;
	public static final int TURNO_JUGADOR_1 = 1;
	public static final int TURNO_JUGADOR_2 =2;
	private int turno;
	private static Mazo baraja;
	private Jugador p1;
	private Jugador p2;
	

	
	public Juego(String nombrep1, String nombrep2, Mazo baraja)
		{
			this.p1 = new Jugador(nombrep1);
			this.p2 = new Jugador(nombrep2);
			this.baraja=baraja; 


		 }
	public static void main(String[] args)
	{
		String nombrep1;
		String nombrep2;
		do{			
				System.out.println ("Ingrese nombre jugador 1");
				 nombrep1= cargaStr();
		
				System.out.println ("Ingrese nombre jugador 2");
				nombrep2= cargaStr();
				
			}while(nombrep1.equals(nombrep2) && nombrep2.equals(nombrep1) );
	
		int mazoAcrear=0;
		do{
				System.out.println ("Si desea cargar un mazo modelo desde un archivo, entonces presione 1.  Si desea crear el maso precione generico, entonces presione 2");
				mazoAcrear= cargaInt();
				
		  }while(mazoAcrear!=1 && mazoAcrear!=2);
		
		 if(mazoAcrear==2)
			{
			 	 baraja=armarMazoGenerico();
			}else{
				 baraja=armarMazoDesdeArchivo();
				 }
		
	
				Juego j=new Juego(nombrep1,nombrep2, baraja);
				System.out.print(j.jugar());
	}
		

private static Mazo armarMazoDesdeArchivo()
		{
	 int mazoDefault=-1;
	 String ruta;
	 while(mazoDefault!=1 && mazoDefault!=2){System.out.println ("desea cargar maso por defecto. si=1 , no=2");mazoDefault=cargaInt();}
		if(mazoDefault==1){ruta="/home/francoe/TUDAIprogra2/prog2/src/com/faller/juegoCartas/cartas.txt";}
		else{  ruta= cargaStr(); }

    
    try {
        InputStream is= new FileInputStream(ruta);
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br= new BufferedReader(isr);
         
        String read=br.readLine();
        int posNombre=0;
        boolean fin=false;
        while((read!=null)&&(!fin))
        	{
            String[] valores=read.split(",");
        	if(posNombre==0)
        		{
        			 baraja=new Mazo(valores[0]);
        		}else if(!valores[0].equals("finArchivo"))
        			{
			            Carta c=armaCartaDeArchivo(valores);
			            baraja.agregarCarta(c);
        			}else{fin=true;}
        	posNombre++;
        	read=br.readLine();
        	}
    	System.out.print(baraja.toString());
        if((baraja.cantCartas())%2==0){
        	baraja.setCantidad(baraja.cantCartas());
        	return	baraja;
       }else{
    	   	System.out.print("debe de ingresar un numero par de cartas. Modifique el archivo y ejecute nuevamente el programa.");
    	   	System.exit(0);  
    	   	return baraja;}
    } catch (FileNotFoundException ex) {
        System.out.println("no se encontro el archivo");
        return baraja;
    } catch (IOException ex) {
        System.out.println("conflicto acceso archivo");
        return baraja;
    } 
    
}
	

public static Carta armaCartaDeArchivo(String[] valores) {
	String nombre=valores[0];
	Carta c= new Carta(nombre);
	int cantidadAt=0;
        for(int i=1;i<valores.length-4;i=i+4){
        	cantidadAt++;
        	if(new String(valores[i+3]).equals("<"))
        		{
        		 Atributo a=new AtributoMenor(new String(valores[i]),new Double(valores[i+1]),new String(valores[i+3]),new String(valores[i+2]));
        		 c.agregarAtributo(a);
        		}else{
        			 Atributo a=new AtributoMayor(new String(valores[i]),new Double(valores[i+1]),new String(valores[i+3]),new String(valores[i+2]));
        			 c.agregarAtributo(a);
        			}
        }c.setCantidadAtributos(cantidadAt);       
       return c;
}


private static Mazo armarMazoGenerico()
		{
		do{
				
				String nombreMazo;
				System.out.println ("Ingrese tipo de Mazo: ");
				nombreMazo= cargaStr();
				
				int totalCartas=-1;
				do{
				System.out.println ("Ingrese cartas totales del mazo(numero par)");
				totalCartas= cargaInt();
				
				}while(totalCartas%2!=0);
				baraja=new Mazo(nombreMazo, totalCartas);
			
			int cartasCreadas=0;
			int cantAtrisElegidos=0;
			do{
				System.out.print("ingrese la cantidad de atributos. debera ser un numero >3 y <8");
				cantAtrisElegidos=cargaInt();
				}while(!((cantAtrisElegidos>=4 ) && (cantAtrisElegidos<=7)));
				do{
					int cantidadAtributos=0;
					String nombrep = "Personaje-"+cartasCreadas;
					Carta c=new Carta(nombrep,cantAtrisElegidos);
					baraja.agregarCarta(c);
					if((baraja.cantCartas()==1))
						{
						 do{
								
							System.out.print("ingrese nombre del atributo");
							String nombreAtri=cargaStr();
							String contiendaAtri;
							int valor1;
							int valor2;
							do{
							System.out.print("Se dara un valor random para el atributo, ingrese el rango de los valores para hacer el random. EL primer valor debe ser mayor al segundo valor ingresado."+"\n");
							System.out.print("Ingrese valor 1");
							valor1=cargaInt();
							System.out.print("Ingrese valor 2");
							valor2=cargaInt();
							}while(valor1>valor2);

							do{
								 System.out.print("ingrese contienda del atributo");
								 contiendaAtri=cargaStr();
								}while(!(contiendaAtri.equals(">")||contiendaAtri.equals("<")));
									
								System.out.print("ingrese unidad del atributo");
								String unidadAtri=cargaStr();
								if(contiendaAtri.equals(">"))
									{
									c.agregarAtributo(new AtributoMayor(nombreAtri, enteroRandom(valor1, valor2),contiendaAtri,unidadAtri));
									}else{
											c.agregarAtributo(new AtributoMenor(nombreAtri, enteroRandom(valor1, valor2),contiendaAtri,unidadAtri));
									 		}
								cantidadAtributos++;
						   }while(cantidadAtributos!=c.getCantidadAtributos());
							 cantidadAtributos=0;
						}else{
							
							  do{
									
										Atributo a= baraja.getCarta(0).getAtributo(cantidadAtributos);
										if(a.getOperacion().equals(">"))
											{
												c.agregarAtributo(new AtributoMayor(a.getNombre(),enteroRandom(2, 200) ,a.getOperacion() ,a.getUnidad()));
											}else{
													c.agregarAtributo(new AtributoMenor(a.getNombre(),enteroRandom(2, 200) ,a.getOperacion() ,a.getUnidad()));
												 }
									cantidadAtributos++;
								   }while((cantAtrisElegidos!=cantidadAtributos));
							
								}
					cantidadAtributos=0;
					cartasCreadas++;
				   	}while(cartasCreadas!=baraja.getCantidad());
			}while(baraja.mazoCorrecto()==false);
			return baraja;
		}
	
	private static int enteroRandom(int min, int max) {
		Random rand = new Random();
		return (rand.nextInt((max - min) + 1) + min);
	}
	
	

	public Mazo getBaraja() {
		return baraja;
	}

	public void setBaraja(Mazo baraja) {
		this.baraja = baraja;
	}

	public Jugador getP1() {
		return p1;
	}

	public void setP1(Jugador p1) {
		this.p1 = p1;
	}

	public Jugador getP2() {
		return p2;
	}

	public void setP2(Jugador p2) {
		this.p2 = p2;
	}
	

	public String jugar() {

		if (baraja.mazoCorrecto()) {	
			int cuentaRondas=0;
			baraja.repartirMazo(p1, p2);
			int rescarta;
			boolean empate=false; 
			String atributoEnJuego="";	
			String atributoAcompetir="";
			Jugador	jugadorTurnoGanado;
			Jugador	jugadorPerdedor;
			
			while (p1.tieneCartas() || p2.tieneCartas()) {
	
				if(!p1.tieneCartas()){
					return " -------------------------"+"\n"+" Termino el juego:Ganador Jugador   "+ p2.getNombre();
				}else if(!p2.tieneCartas())
					{
					return " -------------------------"+"\n"+" Termino el juego:Ganador Jugador   "+ p1.getNombre();
					}

			do{
				cuentaRondas++;
				System.out.print("---------------------------------"+"\n"+"Comienza Ronda "+cuentaRondas+"\n"+"---------------------------------"+"\n");
				System.out.print("Cantidad de cartas jugador "+p1.getNombre()+" :"+p1.totalDcartas() +"\n"+"Cantidad de cartas jugador "+p2.getNombre()+" :"+p2.totalDcartas()+"\n");
		
				switch(turno)
					{
						case TURNO_JUGADOR_1:
						System.out.println("Turno de:"+p1.getNombre()+"\n");
						atributoAcompetir=p1.randomAtributo();
						jugadorTurnoGanado=p1;
						jugadorPerdedor=p2;
						break;
						
						case TURNO_JUGADOR_2:
						System.out.println("Turno de:"+p1.getNombre()+"\n");
						atributoAcompetir=p2.randomAtributo();
						jugadorPerdedor=p1;
						jugadorTurnoGanado=p2;
						break;
						
						default:
						if((baraja.cartasEnJuegoTieneCartas()))
							{
								atributoEnJuego=atributoAcompetir;	
							}else{
									atributoAcompetir=p1.randomAtributo();
								}
						jugadorTurnoGanado=p1;
						jugadorPerdedor=p2;
					}
				rescarta=Competencia(jugadorTurnoGanado, jugadorPerdedor,atributoAcompetir);
				//rescarta =j1.getCarta(0).obtieneAtributo(atributoAcompetir).competencia(j2.getCarta(0).obtieneAtributo(atributoAcompetir));
				System.out.println("Jugador "+p1.getNombre()+" :"+p1.getCarta(0).obtieneAtributo(atributoAcompetir).getValor() +"\n"+"Jugador  "+p2.getNombre()+" :"+p2.getCarta(0).obtieneAtributo(atributoAcompetir).getValor()+"\n");
				switch (rescarta) {
				case GANA_PRIMERA:
					baraja.intercambiaCaras(p1, p2);
					if(baraja.cartasEnJuegoTieneCartas())
						{
							baraja.transfiereCartasAlGanador(p1);
							empate=false;
						}
					System.out.println("----Ronda ganada por jugador "+ p1.getNombre());
					turno=1;
					break;
					
				case GANA_SEGUNDA:
					if(baraja.cartasEnJuegoTieneCartas())
						{
							baraja.transfiereCartasAlGanador(p2);
							empate=false;
						}
					baraja.intercambiaCaras(p2, p1);
					System.out.println("----Ronda ganada por  "+ p2.getNombre());
					turno=2;
					break;
					
				default:
					System.out.println("----Ronda con empate----");
					atributoAcompetir=atributoAcompetir;	
					empate=true;
					baraja.agregarCartaEnJuego(p1.getCarta(0));
					p1.borrarCarta(p1.getCarta(0));
					baraja.agregarCartaEnJuego(p2.getCarta(0));
					p2.borrarCarta(p2.getCarta(0));
					break;
				}
			}while((empate==true)&&(p1.tieneCartas() && p2.tieneCartas()));
				if((empate==true)&&( !p1.tieneCartas() && !p2.tieneCartas()))
					{
						System.out.print("Cantidad de cartas jugador 1: "+p1.totalDcartas() +"\n"+"Cantidad de cartas jugador 2 "+ p2.totalDcartas()+"\n");
						return "-------------------------"+"\n"+" Termino el juego: Empate. ";
					}
				}	
		
		}

		return "El mazo no es correcto.";
	}
	

private int Competencia(Jugador jugadorTurnoGanado, Jugador jugadorPerdedor, String atributoAcompetir)
	{
	return jugadorTurnoGanado.getCarta(0).obtieneAtributo(atributoAcompetir).competencia(jugadorPerdedor.getCarta(0).obtieneAtributo(atributoAcompetir));	 
	}

	
	private static String cargaStr()
		{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			boolean error=false;
			String ingreso = null;
				do{
					
					try{
						ingreso= (entrada.readLine());
						 error=false;
					}catch (Exception exc ) {
			            System.out.println( exc );
			            System.out.print("Ingrese un numero string: \n");
			            error=true;
					}
				}while(error!=false);
				return ingreso;
			}
			
			public static int cargaInt()
			{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			boolean error=false;
			int ingreso=0;
				do{
					
					try{
						ingreso= new Integer (entrada.readLine());
						 error=false;
					}catch (Exception exc ) {
			            System.out.println( exc );
			            System.out.print("Ingrese un numero nuevamente: \n");
			            error=true;
					}
				}while(error!=false);
				return ingreso;
		}
}
