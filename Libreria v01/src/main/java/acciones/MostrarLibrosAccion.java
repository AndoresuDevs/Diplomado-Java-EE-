package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import javaEEJDBC.DataBaseException;

public class MostrarLibrosAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		List<Libro>ListaDeLibros=Libro.buscarTodos();
		
		List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
		request.setAttribute("ListaDeLibros", ListaDeLibros);
		request.setAttribute("ListaDeCategorias", ListaDeCategorias);
	
		return "MostrarLibros.jsp";
	}

}
