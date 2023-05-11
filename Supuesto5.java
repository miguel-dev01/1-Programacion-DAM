package SupuestoPractico5Posible;

public class Supuesto5 {
	public static void main(String args[]) {
		
		String texto = "pepe,,lopez perez,,12345678A,,C/Luna,27,30132,Murcia,,pepelopez@gmail.com,,12/11/2019,,normal,,0;Maria,,Alvarez Martinez,,87654321B,,C/Falsa,123,30009,Murcia,,mariaalvarez@gmail.com,,12/10/2020,,premium,,25";
		
		Client[] clientes = importarClientes(texto);
		
		mostrarClientes(clientes);
	
	} // method main
	
	public static Client[] importarClientes(String texto) {
		
		String[] clientes = texto.split(";");
		Client[] list = new Client[clientes.length+8];
		
		for(int i = 0; i < clientes.length; i++) {
			String[] dato = clientes[i].split(",,");
			Client obj = new Client();
			
			obj.nombre = dato[0];
			obj.apellidos = dato[1];
			obj.nif = dato[2];
			obj.direccion = dato[3];
			obj.email = dato[4];
			obj.fechaAlta = dato[5];
			obj.tipo = dato[6];
			obj.descuento = Integer.parseInt(dato[7]);
			
			list[i] = obj;
			
		}
		
		return list;
	} // cierre importarClientes()
	
	public static void mostrarClientes(Client[] clientes) {
		
		
		for(int i = 0; i < clientes.length; i++) {	
			System.out.println("\nCliente Nº " + (i+1)+"\n---------------------------");
			if(clientes[i] != null) {
				System.out.println("Nombre: " + clientes[i].nombre);
				System.out.println("Apellidos: " + clientes[i].apellidos);
				System.out.println("NIF: " + clientes[i].nif);
				System.out.println("Direccion: " + clientes[i].direccion);
				System.out.println("Email: " + clientes[i].email);
				System.out.println("Fecha de alta: " + clientes[i].fechaAlta);
				System.out.println("Tipo cliente: " + clientes[i].tipo);
				System.out.println("Descuento: " + clientes[i].descuento);
			} else {
				System.out.println("NULL");
				System.out.println("NO HAY CLIENTE");
			}
		}
		
	} // cierre mostrarClientes()
	
} // class main

class Client {
	public String nombre;
	public String apellidos;
	public String nif;
	public String direccion;
	public String email;
	public String fechaAlta;
	public String tipo;
	public int descuento;
} // class Client
