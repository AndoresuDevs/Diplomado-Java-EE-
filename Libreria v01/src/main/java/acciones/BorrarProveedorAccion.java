package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
import javaEEJDBC.Libro;
import javaEEJDBC.Proveedor;

public class BorrarProveedorAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ACT BORRAR PROVEEDOR");
		int id = Integer.parseInt(request.getParameter("id"));
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.find(Proveedor.class, id).BorrarProveedor();
		session.close();
		return "MostrarProveedores.do";
	}

}
