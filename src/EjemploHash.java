import java.util.HashMap;
import java.util.Iterator;
public class EjemploHash {
HashMap<String, String> capitales;
public EjemploHash(){
capitales = new HashMap<String, String>();
}
public void cargarCapitales(){
capitales.put("Buenos Aires", "La Plata");
capitales.put("Córdoba", "Córdoba");
capitales.put("Misiones", "Posadas");
capitales.put("Entre Ríos", "Paraná");
capitales.put("Chaco", "Resistencia");
capitales.put("Mendoza", "Mendoza");
capitales.put("Río Negro", "Viedma");
}
public void imprimirCapitales() {
boolean s=capitales.containsKey("Misiones");
	if(s==true) System.out.println(capitales.get("Misiones"));
Iterator<String> iteradorCapitales = capitales.keySet().iterator();


while (iteradorCapitales.hasNext()){
String provincia = iteradorCapitales.next();
String capital = capitales.get(provincia);
System.out.println("La capital de "+provincia+" es: "+capital);
}
}
public static void main(String[] args) {
EjemploHash ejemplo = new EjemploHash();
ejemplo.cargarCapitales();
ejemplo.imprimirCapitales();
}
}