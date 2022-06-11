package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

public class FiltrarPorCategoriaAccion extends Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		DAOFactory factoria = DAOAbstractFactory.getInstance() ;
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		LibroDAO libroDAO= factoria.getLibroDAO();
		
		try {
			request.setAttribute("ListaDeLibros", libroDAO.buscarPorCategoria(Integer.parseInt(request.getParameter("categoria"))));
			request.setAttribute("ListaDeCategorias", categoriaDAO.buscarTodos());
		} catch (Exception e) {
			e.printStackTrace();
 		}
		return "MostrarLibros.jsp";
	}

}
