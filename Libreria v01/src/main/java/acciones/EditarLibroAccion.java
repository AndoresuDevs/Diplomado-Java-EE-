package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;


public class EditarLibroAccion extends Accion{
	
	DAOFactory factoria = DAOAbstractFactory.getInstance() ;
	CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
	LibroDAO libroDAO= factoria.getLibroDAO();

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Libro lib = new Libro(
				request.getParameter("ISBNLibro"),
				request.getParameter("nomLibro"),
				Integer.parseInt(request.getParameter("catLibro")),
				Float.parseFloat(request.getParameter("preLibro")));
		lib.setnum_lib(Integer.parseInt(request.getParameter("id_lib")));
		
		
		//new LibroDAOJPAImpl().guardarCambios(lib);
		libroDAO.guardarCambios(lib);
		
		return "MostrarLibros.do";
	}

}
