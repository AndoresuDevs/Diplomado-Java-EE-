package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Proveedor;
import servicios.ServicioProveedores;

public class EditarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {	
		try {
			ServicioProveedores servicioProv = (ServicioProveedores) getBean("ServicioProveedores", request);
			Proveedor prov = new Proveedor(
				request.getParameter("nomProv"),
				request.getParameter("telProv"),
				request.getParameter("dirProv")
			);
			prov.setid_prov(Integer.parseInt(request.getParameter("idProv")));
			servicioProv.guardarCambios(prov);
			return "MostrarProveedores.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "Errores.jsp?motivo="+e.getMessage();
		}
	}

}
