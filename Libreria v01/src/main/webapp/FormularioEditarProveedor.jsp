<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.sql.SQLException" %>
<%@page import="beans.Proveedor"%>
<%@page import="dao.ProveedorDAO"%>


<html lang="es">
	<% int idProv = Integer.parseInt(request.getParameter("id"));  //AQUI SE DEBERIA RECIBIR EL PARAMETRO%>
	<%System.out.println("EL ID RECIBIDO ES:  "+idProv);%>
	<%Proveedor p = new ProveedorDAO().buscarProveedor(idProv);%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario para editar un proveedor</title>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
		<div class="formulario">
			<h1>Formulario Editar Proveedor</h1>
			<form action="EditarProveedor.do" method="GET">
				<p><label class="txt" for="ID">ID:</label><br>
				<input class="inputs" id="ID" type="text" name="idProv" value="<%=p.getid_prov() %>" /></p>	
				
				<p><label class="txt" for="Nombre">Nombre:</label><br>
				<input class="inputs" id="Nombre" type="text" name="nomProv" value="<%=p.getnom_prov() %>"/></p>	
						
				<p><label class="txt" for="Telefono">Telefono: </label><br>
				<input class="inputs" id="Telefono" type="text" name="telProv" value="<%=p.gettel_prov() %>"/></p>
				
				<p><label class="txt" for="Direccion">Direccion: </label><br>
				<input class="inputs" id="Direccion" type="text" name="dirProv" value="<%=p.getdir_prov() %>"/></p>
				
				<input class="boton" onClick="editar();" type="submit" value="ENVIAR" name="insertar"><br>
				
				<p class="navegar"><a href="MostrarProveedores.do">Cancelar</a></p>		
			</form>
		</div>
	</body>
</html>
