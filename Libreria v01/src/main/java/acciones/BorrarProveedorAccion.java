package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioProveedores;
import servicios.ServicioProveedoresImpl;

public class BorrarProveedorAccion extends Accion{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioProveedores servicioProv = new ServicioProveedoresImpl();
			servicioProv.borrar(servicioProv.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "MostrarProveedores.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
