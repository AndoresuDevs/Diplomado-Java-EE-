package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import beans.Proveedor;
import javaEEJDBC.DataBaseException;

public class MostrarProveedoresAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Proveedor>ListaDeProveedores=Proveedor.buscarTodos();
		request.setAttribute("ListaDeProveedores", ListaDeProveedores);

		return "MostrarProveedores.jsp";
	}

}
