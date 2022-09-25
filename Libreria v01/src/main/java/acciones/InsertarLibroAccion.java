 package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Libro;
import servicios.ServicioLibros;

public class InsertarLibroAccion extends Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicio = (ServicioLibros) getBean("ServicioLibros", request);
			servicio.insertar(new Libro(
					request.getParameter("ISBN"), 
					request.getParameter("nomLibro"), 
					Integer.parseInt(request.getParameter("catLibro")), 
					Float.parseFloat(request.getParameter("preLibro")))
					);
			return "MostrarLibros.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
