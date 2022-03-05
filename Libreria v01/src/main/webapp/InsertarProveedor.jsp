<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javaEEJDBC.Proveedor"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String Nombre = request.getParameter("Nombre");
	String Telefono = request.getParameter("Telefono");
	String Direccion = request.getParameter("Direccion");
	
	int filas =0;
	try{
		filas = new Proveedor(Nombre,Telefono,Direccion).insertar();
		response.sendRedirect("MostrarProveedores.jsp");
	}catch(DataBaseException e)
	{
		System.out.println("Entro la excepcion :D");
	%>
	<% 
		out.println(e.getMessage());  
		response.sendRedirect("Errores.jsp?motivo="+e.getMessage());
	}%>
	<%
	System.out.println("FILAS MODIFICADAS: "+filas);	
	
	
	
	if(filas!=0){
		//response.sendRedirect("MostrarLibros.jsp");
		//SI SE CUMPLE EL TRY SE SIGUE EL FLUJO, SI ENTRA EL CATCH SE ESTANCA AQUI POR LO QUE NO OCUPO EL IF
	}else{
		
	}
	
	%>
	
%>