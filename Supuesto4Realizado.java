package SupuestoPractico4;
import java.util.Scanner;

public class Supuesto4Realizado {
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int cantidad = 2;
		
		Usuario[] resultado = pedirUsuarios(cantidad);
		
		// Mostramos todos los usuarios junto con TODOS sus datos
		for(int i = 0; i < resultado.length; i++) {
			//System.out.println("Usuario: " + i);
			System.out.println(resultado[i].nombreCompleto());
			
		}
		
		System.out.print("Selecciona un usuario: \n----------------\n");
		
		// Con el siguiente bucle solo se muestran los apellidos
		for(int i = 0; i < resultado.length; i++) {
			
			System.out.println(resultado[i].apellidos);
			
		}
		
		mostrarUsuario(resultado);
		System.out.print("Usuario: \n");
		int value = keyboard.nextInt();
		
		
		//keyboard.close();
	} // Cierre MAIN
	
	
	public static Usuario[] pedirUsuarios(int cantidad) {
		
		Usuario[] array = new Usuario[cantidad];
		Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++) {
			array[i] = new Usuario();
			
			// Pedir apellidos que se asignara
			System.out.print("Introduce los apellidos de la persona " + (i + 1) + ": ");
			array[i].apellidos = keyboard.nextLine();
			
			System.out.print("Introduce el nombre de la persona " + (i + 1) + ": ");
			array[i].nombre = keyboard.nextLine();
			
			System.out.print("Introduce el email de la persona " + (i + 1) + ": ");
			array[i].email = keyboard.nextLine();
		}
		
		// Llamamos al metodo que ordena los usuarios
		Usuario[] arregloOrdenado = ordenarUsuarios(array);
		
		keyboard.close();
		return arregloOrdenado; 
		
	} // Cierre pedirUsuarios()

	
	public static Usuario[] ordenarUsuarios(Usuario[] arreglo) {
		
		for(int i = 0; i < arreglo.length; i++) {
			
			for(int j = 0; j < arreglo.length; j++) {
				
				if(arreglo[i].apellidos.compareToIgnoreCase(arreglo[j].apellidos) < 0) {
					
					Usuario aux = arreglo[j];
					arreglo[j] = arreglo[i];
					arreglo[i] = aux;
				
				}
			}
		}
		
		return arreglo;
	} // Cierre ordenarUsuarios()
		
	public static void mostrarUsuario(Usuario[] usuarios) {
		/*
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Usuario: \n");
		int value = keyboard.nextInt();
		*/
		String nombre = usuarios[1].nombre;
		String apellidos = usuarios[1].apellidos;
		String email = usuarios[1].email;
		
		System.out.println("\nUSUARIO\n------------\n");
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Apellidos: " + apellidos);
		
		System.out.println("Email: " + email);

		
	} // Cierre mostrarUsuario()
	
}