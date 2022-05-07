package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Proveedor;
import javaEEJDBC.DataBaseException;

public class InsertarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String Nombre = request.getParameter("nomProv");
		String Telefono = request.getParameter("telProv");
		String Direccion = request.getParameter("dirProv");
		
		new Proveedor(Nombre, Telefono,Direccion).insertar();
			 
		
		return "MostrarProveedores.do";
	}

}
