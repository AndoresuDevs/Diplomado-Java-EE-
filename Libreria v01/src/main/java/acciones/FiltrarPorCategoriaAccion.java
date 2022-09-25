package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioCategorias;
import servicios.ServicioLibros;

public class FiltrarPorCategoriaAccion extends Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros", request);
			ServicioCategorias servicioCategorias = (ServicioCategorias) getBean("ServicioCategorias", request);
			request.setAttribute("ListaDeLibros", servicioLibros.buscarPorCategoria(Integer.parseInt(request.getParameter("categoria"))));
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos()); //CAMBIAR POR SERV CATEGORIA
			return "MostrarLibros.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
