package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import javaEEJDBC.DataBaseException;

public class FormularioInsertarLibroAccion extends Accion {

	
	DAOFactory factoria = DAOAbstractFactory.getInstance() ;
	CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
	LibroDAO libroDAO= factoria.getLibroDAO();
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<Categoria> listaDeCategorias=null;
		//CategoriaDAOJPAImpl dao = new CategoriaDAOJPAImpl();
		listaDeCategorias = categoriaDAO.buscarTodos();
		request.setAttribute("ListaDeCategorias", listaDeCategorias);
			
		
		return"FormularioInsertarLibro.jsp";
	}

}
