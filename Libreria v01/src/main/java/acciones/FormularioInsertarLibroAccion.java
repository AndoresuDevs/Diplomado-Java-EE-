package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import javaEEJDBC.DataBaseException;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("CTRL FORMULARIO INSERTAR QUE NO SE QUE HACE");
		List<Categoria> listaDeCategorias=null;
		listaDeCategorias = Categoria.buscarCategorias();
		request.setAttribute("ListaDeCategorias", listaDeCategorias);
			
		
		return"FormularioInsertarLibro.jsp";
	}

}
