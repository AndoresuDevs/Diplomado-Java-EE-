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
		// TODO Auto-generated method stub
		
		List<Libro>ListaDeLibros = null;
		List<Libro>ListaPorCategorias = null;
		try {
			if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("seleccionar")) {
				
				ListaDeLibros= Libro.buscarTodos();
			}else {
				System.out.println("PARAMETRO EN MOSTRAR: "+request.getParameter("categoria")+" SI ESTA ENTRANDO LA CATEGORIA QUE QUIERE");
				int cat = Integer.parseInt(request.getParameter("categoria"));
				//ListaPorCategorias=Libro.buscarPorCategoria(cat);
				ListaPorCategorias=Libro.buscarPorCategoria(cat);
			}
			
			//ListaPorCategorias= Libro.buscarPorCategoria(1);
			List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaPorCategoria", ListaPorCategorias);				
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return "MostrarLibros.jsp";
	}

}
