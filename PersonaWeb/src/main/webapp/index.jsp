<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="cl.talentodigital.Persona"%>
<%@page import="cl.talentodigital.IPersonaDAO"%>
<%@page import="cl.talentodigital.PersonaDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<%@include file="includes/menu.jsp" %>
	<%
	IPersonaDAO personaDao = new PersonaDAOImpl();
	%>


	<%
	ArrayList<Persona> personas = (ArrayList) personaDao.getTodasLasPersonas();
	%>


	<div class="container">
		<div class="row">
			<div class="col-10 offset-1">


				<h4>Bienvenido:</h4>




				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th scope="col">Edad</th>
							<th scope="col">Acción</th>

						</tr>
					</thead>
					<tbody>
						<%
						if (personas != null) {
							for (int i = 0; i < personas.size(); i++) {
						%>
						<tr>
							<th><%=personas.get(i).getId()%></th>
							<td><%=personas.get(i).getNombre()%></td>
							<td><%=personas.get(i).getApellido()%></td>
							<td><%=personas.get(i).getEdad()%></td>
							<td><form action="Proccess" method="post">
									<input type="hidden" name="id"
										value="<%=personas.get(i).getId()%>" />
									<button type="submit" name="accion" value="eliminar"
										class="btn btn-danger">Eliminar</button>
									<button type="submit" name="accion" value="editar"
										class="btn btn-warning">Editar</button>
								</form></td>
						</tr>
					</tbody>
					<%
					}
					%>
				</table>

				<%
				} else {
				%>

				<h5>No hay datos.</h5>

				<%
				}
				%>



				<button class="btn btn-primary" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">Agregar
					Personas</button>
				</p>
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<form class="p-3 shadow-sm m-3 " action="Proccess" method="post">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre</label> <input
									type="text" class="form-control" name="nombreForm" required>
							</div>
							<div class="mb-3">
								<label for="apellido" class="form-label">Apellido</label> <input
									type="text" class="form-control" name="apellidoForm" required>
							</div>
							<div class="mb-3">
								<label for="edad" class="form-label">Edad</label> <input
									type="text" class="form-control" name="edadForm" required>
							</div>


							<button id="Agregar" type="submit" name="accion" value="agregar"
								class="btn btn-success">Agregar Persona</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>