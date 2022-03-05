package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Proveedor;

public class InsertarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String Nombre = request.getParameter("nomProv");
		String Telefono = request.getParameter("telProv");
		String Direccion = request.getParameter("dirProv");
		try {
			 new Proveedor(Nombre, Telefono,Direccion).insertar();
			 
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		return "MostrarProveedores.do";
	}

}
