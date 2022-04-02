package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
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
				
				SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
				Session session = factoriaSession.openSession();
				
				Proveedor prov = (Proveedor) session.find(Proveedor.class, id);
				prov.setnom_prov(nom);
				prov.settel_prov(tel);
				prov.setdir_prov(dir);
				prov.insertar();
				session.close();
			
				return "MostrarProveedores.do";
	}

}
