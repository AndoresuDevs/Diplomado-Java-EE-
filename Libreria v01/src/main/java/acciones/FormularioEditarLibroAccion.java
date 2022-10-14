package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioLibros;

public class FormularioEditarLibroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicio = (ServicioLibros) getBean("ServicioLibros",request);
			request.setAttribute("Libro", servicio.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "FormularioEditarLibro.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
