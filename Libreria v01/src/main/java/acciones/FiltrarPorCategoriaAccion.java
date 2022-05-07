package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import javaEEJDBC.DataBaseException;

public class FiltrarPorCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("categoria"));
		System.out.println("FILTRO POR CATEGORIA ACCION");
		List<Libro>ListaPorCategorias= Libro.buscarPorCategoria(id);
		request.setAttribute("ListaDeCategorias", ListaPorCategorias);
		return "MostrarLibros.do";
	}

}
