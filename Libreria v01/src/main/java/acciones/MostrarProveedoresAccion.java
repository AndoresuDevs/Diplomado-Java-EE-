package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import beans.Proveedor;
import dao.ProveedorDAO;
import dao.ProveedorDAOJPAImpl;
import javaEEJDBC.DataBaseException;
import servicios.ServicioProveedores;
import servicios.ServicioProveedoresImpl;

public class MostrarProveedoresAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServicioProveedores servicioProv = new ServicioProveedoresImpl();
			request.setAttribute("ListaDeProveedores", servicioProv.buscarTodos());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "MostrarProveedores.jsp";
	}

}
