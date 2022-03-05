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
		try {
			List<Proveedor>ListaDeProveedores=Proveedor.buscarTodos();
			
			request.setAttribute("ListaDeProveedores", ListaDeProveedores);
			
			//request.setAttribute("ListaPorCategoria", ListaPorCategorias);				
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return "MostrarProveedores.jsp";
	}

}
