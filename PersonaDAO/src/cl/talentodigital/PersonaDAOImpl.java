package cl.talentodigital;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements IPersonaDAO {

	Connection conn;

	@Override
	public List<Persona> getTodasLasPersonas() {
		conn = ConnectionDB.ConnectionDB();
		List<Persona> personas = new ArrayList<Persona>();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM personas";

		try {
			stmt = conn.createStatement();
			// rs = stmt.executeQuery(sqlQuery);

			if (stmt.execute(sqlQuery)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					int id = rs.getInt("persona_id");
					String nombre = rs.getString("persona_nombre");
					String apellido = rs.getString("persona_apellido");
					int edad = rs.getInt("persona_edad");

					Persona persona = new Persona(id, nombre, apellido, edad);
					personas.add(persona);
					
				}
			}
			conn.close();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
		return personas;
	}

	@Override
	public Persona getPersona(int idP) {
		conn = ConnectionDB.ConnectionDB();
		Persona persona = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM personas WHERE persona_id = " + idP + "";

		try {
			stmt = conn.createStatement();
			// rs = stmt.executeQuery(sqlQuery);

			if (stmt.execute(sqlQuery)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					int id = rs.getInt("persona_id");
					String nombre = rs.getString("persona_nombre");
					String apellido = rs.getString("persona_apellido");
					int edad = rs.getInt("persona_edad");

					persona = new Persona(id, nombre, apellido, edad);
				}
			}
			conn.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
		if (persona != null) {
			return persona;
		}
		return null;
	}

	@Override
	public void updatePersona(Persona persona) {
		conn = ConnectionDB.ConnectionDB();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "UPDATE personas " + "SET persona_nombre='" + persona.getNombre() + "', persona_apellido = '"
				+ persona.getApellido() + "', persona_edad = '" + persona.getEdad() + "' WHERE persona_id = "
				+ persona.getId();

		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
			
			conn.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}

	}

	@Override
	public void deletePersona(Persona persona) {
		conn = ConnectionDB.ConnectionDB();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "DELETE FROM personas WHERE persona_id = " + persona.getId();
		System.out.println(sqlQuery);
		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
			
			conn.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}

	}

	@Override
	public void insertPersona(Persona persona) {
		conn = ConnectionDB.ConnectionDB();
		Statement stmt = null;
		ResultSet rs = null;
		String nombre = persona.getNombre();
		String apellido = persona.getApellido();
		int edad = persona.getEdad();
		
		String sqlQuery = "insert into personas(persona_nombre, persona_apellido, persona_edad) values('" + nombre + "','" + apellido + "','" + edad + "')";
		System.out.println(sqlQuery);
		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
			
			conn.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
	}

}
