package Supuesto7;

public class Supuesto7 {
    public static void main(String[] args) {
        Cliente client1 = new Cliente(2, "AAA", "AAA", "aaa@gmail.com");
        client1.setId(1);
        client1.setUsername("maria1");
        client1.setNombre("Maria");
        client1.setEmail("maria@gmail.com");
        System.out.println(client1);
        
        client1.addItem(new Item("SmartTV", "Television de 52\"", 699.95));
        client1.addItem(new Item("Microondas", "Horno microondas de 800W", 69.55));
        client1.addItem(new Item("Libro", "Libro sobre mecanica", 19.95));
        client1.addItem(new Item("Caramelos", "Caramelos de limon", 1.95));
        client1.mostrarItem(7);
        client1.mostrarItem(3);
        client1.eliminarItem(7);
        client1.eliminarItem(3);
        client1.addItem(new Item("Caramelos", "Caramelos de naranja", 2));
        client1.listarTodos();
        System.out.println("Importe total: " + client1.precioTotal() + " euros");
        
        System.out.println();
        
        Administrador admin = new Administrador(0, "", "", "");
        admin.setId(3);
        admin.setUsername("admin");
        admin.setNombre("David");
        admin.setEmail("david@gmail.com");
        System.out.println(admin);
        
        System.out.println();
        
        Cliente client2 = admin.crearCliente(0, "", "", "");
        client2.setId(4);
        client2.setUsername("paco20");
        client2.setNombre("Pacho Martinez");
        client2.setEmail("paco@gmail.com");
        System.out.println(client2);
        
        client2.addItem(new Item("Nintendo Switch", "Consola portatil de Nintendo", 299.95));
        client2.addItem(new Item("Super Mario World", "Videojuego de Super Mario", 59.99));
        client2.listarTodos();
        System.out.println("Importe total: " + client2.precioTotal() + " euros");
    }
}