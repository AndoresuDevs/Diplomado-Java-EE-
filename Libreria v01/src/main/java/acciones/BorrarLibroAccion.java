package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import dao.LibroDAO;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;

public class BorrarLibroAccion extends Accion  {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ACT BORRAR LIBRO");
		int id = Integer.parseInt(request.getParameter("id"));
		
		LibroDAO DAOLib = new LibroDAO();
		
		Libro l = DAOLib.buscarLibro(id);
		DAOLib.BorrarLibro(l);
		return "MostrarLibros.do";
	}

}
