package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioCategorias;

public class FormularioEditarCategoriaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ServicioCategorias servicio = (ServicioCategorias) getBean("ServicioCategorias", request);
			request.setAttribute("Categoria", servicio.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "FormularioEditarCategoria.jsp";
		}catch(Exception e){
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
		
	}

}
