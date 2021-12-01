<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.sql.SQLException" %>
<%@page import="javaEEJDBC.Libro"%>
<html lang="es">
	<% int idLibro = Integer.parseInt(request.getParameter("id"));  //AQUI SE DEBERIA RECIBIR EL PARAMETRO%>
	<%System.out.println("EL ID RECIBIDO ES:  "+idLibro);%>
	<%Libro l = new Libro().buscarLibro(idLibro);%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para editar un libro</title>
		<script type="text/javascript" src="js/validacionEditarLibro.js"></script>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Editar Libro</h1>
			
			<form action="EditarLibro.jsp" method="GET">
				<p><label class="txt" for="ID">ID:</label><br>
				<input class="inputs" id="ID" type="text" name="idLibro" value="<%=l.getNumero() %>"  disabled/></p>	
				
				<p><label class="txt" for="ISBN">ISBN:</label><br>
				<input class="inputs" id="ISBN" type="text" name="ISBNLibro" value="<%=l.getISBN() %>"/></p>	
						
				<p><label class="txt" for="Titulo">Titulo: </label><br>
				<input class="inputs" id="Titulo" type="text" name="nomLibro" value="<%=l.getTitulo() %>"/></p>
				
				<p><label class="txt" for="Categoria">Categoria: </label><br>
				<input class="inputs" id="Categoria" type="text" name="catLibro" value="<%=l.getCategoria() %>"/></p>
				
				<p><label class="txt" for="Precio">Precio: </label><br>
				<input class="inputs" id="Precio" type="text" name="preLibro" value="<%=l.getPrecio() %>"/></p>
				
				<input class="boton" onClick="editar();" type="submit" value="ENVIAR" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarLibros.jsp">Cancelar</a></p>
				
				
					
			</form>
		</div>
	</body>
</html>