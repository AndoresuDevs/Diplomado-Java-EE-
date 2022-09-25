package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioCategorias;

public class MostrarCategoriasAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
//			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			ServicioCategorias servicioCategorias = (ServicioCategorias) getBean("ServicioCategorias",request);
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos());
			return "MostrarCategorias.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
