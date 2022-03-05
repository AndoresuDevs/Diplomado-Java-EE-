package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("CTRL FORMULARIO INSERTAR QUE NO SE QUE HACE");
		List<Categoria> listaDeCategorias=null;
		try {
			listaDeCategorias = Categoria.buscarCategorias();
			request.setAttribute("ListaDeCategorias", listaDeCategorias);
			
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"FormularioInsertarLibro.jsp";
	}

}