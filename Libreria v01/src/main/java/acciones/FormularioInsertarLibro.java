package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class FormularioInsertarLibro extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos());
			return "FormularioInsertarLibro.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
