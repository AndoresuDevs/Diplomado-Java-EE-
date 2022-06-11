package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.ProveedorDAOJPAImpl;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class MostrarCategoriasAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		
		//DAOFactory factoria = DAOAbstractFactory.getInstance();
		//CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		try {
			ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			request.setAttribute("ListaDeCategorias", servicioCategorias.buscarTodos());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "MostrarCategorias.jsp";
	}

}
