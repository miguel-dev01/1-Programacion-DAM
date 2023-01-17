package SupuestoPractico4_V2;

public class Usuario{
	
	public String nombre;
	public String apellidos;
	public String email;
	
	// Constructor
	public Usuario(String nombre, String apellidos, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	public String nombreCompleto() {
		return "\nNombre: " + nombre + "\n" + "Apellidos: " + apellidos + "\n" + "Email: " + email + "\n";
	}
	
	public String ApellidosNombre() {
		return apellidos + ", " + nombre;
	}
	
}