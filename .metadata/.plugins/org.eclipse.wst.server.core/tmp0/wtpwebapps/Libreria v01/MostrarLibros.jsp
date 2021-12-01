<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="javaEEJDBC.Libro"%>
<%@page import="javaEEJDBC.Categoria"%>
<%@page import="javaEEJDBC.DataBaseException"%>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<link rel="stylesheet" href="css/tablas.css">
	<script type="text/javascript" src="js/validacionMostrarLibro.js"></script>
	<title>Lista de Libros</title>
</head>
<body background="img/formulario.jpg">

	<div class=contenedor>
	
	<a href="FormularioInsertarLibro.jsp">Insertar Nuevo Libro</a>
	
	<form action="MostrarLibros.jsp" method="GET">
	
	<p class="navegar">
		<br><label>Categorias disonibles: </label>
		<select name="categoria">
		<option>Seleccionar</option>
		<%
		try{
			//ArrayList<Integer>Categorias = new ArrayList<Integer>();
			//Categorias = new Libro().buscarLasCategorias();
			 
			List<Categoria>Categorias = new ArrayList<Categoria>();
			Categorias = new Categoria().buscarCategorias();
			for(Categoria c: Categorias){
				%>
				<option value="<%=c.getid_cat()%>"> <%=c.getnom_cat()%> </option> 
				<%
			}	
		}catch(Exception e){
			e.printStackTrace();
		}	 
		%>
		</select>
		<input type="submit" value="Filtrar" /> 
	</p>
	</form>
	
	<br><br>
		
	<h2>Lista de libros</h2>
	
		<table class="tabla">
			<thead>
				<tr>
					<th>Numero</th>
					<th>ISBN</th>
					<th>Titulo</th>
					<th>Categoria</th>
					<th>Precio</th>
					<th>Borrar</th>
					<th>Modificar</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<%
					List<Categoria>Categorias = new ArrayList<Categoria>();
					Categorias = new Categoria().buscarCategorias();
					List<Libro> Lista=null;
					if(request.getParameter("categoria")==null || request.getParameter("categoria").equals("Seleccionar")){
						
						try{
							 Lista = new Libro().buscarTodos();
						}catch(DataBaseException e)
						{
							System.out.println("Entro la excepcion :D");
							out.println(e.getMessage());  
						}
					}else{
						int  Cat = Integer.parseInt(request.getParameter("categoria"));
						Lista=new Libro().buscarPorCategoria(Cat);
					}
					
					try{
						
					
					for(Libro l: Lista){ %>
					<td><%=l.getnum_lib()%></td>
					<td><%=l.getisbn_lib()%></td>
					<td><%=l.gettit_lib()%></td>
					
				 	 
				 	<%for(Categoria c: Categorias){
				 		if(c.getid_cat()==l.getcat_lib()){%>
				 			<td><%=c.getnom_cat()%></td> 
				 	<%	}
				 	} %>
					
						
					<td><%=l.getpre_lib()%></td>
					<td><a href="BorrarLibro.jsp?id=<%=l.getnum_lib()%>">Borar</a></td>
					<td><a href="FormularioEditarLibro.jsp?id=<%=l.getnum_lib()%>">Editar</a></td>
					</tr>
					<%}
					}catch(NullPointerException e){%>
						<%//response.sendRedirect("Errores.jsp?motivo="+e.getMessage());%>
						<%out.println("ERROR, LA LISTA DE LIBROS ESTA VACIA"); %>
					<% }%>
				
			</tbody>
		</table>
	
		
		
	</div>
	<br><br>
	
</body>
</html>