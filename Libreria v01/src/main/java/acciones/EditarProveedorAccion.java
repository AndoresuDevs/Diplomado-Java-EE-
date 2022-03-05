package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Proveedor;

public class EditarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("OTRO ID EN ACCION ES:"+request.getParameter("idProv"));
				int id = Integer.parseInt(request.getParameter("idProv"));
				String nom = request.getParameter("nomProv");
				String tel = request.getParameter("telProv");
				String dir = request.getParameter("dirProv");
				
				
				try {
					
					new Proveedor(nom,tel,dir).editarProveedor(id);
				} catch (NumberFormatException | DataBaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return "MostrarProveedores.do";
	}

}
