package Modulo4F1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class Fase3 {
	private static int b5 = 5;
	private static int b10 = 10;
	private static int b20 = 20;
	private static int b50 = 50;
	private static int b100= 100;
	private static int b200= 200;
	private static int b500= 500;
	private static HashMap <Integer, String> platos = new HashMap<Integer, String> ();
	private static HashMap <Integer, Integer> precioPlatos = new HashMap<Integer, Integer> ();
	private static int cuenta;
	static boolean ok ;
	static Scanner entrada= new Scanner(System.in);
	private static int control=0;
	static List<Integer> entradaPedidos =new ArrayList<Integer>();
	
	public static void main (String[] args) {
		//entrada de platos & precio
		System.out.println("Este pograma diseña una menu y permite pedir platos del mismo. Posteriormente calcula el precio del pedido realizado y los billetes con los que se tiene que pagar.");
		System.out.println("Se pueden introducir hasta un máximo de 30 platos, si se pulsa 'ENTER' sin introducir ningun plato, se da por terminado el menu");
		entradaMenu();//Llamada al metodo para generar el menu en el restaurante		
		mostrarMenu(); //Llamada al metodo mostrar menu.
		pedirPlatos();//Llamada al metodo para pedir platos.
		mostrarPedido();
		calcularPago();
	}//Fin metodo main
	
	//En este metodo se calcula como se debe pagar
	public static void calcularPago () {
		//int i=0;
		List <Integer> coleccionBilletes = new ArrayList();
		int acumulado=cuenta;//Variable donde acumularemos el importe de los billetes
		do {
			if (acumulado>=b500) {
				acumulado-=b500;
				coleccionBilletes.add(b500);
			}else if (acumulado>=b200) {
				acumulado-=b200;
				coleccionBilletes.add(b200);
			}else if (acumulado>=b100) {
				acumulado-=b100;
				coleccionBilletes.add(b100);
			}else if (acumulado>=b50) {
				acumulado-=b50;
				coleccionBilletes.add(b50);
			}else if (acumulado>=b20) {
				acumulado-=b20;
				coleccionBilletes.add(b20);
			}else if (acumulado>=b10) {
				acumulado-=b10;
				coleccionBilletes.add(b10);
			}else if (acumulado>=b5) {
				acumulado-=b5;
				coleccionBilletes.add(b5);
			}else {
				acumulado-=b5;
				coleccionBilletes.add(b5);
			}
		}while(acumulado>0);
		System.out.print("Estos son los bileltes con los que tienes que pagar:");
		for (int i=0; i<coleccionBilletes.size();i++) {
			System.out.println(coleccionBilletes.get(i) + "€" );
			
		}
		
	}//Fin metodo calcular pago
	
	//En este metodo se muestra el pedido realizado y el importe total del mismo.
	public static void mostrarPedido() {
		System.out.println("Este es tu pedido:");
		for (int i=0;i<entradaPedidos.size();i++) {
			if (platos.get(entradaPedidos.get(i))==null) {//comprobar si el plato existe
				System.out.println("El plato solicitado nº " +entradaPedidos.get(i) + " no está en el menu.");
			}
			else {
				System.out.println(entradaPedidos.get(i) + "  " +platos.get(entradaPedidos.get(i)));
				cuenta=cuenta+precioPlatos.get(entradaPedidos.get(i));//Suma acumulada del importe de los platos
			}
		}
		System.out.println("El importe total del pedido es de: " + cuenta +"€.");
				
	}
	//Fin metodo de mostrar el pedido e importe
	
	
	
	
	
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
	}//Fin metodo entrada menu
	
	
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
				try {//Control para pedir platos.
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

