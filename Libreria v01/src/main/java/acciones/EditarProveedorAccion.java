package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Proveedor;
import dao.ProveedorDAO;
import dao.ProveedorDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
import servicios.ServicioProveedores;
import servicios.ServicioProveedoresImpl;

public class EditarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ServicioProveedores servicioProv = new ServicioProveedoresImpl();
		System.out.println("OTRO ID EN ACCION ES:"+request.getParameter("idProv"));

				Proveedor prov = new Proveedor(
					request.getParameter("nomProv"),
					request.getParameter("telProv"),
					request.getParameter("dirProv")
				);
				prov.setid_prov(Integer.parseInt(request.getParameter("idProv")));
			
				//ProveedorDAOJPAImpl dao = new ProveedorDAOJPAImpl();
				servicioProv.guardarCambios(prov);
				
				return "MostrarProveedores.do";
	}

}
