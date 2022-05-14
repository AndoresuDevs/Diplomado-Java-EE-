package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Proveedor;
import dao.ProveedorDAO;
import javaEEJDBC.DataBaseException;

public class InsertarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String Nombre = request.getParameter("nomProv");
		String Telefono = request.getParameter("telProv");
		String Direccion = request.getParameter("dirProv");
		
		
		ProveedorDAO dao = new ProveedorDAO();
		dao.insertar(new Proveedor(Nombre, Telefono,Direccion));
		
		return "MostrarProveedores.do";
	}

}
