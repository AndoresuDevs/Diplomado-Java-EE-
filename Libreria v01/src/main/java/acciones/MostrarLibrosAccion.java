package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class MostrarLibrosAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List<Libro>ListaDeLibros=Libro.buscarTodos();
			List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			//request.setAttribute("ListaPorCategoria", ListaPorCategorias);				
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return "MostrarLibros.jsp";
	}

}
