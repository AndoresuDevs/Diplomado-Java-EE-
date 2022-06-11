package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import beans.Proveedor;
import dao.ProveedorDAO;
import dao.ProveedorDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioProveedores;
import servicios.ServicioProveedoresImpl;

public class BorrarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicioProveedores servicioProv = new ServicioProveedoresImpl();
		
		//ProveedorDAOJPAImpl dao = new ProveedorDAOJPAImpl();
		servicioProv.borrar(servicioProv.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
		return "MostrarProveedores.do";
	}

}
