/**
 * @author Miguel Sanchez - 01/06/2023
 */
import java.sql.*;
import java.util.ArrayList;

public class Database {
	private final String SERVER = "r2d2.iescierva.net";
	private final String PORT = "3306";
	private final String DB = "instituto";
	private final String USER = "instituto";
	private final String PASS = "instituto";
	private final String URL = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DB;
	
	public ArrayList<Persona> buscarPersonas(String busqueda) {
		ArrayList<Persona> listado = new ArrayList<Persona>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String query = "select nombre, apellido1, apellido2, poblacion "
					+ "from alumno inner join codigopostal on alumno.cp = codigopostal.cp;";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Persona aux = new Persona();
				aux.setNombre(rs.getString("nombre"));
				aux.setApellido1(rs.getString("apellido1"));
				aux.setApellido2(rs.getString("apellido2"));
				aux.setPoblacion(rs.getString("poblacion"));
				
				listado.add(aux);
			}
			
			System.out.println(query);
			stmt.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println("Error en el metodo buscarPersonas: " + e);
		}
		
		return listado;
		
	}
}

