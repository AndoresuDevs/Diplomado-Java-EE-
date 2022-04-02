package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;
import javaEEJDBC.Libro;

public class BorrarLibroAccion extends Accion  {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ACT BORRAR LIBRO");
		int id = Integer.parseInt(request.getParameter("id"));
		
		SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.find(Libro.class, id).BorrarLibro();
		session.close();
		return "MostrarLibros.do";
	}

}
