package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioProveedores;

public class FormularioEditarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioProveedores servicio = (ServicioProveedores) getBean("ServicioProveedores", request);
			request.setAttribute("Proveedor", servicio.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
			return "FormularioEditarProveedor.jsp";
		}catch(Exception e){
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
