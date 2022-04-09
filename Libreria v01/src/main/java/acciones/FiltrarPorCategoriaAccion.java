package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class FiltrarPorCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("categoria"));
		System.out.println("FILTRO POR CATEGORIA ACCION");
				try {
 
					List<Libro>ListaPorCategorias= Libro.buscarPorCategoria(id);
				
					request.setAttribute("ListaDeCategorias", ListaPorCategorias);
					
					//request.setAttribute("ListaPorCategoria", ListaPorCategorias);				
				} catch (DataBaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "MostrarLibros.do";
	}

}
