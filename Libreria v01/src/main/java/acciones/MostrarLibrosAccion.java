package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;
import javaEEJDBC.DataBaseException;

public class MostrarLibrosAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		List<Libro> ListaDeLibros;
		try {
			ListaDeLibros = LibroDAO.buscarTodos();
			List<Categoria>ListaDeCategorias= CategoriaDAO.buscarTodas();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "MostrarLibros.jsp";
	}

}
