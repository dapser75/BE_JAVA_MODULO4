/*
 * 
 * Exercici:
   L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem diferents plats i després escollirem que volem per menjar. Un cop fet això s’haurà de calcular el preu del menjar el programa ens dirà amb quins bitllets hem de pagar.
   FASE 1 
	Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€, haureu de crear un altre variable per guardar el preu total del menjar. 
	Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat. 
 * 
 */


package Modulo4F1;

class Fase1 {
	private int b5 = 0;
	private int b10 = 0;
	private int b20 = 0;
	private int b50 = 0;
	private int b100= 0;
	private int b200= 0;
	private int b500= 0;
	private String platos [] = new String[10];
	private int precioPlato [];
	private int cuenta;
	
	
	public static void main (String[] args) {
		
		Fase1 billete = new Fase1();
		billete.b5=5;
		billete.b10=10;
		billete.b20=20;
		billete.b50=50;
		billete.b100=100;
		billete.b500=500;
	
	}
	
}
