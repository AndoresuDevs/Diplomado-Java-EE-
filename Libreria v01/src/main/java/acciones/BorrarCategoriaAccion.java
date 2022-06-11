package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class BorrarCategoriaAccion extends Accion{

	
//	DAOFactory factoria = DAOAbstractFactory.getInstance() ;
//	CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		//CategoriaDAOJPAImpl dao = new CategoriaDAOJPAImpl();
		//dao.borrar(dao.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
		servicioCategorias.borrar(servicioCategorias.buscarPorClave(Integer.parseInt(request.getParameter("id"))));
		return "MostrarCategorias.do";
	}

}
