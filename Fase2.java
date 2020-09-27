package Modulo4F1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class Fase2 {
	private int b5 = 0;
	private int b10 = 0;
	private int b20 = 0;
	private int b50 = 0;
	private int b100= 0;
	private int b200= 0;
	private int b500= 0;
	private static HashMap <Integer, String> platos = new HashMap<Integer, String> ();
	private static HashMap <Integer, Integer> precioPlatos = new HashMap<Integer, Integer> ();
	private static int cuenta;
	static boolean ok ;
	static Scanner entrada= new Scanner(System.in);
	private static int control=0;
	static List<Integer> entradaPedidos =new ArrayList();
	
	public static void main (String[] args) {
		//entrada de platos & precio
		entradaMenu();//Llamada al metodo para generar el menu en el restaurante		
		mostrarMenu(); //Llamada al metodo mostrar menu.
		pedirPlatos();//Llamada al metodo para pedir platos.
	}//Fin metodo main
	
	
	//En este metodo se genera el menu del restaurante, para ello se solicita que introduzcamos el nombre del plato y su precio.
	public static void entradaMenu() {
		String entradaMenu="";
		for (int i=0; i<30; i++) {
			entradaMenu="";
			System.out.print("Introduce nombre del plato:");
			entradaMenu=entrada.nextLine();
			if (entradaMenu.isEmpty()){//Control para verificar que se introduce un plato, si no es así salimos del metodo
				break;
			}
			platos.put(i+1, entradaMenu);
			do {
				try {
					System.out.print("Introduce el precio del plato:");
					precioPlatos.put(i+1,entrada.nextInt());
					ok=true;	
					//System.out.println(i +"bucle do antes break   "+ ok);
					entrada.nextLine();
				} catch (Exception e) {
					System.out.print("ERROR: El precio solo puede contener numeros.\n");
					entrada.nextLine();
					ok=false;
				}
			}while(!ok);		
			
		}	
	}
	
	
	//Método para mostrar menu
	public static void mostrarMenu() {
		System.out.println("Este es el menu que disponemos:");
		for (int i=1; i<=platos.size();i++) {//Bucle para recorrer el array.
			System.out.println("Plato nº: " + i +": " + platos.get(i) + " Precio: " + precioPlatos.get(i)+ " €");

		}
	}//Fin metodo mostrar menu
	
	//Metodo para pedir platos.
	public static void pedirPlatos() {
		ok=false;
		int n=0;//Variable para rellenar la lista
		do {//Bucle para pedir platos
			do { //Bucle para controlar que los platos solicitados sean numeros
				try {
					System.out.print("Elige el plato que deseas comer:");
					entradaPedidos.add(n,entrada.nextInt());
					ok=true;
					entrada.nextLine();
				}catch(Exception e) {
					System.out.print("ERROR: Debes registar el numero del plato que deseas comer(tiene que ser un numero).");
					entrada.nextLine();
					ok=false;
				}
			}while(!ok);
			n++;
			control=pedirMas(control);	//Llamada al metodo para pedir más platos	
		}while(control==1);
			
	}//Fin pedirPlatos

	//Metodo para controlar los platos piden más platos
	public static Integer pedirMas(int cont) {
		boolean okk=false;
		do {
			do {//Control que se introduzca un 0 o un 1
				try {
					System.out.print("Quieres pedir más platos (Introducir 1:Si /0:No):");
					cont=entrada.nextInt();
					entrada.nextLine();
					if ((cont!=0) && (cont!=1)){
						System.out.print("ERROR: La opcion introducida no es correcta (Solo puede ser 0 o 1).");
						okk=false;
					}
					else {
						okk=true;
					}
				}catch(Exception e){
					System.out.print("ERROR: La opcion introducida no es correcta (No puede contener letras. Solo puede ser 0 o 1).");
					entrada.nextLine();
					okk=false;
				}
			}while(!okk);//fin control o y 1
		}while((cont!=0) && (cont!=1));
		return(cont);
	}//Fin metodo control si se piden más datos
}

