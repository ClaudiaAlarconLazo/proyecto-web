package cl.talentodigital;

public class Test {

	public static void main(String[] args) {

		IPersonaDAO personaDao = new PersonaDAOImpl();
		
		//Insertar persona
		personaDao.insertPersona(new Persona("Pedro", "Perez", 30));
		
		// Listar todas las personas
		for (Persona persona : personaDao.getTodasLasPersonas()) {
			System.out.println("Persona: nombre: " + persona.getNombre() + " id: " + persona.getId());
		}

		// Recuperar un persona
		Persona persona = personaDao.getPersona(1);
		if (persona != null) {
			System.out.println("La persona: nombre: " + persona.getNombre() + " id: " + persona.getId());
		}

		// Actualizacion de persona Persona persona =
		personaDao.getTodasLasPersonas().get(0);
		persona.setNombre("Camila");
		personaDao.updatePersona(persona);
		
		persona = personaDao.getPersona(1);
		if (persona != null) {
			System.out.println("La persona: nombre: " + persona.getNombre() + " id: " + persona.getId());
		}
		
		
		//Eliminar persona
		personaDao.deletePersona(persona);
		

		


	}

}
