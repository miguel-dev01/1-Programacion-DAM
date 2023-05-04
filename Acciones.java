package Supuesto7;

/**
 * @author MIGUEL SANCHEZ GARCIA
 */

public interface Acciones {

	public void addItem(Item item);
	
	public void mostrarItem(int indice);
	
	public void listarTodos();
	
	public void eliminarItem(int indice);
	
	public double precioTotal();
	
} // cierre clase
