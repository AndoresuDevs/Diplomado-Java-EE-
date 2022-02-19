package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class FiltrarPorCategoriaAction extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Libro>ListaPorCategorias = null;
		List<Libro>ListaDeLibros = null;
		try {
			
			int cat = Integer.parseInt(request.getParameter("categoria"));
			ListaPorCategorias=Libro.buscarPorCategoria(cat);
			
			List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
			
		 	request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaPorCategoria", ListaPorCategorias);
			
			
			
			
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		return "MostrarLibros.jsp";
	}

}
