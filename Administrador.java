package Supuesto7;

/**
 * @author MIGUEL SANCHEZ GARCIA
 */

public class Administrador extends Usuario {

	// Constructor
	public Administrador(int id, String username, String nombre, String email) {
		super(id, username, nombre, email);
	}

	// Metodo toString()
	@Override
	public String toString() {// Metodo toString()
		// Administrador ID: id. Nombre de usuario: username. Email: email
		//return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email + "]";
		return "Administrador ID: " + this.getId() + ". Nombre de usuario: " + this.getUsername() + ". Email: " + this.getEmail();
	}
	
	public Cliente crearCliente(int id, String username, String name, String email) {
		
		Cliente cliente = new Cliente(id,username,name,email);
		
		return cliente;
	}
	
} // cierre class
