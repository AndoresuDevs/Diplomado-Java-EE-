package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;


public class EditarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servicio = new ServicioLibrosImpl(); 
			Libro lib = new Libro(
					request.getParameter("ISBNLibro"),
					request.getParameter("nomLibro"),
					Integer.parseInt(request.getParameter("catLibro")),
					Float.parseFloat(request.getParameter("preLibro")));
			lib.setnum_lib(Integer.parseInt(request.getParameter("id_lib")));
			servicio.guardarCambios(lib);
			return "MostrarLibros.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
