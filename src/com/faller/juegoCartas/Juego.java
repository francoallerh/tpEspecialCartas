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
	private static final int CANT_ATRIBUTOS_MINIMOS=4;
	private static final int  CANT_ATRIBUTOS_MAXIMOS=7;
	
	public static final int GANA_PRIMERA = 1;
	public static final int GANA_SEGUNDA = 2;
	public static final int EMPATE = 0;
	private  Mazo baraja;
	private Jugador p1;
	private Jugador p2;
//	private ArrayList<PocimaGenerica> pocimas;
	

	

	public Juego() {
		this.p1 = new Jugador("jugador1");
		this.p2 = new Jugador("nombrep2");
	}
	public static void main(String[] args) throws IOException
	{
		Juego j=new Juego();
		String nombrep1;
		String nombrep2;
		do{			
				System.out.println ("Ingrese nombre jugador 1");
				 nombrep1= j.cargaStr();
		
				System.out.println ("Ingrese nombre jugador 2");
				nombrep2= j.cargaStr();
				
			}while(nombrep1.equals(nombrep2) && nombrep2.equals(nombrep1) );
		j.p1.setNombre(nombrep1);
		j.p2.setNombre(nombrep2);
	
//		int mazoAcrear=0;
//		do{
//				System.out.println ("Si desea cargar un mazo modelo desde un archivo, entonces presione 1.  Si desea crear el maso precione generico, entonces presione 2");
//				mazoAcrear= j.cargaInt();
//				
//		  }while(mazoAcrear!=1 && mazoAcrear!=2);
//	
//		 if(mazoAcrear==2)
//			{
//			 	 Mazo b= j.armarMazoGenerico();
//
//					j.setBaraja(b);
//			}else{
				Mazo b= j.armarMazoDesdeArchivo();
//
//				j.setBaraja(b);
//				 }
//		
	
				System.out.print(j.jugar());
	}
	private int controlaPathMazoACrear(String path){

		 int correcto=0;
	    try {
	   	 InputStream is=new FileInputStream(path);
	     return 1;
	      
	    } catch (FileNotFoundException ex) {
	        System.out.println("no se encontro el archivo");
	        return 2;
	    } catch (IOException ex) {
	        System.out.println("conflicto acceso archivo");
	        return 2;
	    } 
	}
		
	

public  Mazo armarMazoDesdeArchivo() throws IOException
		{
	 int  PathCorrecto=0;
	 String ruta;
	System.out.print("/home/francoe/TUDAIprogra2/prog2/src/com/faller/juegoCartas/cartas.txt"+ "\n");
	 InputStream is=null;
	 while(PathCorrecto!=1 ){
		 System.out.println("ingrese el path del archivo.");
	 ruta= cargaStr();
	 PathCorrecto= controlaPathMazoACrear(ruta);
	 if(PathCorrecto!=1){
		 System.out.println("ha ingresado mal la ruta, verifiquelo y vuelva a intertar");
	 }else{
		 is=new FileInputStream(ruta);
	 }
	  
	 }
	 
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
        			}else{
        				fin=true;
        			
        				}
        	posNombre++;
        	read=br.readLine();
        	}
    	br.close();
        if((baraja.cantCartas())%2==0){
        	return	baraja;
       }else{
    	   	System.out.print("debe de ingresar un numero par de cartas. Modifique el archivo y ejecute nuevamente el programa.");
    	   	System.exit(0);  
    	   	return baraja;}
    }
    

public void juegoConPosimas(){
int jugar=-1;
	while(jugar!=1 && jugar!=2){
		System.out.print("Desea jugar con pocimas?, 1=SI , 2=NO");
		jugar=cargaInt();
		if(jugar==1){
	//se pregunta si se desea agregar posimas al juego, si se desea entonces se instancian 
		//estas cartas y se llama a repartir cartas aleatoreas
//	pocimas=new ArrayList<PocimaGenerica>();
	
	

	
	/********************PosimaDecrementa*****************************/

	PocimaGenerica posion4=new PocimaDecrementa("choripan",10.22);
	PocimaGenerica posion5=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion6=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion7=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion8=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion9=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion10=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion11=new PocimaDecrementa("choripan",98.22);
	PocimaGenerica posion12=new PocimaDecrementa("choripan",98.22);



	/********************PosimaIncrementa*****************************/
	PocimaGenerica posion17=new PocimaIncrementa("choripan",1115080.22);
	PocimaGenerica posion18=new PocimaIncrementa("choripan",1115050.40);
	PocimaGenerica posion19=new PocimaIncrementa("choripan",1115050.30);
	PocimaGenerica posion20=new PocimaIncrementa("choripan",11150.50);
	
	/********************PosimaValorFijo*****************************/
	PocimaGenerica posion21= new PocimaValorFijo("PosimaValorFijo1");
	PocimaGenerica posion22= new PocimaValorFijo("PosimaValorFijo2");
	PocimaGenerica posion23= new PocimaValorFijo("PosimaValorFijo3");
	PocimaGenerica posion24= new PocimaValorFijo("PosimaValorFijo4");
	
	/********************PocimaSelectivaAtributo*****************************/
	PocimaGenerica posion25= new PocimaSelectivaAtributo("fuerza",35.00);
	PocimaGenerica posion26= new PocimaSelectivaAtributo("peso",43.00);
	PocimaGenerica posion27= new PocimaSelectivaAtributo("peleasganadas",50.00);
	PocimaGenerica posion28= new PocimaSelectivaAtributo("fuerza",35.00);
	
	/********************PocimaIlimitada​*****************************/
	PocimaGenerica posion32= new PocimaIlimitada​("PocimaIimitada1",20,10);
	PocimaGenerica posion29= new PocimaIlimitada​("PocimaIimitada2",20,10);
	PocimaGenerica posion30= new PocimaIlimitada​("PocimaIimitada3",20,10);
	PocimaGenerica pocion31= new PocimaIlimitada​("PocimaIimitada4",20,10);
	
	
	/********************PosimaCocktail*****************************/
	PocimaCocktail posion13= new PocimaCocktail("cokt1",posion12);
	PocimaCocktail posion14= new PocimaCocktail("cokt1",posion12);
	PocimaCocktail posion15= new PocimaCocktail("cokt1",posion12);
	PocimaCocktail posion16= new PocimaCocktail("cokt1",posion12);
	
	
	posion14.agregarPosion(posion5);
	
	posion13.agregarPosion(posion4);
	posion13.agregarPosion(posion17);
	posion13.agregarPosion(posion21);
	posion13.agregarPosion(posion25);
	posion13.agregarPosion(posion21);
	posion13.agregarPosion(posion32);
	posion13.agregarPosion(posion14);
	

	posion15.agregarPosion(posion6);
	posion16.agregarPosion(posion7);
	
	//posion13.agregarPosion(posion4);
	baraja.agregarPocion(posion8);
	baraja.agregarPocion(posion9);
	baraja.agregarPocion(posion10);
	baraja.agregarPocion(posion11);
	baraja.agregarPocion(posion12);
	baraja.agregarPocion(posion13);
	baraja.agregarPocion(posion14);
	baraja.agregarPocion(posion15);
	baraja.agregarPocion(posion16);
	baraja.agregarPocion(posion18);
	baraja.agregarPocion(posion19);
	baraja.agregarPocion(posion20);
	baraja.agregarPocion(posion22);
	baraja.agregarPocion(posion23);
	baraja.agregarPocion(posion24);
	baraja.agregarPocion(posion26);
	baraja.agregarPocion(posion27);
	baraja.agregarPocion(posion28);
	baraja.agregarPocion(posion29);
	baraja.agregarPocion(posion30);
	baraja.agregarPocion(pocion31);
	
		}
	}
}



public  Carta armaCartaDeArchivo(String[] valores) {
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
        };       
       return c;
}



//
//public  Mazo armarMazoGenerico()
//		{
//		do{
//				
//				String nombreMazo;
//				System.out.println ("Ingrese tipo de Mazo: ");
//				nombreMazo= cargaStr();
//				
//				int totalCartas=-1;
//				do{
//				System.out.println ("Ingrese cartas totales del mazo(numero par)");
//				totalCartas= cargaInt();
//				
//				}while(totalCartas%2!=0);
//				baraja=new Mazo(nombreMazo);
//			
//			int cartasCreadas=0;
//			int cantAtrisElegidos=0;
//			do{
//				System.out.print("ingrese la cantidad de atributos. debera ser un numero >3 y <8");
//				cantAtrisElegidos=cargaInt();
//				}while((cantAtrisElegidos>=CANT_ATRIBUTOS_MINIMOS ) ||(cantAtrisElegidos<=CANT_ATRIBUTOS_MAXIMOS));
//				do{
//					int cantidadAtributos=0;
//					String nombrep = "Personaje-"+cartasCreadas;
//					Carta c=new Carta(nombrep,cantAtrisElegidos);
//					baraja.agregarCarta(c);
//					if((baraja.cantCartas()==1))
//						{
//						 do{
//								
//							System.out.print("ingrese nombre del atributo");
//							String nombreAtri=cargaStr();
//							String contiendaAtri;
//							int valor1;
//							int valor2;
//							do{
//							System.out.print("Se dara un valor random para el atributo, ingrese el rango de los valores para hacer el random. EL primer valor debe ser mayor al segundo valor ingresado."+"\n");
//							System.out.print("Ingrese valor 1");
//							valor1=cargaInt();
//							System.out.print("Ingrese valor 2");
//							valor2=cargaInt();
//							}while(valor1>valor2);
//
//							do{
//								 System.out.print("ingrese contienda del atributo");
//								 contiendaAtri=cargaStr();
//								}while(!(contiendaAtri.equals(">")||contiendaAtri.equals("<")));
//									
//								System.out.print("ingrese unidad del atributo");
//								String unidadAtri=cargaStr();
//								if(contiendaAtri.equals(">"))
//									{
//									c.agregarAtributo(new AtributoMayor(nombreAtri, enteroRandom(valor1, valor2),contiendaAtri,unidadAtri));
//									}else{
//											c.agregarAtributo(new AtributoMenor(nombreAtri, enteroRandom(valor1, valor2),contiendaAtri,unidadAtri));
//									 		}
//								cantidadAtributos++;
//						   }while(cantidadAtributos!=c.getCantidadAtributos());
//							 cantidadAtributos=0;
//						}else{
//							
//							  do{
//									
//										Atributo a= baraja.getCarta(0).getAtributo(cantidadAtributos);
//										if(a.getContienda().equals(">"))
//											{
//												c.agregarAtributo(new AtributoMayor(a.getNombre(),enteroRandom(2, 200) ,a.getContienda() ,a.getUnidad()));
//											}else{
//													c.agregarAtributo(new AtributoMenor(a.getNombre(),enteroRandom(2, 200) ,a.getContienda() ,a.getUnidad()));
//												 }
//									cantidadAtributos++;
//								   }while((cantAtrisElegidos!=cantidadAtributos));
//							
//								}
//					cantidadAtributos=0;
//					cartasCreadas++;
//				   	}while(cartasCreadas!=baraja.cantCartas());
//			}while(baraja.mazoCorrecto()==false);
//			return baraja;
//		}
	
	public  int enteroRandom(int min, int max) {
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
			juegoConPosimas();
			int cuentaRondas=0;
			System.out.print(baraja.toString());
			baraja.repartirMazo(p1, p2);
			
			int rescarta;
			boolean empate=false; 
			p1.setTurno(true);
			String atributoEnJuego="";//es usada cuando tengo un empate seteo esta variable para segur compitiendo por el mismo atributo
			String atributoAcompetir="";
			Jugador	jugadorTurnoGanado=p1;
			Jugador	jugadorPerdedor=p2;
			
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
				System.out.print("Cantidad de cartas jugador "+p1.getNombre()+" :"+p1.cantCartas() +"\n"+"Cantidad de cartas jugador "+p2.getNombre()+" :"+p2.cantCartas()+"\n");
		if(p1.isTurno()){
			System.out.println("Turno de:"+p1.getNombre()+"\n");
			atributoAcompetir=p1.randomAtributo();
			jugadorTurnoGanado=p1;
			jugadorPerdedor=p2;
		}else if(p2.isTurno()){
			System.out.println("Turno de:"+p2.getNombre()+"\n");
			atributoAcompetir=p2.randomAtributo();
			jugadorPerdedor=p1;
			jugadorTurnoGanado=p2;
		}else if((baraja.cartasEnJuegoTieneCartas()))
				{
					atributoEnJuego=atributoAcompetir;	// atributo que es acarreado cuando se produce un empate, ya que debe de competirse con el mismo atributo
				}
		
				rescarta=Competencia(jugadorTurnoGanado, jugadorPerdedor,atributoAcompetir);
				System.out.println("Jugador "+p1.getNombre()+" :"+p1.getCarta(0).obtieneAtributo(atributoAcompetir).getValor() +"\n"+"Jugador  "+p2.getNombre()+" :"+p2.getCarta(0).obtieneAtributo(atributoAcompetir).getValor()+"\n");
				switch (rescarta) {
				case GANA_PRIMERA:
					baraja.intercambiaCaras(jugadorTurnoGanado, jugadorPerdedor);
					if(baraja.cartasEnJuegoTieneCartas())
						{
							baraja.transfiereCartasAlGanador(jugadorTurnoGanado);
							empate=false;
						}
					jugadorTurnoGanado.setTurno(true);
					jugadorPerdedor.setTurno(false);
					System.out.println("----Ronda ganada por jugador "+ jugadorTurnoGanado.getNombre());
					jugadorTurnoGanado.setTurno(true);
					break;
					
				case GANA_SEGUNDA:
					if(baraja.cartasEnJuegoTieneCartas())
						{
							baraja.transfiereCartasAlGanador(jugadorTurnoGanado);
							empate=false;
						}
					jugadorTurnoGanado.setTurno(false);
					jugadorPerdedor.setTurno(true);
					baraja.intercambiaCaras(jugadorPerdedor, jugadorTurnoGanado);
					System.out.println("----Ronda ganada por  "+ jugadorPerdedor.getNombre());
				
					break;
					
				default:
					System.out.println("----Ronda con empate----");	
					empate=true;
					baraja.agregarCartaEnJuego(p1.getCarta(0));
					p1.borrarCarta(p1.getCarta(0));
					baraja.agregarCartaEnJuego(p2.getCarta(0));
					p2.borrarCarta(p2.getCarta(0));
					jugadorTurnoGanado.setTurno(false);
					jugadorPerdedor.setTurno(false);
					break;
				}
				
				
			}while((empate==true)&&(p1.tieneCartas() && p2.tieneCartas()));
				if((empate==true)&&( !p1.tieneCartas() && !p2.tieneCartas()))
					{
						System.out.print("Cantidad de cartas jugador 1: "+p1.cantCartas() +"\n"+"Cantidad de cartas jugador 2 "+ p2.cantCartas()+"\n");
						return "-------------------------"+"\n"+" Termino el juego: Empate. ";
						
					}
				
			}	
			
		}

		return "El mazo no es correcto.";
	}
	

private int Competencia(Jugador jugadorTurnoGanado, Jugador jugadorPerdedor, String atributoAcompetir)
	{
	return jugadorTurnoGanado.getCarta(0).obtieneAtributo(atributoAcompetir).compite(jugadorPerdedor.getCarta(0).obtieneAtributo(atributoAcompetir));		
	
	}

	
	private  String cargaStr()
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
			
			public  int cargaInt()
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
