package Supuesto7;

/**
 * @author MIGUEL SANCHEZ GARCIA
 */

public class Item {

	private String nombre;
	private String descripcion;
	private double precio;
	
	// Constructor
	public Item(String nombre, String descripcion, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		
		if(this.precio < 0) {
			this.precio = 0;
		} else {
			this.precio = precio;
		}
	}
	
	// Metodos getters
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		// Formato: nombre (precio euros). descripción
		//return "Item [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
		return this.nombre + " ("+ this.precio +" euros). " + this.descripcion;
	}
	
	
} // cierre class
