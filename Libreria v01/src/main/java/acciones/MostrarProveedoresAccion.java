package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;
import javaEEJDBC.Proveedor;

public class MostrarProveedoresAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Proveedor>ListaDeProveedores=Proveedor.buscarTodos();
		request.setAttribute("ListaDeProveedores", ListaDeProveedores);

		return "MostrarProveedores.jsp";
	}

}
