package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;

public class BorrarLibroAccion extends Accion  {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ACT BORRAR LIBRO");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Libro l = Libro.buscarLibro(id);
		l.BorrarLibro();
		//SessionFactory factoriaSession = DataBaseHelperHibernate.getSessionFactory();
		//Session session = factoriaSession.openSession();
		//session.find(Libro.class, id).BorrarLibro();
		//session.close();
		return "MostrarLibros.do";
	}

}
