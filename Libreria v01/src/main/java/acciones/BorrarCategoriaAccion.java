package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioCategorias;

public class BorrarCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ServicioCategorias servicioCategorias = (ServicioCategorias) getBean("ServicioCategorias", request);
			servicioCategorias.borrar(servicioCategorias.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "MostrarCategorias.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
		
	}

}
