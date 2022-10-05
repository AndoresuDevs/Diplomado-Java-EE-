<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="beans.Libro"%>
<%@page import="servicios.ServicioLibrosImpl"%>
<%@page import="servicios.ServicioLibros"%>
<%@page import="acciones.MostrarLibrosAccion"%>

<html lang="es">
	<% 
		MostrarLibrosAccion mla = new MostrarLibrosAccion();
		ServicioLibros servicioLibros = (ServicioLibros) mla.getBean("ServicioLibros",request);
		Libro l = servicioLibros.buscarPorClave(Integer.parseInt(request.getParameter("id"))); 
		
		//ServicioLibros servLib = new ServicioLibrosImpl();
		//Libro l = servLib.buscarPorClave(Integer.parseInt(request.getParameter("id"))); 
	%>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para editar un libro</title>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Editar Libro</h1>
			<form action="EditarLibro.do" method="GET">
			
				<p><label class="txt" for="ID">ID:</label><br>
				<input class="inputs" id="ID" type="text" name="id_lib" readonly="readonly" value="<%=l.getnum_lib() %>"/></p>	
					
				<p><label class="txt" for="ISBN">ISBN:</label><br>
				<input class="inputs" id="ISBN" type="text" name="ISBNLibro" value="<%=l.getisbn_lib() %>"/></p>	
						
				<p><label class="txt" for="Titulo">Titulo: </label><br>
				<input class="inputs" id="Titulo" type="text" name="nomLibro" value="<%=l.gettit_lib() %>"/></p>
				
				<p><label class="txt" for="Categoria">Categoria: </label><br>
				<input class="inputs" id="Categoria" type="text" name="catLibro" value="<%=l.getcat_lib() %>"/></p>
				
				<p><label class="txt" for="Precio">Precio: </label><br>
				<input class="inputs" id="Precio" type="text" name="preLibro" value="<%=l.getpre_lib() %>"/></p>
				
				<input class="boton" type="submit" value="ENVIAR" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarLibros.do">Cancelar</a></p>		
			</form>
		</div>
	</body>
</html>
