package SupuestoPractico4;

public class Usuario{
	
	public String nombre;
	public String apellidos;
	public String email;
	
	public String nombreCompleto() {
		
		return "\nNombre: " + nombre + "\n" + "Apellidos: " + apellidos + "\n" + "Email: " + email + "\n";
		
		
	}
	
}