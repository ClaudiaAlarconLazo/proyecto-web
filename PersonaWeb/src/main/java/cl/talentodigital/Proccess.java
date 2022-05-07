package cl.talentodigital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Proccess
 */
@WebServlet("/Proccess")
public class Proccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Proccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPersonaDAO personaDao = new PersonaDAOImpl();
		String accion = request.getParameter("accion");

		if (accion.equalsIgnoreCase("eliminar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("entramos al eliminar");
			Persona persona = personaDao.getPersona(id);
			personaDao.deletePersona(persona);
			response.sendRedirect("index.jsp");

		} else if (accion.equalsIgnoreCase("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Persona personaEditable = personaDao.getPersona(id);
			request.setAttribute("id", personaEditable.getId());
			request.setAttribute("nombre", personaEditable.getNombre());
			request.setAttribute("apellido", personaEditable.getApellido());
			request.setAttribute("edad", personaEditable.getEdad());

			request.getRequestDispatcher("editar.jsp").forward(request, response);

		} else if (accion.equalsIgnoreCase("actualizar")) {
			int id = Integer.parseInt(request.getParameter("idForm"));
			String nombre = request.getParameter("nombreForm");
			String apellido = request.getParameter("apellidoForm");
			int edad = Integer.parseInt(request.getParameter("edadForm"));

			personaDao.updatePersona(new Persona(id, nombre, apellido, edad));
			response.sendRedirect("index.jsp");

		} else if (accion.equalsIgnoreCase("agregar")) {
			String nombre = request.getParameter("nombreForm");
			String apellido = request.getParameter("apellidoForm");
			int edad = Integer.parseInt(request.getParameter("edadForm"));

			personaDao.insertPersona(new Persona(nombre, apellido, edad));
			response.sendRedirect("index.jsp");
		}
	}

}
