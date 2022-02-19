package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class EditarLibroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idLibro"));
		String StrISBN = request.getParameter("ISBN");
		String StrTitulo = request.getParameter("nomLibro");
		String Cat = request.getParameter("catLibro");
		String Pre = request.getParameter("preLibro");
		
		try {
			new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)).editarLibro(id);
		} catch (NumberFormatException | DataBaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "MostrarLibros.do";
	}

}
