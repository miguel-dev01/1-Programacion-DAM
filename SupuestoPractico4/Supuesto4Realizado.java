package SupuestoPractico4;
import java.util.Scanner;

public class Supuesto4Realizado {
	// La variable para pedir por teclado debe ir obligatoriamente aqui, para que sea visible por todos los metodos
	static Scanner key = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		int cantidad = 1;
		
		Usuario[] resultado = pedirUsuarios(cantidad);
		
		// Mostramos todos los usuarios junto con TODOS sus datos, tambien ya ordenados
		for(int i = 0; i < resultado.length; i++) {
			System.out.println((i + 1) + "º " + "Usuario: ");
			System.out.println(resultado[i].nombreCompleto());
			
		}
		
		System.out.print("Selecciona un usuario con un numero segun se indique a continuacion: \n----------------------------\n");
		
		// Con el siguiente bucle solo se muestran los apellidos de los usuarios para seleccionarlos posteriormente
		// con un numero.
		
		for(int i = 0; i < resultado.length; i++) {
			
			System.out.println((i+1) + " - " + resultado[i].apellidos + ", " + resultado[i].nombre);
			
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
			array[i] = new Usuario();
			
			// Apellidos
			System.out.print("Introduce los apellidos de la persona " + (i+1) + ": ");
			array[i].apellidos = key.nextLine();
			
			// Nombre
			System.out.print("Introduce el nombre de la persona " + (i+1) + ": ");
			array[i].nombre = key.nextLine();
			
			// Email
			System.out.print("Introduce el email de la persona " + (i+1) + ": ");
			array[i].email = key.nextLine();
			
			System.out.println();
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

		//TODO SI 'valor' ES VALIDO {CODIGO}
			// try{}   catch(){}

		String nombre = usuario[valor].nombre;
		String apellidos = usuario[valor].apellidos;
		String email = usuario[valor].email;
		
		System.out.println("\nDATOS DEL USUARIO\n----------------------------");
		System.out.println("Nombre: " + nombre);
		
		System.out.println("Apellidos: " + apellidos);
		
		System.out.println("Email: " + email);

		
	} // Cierre mostrarUsuario()
	
}