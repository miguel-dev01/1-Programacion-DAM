package SupuestoPractico5Posible;
/**
 * Supuesto5.java
 * @author Miguel Sanchez Garcia - 16/02/2023
 */
public class Principal {
    public static void main(String[] args) {

    	String texto = "Pepe,,Lopez Perez,,12345678a,,C/Luna, 27, 30132, Murcia,,pepelopez@gmail.com,,12/11/2019,,normal,,0;Maria,,Alvarez Martinez,,87654321b,,C/ Falsa, 123, 30009, Murcia,,mariaalvarez@gmail.com,,12/10/2020,,premium,,25;Alberto,,Espinosa Carrillo,,X2654874E,,C/ Arce, 10, Murcia, 30005,,aespinosa@gmail.com,,02/9/2019,,normal,,0;Miguel,,Caballero Pinto,,1122344C,,C/ Olmo, 13, Murcia, 30015,,michaelknight@gmail.com,,45/03/2016,,normal,,5";
    	
    	Cliente[] clientes = importarClientes(texto);
    	
    	mostrarClientes(clientes);
    	
    }

    public static Cliente[] importarClientes(String texto) {
    	
    	String[] allClientes = texto.split(";");
    	
    	Cliente[] lista = new Cliente[allClientes.length+8];
    	
    	for(int i = 0; i < allClientes.length; i++) {
    		
    		String[] onlyCliente = allClientes[i].split(",,");
    		Cliente objs_cliente = new Cliente();
    		
    		objs_cliente.nombre = onlyCliente[0];
    		objs_cliente.apellidos = onlyCliente[1];
    		objs_cliente.nif = onlyCliente[2];
    		objs_cliente.direccion = onlyCliente[3];
    		objs_cliente.email = onlyCliente[4];
    		objs_cliente.fechaAlta = onlyCliente[5];
    		objs_cliente.tipo = onlyCliente[6];
    		objs_cliente.descuento = Integer.parseInt(onlyCliente[7]);
    		
    		lista[i] = objs_cliente;
    	}
    	
    	
    	return lista;
    } // cierre importarclientes
    
    
    public static void mostrarClientes(Cliente[] clientes){
    	
    	for(int i = 0; i < clientes.length; i++) {
    		System.out.println("\nCliente Nº: " + (i+1)+"\n-------------------");
    		if(clientes[i] != null) {
	    		System.out.println("Nombre: " + clientes[i].nombre);
	    		System.out.println("Apellidos: " + clientes[i].apellidos);
	    		System.out.print("NIF: " + clientes[i].nif); 
	    			if(validarFormatoNIF(clientes[i].nif) == true) {
	    				System.out.print(" (Formato valido)\n");
	    			}else {System.out.print(" (Formato no valido)\n");}
	    			
	    		System.out.println("Direccion: " + clientes[i].direccion);
	    		System.out.println("Email: " + clientes[i].email);
	    		System.out.print("fecha de alta: " + clientes[i].fechaAlta);
	    			if(validarFormatoFecha(clientes[i].fechaAlta) == true) {
	    				System.out.print(" (Formato valido)\n");
	    			}else {System.out.print(" (Formato no valido)\n");}
	    			
	    		System.out.println("Tipo: " + clientes[i].tipo);
	    		System.out.println("Descuento: " + clientes[i].descuento);
    		} else {
    			System.out.println("NULL");
    			System.out.println("NO HAY CLIENTE");

    		}
    	}
    	
    } // cierre mostrarclientes
    
    public static boolean validarFormatoNIF(String nif) {
    	
    	String regex = "^[0-9]{8}[A-Za-z]$";
    	if(nif.matches(regex)) {
    		return true;
    	}else {
    		return false;
    	}
    	
    			
    	//return false;	
    } // cierre validarFormatoNIF
    
    public static boolean validarFormatoFecha(String fecha) {
    	
    	String regex = "^(0[1-9]|[1-9]|[12][0-9]|3[01])/(0[1-9]|[1-9]|1[012])/\\d{4}$";
    	
    	if(fecha.matches(regex)) {
    		return true;
    	}else {
    		return false;
    	}
    	
    	
    } // cierre validarFormatoFecha
    

} //class


class Cliente {
    public String nombre;
    public String apellidos;
    public String nif;
    public String direccion;
    public String email;
    public String fechaAlta;
    public String tipo;
    public int descuento;
} //class
