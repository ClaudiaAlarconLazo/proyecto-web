package cl.talentodigital;

import java.util.List;

public interface IPersonaDAO {
	
	public List<Persona> getTodasLasPersonas();
	public Persona getPersona(int id);
	public void updatePersona(Persona persona);
	public void deletePersona(Persona persona);
	public void insertPersona(Persona persona);

}
