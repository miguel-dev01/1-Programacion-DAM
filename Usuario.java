package Supuesto7;

public abstract class Usuario {

	private int id;
	private String username;
	private String nombre;
	private String email;
	
	// Constructor
	public Usuario(int id, String username, String nombre, String email) {
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.email = email;
	}

	// Metodos getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// Metodo toString()
	@Override
	public String toString() {
		// Formato --> ID: id. Nombre de usuario: username. Email: email
		//return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email + "]";
		return "ID: " + this.id + " .Nombre de usuario: " + this.username + ".Email: " + this.email;
	}
	
}
