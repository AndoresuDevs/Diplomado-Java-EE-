 package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import javaEEJDBC.DataBaseException;

public class InsertarLibroAccion extends Accion{
	
	DAOFactory factoria = DAOAbstractFactory.getInstance() ;
	CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
	LibroDAO libroDAO= factoria.getLibroDAO();
	

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
//		new LibroDAOJPAImpl().insertar(new Libro(
//				request.getParameter("ISBN"), 
//				request.getParameter("nomLibro"), 
//				Integer.parseInt(request.getParameter("catLibro")), 
//				Float.parseFloat(request.getParameter("preLibro")))
//				);
		
		libroDAO.insertar(new Libro(
		request.getParameter("ISBN"), 
		request.getParameter("nomLibro"), 
		Integer.parseInt(request.getParameter("catLibro")), 
		Float.parseFloat(request.getParameter("preLibro")))
		);
			 
		
		return "MostrarLibros.do";
	}

}
