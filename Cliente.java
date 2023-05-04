package Supuesto7;

/**
 * @author MIGUEL SANCHEZ GARCIA
 */

import java.util.ArrayList;

public class Cliente extends Usuario implements Acciones {

	private ArrayList<Item> listaItem = new ArrayList<Item>();
	
	// Constructor
	public Cliente(int id, String username, String nombre, String email) {
		super(id, username, nombre, email);
	}

	// Metodo toString()
	@Override
	public String toString() {// Metodo toString()
		// Cliente ID: id. Nombre de usuario: username. Email: email
		//return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email + "]";
		return "Cliente ID: " + this.getId() + ". Nombre de usuario: " + this.getUsername() + ". Email: " + this.getEmail();
	}

	@Override
	public void addItem(Item item) {
		/*
		try {
			listaItem.add(item);
		} catch(NullPointerException e) {
			System.err.println(e);
		}
		*/
		listaItem.add(item);
	}

	@Override
	public void mostrarItem(int indice) {
		try {
			System.out.println("Item: " + listaItem.get(indice));
		}catch(IndexOutOfBoundsException e) {
			System.err.println("Indice no valido");
		}
	}

	@Override
	public void listarTodos() {
		/*
		for(Item i: listaItem) {
			System.out.println(i);
		}
		*/
		for(int i = 0; i < listaItem.size(); i++){
			System.out.println("Item " + i + ": " + listaItem.get(i));
		}
	}

	@Override
	public void eliminarItem(int indice) {
		try {
			listaItem.remove(indice);
		} catch(IndexOutOfBoundsException e) {
			System.err.println("Indice no valido");
		}
	}

	@Override
	public double precioTotal() {
		double result = 0;
		
		for(int i = 0; i < listaItem.size(); i++) {
			Item item = listaItem.get(i);
			
			result += item.getPrecio();
		}
		
		return result;
	}
	
} // cierre class
