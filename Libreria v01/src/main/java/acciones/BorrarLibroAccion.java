package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.DataBaseHelperHibernate;

public class BorrarLibroAccion extends Accion  {

	
	DAOFactory factoria = DAOAbstractFactory.getInstance() ;
	LibroDAO libroDAO= factoria.getLibroDAO();
	
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		//LibroDAOJPAImpl DAOLib = new LibroDAOJPAImpl();		
		//DAOLib.borrar(DAOLib.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
		libroDAO.borrar(libroDAO.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
		return "MostrarLibros.do";
	}

}
