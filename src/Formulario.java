/**
 * @author Miguel Sanchez - 01/06/2023
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class Formulario extends JFrame implements ActionListener {
	
	private Container contenedor;
	private JLabel titulo, labelBusqueda , informacion, labelImagen, labelNombre, labelLimitar, labelFecha, labelOrdenar;
	private JTextField campoBusqueda;
	private JRadioButton todos, uno, ascendente, descendente;
	private JButton botonBuscar, botonLimpiar;
	private JTable resultados;
	private JScrollPane tableJScroll;
	private JCheckBox terminos;
	private String[] columnas = {"Nombre", "Apellido1", "Apellido2" , "Poblacion"};
	private JSpinner cantidad;
	private JComboBox selectorOrdenar;
	
	public Formulario() {
		
		this.setTitle("Supuesto practico 8");
		this.setSize(800, 600);;
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.contenedor = this.getContentPane();
		this.contenedor.setLayout(null);
		
		this.titulo = new JLabel("Ver Alumnos:");
		this.titulo.setFont(new Font("Arial", Font.PLAIN, 40));
		this.titulo.setBounds(100,20, 300, 30);
		this.contenedor.add(this.titulo);
		
		/**
		 * Colocamos la imagen en la ventana y nuestro nombre
		 */
		ImageIcon imagen = new ImageIcon("./assets/imagen.jpg");
		this.labelImagen = new JLabel();
		this.labelImagen.setBounds(450, 30, 300, 200);
		this.labelImagen.setIcon(imagen);
		this.contenedor.add(this.labelImagen);
		
		this.labelNombre= new JLabel("Miguel Sanchez");
		this.labelNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelNombre.setBounds(500, 180, 300, 30);
		this.contenedor.add(this.labelNombre);
		
		this.labelFecha = new JLabel("01/06/2023");
		this.labelFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelFecha.setBounds(500 , 210, 300, 30);
		this.contenedor.add(this.labelFecha);
		
		this.labelBusqueda = new JLabel("Busqueda");
		this.labelBusqueda.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelBusqueda.setBounds(100, 60, 150, 20);
		this.contenedor.add(this.labelBusqueda);
		
		this.campoBusqueda = new JTextField("");
		this.campoBusqueda.setFont(new Font("Arial", Font.PLAIN, 19));
		this.campoBusqueda.setBounds(100, 90, 200, 25);
		this.campoBusqueda.addActionListener(this);
		this.contenedor.add(campoBusqueda);
		
		this.todos = new JRadioButton("Todos");
		this.todos.setFont(new Font("Arial", Font.PLAIN, 15));
		this.todos.setBounds(100, 125, 120, 15);
		
		this.uno = new JRadioButton("Al menos uno");
		this.uno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.uno.setBounds(100, 150, 120, 15);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(this.todos);
		grupo1.add(this.uno);
		
		this.todos.setSelected(true);
		
		this.contenedor.add(todos);
		this.contenedor.add(uno);
		
		this.labelOrdenar = new JLabel("Ordenar por campo");
		this.labelOrdenar.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelOrdenar.setBounds(100, 170, 300, 20);
		this.contenedor.add(this.labelOrdenar);
	
		this.labelLimitar = new JLabel("Limitar cantidad resultados:");
		this.labelLimitar.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelLimitar.setBounds(100, 250, 300, 20);
		this.contenedor.add(this.labelLimitar);
		
		SpinnerModel modelo = new SpinnerNumberModel(10,1,100,1);
		this.cantidad = new JSpinner(modelo);
		this.cantidad.setBounds(100, 280, 70, 25);
		this.contenedor.add(this.cantidad);
		
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.setFont(new Font("Arial", Font.PLAIN, 19));
		this.botonBuscar.setBounds(100, 315, 100, 20);
		this.botonBuscar.addActionListener(this);
		this.contenedor.add(this.botonBuscar);
		
		this.botonLimpiar = new JButton("Limpiar");
		this.botonLimpiar.setFont(new Font("Arial", Font.PLAIN, 19));
		this.botonLimpiar.setBounds(205, 315, 100, 20);
		this.botonLimpiar.addActionListener(this);
		this.contenedor.add(this.botonLimpiar);
		
		this.informacion = new JLabel("No hay resultados.");
		this.informacion.setFont(new Font("Arial", Font.PLAIN, 20));
		this.informacion.setBounds(350, 315, 300, 20);
		this.contenedor.add(this.informacion);
		
		this.selectorOrdenar = new JComboBox();
		this.selectorOrdenar.setFont(new Font("Arial", Font.PLAIN, 15));
		this.selectorOrdenar.setBounds(100, 200, 200, 20);
		this.selectorOrdenar.addItem("Nombre ");
		this.selectorOrdenar.addItem("Apellido 1");
		this.selectorOrdenar.addItem("Apellido 2");
		this.selectorOrdenar.addItem("Poblacion");
		
		this.ascendente = new JRadioButton("Ascendente");
		this.ascendente.setFont(new Font("Arial", Font.PLAIN, 15));
		this.ascendente.setBounds(100, 230, 120, 15);
		
		this.descendente = new JRadioButton("Descendente");
		this.descendente.setFont(new Font("Arial", Font.PLAIN, 15));
		this.descendente.setBounds(210, 230, 120, 15);
		
		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(this.ascendente);
		grupo2.add(this.descendente);
		
		this.ascendente.setSelected(true);
		
		this.contenedor.add(ascendente);
		this.contenedor.add(descendente);
	
		this.contenedor.add(this.selectorOrdenar);
		
		this.resultados = new JTable(new String[0][0], this.columnas);
		this.tableJScroll = new JScrollPane(this.resultados);
		this.tableJScroll.setBounds(100, 350, 600, 200);
		
		this.contenedor.add(this.tableJScroll);
	
		this.setVisible(true);
		
		
	} // cierre constructor
	
	/**
	 * Metodo que contiene la logica para cuando el usuario realiza la accion con elementos de la ventana
	 * como campo de busqeuda o hacer clic al boton de BUSCAR
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.botonBuscar || e.getSource() == this.campoBusqueda) {
			this.buscar();
			
		} else if (e.getSource() == this.botonLimpiar) {
			this.reset();
		}

	}
	
	private void buscar() {
		String buscarUsuario = this.campoBusqueda.getText().trim();
		
		Database conexion = new Database();
		ArrayList<Persona> listado = conexion.buscarPersonas(buscarUsuario);
		if(listado.size() == 0) {
			this.informacion.setText("No se han encontrado resultados");
			this.resultados.setModel(new DefaultTableModel(new String[0][0], this.columnas));
		}else {
			this.informacion.setText("Se han encontrado " + listado.size() + " resultados.");
			System.out.println("Se han encontrado " + listado.size() + " resultados.");
			this.setResultados(listado);
		}
	}
	
	/**
	 * Pasamos a este metodo el arraylist con todo filtrado y lo mostraremos en la tabla de la ventana
	 * @param listado
	 */
	private void setResultados(ArrayList<Persona> listado) {
		String[][] datos = new String[listado.size()][this.columnas.length];
		
		for(int i  = 0; i < listado.size(); i++) {
			Persona persona = listado.get(i);
			datos[i][0] = persona.getNombre();
			datos[i][1] = persona.getApellido1();
			datos[i][2] = persona.getApellido2();
			datos[i][3] = persona.getPoblacion();
		}
		
		this.resultados.setModel(new DefaultTableModel(datos, this.columnas));
	} // cierre setResultados()
	
	/**
	 * Resetear tabla de la ventana
	 */
	public void reset() {
		this.campoBusqueda.setText("");
		this.resultados.setModel(new DefaultTableModel(new String[0][0], this.columnas));
	}
} // cierre class
