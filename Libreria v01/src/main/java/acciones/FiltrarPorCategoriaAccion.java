package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.LibroDAO;
import javaEEJDBC.DataBaseException;

public class FiltrarPorCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("categoria"));
		System.out.println("FILTRO POR CATEGORIA ACCION");
		List<Libro> ListaPorCategorias;
		try {
			ListaPorCategorias = LibroDAO.buscarPorCategoria(id);
			request.setAttribute("ListaDeCategorias", ListaPorCategorias);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "MostrarLibros.do";
	}

}
