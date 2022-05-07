<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<%@include file="includes/menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-10 offset-1">
				<form class="p-3 shadow-sm m-3 " action="Proccess" method="post">
					<div class="mb-3">
						<input type="hidden" class="form-control" name="idForm"
							value="<%=request.getAttribute("id")%>">
					</div>
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label> <input
							type="text" class="form-control" name="nombreForm"
							value="<%=request.getAttribute("nombre")%>">
					</div>
					<div class="mb-3">
						<label for="apellido" class="form-label">Apellido</label> <input
							type="text" class="form-control" name="apellidoForm"
							value="<%=request.getAttribute("apellido")%>">
					</div>
					<div class="mb-3">
						<label for="edad" class="form-label">Edad</label> <input
							type="text" class="form-control" name="edadForm"
							value="<%=request.getAttribute("edad")%>">
					</div>


					<button id="Agregar" type="submit" name="accion" value="actualizar"
						class="btn btn-success">Actualizar Persona</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>