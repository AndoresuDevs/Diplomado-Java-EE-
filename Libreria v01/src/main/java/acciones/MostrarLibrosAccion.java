package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class MostrarLibrosAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		//DAOFactory factoria = DAOAbstractFactory.getInstance() ;
		//CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		//LibroDAO libroDAO= factoria.getLibroDAO();
		
		
		try {
			//ESTO ERA SOLO CON JPA
			//request.setAttribute("ListaDeLibros", new LibroDAOJPAImpl().buscarTodos());
			//request.setAttribute("ListaDeCategorias", new CategoriaDAOJPAImpl().buscarTodos());
			
			request.setAttribute("ListaDeLibros", servicioLibros.buscarTodos());
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos()); //CAMBIAR POR SERV CATEGORIA
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "MostrarLibros.jsp";
	}

}
