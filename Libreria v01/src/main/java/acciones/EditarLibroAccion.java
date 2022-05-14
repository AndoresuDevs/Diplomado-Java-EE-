package acciones;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;

public class EditarLibroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id_lib"));
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("nomLibro");
		String Cat = request.getParameter("catLibro");
		String Pre = request.getParameter("preLibro");
	
		
		
		
		return "MostrarLibros.do";
	}

}
