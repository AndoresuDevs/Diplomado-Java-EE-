package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Proveedor;

public class BorrarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ACT BORRAR PROVEEDOR");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			
			new Proveedor().BorrarProveedor(id);
			
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "MostrarProveedores.do";
	}

}
