package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class FiltrarPorCategoriaAccion extends Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicioLibros = new ServicioLibrosImpl();
			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			request.setAttribute("ListaDeLibros", servicioLibros.buscarPorCategoria(Integer.parseInt(request.getParameter("categoria"))));
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos()); //CAMBIAR POR SERV CATEGORIA
			return "MostrarLibros.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
