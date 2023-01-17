// VERSION 2.0 DE SUPUESTO PRACTICO 4
// Realizado por Miguel Sanchez. 1DAM. 
// IES Ingeniero de la Cierva, Murcia

package SupuestoPractico4_V2;
import java.util.Scanner;

public class Supuesto4Realizado {
	// La variable para pedir por teclado debe ir obligatoriamente aqui, para que sea visible por todos los metodos
	static Scanner key = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		int cantidad = 2;
		
		Usuario[] resultado = pedirUsuarios(cantidad);
		
		// Mostramos todos los usuarios junto con TODOS sus datos, tambien ya ordenados
		for(int i = 0; i < resultado.length; i++) {
			System.out.println((i + 1) + "� " + "Usuario: ");
			System.out.println(resultado[i].nombreCompleto());
			
		}
		
		System.out.print("Selecciona un usuario con un numero segun se indique a continuacion: \n----------------------------\n");
		
		// Con el siguiente bucle solo se muestran los apellidos de los usuarios para seleccionar los datos posteriormente
		// con un numero.
		for(int i = 0; i < resultado.length; i++) {
			
			System.out.println((i+1) + " - " + resultado[i].ApellidosNombre());
			
		}
		
		System.out.println();
		System.out.print("Usuario: ");
		
		// Se pide por teclado el valor int para seleccionar el usuario y ver sus datos
		int value = key.nextInt();
		
		// Se instancia el metodo que muestra el usuario elegido y se le resta -1 al valor introducido
		// para que cuadre con la posicion del array donde se halle la informacion del usuario, ya que se
		// empieza a contar desde 0
		mostrarUsuario(resultado, value - 1);
		
		
		//keyboard.close();
	} // Cierre MAIN
	
	
	public static Usuario[] pedirUsuarios(int cantidad) {
		
		Usuario[] array = new Usuario[cantidad];
		
		for(int i = 0; i < array.length; i++) {
			
			// Apellidos
			System.out.print("Introduce los apellidos de la persona " + (i+1) + ": ");
			String apellidos = key.nextLine();
			
			// Nombre
			System.out.print("Introduce el nombre de la persona " + (i+1) + ": ");
			String nombre = key.nextLine();
			
			// Email
			System.out.print("Introduce el email de la persona " + (i+1) + ": ");
			String email = key.nextLine();
			
			System.out.println();
			
			// Usandose un constructor. Donde podemos tener mejor manejo de estos valores de las propiedades
			// a la hora de introducirlas por consola.
			array[i] = new Usuario(nombre, apellidos, email);
			
		}
		
		// Llamamos al metodo que ordena los usuarios, y le pasamos array con los datos introducidos para que los
		// ordene alfabeticamente. Y lo guardamos en una variable de tipo Usuario de array para devolverlo.
		Usuario[] arregloOrdenado = ordenarUsuarios(array);
		
		// Y devolvemos el array ya ordenado para instanciarlo en el Main()
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
		
	public static void mostrarUsuario(Usuario[] usuario, int valor) {

		// Restriccion para cuando se introduce un numero que no corresponde a ningun usuario
		if(valor < 0 || valor >= usuario.length) {
			System.err.println("El valor introducido no corresponde a ningun usuario.");
			return;
		}
		
		// Aqui se puede usar, en lugar del siguiente codigo para mostrar los apellidos, nombres y email
		// desde la clase Usuario podemos crear getters y setters que encapsulen dichos datos,
		// de forma independiente unos de otros y mostrarlos donde corresponda
		String nombre = usuario[valor].nombre;
		String apellidos = usuario[valor].apellidos;
		String email = usuario[valor].email;
		
		System.out.println("\nDATOS DEL USUARIO\n----------------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Apellidos: " + apellidos);
		
		System.out.println("Email: " + email);

		
	} // Cierre mostrarUsuario()
	
}