package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioProveedores;

public class MostrarProveedoresAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioProveedores servicioProv = (ServicioProveedores) getBean("ServicioProveedores",request);
			
//			ServicioProveedores servicioProv = new ServicioProveedoresImpl();
			request.setAttribute("ListaDeProveedores", servicioProv.buscarTodos());
			return "MostrarProveedores.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
