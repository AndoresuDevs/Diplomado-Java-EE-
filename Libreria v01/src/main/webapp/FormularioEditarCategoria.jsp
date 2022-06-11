<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.sql.SQLException" %>
<%@page import="beans.Categoria"%>
<%@page import="dao.CategoriaDAOJPAImpl"%>
<%@page import="dao.DAOFactory"%>
<%@page import="dao.DAOAbstractFactory"%>
<%@page import="dao.CategoriaDAO"%>


<html lang="es">
	<%
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		CategoriaDAO catDAO = factoria.getCategoriaDAO();
		Categoria c = catDAO.buscarPorClave(Integer.parseInt(request.getParameter("id")));
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para editar una Categoria</title>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Editar Categoria</h1>
			<form action="EditarCategoria.do" method="GET">
				<p><label class="txt" for="ID">ID:</label><br>
				<input class="inputs" id="ID" type="text" name="idCat" value="<%=c.getid_cat() %>" /></p>	
				
				<p><label class="txt" for="Nombre">Nombre:</label><br>
				<input class="inputs" id="Nombre" type="text" name="nomCat" value="<%=c.getnom_cat() %>"/></p>	
						
				<input class="boton" type="submit" value="ENVIAR" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarProveedores.do">Cancelar</a></p>		
			</form>
		</div>
	</body>
</html>
