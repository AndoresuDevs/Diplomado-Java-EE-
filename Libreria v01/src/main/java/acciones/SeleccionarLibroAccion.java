package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioLibros;

public class SeleccionarLibroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros",request);
			request.setAttribute("Libro", servicioLibros.buscarPorClave(0));
			return "MostrarLibros.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
		
		
	}

}
