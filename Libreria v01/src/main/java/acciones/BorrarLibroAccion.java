package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class BorrarLibroAccion extends Accion  {
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioLibros servLib = new ServicioLibrosImpl();
			servLib.borrar(servLib.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "MostrarLibros.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
		
	}

}
