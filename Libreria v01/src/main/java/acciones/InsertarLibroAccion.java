package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class InsertarLibroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String StrISBN = request.getParameter("ISBN");
		String StrTitulo = request.getParameter("nomLibro");
		String Cat = request.getParameter("catLibro");
		String Pre = request.getParameter("preLibro"); 
		
		new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).insertar();
			 
		
		return "MostrarLibros.do";
	}

}
