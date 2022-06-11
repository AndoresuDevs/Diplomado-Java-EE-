package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Proveedor;
import dao.ProveedorDAO;
import dao.ProveedorDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import servicios.ServicioProveedores;
import servicios.ServicioProveedoresImpl;

public class InsertarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioProveedores servicioProv = new ServicioProveedoresImpl();
		servicioProv.insertar( new Proveedor(
				request.getParameter("nomProv"),
				request.getParameter("telProv"),
				request.getParameter("dirProv"))
				);
		return "MostrarProveedores.do";
	}

}
