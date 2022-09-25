package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Proveedor;
import servicios.ServicioProveedores;

public class InsertarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioProveedores servicioProv = (ServicioProveedores) getBean("ServicioProveedores", request);
			servicioProv.insertar( new Proveedor(
					request.getParameter("nomProv"),
					request.getParameter("telProv"),
					request.getParameter("dirProv"))
					);
			return "MostrarProveedores.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
